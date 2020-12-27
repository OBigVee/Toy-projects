package com.example.permissions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
Button btnPermissionCamera;
    private static final int UNIQUE_REQUEST_CODE2 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnPermissionCamera = (Button) findViewById(R.id.btnPermissionsCamera);

        btnPermissionCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(Main2Activity.this, new String[]{Manifest.permission.CAMERA},UNIQUE_REQUEST_CODE2);
                }
                else{
                    Toast.makeText(Main2Activity.this, "you need the camera to complete job", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == UNIQUE_REQUEST_CODE2){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "thumbs Up Camera granted", Toast.LENGTH_SHORT).show();
            }
        }else if(grantResults[0] == PackageManager.PERMISSION_DENIED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(Main2Activity.this,Manifest.permission.CAMERA)){
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setMessage("camera is not needed to complete this job")
                        .setTitle("Camera permissions Needed");

                dialog.setPositiveButton("okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(Main2Activity.this,new String[]{Manifest.permission.CAMERA},UNIQUE_REQUEST_CODE2);
                    }
                });

                dialog.setNegativeButton("NO!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Main2Activity.this, "Camera permission not granted", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
            else {
                Toast.makeText(this, "No Permission", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
