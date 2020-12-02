package com.example.loginfunc;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Response;

public class StorytellingActivity extends AppCompatActivity {
    private ViewPager viewPager_story;
    private FragmentPagerAdapter fragmentPagerAdapter_story;
    public SharedPreferences prefs;
    private Button gotonext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storytelling);
        SharedPreferences pref = getSharedPreferences("checkFirst", Activity.MODE_PRIVATE);

        //뷰페이저 세팅
        viewPager_story = (ViewPager) findViewById(R.id.viewPager_Storytelling);

        fragmentPagerAdapter_story = new ViewPagerAdpater_storytelling(getSupportFragmentManager(), this);

        //TabLayout tabLayout = findViewById(R.id.tab_layout);
        viewPager_story.setAdapter(fragmentPagerAdapter_story);
        //tabLayout.setupWithViewPager(viewPager);

    }

    public void movePage() {
        Intent intent = new Intent(StorytellingActivity.this, GuideActivity.class);
        startActivity(intent);
        finish();
    }
}