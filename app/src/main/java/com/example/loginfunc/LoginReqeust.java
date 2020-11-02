package com.example.loginfunc;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginReqeust extends StringRequest {

    final static private String URL = "http://dustn1259.cafe24.com/Login.php";
    private Map<String, String> map;

    public LoginReqeust(String userID, String userPassword, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("userID", userID);
        map.put("userPassword", userPassword);


    }
   @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}



