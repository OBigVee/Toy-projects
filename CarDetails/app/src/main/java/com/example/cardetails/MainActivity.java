package com.example.cardetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked {

    Button btnCarInfo,btnOwnerInfo;
    ImageView ivBrand;
    TextView tvModel,tvName,tvPhone;

    FragmentManager fragmentManager;
    Fragment listFrag,carInfoDisplayFragment,ownerInfoDisplayFragment,buttonFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCarInfo = findViewById(R.id.btnCarInfo);
        btnOwnerInfo = findViewById(R.id.btnOwnerInfo);
        ivBrand = findViewById(R.id.ivBrand);
        tvModel = findViewById(R.id.tvModel);
        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);

        fragmentManager = getSupportFragmentManager();

        listFrag = fragmentManager.findFragmentById(R.id.listFrag);
        carInfoDisplayFragment = fragmentManager.findFragmentById(R.id.carInfo);
        ownerInfoDisplayFragment = fragmentManager.findFragmentById(R.id.ownerInfo);
        buttonFragment = fragmentManager.findFragmentById(R.id.buttons);

        fragmentManager.beginTransaction().
                show(buttonFragment).
                show(listFrag).
                show(carInfoDisplayFragment).
                hide(ownerInfoDisplayFragment).
                commit();

onItemClicked(0);

        btnOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().
                        hide(carInfoDisplayFragment).
                        show(ownerInfoDisplayFragment).
                        commit();


            }
        });

        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().
                        show(carInfoDisplayFragment).
                        hide(ownerInfoDisplayFragment).
                        commit();
            }
        });

//        if(findViewById(R.id.layout_portrait) != null){
//            FragmentManager manager = this.getSupportFragmentManager();
//            manager.beginTransaction().
//                    hide(manager.findFragmentById(R.id.home2Frag)).
//                    show(manager.findFragmentById(R.id.listFrag));
//        }
//        else{
//            FragmentManager manager = this.getSupportFragmentManager();
//            manager.beginTransaction().
//                    show(manager.findFragmentById(R.id.listFrag)).
//                    show(manager.findFragmentById(R.id.home2Frag)).commit();
//        }


    }

    @Override
    public void onItemClicked(int index) {
        tvName.setText(CarAppClass.cars.get(index).getOwnerName());
        tvModel.setText(CarAppClass.cars.get(index).getModel());
       tvPhone.setText(CarAppClass.cars.get(index).getOwnerPhoneNo());


       if(CarAppClass.cars.get(index).getBrand().equals("Volkswagen")){
           ivBrand.setImageResource(R.drawable.volkswagen);
        }
       else if(CarAppClass.cars.get(index).getBrand().equals("Nissan")){
           ivBrand.setImageResource(R.drawable.nissan);
       }
       else {
           ivBrand.setImageResource(R.drawable.mercedes);
       }

    }
}
