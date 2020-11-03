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
    private boolean validate = false;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //id값 찾아서 넣어주기
        idText = findViewById(R.id.idText);
        passwordText = findViewById(R.id.passwordText);
        nicknameText = findViewById(R.id.nicknameText);
        ageText = findViewById(R.id.ageText);

        final Button validateButton = (Button) findViewById(R.id.validateButton);//아이디 유효성 검사
        //아이디 중복 체크
        validateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String userID = idText.getText().toString();
                if (validate) {
                    return; //검증 완료
                }

                if (userID.equals("")) {
                    AlertDialog.Builder builder=new AlertDialog.Builder( RegisterActivity.this );
                    dialog=builder.setMessage("아이디는 빈 칸일 수 없습니다")
                            .setPositiveButton("확인",null)
                            .create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse=new JSONObject(response);
                            boolean success=jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder=new AlertDialog.Builder( RegisterActivity.this );
                                dialog=builder.setMessage("사용할 수 있는 아이디입니다.")
                                        .setPositiveButton("확인",null)
                                        .create();
                                dialog.show();
                                idText.setEnabled(false);
                                validate=true;
                                validateButton.setText("확인");
                            }
                            else{
                                AlertDialog.Builder builder=new AlertDialog.Builder( RegisterActivity.this );
                                dialog=builder.setMessage("사용할 수 없는 아이디입니다.")
                                        .setNegativeButton("확인",null)
                                        .create();
                                dialog.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                ValidateRequest validateRequest=new ValidateRequest(userID,responseListener);
                RequestQueue queue= Volley.newRequestQueue(RegisterActivity.this);
                queue.add(validateRequest);

            }
        });

        Button registerButton = (Button) findViewById(R.id.registerButton);
        //회원가입 버튼을 눌렀을때
        registerButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //사용자가 넣은 값을 get해오기(값넣어주기)
                String userID = idText.getText().toString();
                String userPassword = passwordText.getText().toString();
                String usernickName = nicknameText.getText().toString();
                int userAge = Integer.parseInt(ageText.getText().toString());
                if(!validate){
                    Toast.makeText(getApplicationContext(),"중복체크 해주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try{
                            JSONObject jsonObject = new JSONObject(response);//JSONObject는 그냥 값을 서버에 전달하지 못해서 값서버전달시 사용하는 애
                            boolean success = jsonObject.getBoolean("success");//php response값인 success받아오고 걔가 true인지 false인지 검사 --> 서버통신 잘되었는지 확인
                            if (success){ //성공한경우
                                Toast.makeText(getApplicationContext(),"회원등록에 성공했습니다.",Toast.LENGTH_SHORT).show(); //토스트바형태로 메시지출력
                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class); //intent는 화면전환에 이용 : Register.this(지금코드)에서 LoginActivity로 이
                                startActivity(intent); //이동하라


                            }

                            else { //실패
                                Toast.makeText(getApplicationContext(),"회원등록에 실패했습니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }

                        }
                        catch(JSONException e){
                            e.printStackTrace();
                        }

                    }
                };
                //실제 서버로 volly통해 요청
                RegisterReqeust registerReqeust = new RegisterReqeust(userID, userPassword, usernickName, userAge, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerReqeust);

            }

        });



    }
}