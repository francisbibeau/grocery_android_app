package com.example.testit.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.testit.entity.Category;
import com.example.testit.entity.Listes;
import com.example.testit.services.ConnexionBd;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class ListesManager {

    private final static String querySupprimerListe = "DELETE from lists where id = ?;";
    public static void supprimerListe(Context ctx, int id) {
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        //SQLiteDatabase db=this.getWritableDatabase();
        Log.v("pop", "" + id);
        bd.execSQL(querySupprimerListe, new String[]{"" + id});
        bd.close();
    }
    //  private final static String queryCreerListe =   "INSERT INTO lists(date,name) VALUES(datetime('now'),?);";
    public static Boolean addListe(Context ctx, Listes liste) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        cv.put("name", liste.getNom());
        cv.put("date", liste.getDate());
        long resultat = bd.insert("lists", null, cv);
        ConnexionBd.closeBd();
        if (resultat == -1) {
            return false;
        } else {
            return true;
        }
    }
    private final static String queryGetAllDesc = "select * from lists ORDER by date Desc;";
    public static List<Listes> getAllDesc(Context ctx) {
        ArrayList<Listes> listes = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        // SQLiteDatabase db1=getReadableDatabase();
        //Cursor cursor = getReadableDtabase()
        Cursor cursor = bd.rawQuery(queryGetAllDesc, null);
        while (cursor.moveToNext()) {
            listes.add(new Listes(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
        }
        return listes;
    }
    private final static String queryGetAll = "select * from lists";
    public static List<Listes> getAll(Context ctx) {
        ArrayList<Listes> listes = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        // SQLiteDatabase db1=getReadableDatabase();
        //Cursor cursor = getReadableDtabase()
        Cursor cursor = bd.rawQuery(queryGetAll, null);
        while (cursor.moveToNext()) {
            listes.add(new Listes(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
        }
        return listes;
    }
    private final static String queryRyGetLastOne = "Select name FROM lists order by date Desc LIMIT 1";
    public static String getLastOneListe(Context ctx) {
        String lasOneList = null;
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor cursor = bd.rawQuery(queryRyGetLastOne, null);
        if (cursor.moveToNext()) {
            lasOneList = cursor.getString(0);
        }
        return lasOneList;
    }
    private final static String queryRyGetLastOneid = "Select id FROM lists order by date Desc LIMIT 1";
    public static int getLastOneListeid(Context ctx) {
        int lasOneListId = 0;
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor cursor = bd.rawQuery(queryRyGetLastOneid, null);
        if (cursor.moveToNext()) {
            lasOneListId = cursor.getInt(0);
        }
        return lasOneListId;
    }
    public static String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}

