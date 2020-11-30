package com.example.frag;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class listFrag extends ListFragment {

    ItemSelected activity;

    public listFrag() {
        // Required empty public constructor
    }

    public  interface ItemSelected{
        void onItemSelection(int index);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (ItemSelected) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String [] data = getResources().getStringArray(R.array.pieces);

        //ArrayList<String> data = new ArrayList<>();

//        data.add("1, this is item 1");
//        data.add("2, this is item 2");
//        data.add("3, this is item 3");
//        data.add("4, this is item 4");


        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data));

        // phone is landscape mode
        if (getActivity().findViewById(R.id.layout_portrait) == null){
            activity.onItemSelection(0);
        }
        //activity.onItemSelection(0);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
       // super.onListItemClick(l, v, position, id);
        activity.onItemSelection(position);
    }
}
