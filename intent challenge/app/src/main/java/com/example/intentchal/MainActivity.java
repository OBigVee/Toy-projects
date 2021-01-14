package com.example.intentchal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    // constant to determine which sub-activity returns
    private static final int REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View v){
        EditText inputForIntent = (EditText) findViewById(R.id.inputForIntent);
        String string = inputForIntent.getText().toString();
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("yourKey",string);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE){
            if (data.hasExtra("etReturnValue")){
                String result = data.getExtras().getString("etReturnValue");
                if (result != null && result.length() > 0){
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public  void shareIntent(View view){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "REPLACE WITH YOUR TEXT");
        startActivity(shareIntent);
    }
}