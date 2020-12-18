package com.example.fragrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdpater extends RecyclerView.Adapter<PersonAdpater.ViewHolder> {

    ItemClicked activity;
    private ArrayList<Person> people;

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    public PersonAdpater(Context context, ArrayList<Person>list) {
        people = list;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(people.indexOf((Person) v.getTag()));

                }
            });


        }
    }
    @NonNull
    @Override
    // this section creates a view of the items in row_layout xlm file
    public PersonAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdpater.ViewHolder holder, int position) {

        holder.itemView.setTag(people.get(position));

        holder.tvName.setText(people.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
