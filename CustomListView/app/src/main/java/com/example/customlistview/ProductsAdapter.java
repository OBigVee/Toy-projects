package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProductsAdapter extends ArrayAdapter<Products> {
    private final Context context;
    private final ArrayList<Products> values;

    public ProductsAdapter(@NonNull Context context,  ArrayList<Products> list) {
        super(context, R.layout.row_layout,list);
        this.context = context;
        this.values = list;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_layout,parent,false);

        TextView tvProduct = (TextView) rowView.findViewById(R.id.tvProduct);
        TextView tvPrice  = (TextView) rowView.findViewById(R.id.tvPrice);
        TextView tvDescription = (TextView) rowView.findViewById(R.id.tvDescription);

        ImageView ivProduct = (ImageView) rowView.findViewById(R.id.ivProduct);
        ImageView ivSale = (ImageView) rowView.findViewById(R.id.ivSale);


        tvProduct.setText(values.get(position).getTitle());
        tvPrice.setText("#"+ values.get(position).getPrice());
        tvDescription.setText(values.get(position).getDescription());

        if(values.get(position).getSale()){
            ivSale.setImageResource(R.mipmap.sale);
        }
        else {
            ivSale.setImageResource(R.mipmap.best_price);
        }

        if(values.get(position).getType().equals("Laptop")){
            ivProduct.setImageResource(R.mipmap.laptop);
        }
        else if(values.get(position).getType().equals("hdd".toUpperCase())){
            ivProduct.setImageResource(R.mipmap.hdd);
        }
        else if(values.get(position).getType().equals("Flash_drive")){
            ivProduct.setImageResource(R.mipmap.flash_drive);
        }
        else{
            ivProduct.setImageResource(R.mipmap.screen);
        }



        return rowView;
    }
}
