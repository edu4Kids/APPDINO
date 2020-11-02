package com.example.loginfunc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView idText, passwordText,nicknameText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nicknameText = findViewById(R.id.nicknameText);
        Intent intent = getIntent();
        String usernickName = intent.getStringExtra("usernickName");



        nicknameText.setText(usernickName);

    }
    }