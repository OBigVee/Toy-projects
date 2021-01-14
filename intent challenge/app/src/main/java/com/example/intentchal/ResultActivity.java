package com.example.intentchal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle extras = getIntent().getExtras();
        String inputString = extras.getString("yourKey");
        TextView tvDisplayingInternExtra = (TextView) findViewById(R.id.tvDisplayingInternExtra);
        tvDisplayingInternExtra.setText(inputString);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }



//        if (actionBar != null) {
//        actionBar.setDisplayHomeAsUpEnabled(true);
//    }
    @Override
    public void finish() {
        // create new Intent
        Intent intent = new Intent();
        // read the data of the EditText field with the id etReturnValue
        EditText etReturnValue = (EditText) findViewById(R.id.etReturnValue);
        // put the text from EditText as String extra into the intent
        // use editText.getText().toString();
        String string = etReturnValue.getText().toString();
        intent.putExtra("returnKey",string);
        // use setResult (RESULT_OK, intent) to return the Intent to application
        setResult(RESULT_OK,intent);
        super.finish();
    }
}