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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.testit.adapter.ItemAdapter;
import com.example.testit.entity.Category;
import com.example.testit.entity.Item;
import com.example.testit.manager.ItemListmanager;
import com.example.testit.manager.ItemManager;
import com.example.testit.manager.ListesManager;
import com.example.testit.services.ConnexionBd;


public class ItemGridViewActivity extends AppCompatActivity {

    Context ctx;
    Button btnAjouter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_grid_view);
        ctx = this;
        btnAjouter = findViewById(R.id.btnajouterItem);
        ConnexionBd.importDatabase(ctx);
        Intent intentRetour = getIntent();
        intentRetour.getIntExtra("id", 0);
        int id = intentRetour.getIntExtra("id", 0);
        //Log.v("hi", String.valueOf(id));
        GridView gv = findViewById(R.id.gv_item);
        final ItemAdapter itemAdapter = new ItemAdapter(ctx, R.layout.item_layout, ItemManager.getByIdCategory(ctx, id));
        gv.setAdapter(itemAdapter);
        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(ctx);
                builder1.setMessage("Entrez le nom de la L'item");
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
                        Item item1 = new Item(leNom, 2);
                        ItemManager.addItem(ctx, item1);
                        itemAdapter.clear();
                        itemAdapter.notifyDataSetChanged();
                        Toast.makeText(ctx,"item crée",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(ctx, CategoryGridViewActivity.class);
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
