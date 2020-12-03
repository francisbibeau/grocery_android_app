package com.example.testit.manager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.testit.entity.Liste;
import com.example.testit.services.ConnexionBd;

import java.util.ArrayList;
import java.util.List;


public class ListeManager {

    private final static String queryGetAll = "select * from itemlist";
    private final static String queryGetById = "select * from itemlist where id_list = ?";
    public static List<Liste> getAll(Context ctx) {
        ArrayList<Liste> liste = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor cursor = bd.rawQuery(queryGetAll, null);
        while (cursor.moveToNext()) {
            liste.add(new Liste(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2)));
        }
        return liste;
    }
    public static ArrayList<Liste> getById(Context ctx, String idListe) {
        ArrayList<Liste> retour = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor cursor = bd.rawQuery(queryGetById, new String[]{"" + idListe});
        while (cursor.moveToNext()) {
            retour.add(new Liste(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2)));
        }
        return retour;
    }
}


