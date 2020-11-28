package com.example.Expore_Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.intentchallenge.R;

public class Main2Activity extends AppCompatActivity  implements View.OnClickListener{
    EditText edtName, edtNumber, edtLocation,edtWeb;
    ImageView imgSmile, imgNeutral, imgSad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edtName = findViewById(R.id.edtName);
        edtLocation = findViewById(R.id.edtLocation);
        edtNumber = findViewById(R.id.edtNumber);
        edtWeb = findViewById(R.id.edtWeb);

        imgSmile = findViewById(R.id.imgSmile);
        imgNeutral = findViewById(R.id.imgNetural);
        imgSad = findViewById(R.id.imgSad);

        imgSmile.setOnClickListener(this);
        imgNeutral.setOnClickListener(this);
        imgSad.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(edtName.getText().toString().isEmpty() || edtWeb.getText().toString().isEmpty() || edtNumber.getText().toString().isEmpty() || edtLocation.getText().toString().isEmpty()){
            Toast.makeText(this, "fill all fields", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent();
            intent.putExtra("name",edtName.getText().toString().trim());
            intent.putExtra("location",edtLocation.getText().toString().trim());
            intent.putExtra("number",edtNumber.getText().toString().trim());
            intent.putExtra("web",edtWeb.getText().toString().trim());

            if(v.getId() == R.id.imgSmile){
                intent.putExtra("mood","smile");
            }
            else if(v.getId() == R.id.imgNetural){
                intent.putExtra("mood","neutral");
            }
            else{
                intent.putExtra("mood","sad");
            }
            setResult(RESULT_OK,intent);
            Main2Activity.this.finish();
        }

    }
}
