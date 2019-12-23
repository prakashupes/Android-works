package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String key1="Name" ,key2="age",name,age;
    EditText e1,e2;
    private Button save,ret,sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.age);
        e2=findViewById(R.id.name);

        save=findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  age=((EditText)findViewById(R.id.age)).getText().toString();

                name=e2.getText().toString();
                age=e1.getText().toString();
                Toast.makeText(MainActivity.this,name+" "+age,Toast.LENGTH_SHORT).show();
                SharedPreferences sharedPreferences=getSharedPreferences("MyPref",MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString(key1,name);
                editor.putString(key2,age);
                editor.commit();

            }
        });
        ret=findViewById(R.id.ret);
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"View Clicked",Toast.LENGTH_SHORT).show();
                SharedPreferences sharedPreferences=getSharedPreferences("MyPref",MODE_PRIVATE);
                //SharedPreferences.Editor editor= sharedPreferences.edit();
                name=sharedPreferences.getString(key1,"");
                age=sharedPreferences.getString(key2,"");
                e1.setText(name);
                e2.setText(age);
            }
        });
        sql=findViewById(R.id.sqlite);
        sql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SQLitePract.class);
                startActivity(i);
            }
        });
    }
}
