package com.example.fragrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdpater.ItemClicked {

    TextView tvName,tvPhone;
    ImageView ivContact;
    EditText etName,etPhone;
    Button btnAdd;
    listFrag listFrag;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);

        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);

        ivContact = findViewById(R.id.ivContact);

        // get the support of the fragment manager
        fragmentManager = this.getSupportFragmentManager();
        // use the support of the fragment manager to find the list fragment id and make connection with it
        listFrag  = (listFrag) fragmentManager.findFragmentById(R.id.listFrag);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().isEmpty() || etPhone.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Fill in all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    AppClass.people.add(
                            new Person(etName.getText().toString().trim(), etPhone.getText().toString().trim()));
                    Toast.makeText(MainActivity.this, "Person successfully added", Toast.LENGTH_SHORT).show();
                    etName.setText(null);
                    etPhone.setText(null);
                    listFrag.notifyDataChanged();
                }
            }
        });

        onItemClicked(0);

    }

    @Override
    public void onItemClicked(int index) {
    tvName.setText(AppClass.people.get(index).getName());
    tvPhone.setText(AppClass.people.get(index).getPhone());
    }
}
