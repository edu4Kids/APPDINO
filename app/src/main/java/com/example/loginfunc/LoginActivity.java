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
     private CheckBox autoCheck ;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        idText =  findViewById(R.id.idText);
        passwordText = findViewById(R.id.passwordText);
        autoCheck = findViewById(R.id.autoCheck);




      if(idText != null && passwordText !=null) {
          //저장된 값을 불러오기 위해 같은 네임파일을 찾음.
          SharedPreferences sf = getSharedPreferences("sFile", MODE_PRIVATE);
          //text라는 key에 저장된 값이 있는지 확인. 아무값도 들어있지 않으면 ""를 반환
          String userID = sf.getString("userID", "");
          idText.setText(userID);
          String userPassword = sf.getString("userPassword", "");
          passwordText.setText(userPassword);


          Response.Listener<String> responseListener = new Response.Listener<String>() {
              @Override
              public void onResponse(String response) {
                  try {
                      JSONObject jsonObject = new JSONObject(response);
                      boolean success = jsonObject.getBoolean("success");
                      if (success) {
                          String userID = jsonObject.getString("userID");
                          String userPassword = jsonObject.getString("userPassword");
                          String usernickName = jsonObject.getString("usernickName");
                          Toast.makeText(LoginActivity.this, "자동로그인 입니다.", Toast.LENGTH_SHORT).show();
                          Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                          intent.putExtra("usernickName", usernickName);
                          startActivity(intent);
                          finish();
                      }
                  } catch (JSONException e) {
                      e.printStackTrace();
                  }

              }
          };

          //volly활용해서 실제 서버요청




      }


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
       loginButton.setOnClickListener(new View.OnClickListener() {
           @Override
           //로그인 버튼 클릭했을 때
           public void onClick(View view) {
               String userID = idText.getText().toString(); //사용자가 적은 값 get해와라
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
                               String usernickName = jsonObject.getString("usernickName"); //데이터 서버안에 userNickName을 getString해온뒤에 String usernickName해라
                               Toast.makeText(getApplicationContext(),"로그인에 성공했습니다.",Toast.LENGTH_SHORT).show(); //성공시 토스트출력
                               Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                               intent.putExtra("userId",userID);
                               intent.putExtra("userPassword",userPassword);
                               intent.putExtra("usernickName",usernickName);
                               // //intent.putExtra는 화면이동할 때 값전달시 사용 ==> 화면 이동시 main화면에 nickname값이 뜰 수 있게 intent.putExtra를 활용하여 값 전달
                                // 형식은 map과 같음
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

               //volly활용해서 실제 서버요청
               LoginReqeust loginReqeust = new LoginReqeust(userID,userPassword,responseListener);
               RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
               queue.add(loginReqeust);
           }
       });
    }
     @Override
     protected void onStop() {
         super.onStop();

// Activity가 종료되기 전에 저장한다.
//SharedPreferences를 sFile이름, 기본모드로 설정
         SharedPreferences sharedPreferences = getSharedPreferences("sFile",MODE_PRIVATE);

//저장을 하기위해 editor를 이용하여 값을 저장시켜준다.
         SharedPreferences.Editor editor = sharedPreferences.edit();
         String userID = idText.getText().toString(); // 사용자가 입력한 저장할 데이터
         editor.putString("userID",userID); // key, value를 이용하여 저장하는 형태
         String userPassword = passwordText.getText().toString(); // 사용자가 입력한 저장할 데이터
         editor.putString("userPassword",userPassword); // key, value를 이용하여 저장하는 형태
//다양한 형태의 변수값을 저장할 수 있다.
//editor.putString();
//editor.putBoolean();
//editor.putFloat();
//editor.putLong();
//editor.putInt();
//editor.putStringSet();


//최종 커밋
         editor.commit();
     }
            }




