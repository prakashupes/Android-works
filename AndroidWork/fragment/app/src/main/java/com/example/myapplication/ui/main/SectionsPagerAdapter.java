package com.example.myapplication.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFrag=new ArrayList<>(); //Keeps track of frag
    private List<String> mFragTitle =new ArrayList<>(); //Keeps track of Title of frag

    public SectionsPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }
    @Override
    public int getCount() {
        return mFrag.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragTitle.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFrag.get(position);
    }
    public void addFragment(Fragment fragment, String title)

    {
        mFrag.add(fragment);
        mFragTitle.add(title);
    }

}