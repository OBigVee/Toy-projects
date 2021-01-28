package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);

        tvQuestion = findViewById(R.id.tvQuestion);
        int question = questionBank[currentIndex].getTextResourceId();
        tvQuestion.setText(question);

        btnFalse = (Button) findViewById(R.id.btnFalse);
        btnTrue = (Button) findViewById(R.id.btnTrue);

        ivNextQuestion = (ImageView) findViewById(R.id.ivNextQuestion);
        ivPrevQuestion = (ImageView) findViewById(R.id.ivPrevQuestion);


        //btnNext = (Button) findViewById(R.id.btnNext);
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something
                //Toast.makeText(MainActivity.this,R.string.toastCorrect,Toast.LENGTH_LONG).show();
                checkAnswer(true);

            }
        });

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
////                for (int i=0; i<questionBank.length;currentIndex++){
////                   tvQuestion.setText(question);
////                }
//               // Toast.makeText(MainActivity.this, "Goto the next question", Toast.LENGTH_SHORT).show();
////                currentIndex = (currentIndex++);
////                if (currentIndex == questionBank.length){
////                    Toast.makeText(MainActivity.this, "End of question!", Toast.LENGTH_SHORT).show();
////                }
////                else {
////                    int question = questionBank[currentIndex].getTextResourceId();
////                    tvQuestion.setText(question);
////                    updateQuestion();
////                }
//                currentIndex = (currentIndex+1) % questionBank.length;
//                updateQuestion();
//               // int question = questionBank[currentIndex].getTextResourceId();
//               // tvQuestion.setText(question);
//            }
//        });

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