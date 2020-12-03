package com.example.testit.entity;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;


public class Item {

    private String name;
    private int id;
    private int idCategorie;
    private String nomImage;
    private Drawable imgDrawable;
    public Item() {
    }
    public Item(String name, int idCategorie) {
        this.name = name;
        this.idCategorie = idCategorie;
    }
    public Item(String name, int id, int idCategorie, String nomImage) {
        this.name = name;
        this.id = id;
        this.idCategorie = idCategorie;
        this.nomImage = nomImage;
    }
    public Item(Context ctx, String name, int id, int idCategorie, String nomImage) {
        this.name = name;
        this.id = id;
        this.nomImage = nomImage;
        this.idCategorie = idCategorie;
        try {
            this.imgDrawable = Drawable.createFromStream(ctx.getAssets().open("img/" + nomImage), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getNomImage() {
        return nomImage;
    }
    public void setNomImage(String nomImage) {
        this.nomImage = nomImage;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdCategorie() {
        return idCategorie;
    }
    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }
    public Drawable getImgDrawable() {
        return imgDrawable;
    }
    public void setImgDrawable(Drawable imgDrawable) {
        this.imgDrawable = imgDrawable;
    }
}
