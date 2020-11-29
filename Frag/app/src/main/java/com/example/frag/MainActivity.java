package com.example.frag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements listFrag.ItemSelected {
    TextView tvDescription;
    ArrayList<String> descriptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.tvDescription);
        descriptions = new ArrayList<String>();

        descriptions.add("Description for item 1");
        descriptions.add("Description for item 2");
        descriptions.add("Description for item 3");
        descriptions.add("Description for item 4");

    }

    @Override
    public void onItemSelection(int index) {
        tvDescription.setText(descriptions.get(index));
    }
}
