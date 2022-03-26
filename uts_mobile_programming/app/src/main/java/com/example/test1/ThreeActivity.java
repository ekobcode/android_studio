package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
    }

    public void Kembali(View view) {
        Intent intent = new Intent(ThreeActivity.this, TwoActivity.class);
        startActivity(intent);
    }

    public void Kirim(View view) {
        Intent intent = new Intent(ThreeActivity.this, FourActivity.class);
        startActivity(intent);
    }
}