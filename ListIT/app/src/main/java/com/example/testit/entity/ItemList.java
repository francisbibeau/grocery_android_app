package com.example.testit.entity;

public class ItemList {

    private int id;
    private int id_liste;
    private int id_product;
    public ItemList() {
    }
    public ItemList(int id, int id_liste, int id_product) {
        this.id = id;
        this.id_liste = id_liste;
        this.id_product = id_product;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_liste() {
        return id_liste;
    }
    public void setId_liste(int id_liste) {
        this.id_liste = id_liste;
    }
    public int getId_product() {
        return id_product;
    }
    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

}
