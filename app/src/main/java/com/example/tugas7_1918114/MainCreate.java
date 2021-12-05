package com.example.tugas7_1918114;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama_casing, Eharga;
    private String Snama_casing, Sharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama_casing = (EditText) findViewById(R.id.create_nama_casing);
        Eharga = (EditText) findViewById(R.id.create_harga);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama_casing = String.valueOf(Enama_casing.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snama_casing.equals("")){
                    Enama_casing.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sharga.equals("")) {
                    Eharga.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi kelas",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Enama_casing.setText("");
                    Eharga.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateCasingHP(new CasingHP(null, Snama_casing,
                            Sharga));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}