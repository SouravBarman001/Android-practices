package com.example.scrolltabdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends FragmentActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.pagerID);
        FragmentManager fragmentManager = getSupportFragmentManager();

        customAdapter adapter = new customAdapter(fragmentManager);
        viewPager.setAdapter(adapter);

    }
}

class customAdapter extends FragmentStatePagerAdapter{

    public customAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0){
            fragment = new BlankFragmentOne();
        }
       else if (position == 1){
            fragment = new BlankFragmentTwo();
        }
       else if (position == 2){
            fragment = new BlankFragmentThree();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}