package com.example.testit.services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class GestionCategoryBd extends SQLiteOpenHelper {

    public GestionCategoryBd(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
      /*  String CREATE_CATEGORY_TABLE = "CREATE TABLE \"category\" (\n" +
                "\t\"name\"\tTEXT NOT NULL,\n" +
                "\t\"id\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"imgUrl\"\tINTEGER\n" +
                ")";
        String CREATE_ITEM_TABLE = "CREATE TABLE \"item\" (\n" +
                "\t\"name\"\tINTEGER NOT NULL,\n" +
                "\t\"id\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"idCategory\"\tINTEGER NOT NULL,\n" +
                "\t\"imgUrl\"\tINTEGER\n" +
                ")";
        String CREATE_ITEM_LIST_TABLE = "CREATE TABLE \"itemlist\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                "\t\"id_list\"\tINTEGER,\n" +
                "\t\"id_product\"\tINTEGER NOT NULL\n" +
                ")";
        String CREATE_LISTS_TABLE = "CREATE TABLE \"lists\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                "\t\"date\"\tNUMERIC NOT NULL,\n" +
                "\t\"name\"\tTEXT NOT NULL UNIQUE\n" +
                ")";
        String JE_SAIS_PAS = "CREATE TABLE sqlite_sequence(name,seq)";
        db.execSQL(CREATE_CATEGORY_TABLE);
        db.execSQL(CREATE_ITEM_TABLE);
        db.execSQL(CREATE_ITEM_LIST_TABLE);
        db.execSQL(CREATE_LISTS_TABLE);
        db.execSQL(JE_SAIS_PAS);*/
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       onCreate(db);
    }
}
