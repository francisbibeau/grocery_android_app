package com.example.testit.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testit.ListeActivity;
import com.example.testit.ListesActivity;
import com.example.testit.R;
import com.example.testit.entity.Liste;
import com.example.testit.entity.Item;
import com.example.testit.manager.ItemListmanager;
import com.example.testit.manager.ListeManager;
import com.example.testit.manager.ListesManager;

import java.util.List;


public class ListeAdapter extends ArrayAdapter<Item> {

    int layout;
    Intent intent;
    Context ctx;
    Button btnSupprimer;
    //3eme construnteur
    public ListeAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        layout = resource;
    }
    /*  btnSupprmier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListesManager.supprimerListe(ctx, liste.getId());
                clear();
                notifyDataSetChanged();
                Intent myIntent = new Intent(v.getContext(), ListesActivity.class);
                v.getContext().startActivity(myIntent);
                Toast.makeText(getContext(), "la liste a ete suprime", Toast.LENGTH_SHORT).show();

            }
        });*/
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Item item = getItem(position);
        Button btnSupprimer = convertView.findViewById(R.id.btn_supprimer_item_liste);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(layout, null);
        } else {
        }
        btnSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemListmanager.supprimerItem(ctx, item.getId());
                clear();
                notifyDataSetChanged();
                Intent myIntent = new Intent(v.getContext(), ListeActivity.class);
                v.getContext().startActivity(myIntent);
                Toast.makeText(getContext(),"l'item a ete suprime",Toast.LENGTH_SHORT).show();
            }
        });
        TextView tvNom = convertView.findViewById(R.id.item_liste_name);
        tvNom.setText(item.getName());
        return convertView;
    }
}



