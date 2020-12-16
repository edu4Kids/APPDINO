package com.example.loginfunc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Guide_new3 extends AppCompatActivity {

    private Button afterbtn;
    private Button BeforeBtn;
    private Button guide_button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_new3);

        guide_button4= findViewById(R.id.guide_button4);
        guide_button4.setOnClickListener(new View.OnClickListener() {

            @Override
            //X 버튼 클릭했을 때 MAIN
            public void onClick(View view) {
                Intent intent = new Intent(Guide_new3.this,MainActivity.class); //로그인 버튼 클릭시 RegisterActivty로 이동

                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        afterbtn= findViewById(R.id.afterbtn);
        afterbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            //right -> 3
            public void onClick(View view) {
                Intent intent = new Intent(Guide_new3.this,Guide_new4.class); //로그인 버튼 클릭시 RegisterActivty로 이동

                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        BeforeBtn= findViewById(R.id.beforebtn);
        BeforeBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            //left -> 2
            public void onClick(View view) {
                Intent intent = new Intent(Guide_new3.this,Guide_new2.class); //로그인 버튼 클릭시 RegisterActivty로 이동

                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }
}