package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputJudul, inputNotifikasi, inputIsi;
    TextView tampiljudul, tampilNotifikasi, tampilisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openAlertDialog(View view) {
        inputJudul = (EditText) findViewById(R.id.editJudul);
//        inputNotifikasi = (EditText) findViewById(R.id.editNotifikasi);
        inputIsi = (EditText) findViewById(R.id.editIsi);


        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(inputJudul.getText().toString())
//                .setMessage(inputNotifikasi.getText().toString())
                .setMessage(inputIsi.getText().toString())
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Kamu memilih OK", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Kamu memilih Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }


}