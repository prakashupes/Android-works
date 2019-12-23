package com.example.exp7;

import android.app.Activity;
import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomArray extends ArrayAdapter<Student> {

    TextView name,age;
    private Activity context;
    private List<Student> studentList;


    public CustomArray(@NonNull Activity context,  List<Student> studentList) {
        super(context, R.layout.new_layout,studentList);
        this.context = context;
        this.studentList = studentList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =context.getLayoutInflater();
        View view=inflater.inflate(R.layout.new_layout,null,true);
        name=view.findViewById(R.id.nameShow);
        age=view.findViewById(R.id.ageShow);
        Student student=studentList.get(position);
        name.setText(student.getName());
        age.setText(student.getAge());



        return view;
    }
}
