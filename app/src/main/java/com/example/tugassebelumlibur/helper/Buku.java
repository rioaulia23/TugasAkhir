package com.example.tugassebelumlibur.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Buku extends SQLiteOpenHelper {
    final static String NAMADB = "bukus.db";
    final static int VERSIDB = 1;

    public Buku(Context context) {
        super(context, NAMADB, null, VERSIDB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreate = "CREATE TABLE " +
                "buku(_id integer primary key autoincrement," +
                "title text, author text);";
        db.execSQL(queryCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropQuery = "DROP TABLE IF EXISTS buku";
        db.execSQL(dropQuery);
        onCreate(db);
    }
}