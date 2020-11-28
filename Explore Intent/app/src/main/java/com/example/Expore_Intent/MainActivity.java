package com.example.Expore_Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.intentchallenge.R;

public class MainActivity extends AppCompatActivity {
    TextView tvDescription;
    Button btnCreate;
    final int CREATE_CONTACT = 2;
    String name = "", web = "", location = "", number = "", mood = "";

    ImageView imgEmoji, imgCall,imgWeb,imgPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDescription = findViewById(R.id.tvDescription);
        btnCreate = findViewById(R.id.btnCreate);


        tvDescription = findViewById(R.id.tvDescription);
        imgCall = findViewById(R.id.imgCall);
        imgPlace = findViewById(R.id.imgPlace);
        imgEmoji = findViewById(R.id.imageSmile);
        imgWeb = findViewById(R.id.imgWeb);
        btnCreate = findViewById(R.id.btnCreate);

        //tvDescription.setVisibility(View.GONE);
        imgCall.setVisibility(View.GONE);
        imgPlace.setVisibility(View.GONE);
        imgEmoji.setVisibility(View.GONE);
        imgWeb.setVisibility(View.GONE);
        //btnCreate.setVisibility(View.GONE);

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });

        imgWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+web));
                startActivity(intent);
            }
        });
        imgEmoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent();
            }
        });
        imgPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+location));
                startActivity(intent);
            }
        });
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                //startActivity(intent);
                startActivityForResult(intent,CREATE_CONTACT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CREATE_CONTACT){
            if(resultCode == RESULT_OK){
                imgCall.setVisibility(View.VISIBLE);
                imgPlace.setVisibility(View.VISIBLE);
                imgEmoji.setVisibility(View.VISIBLE);
                imgWeb.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name");
                number = data.getStringExtra("number");
                web = data.getStringExtra("web");
                location = data.getStringExtra("location");
                mood = data.getStringExtra("mood");

                if (mood.equals("smile")){
                    imgEmoji.setImageResource(R.drawable.smile);
                }
                else if (mood.equals("neutral")){
                    imgEmoji.setImageResource(R.drawable.neutral);
                }
                else{
                    imgEmoji.setImageResource(R.drawable.sad);
                }
            }else{
                Toast.makeText(this, "No data Passed through", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
