package com.example.uas_mobile;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DataHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "mahasiswa.db";
    public DataHelper (Context context) {
        super(context, DATABASE_NAME, null , 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table mahasiswa ( nama text, nim text , kelas text , email text , hp text , alamat text );";
        Log.d("Data","onCreate : " + sql);
        db.execSQL(sql);
        sql = "Insert Into mahasiswa ( nama, nim, kelas, email, hp, alamat )" +
                " VALUES ('Eko Budiarto', '191011402097', '06TPLE024', 'ekobcode@gmail.com', '082322728715','Jakarta Barat');";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
