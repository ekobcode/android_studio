package com.example.uas_mobile;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper database;
    Button btn_simpan;
    TextView nama, nim, kelas, email, hp, alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        database = new DataHelper(this);
        nama = findViewById(R.id.nama);
        nim = findViewById(R.id.nim);
        kelas = findViewById(R.id.kelas);
        email = findViewById(R.id.email);
        hp = findViewById(R.id.hp);
        alamat = findViewById(R.id.alamat);
        btn_simpan = findViewById(R.id.btn_simpan);

        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("select * from mahasiswa where nama ='"+
                getIntent().getStringExtra("nama")+"'", null);
        cursor.moveToFirst();
        if(cursor.getCount()> 0) {
            cursor.moveToPosition(0 );
            nama.setText(cursor.getString(0).toString());
            nim.setText(cursor.getString(1).toString());
            kelas.setText(cursor.getString(2).toString());
            email.setText(cursor.getString(3).toString());
            hp.setText(cursor.getString(4).toString());
            alamat.setText(cursor.getString(5).toString());
        }
    }
}