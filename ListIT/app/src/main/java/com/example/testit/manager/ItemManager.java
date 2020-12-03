package com.example.testit.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.testit.entity.Item;
import com.example.testit.entity.Liste;
import com.example.testit.entity.Listes;
import com.example.testit.services.ConnexionBd;

import java.util.ArrayList;
import java.util.List;


public class ItemManager {

    private final static String queryGetAll = "select * from item";
    public static ArrayList<Item> getAll(Context ctx) {
        ArrayList<Item> items = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        // SQLiteDatabase db1=getReadableDatabase();
        //Cursor cursor = getReadableDtabase()
        Cursor cursor = bd.rawQuery(queryGetAll, null);
        while (cursor.moveToNext()) {
            items.add(new Item(ctx, cursor.getString(0), cursor.getInt(1), cursor.getInt(2), cursor.getString(3)));
        }
        return items;
    }
    private final static String querryGetByIdCategory = "select * from item where idCategory = ?";
    public static ArrayList<Item> getByIdCategory(Context ctx, int idCategory) {
        ArrayList<Item> lisItemByCategory = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor cursor = bd.rawQuery(querryGetByIdCategory, new String[]{"" + idCategory});
        while (cursor.moveToNext()) {
            lisItemByCategory.add(new Item(ctx, cursor.getString(0), cursor.getInt(1), cursor.getInt(2), cursor.getString(3)));
            ConnexionBd.closeBd();
        }
        return lisItemByCategory;
    }
    private final static String querryGetItemById = "select * from item where id = ?";
    public static Item getItemById(Context ctx, int idItem) {
        Item item = new Item();
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        Cursor cursor = bd.rawQuery(querryGetItemById, new String[]{"" + idItem});
        while (cursor.moveToNext()) {
            item = (new Item(cursor.getString(0), cursor.getInt(1), cursor.getInt(2), cursor.getString(3)));
        }
        return item;
    }
    //AjouterNnouvelItem
    public static Boolean addItem(Context ctx, Item item) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        cv.put("name", item.getName());
        cv.put("idCategory", item.getIdCategorie());
        //  cv.put("nom_image", item.getNomImage());
        long resultat = bd.insert("item", null, cv);
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
        Log.v("pop", "" + id);
        bd.execSQL(querySupprimerItem, new String[]{"" + id});
        bd.close();
    }
}
