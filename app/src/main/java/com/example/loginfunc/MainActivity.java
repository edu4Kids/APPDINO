package com.example.loginfunc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView nicknameText;
    private Button gosetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nicknameText = findViewById(R.id.nicknameText);
        Intent intent = getIntent();
        String usernickName = intent.getStringExtra("usernickName");
        String userID = intent.getStringExtra("userID");
        String userPassword = intent.getStringExtra("userPassword");




        nicknameText.setText(usernickName);

        gosetBtn = findViewById(R.id.gosetBtn);
        gosetBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            //set 버튼 클릭했을 때
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SettingActivity.class); //로그인 버튼 클릭시 RegisterActivty로 이동
                intent.putExtra("userId",userID);
                intent.putExtra("userPassword",userPassword);
                intent.putExtra("usernickName",usernickName);
                startActivity(intent);

            }
        });

    }
    }