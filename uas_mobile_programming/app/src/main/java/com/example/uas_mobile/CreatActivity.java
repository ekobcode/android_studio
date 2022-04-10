package com.example.uas_mobile;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreatActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper database;
    Button btn_simpan;
    EditText nama, nim, kelas, email, hp, alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat);
        database = new DataHelper(this);
        nama = findViewById(R.id.nama);
        nim = findViewById(R.id.nim);
        kelas = findViewById(R.id.kelas);
        email = findViewById(R.id.email);
        hp = findViewById(R.id.hp);
        alamat = findViewById(R.id.alamat);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("insert into mahasiswa (nama, nim, kelas, email, hp, alamat) values('" +
                        nama.getText().toString() + "','" +
                        nim.getText().toString() + "','" +
                        kelas.getText().toString() + "','" +
                        email.getText().toString() + "','" +
                        hp.getText().toString() + "','" +
                        alamat.getText().toString() +
                        "')");
                Toast.makeText(CreatActivity.this, "Data Berhasil Tersimpan", Toast.LENGTH_SHORT).show();
                MahasiswaActivity.ma.RefreshList();
                finish();
            }
        });

    }
}