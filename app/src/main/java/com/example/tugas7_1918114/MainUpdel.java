package com.example.tugas7_1918114;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama_casing, Sharga;
    private EditText Enama_casing, Eharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama_casing = i.getStringExtra("Inama_casing");
        Sharga = i.getStringExtra("Iharga");
        Enama_casing = (EditText) findViewById(R.id.updel_nama_casing);
        Eharga = (EditText) findViewById(R.id.updel_harga);
        Enama_casing.setText(Snama_casing);
        Eharga.setText(Sharga);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama_casing = String.valueOf(Enama_casing.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snama_casing.equals("")){
                    Enama_casing.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi kelas",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateCasingHP(new CasingHP(Sid, Snama_casing,
                            Sharga));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteCasingHP(new CasingHP(Sid, Snama_casing,
                        Sharga));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}