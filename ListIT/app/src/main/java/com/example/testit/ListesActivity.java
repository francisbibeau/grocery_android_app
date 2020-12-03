package com.example.testit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testit.adapter.ListesAdapter;
import com.example.testit.manager.ListesManager;
import com.example.testit.services.ConnexionBd;


public class ListesActivity extends AppCompatActivity {

    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listes_view_listes_layout);
        ctx = this;
        Intent intent = getIntent();
        ConnexionBd.importDatabase(ctx);
        ListView listesViewListes = findViewById(R.id.list_view_listes);
        ListesAdapter listesAdapter = new ListesAdapter(ctx, R.layout.listes_component_layout, ListesManager.getAllDesc(ctx));
        listesViewListes.setAdapter(listesAdapter);
    }
}

