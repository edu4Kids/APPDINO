package com.example.loginfunc;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class GuideActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        //뷰페이저 세팅
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        fragmentPagerAdapter = new ViewPagerAdpater(getSupportFragmentManager());

        //TabLayout tabLayout = findViewById(R.id.tab_layout);
        viewPager.setAdapter(fragmentPagerAdapter);
        //tabLayout.setupWithViewPager(viewPager);



    }
}
