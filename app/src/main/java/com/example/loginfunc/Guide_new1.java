package com.example.loginfunc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Guide_new1 extends AppCompatActivity {
    private Button guide_button4;
    private Button gonext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_new1);

        guide_button4= findViewById(R.id.guide_button4);
        guide_button4.setOnClickListener(new View.OnClickListener() {

            @Override
            //x -> main
            public void onClick(View view) {
                Intent intent = new Intent(Guide_new1.this,MainActivity.class); //로그인 버튼 클릭시 RegisterActivty로 이동

                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        gonext= findViewById(R.id.nextbtn);
       gonext.setOnClickListener(new View.OnClickListener() {

            @Override
            //page click -> main
            public void onClick(View view) {
                Intent intent = new Intent(Guide_new1.this,Guide_new2.class); //로그인 버튼 클릭시 RegisterActivty로 이동

                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }
}