package com.example.testit.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testit.R;
import com.example.testit.entity.Category;

import java.util.List;


public class CategoryAdapter extends ArrayAdapter<Category> {

    int layout;
    //3eme construnteur
    public CategoryAdapter(@NonNull Context context, int resource, @NonNull List<Category> objects) {
        super(context, resource, objects);
        layout = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Category category = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(layout, null);
        } else {
//            convertView.setBackgroundColor(Color.RED);
        }
        ImageView img = convertView.findViewById(R.id.imgCategoryLayout);
        TextView tv = convertView.findViewById(R.id.tvCategoryLayout);
        // return super.getView(position, convertView, parent);
        // img.setImageDrawable(category.getImgDrawable());
        if (category.getImgDrawable() != null) {
            img.setImageDrawable(category.getImgDrawable());
        } else {
            img.setImageResource(R.drawable.noimage);
        }
        tv.setText(category.getName());
       /* img.setOnClickListener(new View.OnClickListener() {
            //int i = img.getId();
            @Override
            public void onClick(View v) {
                 Log.v("salut", "hi");
            }
        });*/
        return convertView;
        //cest possible que convetView soi null
    }
}
