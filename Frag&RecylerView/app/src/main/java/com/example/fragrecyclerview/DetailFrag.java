package com.example.fragrecyclerview;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFrag extends Fragment {
RecyclerView recyclerView;
RecyclerView.Adapter myAdapter;
RecyclerView.LayoutManager layoutManager;
View view;

    public DetailFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       return inflater.inflate(R.layout.fragment_detail, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        recyclerView = view.findViewById(R.id.lld);
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this.getActivity());
//        recyclerView.setLayoutManager(layoutManager);


//        myAdapter = new PersonAdpater(this.getActivity(),AppClass.people);
//        recyclerView.setAdapter(myAdapter);
    }
}
