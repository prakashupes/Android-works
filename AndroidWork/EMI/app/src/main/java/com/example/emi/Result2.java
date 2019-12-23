package com.example.emi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Result2 extends AppCompatActivity {
    TextView p,r,t,e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        p=findViewById(R.id.prin);
        r=findViewById(R.id.rate);
        t=findViewById(R.id.time);
        e=findViewById(R.id.emi);
        p.setText("Principal: "+String.valueOf(getIntent().getExtras().getDouble("p")));
        r.setText("Rate: "+String.valueOf(getIntent().getExtras().getDouble("rate")));
        t.setText("Time: "+String.valueOf(getIntent().getExtras().getDouble("time")));
        e.setText("EMI: "+String.valueOf(getIntent().getExtras().getDouble("emi")));
    }
}
