package com.example.recylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Person> people;
    Button button_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_add = findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("new","NewMan","plane"));
                myAdapter.notifyDataSetChanged();

            }
        });
        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true); // makes sures the recycle view is not changing

        // Linear vertical scrolling
        //layoutManager = new LinearLayoutManager(this);

        // grid vertical scrolling
        layoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);

        // Grid Horizontal scrolling
        //layoutManager = new GridLayoutManager(this,3,GridLayoutManager.HORIZONTAL,false);

        // Linear Horizontal Scrolling
        //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);

        recyclerView.setLayoutManager(layoutManager);


        people = new ArrayList<Person>();
        people.add(new Person("John","Rambo","bus"));
        people.add(new Person("Trump","Donald","plane"));
        people.add(new Person("Taye","Ope","bus"));
        people.add(new Person("Yemi","Ayeni","plane"));
        people.add(new Person("Victor","Mark","plane"));
        people.add(new Person("Juliet","Adedeji","plane"));
        people.add(new Person("Justina","Ariyo","bus"));
        people.add(new Person("Samson","Oguntade","bus"));
        people.add(new Person("Grace","Opeyemi","plane"));
        people.add(new Person("Tolu","Amos","bus"));
        people.add(new Person("Ebube","adedoyin","bus"));
        people.add(new Person("Naeem","Illias","bus"));
        people.add(new Person("Kent","Olalusi","plane"));
        people.add(new Person("Mayorwa","Obebe","bus"));
        people.add(new Person("Desmond","Akinde","plane"));
        people.add(new Person("Deborah","Adedoyin","bus"));
        people.add(new Person("Pelumi","adedoyin","plane"));
        people.add(new Person("Segun","Raimi","bus"));
        people.add(new Person("Steve","Adebomi","bus"));
        people.add(new Person("Lawrence","Okegbemi","bus"));
        people.add(new Person("Samson","Amos","plane"));
        people.add(new Person("Yetunde","Ilesanmi","plane"));
        people.add(new Person("Tope","Bello","bus"));
        people.add(new Person("Tosin","Bello","plane"));
        people.add(new Person("Deborah","Oluwayemisi","plane"));
        people.add(new Person("Elijah","Jacob","train"));
        people.add(new Person("Harmzat","Toeam","bike"));
        people.add(new Person("Folajimi","Ojo","bike"));
        people.add(new Person("Captain","Philip","train"));
        people.add(new Person("Babatunde","Fashola","bike"));
        people.add(new Person("Muhahmed","Buhari","plane"));





        myAdapter = new PersonAdapter(this,people);
        recyclerView.setAdapter(myAdapter);


    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, "surname:"+people.get(index).getSurName(), Toast.LENGTH_SHORT).show();
        
    }
}
