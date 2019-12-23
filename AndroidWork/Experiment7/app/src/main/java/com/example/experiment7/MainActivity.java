package com.example.experiment7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    int flags[]={R.drawable.india,R.drawable.afghanistan,R.drawable.africa,R.drawable.australia,R.drawable.bangladesh,
            R.drawable.kingdom,R.drawable.newzealand,R.drawable.srilanka,R.drawable.pakistan
    };
    String country[]={"INDIA","AFG","SOUTH AFRICA","AUS","BAN","ENG","NZ","LANKA","PAK"};
    String captain[]={"Virat","Rashid","Faf du Plessis","Finch","Mahmudullah","Eoin Morgan","Williamson","Lasith Malinga","Azam"};
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.lit);
        getLayoutInflater().inflate(R.layout.activity_lsit,null);
        CustomArray adapter=new CustomArray(this,flags,captain,country);
        list.setAdapter(adapter);
    }

}