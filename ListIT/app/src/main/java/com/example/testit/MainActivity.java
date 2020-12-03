package com.example.testit;

import java.sql.Date;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testit.adapter.ListesAdapter;
import com.example.testit.entity.Listes;
import com.example.testit.manager.ListesManager;
import com.example.testit.services.ConnexionBd;

import java.text.SimpleDateFormat;


public class MainActivity extends AppCompatActivity {

    LinearLayout ll_header;
    Button btnCategories, btnListes, btnCreerListe;
    TextView textCategories;
    Context ctx;
    Date date;
    Intent intent;
    Handler handler;
    Animation animation;
    LinearLayout llMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        // ConnexionBd.importDatabase(ctx);
        setContentView(R.layout.activity_main);
        llMain = findViewById(R.id.ll_body_acceuil);
        handler = new Handler();
        animation = new Animation(ctx, handler);
        llMain.addView(animation);
        btnCategories = findViewById(R.id.btn_categories);
        btnListes = findViewById(R.id.btn_listes);
        btnCreerListe = findViewById(R.id.btn_creer_liste);
        Intent intentRetour = getIntent();
        btnCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ctx, CategoryGridViewActivity.class);
                startActivity(intent);
            }
        });
        btnListes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ctx, ListesActivity.class);
                startActivity(intent);
            }
        });
        btnCreerListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setMessage("Voulez-vous créer une nouvelle liste ?");
                builder.setTitle("Création d'une nouvelle liste");
                builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(ctx);
                        builder1.setMessage("Entrez le nom de la liste");
                        builder1.setTitle("Création d'une nouvelle liste");
                        LinearLayout ll = new LinearLayout(ctx);
                        final EditText ed = new EditText(ctx);
                        ll.setOrientation(LinearLayout.VERTICAL);
                        ll.addView(ed);
                        builder1.setView(ll);
                        builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                final String leNom;
                                leNom = ed.getText().toString();
                                Log.v("marche", leNom);
                                ListesAdapter list = new ListesAdapter(ctx, R.layout.listes_component_layout, ListesManager.getAllDesc(ctx));
                                Listes liste = new Listes(ListesManager.getDateTime(), leNom);
                                ListesManager.addListe(ctx, liste);
                                list.clear();
                                //je rajoute une nouvelle liste
                                list.notifyDataSetChanged();
                            }
                        });
                        AlertDialog dialog2 = builder1.create();
                        dialog2.show();
                    }
                });
                builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx, "La liste n'a pas été créé", Toast.LENGTH_SHORT).show();
                        Log.v("salut", "salut");
                    }
                });
                // builder.show();
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
