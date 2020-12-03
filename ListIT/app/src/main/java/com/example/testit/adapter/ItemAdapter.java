package com.example.testit.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.example.testit.R;
import com.example.testit.entity.Item;
import com.example.testit.manager.ItemListmanager;
import com.example.testit.manager.ItemManager;
import com.example.testit.manager.ListesManager;

import java.util.ArrayList;


public class ItemAdapter extends ArrayAdapter<Item> {

    Context ctx;
    int idLayout;
    // int listeEncours;
    public ItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Item> objects) {
        super(context, resource, objects);
        idLayout = resource;
        context = ctx;
        // listeEncours = 0;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // return super.getView(position, convertView, parent);
        final Item item = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(idLayout, null);
        }
        Button btn = convertView.findViewById(R.id.btnajouterItem);
        ImageView imgitem = convertView.findViewById(R.id.imgItemLayout);
        TextView tvItem = convertView.findViewById(R.id.tvItemLayout);
        if (item.getImgDrawable() != null) {
            imgitem.setImageDrawable(item.getImgDrawable());
        } else {
            imgitem.setImageResource(R.drawable.noimage);
        }
        //imgitem.setImageDrawable(item.getImgDrawable());
        tvItem.setText(item.getName());
        imgitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("hi", "hi");
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("voulez- vous ajouter cet item a votre liste?");
                builder.setPositiveButton("oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ItemListmanager.addItemlist(getContext(), item.getId(), ListesManager.getLastOneListeid(getContext()));
                        // Log.v("id", String.valueOf(item.getId()));
                        clear();
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Non", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        return convertView;
    }
}
