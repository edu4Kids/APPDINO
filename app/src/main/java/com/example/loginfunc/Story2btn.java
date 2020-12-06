package com.example.loginfunc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Story2btn extends AppCompatActivity {
private Button goto3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story2btn);

        goto3= findViewById(R.id.storytelling_np2);
        goto3.setOnClickListener(new View.OnClickListener() {

            @Override
            //set 버튼 클릭했을 때
            public void onClick(View view) {
                Intent intent = new Intent(Story2btn.this,Story3btn.class); //로그인 버튼 클릭시 RegisterActivty로 이동

                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

    }
}