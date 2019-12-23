package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner s,s2;
    private Button b;
    public void adapterCheck()
    {

        List<String> list=new ArrayList<>();
        list.add("Item1");
        list.add("item2");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("App","onCreate()");
        s=findViewById(R.id.state);
        adapterCheck();
        b=findViewById(R.id.btn);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String state=String.valueOf(s2.getSelectedItem());
                Toast.makeText(MainActivity.this,
                        "OnClickListener : " +
                                "\nSpinner 1 : "+ state,

                        Toast.LENGTH_SHORT).show();

            }
        });

    }
}
