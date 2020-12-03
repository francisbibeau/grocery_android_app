package com.example.testit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testit.adapter.CategoryAdapter;
import com.example.testit.entity.Category;
import com.example.testit.entity.Item;
import com.example.testit.manager.CategoryManager;
import com.example.testit.manager.ItemManager;
import com.example.testit.manager.ListesManager;
import com.example.testit.services.ConnexionBd;

import java.util.ArrayList;


public class CategoryGridViewActivity extends AppCompatActivity {

    ImageView logo;
    Context ctx;
    Button btnAjouter;
    TextView edtNomListeActuelle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_grid_view);
        ctx = this;
        logo = findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, MainActivity.class);
                startActivity(intent);
            }
        });
        btnAjouter = findViewById(R.id.btn_ajouter_category);
        edtNomListeActuelle = findViewById(R.id.listeActuelle);
        edtNomListeActuelle.setText(ListesManager.getLastOneListe(ctx));
        ConnexionBd.importDatabase(ctx);
        GridView gv = findViewById(R.id.gv);
        final CategoryAdapter categoryAdapter = new CategoryAdapter(ctx, R.layout.category_layout, CategoryManager.getAll(ctx));
        gv.setAdapter(categoryAdapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(ctx, "salut", Toast.LENGTH_LONG).show();
                Category item = (Category) parent.getItemAtPosition(position);
                int categoryId = item.getId(); // ca cest l'id de la category
                ArrayList<Item> items = ItemManager.getByIdCategory(ctx, categoryId);
                Intent intent = new Intent(ctx, ItemGridViewActivity.class);
                intent.putExtra("id", categoryId);
                startActivity(intent);
                //  Log.v("hi" , String.valueOf(categoryId));
            }
        });
        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(ctx);
                builder1.setMessage("Entrez le nom de la La category");
                LinearLayout ll = new LinearLayout(ctx);
                final EditText ed = new EditText(ctx);
                ll.setOrientation(LinearLayout.VERTICAL);
                ll.addView(ed);
                builder1.setView(ll);
                builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String leNom;
                        leNom = ed.getText().toString();
                        Category category = new Category(leNom, "image");
                        CategoryManager.addCategory(ctx, category);
                        categoryAdapter.clear();
                        categoryAdapter.notifyDataSetChanged();
                        Toast.makeText(ctx,"categorie crée",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(ctx,CategoryGridViewActivity.class);
                        startActivity(intent);
                    }
                });
                builder1.setNegativeButton("Non", null);
                AlertDialog dialog1 = builder1.create();
                dialog1.show();
            }
        });
    }
}