package com.example.tugas7_1918114;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<CasingHP> listCasingHP = new
            ArrayList<CasingHP>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, listCasingHP
        );
        mListView = (ListView) findViewById(R.id.list_casingHP);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        listCasingHP.clear();
        List<CasingHP> casingHP = db.ReadCasingHP();
        for (CasingHP mhs : casingHP) {
            CasingHP daftar = new CasingHP();
            daftar.set_id(mhs.get_id());
            daftar.set_nama_casing(mhs.get_nama_casing());
            daftar.set_harga(mhs.get_harga());
            listCasingHP.add(daftar);
            if ((listCasingHP.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        CasingHP detailMhs = (CasingHP)o;
        String Sid = detailMhs.get_id();
        String Snama_casing = detailMhs.get_nama_casing();
        String Sharga = detailMhs.get_harga();
        Intent goUpdel = new Intent(MainRead.this,
                MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama_casing", Snama_casing);
        goUpdel.putExtra("Iharga", Sharga);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        listCasingHP.clear();
        mListView.setAdapter(adapter_off);
        List<CasingHP> casingHP = db.ReadCasingHP();
        for (CasingHP mhs : casingHP) {
            CasingHP daftar = new CasingHP();
            daftar.set_id(mhs.get_id());
            daftar.set_nama_casing(mhs.get_nama_casing());
            daftar.set_harga(mhs.get_harga());
            listCasingHP.add(daftar);
            if ((listCasingHP.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}

