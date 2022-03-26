package com.example.test1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TwoActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        imageView = findViewById(R.id.imageCamera);
        Button button = findViewById(R.id.buttonCamera);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentCamera, CAMERA_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photoCamera = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photoCamera);
        }
    }

    public void Lanjut(View view) {
        Intent intent = new Intent(TwoActivity.this, ThreeActivity.class);
        startActivity(intent);
    }

    public void Kembali(View view) {
        Intent intent = new Intent(TwoActivity.this, MainActivity.class);
        startActivity(intent);
    }
}