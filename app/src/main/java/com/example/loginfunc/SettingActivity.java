package com.example.loginfunc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SettingActivity extends AppCompatActivity {
    private TextView nicknameText;
    private Button logoutButton;
    private AlertDialog dialog;
    SessionManager sessionManager;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        sharedPreferences = getSharedPreferences("sfile",0);
        String usernickName = sharedPreferences.getString("usernickName","");
        nicknameText = findViewById(R.id.nicknameText);
        Intent intent = getIntent();
        nicknameText.setText(usernickName);


        final Button logoutButton = (Button) findViewById(R.id.logoutButton);//로그아웃버튼 찾
        sessionManager = new SessionManager(getApplicationContext());
        String userID = sessionManager.getUserID();
        String userPassword = sessionManager.getUserPassword();

        //아이디 중복 체크
        logoutButton.setOnClickListener(new View.OnClickListener() { //로그아웃 버튼 클

            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(SettingActivity.this/* 해당 액티비티를 가르킴 */)
                        .setTitle("로그아웃").setMessage("로그아웃 하시겠습니까?")
                        .setPositiveButton("로그아웃", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                               sessionManager.setLogin(false);
                               sessionManager.setUserID("");
                                sessionManager.setUserPassword("");
                                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                                finish();



                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }
                        })
                        .show();


            }




        });


    }


}
