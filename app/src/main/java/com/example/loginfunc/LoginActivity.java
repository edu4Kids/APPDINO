 package com.example.loginfunc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
     public SharedPreferences prefs;


     SessionManager sessionManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        idText =  findViewById(R.id.idText);
        passwordText = findViewById(R.id.passwordText);



        sessionManager = new SessionManager(getApplicationContext());


        loginButton =  findViewById(R.id.loginButton);
       registerButton = findViewById(R.id.registerButton);

       registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //회원가입 버튼 클릭했을 때
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class); //로그인 버튼 클릭시 RegisterActivty로 이동
                startActivity(intent);

            }
        });

        if (sessionManager.getLogin()){

            startActivity(new Intent(getApplicationContext(),MainActivity.class));


        }
        sessionManager = new SessionManager(getApplicationContext());
       loginButton.setOnClickListener(new View.OnClickListener() {
           @Override
           //로그인 버튼 클릭했을 때
           public void onClick(View view) {

               SharedPreferences pref = getSharedPreferences("checkFirst",Activity.MODE_PRIVATE);
               boolean checkFirst = pref.getBoolean("checkFirst",false);

               String userID = idText.getText().toString().trim(); //사용자가 적은 값 get해와라
               String userPassword = passwordText.getText().toString().trim();

               Response.Listener<String> responseListener = new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {
                       try{
                           JSONObject jsonObject = new JSONObject(response);
                           boolean success = jsonObject.getBoolean("success");
                           if (success){
                               String userID = jsonObject.getString("userID");
                               String userPassword = jsonObject.getString("userPassword");
                               String usernickName = jsonObject.getString("usernickName"); //데이터 서버안에 userNickName을 getString해온뒤에 String usernickName해라
                               Toast.makeText(getApplicationContext(),"로그인에 성공했습니다.",Toast.LENGTH_SHORT).show(); //성공시 토스트출력
                               Intent intent = new Intent(LoginActivity.this,MainActivity.class);

                                sessionManager.setLogin(true);
                                sessionManager.setUserID(userID);
                                sessionManager.setUserPassword(userPassword);
                                sessionManager.setUserNickname(usernickName);

                               // //intent.putExtra는 화면이동할 때 값전달시 사용 ==> 화면 이동시 main화면에 nickname값이 뜰 수 있게 intent.putExtra를 활용하여 값 전달
                                // 형식은 map과 같음

                               prefs = getSharedPreferences("Pref", MODE_PRIVATE);
                               boolean checkFirst = prefs.getBoolean("checkFirst", false);
                                 if (checkFirst ==false ){
                                     SharedPreferences.Editor editor = pref.edit();
                                     editor.putBoolean("checkFisrt",true);
                                     editor.commit();

                                     Intent intent1 = new Intent(LoginActivity.this, Unitystory.class);
                                     overridePendingTransition(0, 0);
                                     startActivity(intent1);
                                     finish();
                                 }
                          else {
                                     startActivity(new Intent(getApplicationContext(), MainActivity.class));


                                 }
                               intent.putExtra("userId",userID);
                               intent.putExtra("userPassword",userPassword);
                               intent.putExtra("usernickName",usernickName);



                           }
                           else {
                               Toast.makeText(getApplicationContext(),"로그인에 실패했습니다.",Toast.LENGTH_SHORT).show();
                               return;
                           }

                       }
                       catch(JSONException e){
                           e.printStackTrace();
                       }
                   }
               };


               //volly활용해서 실제 서버요청
               LoginReqeust loginReqeust = new LoginReqeust(userID,userPassword,responseListener);
               RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
               queue.add(loginReqeust);
           }

       });
    }

            }




