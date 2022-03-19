package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    String[] lvItems = {"06TPLE001", "06TPLE002", "06TPLE003",
            "06TPLE004", "06TPLE005", "06TPLE006", "06TPLE007", "06TPLE008",
            "06TPLE009", "06TPLE010", "06TPLE011", "06TPLE012", "06TPLE013",
            "06TPLE0014", "06TPLE015", "06TPLE016", "06TPLE017", "06TPLE018",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, lvItems);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),
                        "You have selected : " + lvItems[position],
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}