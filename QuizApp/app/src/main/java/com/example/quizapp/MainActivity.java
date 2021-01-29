package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    Button btnTrue,btnFalse,btnNext;
    ImageView ivPrevQuestion,ivNextQuestion;

    private int currentIndex = 0;
    TextView tvQuestion;
    private Question [] questionBank = new Question[]{
      new Question(R.string.question_australia,true),
      new Question(R.string.question_oceans,true),
      new Question(R.string.question_mideast,false),
      new Question(R.string.question_africa, false),
      new Question(R.string.question_americas,true),
      new Question(R.string.question_asia,true)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate(Bundle) called");
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            currentIndex = savedInstanceState.getInt(KEY_INDEX,0);
        }

        tvQuestion = findViewById(R.id.tvQuestion);
        int question = questionBank[currentIndex].getTextResourceId();
        tvQuestion.setText(question);

        btnFalse = (Button) findViewById(R.id.btnFalse);
        btnTrue = (Button) findViewById(R.id.btnTrue);

        ivNextQuestion = (ImageView) findViewById(R.id.ivNextQuestion);
        ivPrevQuestion = (ImageView) findViewById(R.id.ivPrevQuestion);

        tvQuestion.setOnClickListener(new View.OnClickListener() {
            // user can move to the next question by just touching the text screen
            @Override
            public void onClick(View v) {
                int question = questionBank[currentIndex].getTextResourceId();
                currentIndex = (currentIndex+1)%questionBank.length;
                tvQuestion.setText(question);
            }
        });

        //btnNext = (Button) findViewById(R.id.btnNext);
        // TRUE BUTTON
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something
                //Toast.makeText(MainActivity.this,R.string.toastCorrect,Toast.LENGTH_LONG).show();
                checkAnswer(true);

            }
        });

        // FALSE BUTTON
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something
                //Toast.makeText(MainActivity.this,R.string.toastInCorrect,Toast.LENGTH_LONG).show();
                checkAnswer(false);
            }
        });

        ivNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int question = questionBank[currentIndex].getTextResourceId();
                currentIndex = (currentIndex+1)%questionBank.length;
                tvQuestion.setText(question);

            }
        });

        ivPrevQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int question = questionBank[currentIndex].getTextResourceId();
                currentIndex = (currentIndex-1)%questionBank.length;
                if(currentIndex < 1) {
                    currentIndex =1;
                    tvQuestion.setText(question);
                    //Toast.makeText(MainActivity.this, "this is theh very first question", Toast.LENGTH_SHORT).show();
                }
                else{
                    tvQuestion.setText(question);
                }

            }
        });
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                int question = questionBank[currentIndex].getTextResourceId();
//                currentIndex = (currentIndex+1) % questionBank.length;
//                updateQuestion();
//               // int question = questionBank[currentIndex].getTextResourceId();
//               // tvQuestion.setText(question);
//            }
//        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume() called");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    /* === SAVE DATA ACROSS ROTATION ===
    save and pass the current question index value
     across resource activity(i.e while screen layout changes)
     */

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG,"onSaveInstance");
        outState.putInt(KEY_INDEX,currentIndex);
    }
    


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy() called");
    }

    private void  updateQuestion(){
        int question = questionBank[currentIndex].getTextResourceId();
        tvQuestion.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){
        // check if the answer is right.
        boolean answerIsTrue = questionBank[currentIndex].isAnswerTrue();
        int messageResourceId = 0;

        if (userPressedTrue == answerIsTrue){
            messageResourceId = R.string.toastCorrect;
        }
        else{
            messageResourceId = R.string.toastInCorrect;
        }
        Toast.makeText(this, messageResourceId, Toast.LENGTH_SHORT).show();

       // boolean answerIsTrue = questionBank[currentIndex].isAnswerTrue();
    }
}