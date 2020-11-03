package com.example.loginfunc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SettingActivity extends AppCompatActivity {
    private TextView nicknameText;
     private Button logoutButton;
    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        nicknameText = findViewById(R.id.nicknameText);
        Intent intent = getIntent();
        String usernickName = intent.getStringExtra("usernickName");



        nicknameText.setText(usernickName);

        final Button logoutButton = (Button) findViewById(R.id.logoutButton);//로그아웃버튼 찾
        //아이디 중복 체크
        logoutButton.setOnClickListener(new View.OnClickListener() { //로그아웃 버튼 클

            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(SettingActivity.this/* 해당 액티비티를 가르킴 */)
                        .setTitle("로그아웃").setMessage("로그아웃 하시겠습니까?")
                        .setPositiveButton("로그아웃", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Intent i = new Intent(SettingActivity.this/*현재 액티비티 위치*/ , LoginActivity.class/*이동 액티비티 위치*/);
                                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                startActivity(i);
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }
                        })
                        .show();

            }


    });
}}