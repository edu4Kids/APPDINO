package com.example.loginfunc;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterReqeust extends StringRequest {

    final static private String URL = "http://dustn1259.cafe24.com/Register.php";
    private Map<String, String> map;

    public RegisterReqeust(String userID, String userPassword, String usernickName, int userAge, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("userID", userID);
        map.put("userPassword", userPassword);
        map.put("usernickName", usernickName);
        map.put("userAge", userAge + "");


    }
   @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}



