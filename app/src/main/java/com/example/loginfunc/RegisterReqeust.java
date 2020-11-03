package com.example.loginfunc;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterReqeust extends StringRequest {
     //php서버연
    final static private String URL = "http://dustn1259.cafe24.com/Register.php";
    private Map<String, String> map;//키 값과 그안에 담을 value

    public RegisterReqeust(String userID, String userPassword, String usernickName, int userAge, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("userID", userID); //userID에 userID를 담는다 (key,value)
        map.put("userPassword", userPassword);
        map.put("usernickName", usernickName);
        map.put("userAge", userAge + ""); //age를 문자형화 하기 위해 +""사용


    }
   @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}



