package com.example.subhunter;

//import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.util.Log;
import android.widget.ImageView;
import java.util.Random;

public class SubHunter extends Activity {
    ImageView gameView;
    Bitmap blankBitmap;
    Canvas canvas;
    Paint paint;

    int numberHorizontalPixels;
    int numberVerticalPixels;
    int blockSize;
    int gridWidth = 40;
    int gridHeight;
    float horizontalTouched = -100;
    float verticalTouched = -100;
    int subHorizontalPosition;
    int subVerticalPosition;
    boolean hit = false;
    int shotsTaken;
    int distanceFromSub;
    boolean debugging = true;






    /*
    * Android runs this code just before
    * the player sees the app.
    * the code for the one-time setup phase.
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




//        int widthInPixels = 800;
//        int heightInPixels = 800;
//
//        myBlankBitmap = Bitmap.createBitmap(widthInPixels,
//                heightInPixels,
//                Bitmap.Config.ARGB_8888);
//
//
//        // init the canvas and associate it with the bitmap to draw on
//        myCanvas = new Canvas(myBlankBitmap);
//
//        // init the ImageView and the paint
//        myImageView = new ImageView(this);
//        myPaint = new Paint();
//
//        //Draw on the Bitmap
//        // wipe the Bitmap with a blue color
//        myCanvas.drawColor(Color.argb(255,0,0,255));
//        // Re-size the text
//        myPaint.setTextSize(100);
//        // change the paint to white
//        myPaint.setColor(Color.argb(255,255,255,255));
//        // Draw some text
//        myCanvas.drawText("hello world!",100,100,myPaint);
//
//        // change the paint to yellow
//        myPaint.setColor(Color.argb(255,212,207,62));
//        // Draw a circle
//        myCanvas.drawCircle(400,250,100,myPaint);
//
//        // Associate the drawn upon Bitmap with the ImageView
//        myImageView.setImageBitmap(myBlankBitmap);
//
//        // Tell andriod to set our drawing as the view for this app
//        // via the ImageView
//        setContentView(myImageView);

//        myCanvas = new Canvas(myBlankBitmap);
//        myImageView = new ImageView(this);
//        myPaint = new Paint();

        // Get the current device's screen resolution
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        // Initialize our size based variables
        // based on the screen resolution
        numberHorizontalPixels = size.x;
        numberVerticalPixels = size.y;
        blockSize = numberHorizontalPixels / gridWidth;
        gridHeight = numberVerticalPixels / blockSize;

        // init all the objects ready for drawing
        blankBitmap = Bitmap.createBitmap(numberHorizontalPixels,
                numberVerticalPixels,
                Bitmap.Config.ARGB_8888);

        canvas = new Canvas(blankBitmap);
        gameView = new ImageView(this);
        paint = new Paint();

        // Tell android to set our drawing as the view for this app
        setContentView(gameView);

        Log.d("Debugging","In oncreate");
        newGame();
        draw();
    }

    void newGame(){
        /*
    * This code will execute when a new game needs to be started.
    * It will happen when the app is first started and after the player wins a game
       */
        Random random = new Random();
        subHorizontalPosition = random.nextInt(gridWidth);
        subVerticalPosition = random.nextInt(gridHeight);
        shotsTaken = 0;

        Log.d("Debugging", "In newGame");
    }

    void draw(){
        // Here we will do all the drawing.The grid lines, the HUD,
        // the touch indicator and the "BOOM" when a sub' is hit
        gameView.setImageBitmap(blankBitmap);

        // Wipe the screen with a white color
        canvas.drawColor(Color.argb(255,255,255,255));
        // change the paint color to black
        paint.setColor(Color.argb(255,0,0,0));

        // Draw the vertical lines of the grid
        canvas.drawLine(blockSize*1,0,blockSize*1,
                numberVerticalPixels -1,paint);

        // draw the horizontal lines of the grid
        canvas.drawLine(0,blockSize*1,
                numberHorizontalPixels -1, blockSize*1,
                paint);

        Log.d("Debugging","In draw");
        printDebuggingText();
    }


    // This part of the code will handle detecting that the player has tapped the screen
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        Log.d("Debugging","In onTouchEvent");
        takeShot();
        return true;
    }

    void takeShot(){
         // The code here will execute when the player taps the screen It will
        // calculate the distance from the sub' and determine a hit or miss
        Log.d("Debugging","In takeShot");
        draw();
    }

    // This code says "BOOM!"
    void boom(){
    }

    // This code prints the debugging text
    void printDebuggingText(){
        Log.d("numberHorizontalPixels",""+numberHorizontalPixels);
        Log.d("numberVerticalPixels",""+numberVerticalPixels);
        Log.d("blockSize",""+blockSize);
        Log.d("gridWidth",""+gridWidth);
        Log.d("gridHieght",""+gridHeight);
        Log.d("horizontalTouched",""+horizontalTouched);
        Log.d("verticalTouched",""+verticalTouched);
        Log.d("subHorizontalPosition",""+subHorizontalPosition);
        Log.d("hit",""+hit);
        Log.d("shotTaken",""+shotsTaken);
        Log.d("debugging",""+debugging);
        Log.d("distanceFromSub",""+distanceFromSub);

    }
}

