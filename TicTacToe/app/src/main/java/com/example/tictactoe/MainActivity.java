package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private int playCounter;
    private int roundCount;
    private boolean player1Turn = true;

    private int player1Points;
    private int player2Points;
    TextView tvPlayer1,tvPlayer2;

    Button button [][] = new Button [3][3];
    Button btnReset, btn00,btn01,btn02,btn10,btn11,btn12,btn20,btn21,btn22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvPlayer1 = findViewById(R.id.tvPlayer1);
        tvPlayer2 = findViewById(R.id.tvPlayer2);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonId = "btn" + i + j;
                int resourceId = getResources().getIdentifier(buttonId, "id", getPackageName());
                button[i][j] = findViewById(resourceId);
                button[i][j].setOnClickListener(this);
            }
        }

        btnReset = findViewById(R.id.btnReset);

        btn00 = findViewById(R.id.btn00);
        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);

        btn10 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);

        btn20 = findViewById(R.id.btn20);
        btn21 = findViewById(R.id.btn21);
        btn22 = findViewById(R.id.btn22);


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Game Resetting now! ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(!((Button)v).getText().toString().equals("")){
            return;
        }
        if(player1Turn){
            ((Button)v).setText("X");
        }else{
            ((Button)v).setText("O");
        }
        roundCount++;
        if(checkForWin()){
            if(player1Turn){
                player1Wins();
            }else{
                player2Wins();
            }
        } else if (roundCount == 9) {
            draw();
        }else{
            player1Turn = !player1Turn;
        }
    }


    public boolean checkForWin(){
        String [][] field = new String [3][3];
        for (int i=0;i<3;i++){
            for(int j=0; j<3; j++){
                field[i][j] = button[i][j].getText().toString();
            }
        }

        for(int i = 0; i<3; i++){
            if(field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")){
                return true;
            }
        }

        if ( field[0][0].equals(field[1][1])&&
                field[0][0].equals(field[2][2])&&
                !field[0][0].equals("")){
            return true;
        }

        if(field[0][2].equals(field[1][1])
        && field[0][2].equals(field[2][0])
        && !field[0][2].equals("")){
            return true;
        }

        return false;
    }


    private void player1Wins(){
        player1Points++;
        Toast.makeText(this, "Player 1 wins", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();

    }


    private void player2Wins(){
        player2Points++;
        Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }
    private void draw(){
        Toast.makeText(this, "Draw!!!", Toast.LENGTH_SHORT).show();
    }

    private void updatePointsText() {
        tvPlayer1.setText("player 1:"+player1Points);
        tvPlayer2.setText("player 2:"+player2Points);
    }

    private void resetBoard(){
        for(int i= 0;i<3; i++){
            for (int j=0; j<3;j++){
                button[i][j].setText("");
            }
        }
        roundCount = 0;
        player1Turn = true;
    }

}


