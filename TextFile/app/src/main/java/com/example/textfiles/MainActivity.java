package com.example.textfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    EditText etFirstName, etLastName;
//    Button btnAdd,btnSave;
    ArrayList<Person> persons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = (TextView) findViewById(R.id.tvResult);
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
//        btnAdd = findViewById(R.id.btnAdd);
//        btnSave = findViewById(R.id.btnSave);
        persons = new ArrayList<Person>();
       loadData();
    }

        public void btnAdd(View v){
        String name = etFirstName.getText().toString();
        String surname = etLastName.getText().toString();

        Person person = new Person(name, surname);
        persons.add(person);
        setTextToTextView();

        }

    private void setTextToTextView() {
        String text = "";
        for (int i=0;i<persons.size(); i++){
            text = text + persons.get(i).getName() + "\t" + persons.get(i).getSurname()+"\n";
            System.out.println(text);
        }
        tvResult.setText(text);
    }

    public void loadData(){
        //function loads the already saved data
        persons.clear(); // makes sure no duplicate is present

        File file = getApplicationContext().getFileStreamPath("data.txt");
        String lineFromFile;

        if(file.exists()){
            try{
                // if the file exist write directly to it.

                BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("data.txt")));
                while ((lineFromFile = reader.readLine()) != null){
                    StringTokenizer tokens = new StringTokenizer(lineFromFile,",");
                    Person person = new Person(tokens.nextToken(),tokens.nextToken());
                    persons.add(person);
                }

                reader.close();
                setTextToTextView();

            }catch (IOException e){

            }
        }

    }

    public void btnSave(View v){
            try{
                FileOutputStream file = openFileOutput("data.txt",MODE_PRIVATE);
                OutputStreamWriter outputFile = new OutputStreamWriter(file);
                for(int i =0; i<persons.size();i++){
                    outputFile.write(persons.get(i).getName()+","+persons.get(i).getSurname()+"\n");
                }
                outputFile.flush(); // makes sure all the data is written to the file.
                outputFile.close();
                Toast.makeText(MainActivity.this, "Successfully saved", Toast.LENGTH_SHORT).show();
            }
            catch (IOException e){
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//    }
}
