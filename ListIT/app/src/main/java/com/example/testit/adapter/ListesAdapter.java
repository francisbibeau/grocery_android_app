package com.example.testit.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testit.ItemGridViewActivity;
import com.example.testit.ListeActivity;
import com.example.testit.ListesActivity;
import com.example.testit.R;
import com.example.testit.entity.Listes;
import com.example.testit.manager.ListesManager;

import java.lang.reflect.Field;
import java.util.List;


public class ListesAdapter extends ArrayAdapter<Listes> {

    int layout;
    Intent intent;
    Context ctx;
    //3eme construnteur
    public ListesAdapter(@NonNull Context context, int resource, @NonNull List<Listes> objects) {
        super(context, resource, objects);
        this.ctx = context;
        layout = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Listes liste = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(layout, null);
        } else {
        }
        TextView tvNomListes = convertView.findViewById(R.id.listes_nom_layout);
        TextView tvDateListes = convertView.findViewById(R.id.listes_date_layout);
        Button btnSupprmier = convertView.findViewById(R.id.btn_supprimer_liste_item_listes_layout);
        tvNomListes.setText(liste.getNom());
        btnSupprmier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListesManager.supprimerListe(ctx, liste.getId());
                clear();
                notifyDataSetChanged();
                Intent myIntent = new Intent(v.getContext(), ListesActivity.class);
                v.getContext().startActivity(myIntent);
                Toast.makeText(getContext(), "la liste a ete suprime", Toast.LENGTH_SHORT).show();

            }
        });
        Log.v("salut", String.valueOf(liste.getId()));
        tvNomListes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, ListeActivity.class);
                intent.putExtra("idListe", liste.getId());
                ctx.startActivity(intent);
            }
        });
        tvDateListes.setText(liste.getDate());
        return convertView;
    }
}
