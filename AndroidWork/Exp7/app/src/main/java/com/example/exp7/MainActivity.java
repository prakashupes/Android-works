package com.example.exp7;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

class Student
{
    public String age;
    public String name;

    public Student()
    {

    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

public class MainActivity extends AppCompatActivity {
    public void click(View v)
    {
        Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show();

    }
    private FirebaseDatabase db;
    ListView listView;
    List<Student> studentList;
    private Button b1,b2;
    EditText e1, e2;
    TextView t1,t2;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        db=FirebaseDatabase.getInstance();
        final DatabaseReference myRef=FirebaseDatabase.getInstance().getReference("Student");

        // Write a message to the database

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       listView=findViewById(R.id.listView);

        e1=findViewById(R.id.name);
        e2=findViewById(R.id.age);
        b1=findViewById(R.id.b);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=e1.getText().toString();
                String age=e2.getText().toString();
                Log.d("Age",age);
                Log.d("Name",name);
                final Student st=new Student(name,age);
                final String id=myRef.push().getKey();
                Log.d("id",id);

               // Concept myRef.child(id).child("name").setValue("xyz");

                myRef.child(id).setValue(st);


            }
        });
        t1=findViewById(R.id.ageShow);
        t2=findViewById(R.id.nameShow);
        b2=findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentList =new ArrayList<>();
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        studentList.clear();

                        for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                        {

                            Student st=dataSnapshot1.getValue(Student.class);
                            studentList.add(st);
                        }
                        CustomArray adapter= new CustomArray(MainActivity.this,studentList);
                        listView.setAdapter(adapter);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
              /*
                myRef.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        studentList.clear();

                        for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                        {

                            Student st=dataSnapshot1.getValue(Student.class);
                            studentList.add(st);
                        }
                        CustomArray adapter= new CustomArray(MainActivity.this,studentList);
                        listView.setAdapter(adapter);





                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

*/

            }


        });
    }
}