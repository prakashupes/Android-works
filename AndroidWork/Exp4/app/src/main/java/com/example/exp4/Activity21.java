package com.example.exp4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;

import java.util.SimpleTimeZone;

public class Activity21 extends AppCompatActivity implements OnClickListener {
     public TextView result;
    EditText Num1;
    EditText Num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_21);




       Num1 = (EditText) findViewById(R.id.e1);
         Num2 = (EditText) findViewById(R.id.e2);
       Button Add = (Button) findViewById(R.id.add);
       Button Sub = (Button) findViewById(R.id.b2);
       Button Mul = (Button) findViewById(R.id.b3);
       Button Div = (Button) findViewById(R.id.b4);
        result = (TextView) findViewById(R.id.t1);

        // set a listener
        Add.setOnClickListener(this);
        Sub.setOnClickListener(this);
        Mul.setOnClickListener(this);
        Div.setOnClickListener(this);
    }
    public void onClick(View view)
    {
        float num1 =0;
        float num2 =0;
        float r=0;

        num1 = Float.parseFloat(Num1.getText().toString());
        num2 = Float.parseFloat(Num2.getText().toString());
        switch (view.getId())
        {
            case R.id.add:
                r= num1 + num2;
                break;
            case R.id.b2:
                r= num1 - num2;
                break;
            case R.id.b3:
                r= num1 * num2;
                break;
            case R.id.b4:
                r= num1 / num2;
                break;

        }
        result.setText(String.valueOf(r));
    }
}
