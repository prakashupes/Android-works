package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SQLitePract extends AppCompatActivity {
    private TextView t1,t2,t3;
    Button add,view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_pract);
        DataBaseHandler db=new DataBaseHandler(this);
        t1=findViewById(R.id.n1);
        t2=findViewById(R.id.n2);
        t3=findViewById(R.id.n3);

        db.addContact("abc");
        db.addContact("abc2");
        db.addContact("abc3");
       final List<String> contacts=db.getAllContacts();

        view=findViewById(R.id.view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(contacts.get(0));
                t2.setText(contacts.get(1));
            }
        });



    }
}
