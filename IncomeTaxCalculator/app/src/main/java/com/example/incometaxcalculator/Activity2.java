package com.example.incometaxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        final int tax=getIntent().getExtras().getInt("abc");

        final TextView t1=findViewById(R.id.tax);
        t1.setText("Tax: "+String.valueOf(tax));
        final int amt=getIntent().getExtras().getInt("xyz");
        final TextView Q=findViewById(R.id.income);
        Q.setText("Income: "+String.valueOf(amt));

        String name=getIntent().getExtras().getString("name");
        TextView n=findViewById(R.id.name);

        n.setText(name);
    }
}
