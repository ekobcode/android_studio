package com.example.uas_mobile;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MahasiswaActivity extends AppCompatActivity {

    String[] daftar;
    ListView listview;
    Menu menu;
    protected Cursor cursor;
    DataHelper database;
    public static MahasiswaActivity ma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new  Intent(MahasiswaActivity.this, CreatActivity.class);
                startActivity(pindah);
            }
        });

        ma = this;
        database = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList() {
        SQLiteDatabase  db = database.getReadableDatabase();
        cursor = db.rawQuery("Select * from mahasiswa", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int i = 0; i< cursor.getCount(); i++ ){
            cursor.moveToPosition(i);
            daftar[i] = cursor.getString(0).toString();
        }
        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, daftar));
        listview.setSelected(true);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView arg0, View arg1 , int arg2, long arg3) {
                final String selection = daftar[arg2];
                final CharSequence[] dialogitem = {"Lihat Masiswa", "Edit Mahasiswa", "Hapus Mahasiswa"};
                AlertDialog.Builder builder = new  AlertDialog.Builder(MahasiswaActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item){
                            case 0:
                                Intent i = new Intent(getApplicationContext(), DetailActivity.class);
                                i.putExtra("nama", selection);
                                startActivity(i);
                                break;
                            case 1:
                                Intent in = new Intent(getApplicationContext(), UpdateActivity.class);
                                in.putExtra("nama", selection);
                                startActivity(in);
                                break;
                            case 2:
                                SQLiteDatabase db = database.getWritableDatabase();
                                db.execSQL("DELETE FROM mahasiswa WHERE nama='"+ selection +"' ");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter)listview.getAdapter()).notifyDataSetInvalidated();
    }

}