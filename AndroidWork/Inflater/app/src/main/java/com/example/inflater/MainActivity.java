package com.example.inflater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;
    LinearLayout l;
    TextView t;
    public void click(View view)
    {
        t=findViewById(R.id.h1);
        String s=t.getText().toString();
        Toast.makeText(this,"Clicked "+s,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater=getLayoutInflater();
                View view=inflater.inflate(R.layout.new_layout,null);
                l=findViewById(R.id.homeContent);
                l.addView(view);
            }
        });

    }
}
