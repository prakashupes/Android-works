package com.example.grid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView g;
    public void grid()
    {
        List<String> l=new ArrayList<>();
        l.add("Apple");
        l.add("Mango");
        g=findViewById(R.id.grid);
        ArrayAdapter<String> arr=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,l);

        g.setAdapter(arr);
        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String st=parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this,st,Toast.LENGTH_SHORT).show();



            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final RadioGroup rg;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg=findViewById(R.id.rdgroup);

        Button b=findViewById(R.id.bt);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb;
                int id=rg.getCheckedRadioButtonId();
                rb=findViewById(id);
                String str=String.valueOf(rb.getText());
               // Toast.makeText(MainActivity.this,String.valueOf(rb.getText()),Toast.LENGTH_SHORT).show();
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("msg",str);
                startActivity(i);


            }
        });
    }
}
