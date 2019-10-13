package com.example.emi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    TextView t1,result;
    Button b,reset;
    public boolean nullStringException(String str)
    {
        if(str.length()==0)
            return true;
        return false;
    }
public void calculateEMI(String pr, String ra, String ti)
{
    double p=Double.valueOf(pr);
    double r=Double.valueOf(ra); //Yearly rate
    double t=Double.valueOf(ti);
    double R=r/(12*100);
    double x=Math.pow((1+R),t);
    final double emi=(p*R*x)/(x-1);
    Intent i=new Intent(MainActivity.this,Result2.class);
    i.putExtra("emi",emi);
    i.putExtra("p",p);
    i.putExtra("rate",r);
    i.putExtra("time",t);
    startActivity(i);



}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.prin);
        e2=findViewById(R.id.rate);
        e3=findViewById(R.id.time);
        t1=findViewById(R.id.warning);
        result=findViewById(R.id.result);
        b=findViewById(R.id.b1);
        reset=findViewById(R.id.reset);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pr=e1.getText().toString();
                String ra=e2.getText().toString();
                String ti=e3.getText().toString();

                //Exception Handling
                if(nullStringException(pr)==true || nullStringException(ra)==true || nullStringException(ti)==true)
                {

                    t1.setText("Warning: Any field must not Empty!!");
                }
                else
                {
                    t1.setText("");

                    calculateEMI(pr,ra,ti);



                }


            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
                e2.setText("");
                e3.setText("");
                t1.setText("");
                result.setText("");
            }
        });


    }
}
