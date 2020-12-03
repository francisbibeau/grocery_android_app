package com.example.testit.entity;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;


public class Category {

    private String name;
    private int id;
    private String nomImage;
    private Drawable imgDrawable;
    public Category() {
    }
    public Category(String name, String nomImage) {
        this.name = name;
        this.nomImage = nomImage;
    }
    public Category(Context ctx, String name, int id, String imgUrl) {
        this.name = name;
        this.id = id;
        this.nomImage = imgUrl;
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
    public Drawable getImgDrawable() {
        return imgDrawable;
    }
    public void setImgDrawable(Drawable imgDrawable) {
        this.imgDrawable = imgDrawable;
    }
}
