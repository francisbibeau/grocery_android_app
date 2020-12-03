package com.example.testit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testit.entity.Item;
import com.example.testit.entity.Liste;
import com.example.testit.adapter.ListeAdapter;
import com.example.testit.manager.ItemManager;
import com.example.testit.manager.ListeManager;
import com.example.testit.services.ConnexionBd;

import java.util.ArrayList;


public class ListeActivity extends AppCompatActivity {

    Context ctx;
    int idListe;
    ArrayList<Item> items;
    ImageView bouttonRedirection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_host_layout);
        ctx = this;
        items = new ArrayList<>();

        setContentView(R.layout.liste_host_layout);
        bouttonRedirection=findViewById(R.id.liste_host_image_button_redirection);
        ConnexionBd.importDatabase(ctx);
        ListView listeViewListe = findViewById(R.id.list_view_liste);
        Intent intent = getIntent();
        idListe = intent.getIntExtra("idListe", -1);
        //   Log.v("voila", "" + idListe);
        ArrayList<Liste> produits = ListeManager.getById(this, "" + idListe);
        for (Liste produit : produits) {
            int idProd = produit.getIdProduct();
            Log.v("produit", "" + idProd);
            Item item = new Item();
            item = ItemManager.getItemById(this, idProd);
            items.add(item);
        }
        ListeAdapter listeAdapter = new ListeAdapter(ctx, R.layout.layout_liste_component_layout, items);
        listeViewListe.setAdapter(listeAdapter);
    }
}
