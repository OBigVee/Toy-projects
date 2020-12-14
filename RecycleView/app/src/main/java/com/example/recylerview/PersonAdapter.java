package com.example.recylerview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> people;
    ItemClicked activity;

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    public PersonAdapter(Context context, ArrayList<Person> list){
        people = list;
        activity = (ItemClicked) context;

    }
        // this class rep every items in the list view
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivPref;
        TextView tvName,tvSurname;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            ivPref = itemView.findViewById(R.id.ivPref);
            tvName = itemView.findViewById(R.id.tvName);
            tvSurname = itemView.findViewById(R.id.tvSurname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(people.indexOf((Person)itemView.getTag()));

                }
            });
        }

    }



    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder .itemView.setTag(people.get(position));
        holder.tvName.setText(people.get(position).getName());
        holder.tvSurname.setText(people.get(position).getSurName());




        if (people.get(position).getPreference().equals("bus")){
            holder.ivPref.setImageResource(R.drawable.bus);
        }
        else if (people.get(position).getPreference().equals("plane")){
            holder.ivPref.setImageResource(R.drawable.plane);
        }
        else if (people.get(position).getPreference().equals("train")){
            holder.ivPref.setImageResource(R.drawable.train);
        }
        else {
            holder.ivPref.setImageResource(R.drawable.bike);
        }

    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
