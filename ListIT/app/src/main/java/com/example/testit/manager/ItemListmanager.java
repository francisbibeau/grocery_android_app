package com.example.testit.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.testit.services.ConnexionBd;
/*  SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        cv.put("name", liste.getNom());
        cv.put("date", liste.getDate());
        long resultat = bd.insert("lists", null, cv);
        ConnexionBd.closeBd();*/

public class ItemListmanager {

    public static Boolean addItemlist(Context ctx, int idProduit, int idListe) {
        String where = "id=?";
        String[] whereArgs = new String[]{String.valueOf(idListe)};
        ContentValues cv = new ContentValues();
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        cv.put("id_list", idListe);
        cv.put("id_product", idProduit);
        //long resultat = bd.insert("liste", where, cv);
        long resultat = bd.insert("itemlist", null,cv);
        Log.d("bd",""+bd.insert("itemlist", null,cv));
        ConnexionBd.closeBd();
        if (resultat == -1) {
            return false;
        } else {
            return true;
        }
    }
    private final static String querySupprimerItem = "DELETE from itemlist where id = ?;";
    public static void supprimerItem(Context ctx, int id) {
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        //SQLiteDatabase db=this.getWritableDatabase();
        Log.v("pop", "" + id);
        bd.execSQL(querySupprimerItem, new String[]{"" + id});
        bd.close();
    }

}
