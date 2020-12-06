package com.example.loginfunc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Story3btn extends AppCompatActivity {
    private Button gotoguide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story3btn);
        gotoguide = findViewById(R.id.gotoguidebutton);

        gotoguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bundle bundle = new Bundle(); //꾸러미
//                bundle.putString("fromFragStorytelling", "toGuideStorytelling");
//                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                FragMonday fragMonday = new FragMonday();
//                fragMonday.setArguments(bundle);
//                transaction.replace(R.id.frameLayout, fragMonday);
         Intent intent = new Intent(Story3btn.this, GuideActivity.class);
        startActivity(intent);
                overridePendingTransition(0, 0);
       finish();

            }
        });
    }
}