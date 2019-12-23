package com.example.experiment7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomArray extends ArrayAdapter<String> {
    TextView captainText,countryText;
    ImageView flag;
    private int[] image;
    private String[] capt;
    private String[] country;
    private Activity context;


    public CustomArray(@NonNull Activity context, int image[],String capt[],String country[]) {
        super(context,R.layout.activity_lsit,capt);
        this.capt=capt;
        this.context=context;
        this.country=country;
        this.image=image;




    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View view=inflater.inflate(R.layout.activity_lsit,null,true);
        captainText=view.findViewById(R.id.captain);
        countryText=view.findViewById(R.id.country);
        flag=view.findViewById(R.id.flag);
        captainText.setText(capt[position]);
        countryText.setText(country[position]);
        flag.setImageResource(image[position]);

        return view;
    }
}
