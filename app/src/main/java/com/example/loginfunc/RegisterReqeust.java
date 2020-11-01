package com.example.loginfunc;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterReqeust extends StringRequest {

    final static private String URL = "https://dustn1259.cafe24.com/Register.php";
    private Map<String, String> parameters;

    public RegisterReqeust(String userID, String userPassword, String usernickName, int userAge, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("usernickName", usernickName);
        parameters.put("userAge", userAge + "");


    }

    public Map<String, String> getParameters() {
        return parameters;
    }
}



