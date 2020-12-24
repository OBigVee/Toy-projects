package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    EditText etNumber;
    Button btnRollDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        etNumber = findViewById(R.id.etNumber);
        btnRollDice = findViewById(R.id.btnRollDice);
        tvResult.setVisibility(View.GONE);

        btnRollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nrOfTimes = Integer.parseInt(etNumber.getText().toString().trim());
               new ProcessDiceInBackground().execute(nrOfTimes);
//                int ones = 0 ,twos = 0, threes = 0, fours = 0 , fives = 0, sixes = 0;
//                int randomNumbers ;
//               // int nrOfTimes = Integer.parseInt(etNumber.getText().toString().trim());
//
//                Random random = new Random();
//                String result;
//
//                for (int i=0; i<nrOfTimes;i++){
//                    randomNumbers = random.nextInt(6)+1;
//                    switch (randomNumbers){
//                        case 1:
//                            ones++;
//                            break;
//                        case 2:
//                            twos++;
//                            break;
//                        case 3:
//                            threes++;
//                            break;
//                        case 4:
//                            fours++;
//                            break;
//                        case 5:
//                            fives++;
//                            break;
//                        case 6:
//                            sixes++;
//                            break;
//                    }
//                }
//                result = "Results: \n1: "+ones+"\n2: "+twos+"\n3: "+threes+"\n4: "+fours+"\n5: "+fives+"\n6: "+sixes;
//                tvResult.setText(result);
//                Toast.makeText(MainActivity.this, "process done!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public class ProcessDiceInBackground extends AsyncTask<Integer,Integer,String>{
        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            // runs on the ui thread
            // before going to the backGround

            super.onPreExecute();
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setMax(Integer.parseInt(etNumber.getText().toString().trim()));
            dialog.show();
        }

        @Override
        protected String doInBackground(Integer... params) {
            // runs on another thread the background thread and then use onProgressUpdate to update it to the UI

            int ones = 0 ,twos = 0, threes = 0, fours = 0 , fives = 0, sixes = 0, randomNumbers ;
            //int nrOfTimes = Integer.parseInt(etNumber.getText().toString().trim());

            Random random = new Random();
            String result;
            double currentProgress ;
            double previousProgress = 0;

            for (int i=0; i<params[0];i++) {
                currentProgress = (double) i / params[0];
                if (currentProgress - previousProgress >= 0.03) {
                    //System.out.println(currentProgress-previousProgress);
                    publishProgress(i);
                }

                randomNumbers = random.nextInt(6) + 1;
                switch (randomNumbers) {
                    case 1:
                        ones++;
                        break;
                    case 2:
                        twos++;
                        break;
                    case 3:
                        threes++;
                        break;
                    case 4:
                        fours++;
                        break;
                    case 5:
                        fives++;
                        break;
                    case 6:
                        sixes++;
                        break;
                }
            }
                result = "Results: \n1: "+ones+"\n2: "+twos+"\n3: "+threes+"\n4: "+fours+"\n5: "+fives+"\n6: "+sixes;
                return result;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            super.onProgressUpdate(values);
            dialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            // runs on the main ui thread
            super.onPostExecute(s);
            dialog.dismiss(); // to stop showing the progressbar After process is completed
            tvResult.setText(s);
            tvResult.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "Process Done", Toast.LENGTH_SHORT).show();

        }


    }
}
