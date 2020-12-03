package com.example.testit.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.testit.entity.Category;
import com.example.testit.entity.Item;
import com.example.testit.services.ConnexionBd;

import java.util.ArrayList;
import java.util.List;


public class CategoryManager {

       private final static String queryGetAll = "select * from category;";// si final ca veut sdire quelle va pa changer
    private static ArrayList<Category> categories = new ArrayList<>();
    public static List<Category> getAll(Context ctx) {
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        // SQLiteDatabase db1=getReadableDatabase();
        //Cursor cursor = getReadableDtabase()
        Cursor cursor = bd.rawQuery(queryGetAll, null);//ou bd.ececutesql mais il va rien me retourner
        while (cursor.moveToNext()) {
            categories.add(new Category(ctx, cursor.getString(0), cursor.getInt(1), cursor.getString(2)));
        }
        ConnexionBd.closeBd();
        return categories;
    }
    public static Category getById(int id) {
        int indice = 0;
        while (indice < categories.size() && categories.get(indice).getId() != id) indice++;
        return categories.get(indice);
    }

//    private final static String querryAddCategory = "insert into category(name,id,nom_image) values (?,?,?)";

    //AjouterNnouvelItem
    public static Boolean addCategory(Context ctx, Category category) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        cv.put("name", category.getName());
        cv.put("nom_image", category.getNomImage());
        long resultat = bd.insert("category", null, cv);
        ConnexionBd.closeBd();
        if (resultat == -1) {
            return false;
        } else {
            return true;
        }
    }
}