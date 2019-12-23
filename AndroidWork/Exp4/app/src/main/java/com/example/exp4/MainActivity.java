package com.example.exp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         Button buttton = findViewById(R.id.exp4);
         buttton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,Activity21.class);
                 startActivity(i);
             }
         });
    }
    public void openNewActivity()
    {
        Intent i = new Intent(this,Activity21.class);
        startActivity(i);
    }
    public void changefont(View v)
    {

        TextView textView = findViewById(R.id.v1);
        textView.setTextSize(40);
    }
    public void changecolor(View v)
    {
        TextView textView = findViewById(R.id.v1);
        textView.setTextColor(getResources().getColor(R.color.colorAccent));

    }
}