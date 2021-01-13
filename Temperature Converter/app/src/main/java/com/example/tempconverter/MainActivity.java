package com.example.tempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText etValue;
TextView tvResult;
//RadioButton rg2Celsius,rg2Fahrenheit;
Button btnConvert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etValue = (EditText) findViewById(R.id.etValue);
        tvResult = (TextView) findViewById(R.id.tvResult);
//        rg2Celsius.findViewById(R.id.rg2Celsius);
//        rg2Fahrenheit.findViewById(R.id.rg2Fahrenheit);

    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnConvert:
                RadioButton celsiusButton = (RadioButton) findViewById(R.id.rg2Celsius);
                RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.rg2Fahrenheit);
                if(etValue.getText().length() == 0){
                    Toast.makeText(this, "enter a valid value", Toast.LENGTH_SHORT).show();
                    return;
                }
                float inputValue = Float.parseFloat(etValue.getText().toString());
                if(celsiusButton.isChecked()){
                    String result = " celsius";
                    tvResult.setText(String.valueOf(ConvertUtility.fahrenheitToCelsius(inputValue))+result);
                    celsiusButton.setChecked(true);
                    fahrenheitButton.setChecked(false);
                }
                else {
                    String result = " fahrenheit";
                    tvResult.setText(String.valueOf(ConvertUtility.celsiusToFahrenheit(inputValue))+result);
                    fahrenheitButton.setChecked(true);
                    celsiusButton.setChecked(false);
                }
                break;
        }
    }
}