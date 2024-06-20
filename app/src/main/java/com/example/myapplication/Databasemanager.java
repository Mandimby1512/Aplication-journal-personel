package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Databasemanager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "listeapp.db";
    private static final int DATABASE_VERSION = 1;

    public Databasemanager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createListeTable = "CREATE TABLE liste (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL)";
        db.execSQL(createListeTable);

        String createNotelisteTable = "CREATE TABLE noteliste (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "isDone INTEGER NOT NULL," +
                "idliste INTEGER NOT NULL)";
        db.execSQL(createNotelisteTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades if needed
    }

    public void insertliste(String listeName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", listeName);
        db.insert("liste", null, values);
        db.close();
    }

    public ArrayList<liste> getAllliste() {
        ArrayList<liste> listeArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM liste", null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));

                liste listeobj = new liste();
                listeobj.setId(id);
                listeobj.setName(name);

                listeArrayList.add(listeobj);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return listeArrayList;
    }
}
