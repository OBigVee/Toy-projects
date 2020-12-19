package com.example.cardetails;

import android.app.Application;

import java.util.ArrayList;

public class CarAppClass extends Application {
    public static ArrayList<Car> cars;

    @Override
    public void onCreate() {
        super.onCreate();
        cars = new ArrayList<Car>();
        cars.add(new Car("Volkswagen","Polo","Chuck Morris","90538530"));
        cars.add(new Car("Nissan","Quest","Justin Johnson","049035454"));
        cars.add(new Car("Mercedes","CLA","Victor Adedeji","0997875474"));
        cars.add(new Car("Mercedes","G-Class","Victor Tobiloba","995768476"));
        cars.add(new Car("Volkswagen","Konbi","Neslon Mandela","98756434567"));
        cars.add(new Car("Nissan","Almera","Chris James","8767387636"));
        cars.add(new Car("Mercedes","S-class","Philip Oladele","78454356"));
        cars.add(new Car("Nissan","Navara","Elizabeth Adedeji","0987654376"));

    }
}
