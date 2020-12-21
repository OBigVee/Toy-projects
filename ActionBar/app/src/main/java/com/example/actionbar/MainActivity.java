package com.example.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.studio);
        actionBar.setTitle(" Welcome");
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.refresh:
                Toast.makeText(this, "refresh clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Main2Activity.class));
                break;
            case R.id.download:
                Toast.makeText(this, "download clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Main2Activity.class));
                break;
            case R.id.send:
                Toast.makeText(this, "send clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Main2Activity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
