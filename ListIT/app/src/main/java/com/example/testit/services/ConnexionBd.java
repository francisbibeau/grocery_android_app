package com.example.testit.services;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class ConnexionBd {
    private static SQLiteDatabase bd;
    private static int version = 1;
    private static  String nomBd = "databd";

    public static SQLiteDatabase getBd(Context ctx){
        GestionCategoryBd gestionCategoryBd = new GestionCategoryBd(ctx,nomBd,null,version);
        bd= gestionCategoryBd.getWritableDatabase();
        return  bd;
    }

    public  static void closeBd(){
        bd.close();
    }

    public static void importDatabase (Context ctx){

        AssetManager assetManager = ctx.getAssets();

        InputStream in = null;
        OutputStream out = null;
        try {
            in = assetManager.open("databd.db");
            out = new FileOutputStream(ctx.getDatabasePath(nomBd));
            int read = 0;
            byte[] buffer = new byte[256];
            while ((read = in.read(buffer)) != -1){
                out.write(buffer);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
