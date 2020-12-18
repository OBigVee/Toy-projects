package com.example.fragrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class AppClass extends Application {
    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();
        people = new ArrayList<Person>();
        people.add(new Person("Victor","023924040204"));
        people.add(new Person("Tope","023935340204"));
        people.add(new Person("Ope","075784040204"));



    }
}
