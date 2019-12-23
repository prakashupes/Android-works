package com.example.exp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button b,b2;
    private EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.b);
        e1=findViewById(R.id.uri);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri=e1.getText().toString();

                Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse(uri));
                startActivity(i);
            }
        });
        b2=findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}
