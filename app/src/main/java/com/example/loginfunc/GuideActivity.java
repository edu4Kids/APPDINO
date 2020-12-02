package com.example.loginfunc;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Response;

public class GuideActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private ImageButton guide_button;
    public SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        SharedPreferences pref = getSharedPreferences("checkFirst", Activity.MODE_PRIVATE);

        //뷰페이저 세팅
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        fragmentPagerAdapter = new ViewPagerAdpater(getSupportFragmentManager(), this);

        //TabLayout tabLayout = findViewById(R.id.tab_layout);
        viewPager.setAdapter(fragmentPagerAdapter);
        //tabLayout.setupWithViewPager(viewPager);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragMonday fragMonday = new FragMonday();
        transaction.replace(R.id.frameLayout, fragMonday);
        transaction.commit();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            public void onResponse(String response) {
                prefs =  getSharedPreferences("Pref", MODE_PRIVATE);

                boolean checkFirst = prefs.getBoolean("checkFirst", false);
                if (checkFirst == false) {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("checkFisrt", true);
                    editor.commit();

                    Intent intent1 = new Intent(GuideActivity.this, MainActivity.class);
                    startActivity(intent1);
                    finish();
                }

            }

        };
    }

    public void movePage() {
        Intent intent = new Intent(GuideActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
