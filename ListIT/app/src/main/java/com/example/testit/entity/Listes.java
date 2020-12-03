package com.example.testit.entity;

import java.util.Date;


public class Listes {

    int id;
    String date;
    String nom;
    public Listes() {
    }

    public Listes(int id, String date, String nom) {
        this.id = id;
        this.date = date;
        this.nom = nom;
    }
    public Listes( String date, String nom) {

        this.date = date;
        this.nom = nom;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
