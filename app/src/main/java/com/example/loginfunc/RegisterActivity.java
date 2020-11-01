package com.example.loginfunc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText idText = (EditText) findViewById(R.id.idText);
        EditText passwordText = (EditText) findViewById(R.id.passwordText);
        EditText nicknameText = (EditText) findViewById(R.id.nicknameText);
        EditText AgeText = (EditText) findViewById(R.id.AgeText);

        Button registerButton = (Button) findViewById(R.id.registerButton);



    }
}