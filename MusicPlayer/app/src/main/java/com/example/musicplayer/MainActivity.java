package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MusicStoppedListener {

    ImageView ivPlay, ivPhoto;
    String audioLink = "https://dl.dropbox.com/s/8cyfl0nbdmh4upj/Lawrence%20Oyor%20if%20I%20press%20and%20press.mp3?dl=0";
    boolean musicPlaying = false;
    Intent serviceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivPlay = (ImageView) findViewById(R.id.ivPlay);
        ivPlay.setBackgroundResource(R.mipmap.play);

        ivPhoto = (ImageView) findViewById(R.id.ivPhoto);
        ivPhoto.setBackgroundResource(R.mipmap.do_more);

        serviceIntent = new Intent(this,MyPlayService.class);

        Application.context = (Context) MainActivity.this;

        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!musicPlaying)
                {
                    playAudio();
                    ivPlay.setImageResource(R.mipmap.pause);
                    ivPhoto.setImageResource(R.mipmap.music);

                    musicPlaying = true;
                }
                else {
                    stopPlayService();
                    ivPlay.setImageResource(R.mipmap.play);
                    ivPhoto.setImageResource(R.mipmap.do_more);
                    musicPlaying = false;
                }

            }
        });
    }

    private void stopPlayService() {
        try{
            stopService(serviceIntent);
        }catch (SecurityException e){
            Toast.makeText(this, "Error!\t"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void playAudio() {
        serviceIntent.putExtra("audioLink",audioLink);
        try{
            startService(serviceIntent);
        }
        catch (SecurityException e){
            Toast.makeText(this, "Error!\t"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMusicStopped() {
        ivPlay.setImageResource(R.mipmap.play);
        ivPhoto.setImageResource(R.mipmap.do_more);
        musicPlaying = false;
    }
}