package com.example.recylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Person> people;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true); // makes sures the recycle view is not changing

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        people = new ArrayList<Person>();
        people.add(new Person("john","rambo","bus"));
        people.add(new Person("trump","Donald","plane"));
        people.add(new Person("taye","ope","bus"));
        people.add(new Person("Yemi","ayeni","plane"));
        people.add(new Person("Victor","Mark","plane"));
        people.add(new Person("Juliet","Adedeji","plane"));
        people.add(new Person("Justina","Ariyo","bus"));
        people.add(new Person("Samson","oguntade","bus"));
        people.add(new Person("Grace","Opeyemi","plane"));
        people.add(new Person("Tolu","amos","bus"));
        people.add(new Person("Ebube","adedoyin","bus"));
        people.add(new Person("Naeem","Illias","bus"));
        people.add(new Person("Kent","Olalusi","plane"));
        people.add(new Person("Mayorwa","Obebe","bus"));
        people.add(new Person("Desmond","akinde","plane"));
        people.add(new Person("Deborah","adedoyin","bus"));
        people.add(new Person("Pelumi","adedoyin","plane"));
        people.add(new Person("Segun","Raimi","bus"));
        people.add(new Person("Steve","Adebomi","bus"));
        people.add(new Person("Lawrence","Okegbemi","bus"));

        myAdapter = new PersonAdapter(this,people);
        recyclerView.setAdapter(myAdapter);


    }
}
