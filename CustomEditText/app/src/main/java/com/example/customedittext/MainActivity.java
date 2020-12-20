package com.example.customedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView etFirstName,etLastName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = (AutoCompleteTextView) findViewById(R.id.etFirstName);
        etLastName = (AutoCompleteTextView) findViewById(R.id.etLastName);
        String [] names = {"james","john","jennie","jennifer","jack","Victor","Tope","Yemi","Juliet","Theophilus","Captain","Cassandra"};
        names.toString().toLowerCase();

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,names);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_text_design_auto_complete,names);

        etFirstName.setThreshold(1);
        etFirstName.setAdapter(adapter);

        etLastName.setThreshold(2);
        etLastName.setAdapter(adapter);


    }
}
