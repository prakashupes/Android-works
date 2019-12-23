package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {


    private SectionsPagerAdapter msectionsPagerAdapter;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msectionsPagerAdapter =new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);
        TabLayout tabLayout=findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager)
    {
        SectionsPagerAdapter adapter =new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Frag1(),"EMI");
        adapter.addFragment(new Frag2(),"Income Tax");
       // adapter.addFragment(new Frag3(),"Tab3");
        viewPager.setAdapter(adapter);
    }
}