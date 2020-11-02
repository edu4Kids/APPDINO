package com.example.loginfunc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {


    private EditText idText,passwordText,nicknameText, ageText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        idText = findViewById(R.id.idText);
        passwordText = findViewById(R.id.passwordText);
        nicknameText = findViewById(R.id.nicknameText);
        ageText = findViewById(R.id.ageText);


        Button registerButton = (Button) findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String userID = idText.getText().toString();
                String userPassword = passwordText.getText().toString();
                String usernickName = nicknameText.getText().toString();
                int userAge = Integer.parseInt(ageText.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success){
                                Toast.makeText(getApplicationContext(),"회원등록에 성공했습니다.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent);


                            }

                            else {
                                Toast.makeText(getApplicationContext(),"회원등록에 실패했습니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }

                        }
                       catch(JSONException e){
                            e.printStackTrace();
                       }

                    }
                };
                //실제 서버로 volly통해 요
                RegisterReqeust registerReqeust = new RegisterReqeust(userID, userPassword, usernickName, userAge, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerReqeust);

            }
        });



    }
}