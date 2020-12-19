package com.example.cardetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    ArrayList<Car> cars;
//    ItemClicked activity;

    public CarAdapter(Context context, ArrayList<Car> list){
        cars = list;
       // activity = (ItemClicked) context;
    }

//    public interface ItemClicked{
//        void onItemClicked(int index);
//    }
    // get access to the row_layout id's
    // and then get them link to OnCreateViewHolder Method and on the onBindViewHolder where we set the items
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivBrand;
        TextView tvModel, tvOwner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivBrand = itemView.findViewById(R.id.ivBrand);
            tvModel = itemView.findViewById(R.id.tvModel);
            tvOwner = itemView.findViewById(R.id.tvOwner);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
        }
    }

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //must return an object of the class CarAdapter
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {
        // this function runs for every element you have in the cars
        holder.itemView.setTag(cars.get(position));

        holder.tvOwner.setText(cars.get(position).getOwnerName());
        holder.tvModel.setText(cars.get(position).getModel());

        // change the image as selected by the client
        if(cars.get(position).getBrand().equals("Volkswagen")){
            holder.ivBrand.setImageResource(R.drawable.volkswagen);
        }
        else if(cars.get(position).getBrand().equals("Nissan")){
            holder.ivBrand.setImageResource(R.drawable.nissan);
        }
        else{
            holder.ivBrand.setImageResource(R.drawable.mercedes);
        }

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
