package com.example.imagepicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_PICK = 1;
    private Bitmap bitmap;
    private ImageView profilePicture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profilePicture = findViewById(R.id.ivUserPicture);

    }
    public void onClick(View view){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent,REQUEST_IMAGE_PICK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_PICK && resultCode == Activity.RESULT_OK){

                try (
                        InputStream stream =
                                getContentResolver().openInputStream(data.getData());)
                        {
                                    if (bitmap != null){
                                        bitmap.recycle();
                                    }
                                    bitmap = BitmapFactory.decodeStream(stream);
                                    profilePicture.setImageBitmap(bitmap);
                }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}