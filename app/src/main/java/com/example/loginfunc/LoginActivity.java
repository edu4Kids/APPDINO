 package com.example.loginfunc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

 public class LoginActivity extends Activity {
     private EditText idText,passwordText;
     private Button loginButton, registerButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idText =  findViewById(R.id.idText);
        passwordText = findViewById(R.id.passwordText);

       loginButton =  findViewById(R.id.loginButton);
       registerButton = findViewById(R.id.registerButton);
       registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });
       loginButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String userID = idText.getText().toString();
               String userPassword = passwordText.getText().toString();

               Response.Listener<String> responseListener = new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {
                       try{
                           JSONObject jsonObject = new JSONObject(response);
                           boolean success = jsonObject.getBoolean("success");
                           if (success){
                               String userID = jsonObject.getString("userID");
                               String userPassword = jsonObject.getString("userPassword");
                               Toast.makeText(getApplicationContext(),"로그인에 성공했습니다.",Toast.LENGTH_SHORT).show();
                               Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                               intent.putExtra("userId",userID);
                               intent.putExtra("userPassword",userPassword);
                               startActivity(intent);


                           }

                           else {
                               Toast.makeText(getApplicationContext(),"로그에 실패했습니다.",Toast.LENGTH_SHORT).show();
                               return;
                           }

                       }
                       catch(JSONException e){
                           e.printStackTrace();
                       }
                   }
               };
               LoginReqeust loginReqeust = new LoginReqeust(userID,userPassword,responseListener);
               RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
               queue.add(loginReqeust);
           }
       });
    }
            }




