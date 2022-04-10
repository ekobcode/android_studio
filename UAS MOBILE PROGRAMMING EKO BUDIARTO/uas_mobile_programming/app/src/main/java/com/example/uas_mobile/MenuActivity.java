package com.example.uas_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void Maps(View view) {
        Intent intent = new Intent(MenuActivity.this, MapsActivity.class);
        startActivity(intent);
    }

    public void Camera(View view) {
        Intent intent = new Intent(MenuActivity.this, CameraActivity.class);
        startActivity(intent);
    }

    public void DataMahasiswa(View view) {
        Intent intent = new Intent(MenuActivity.this, MahasiswaActivity.class);
        startActivity(intent);
    }
}