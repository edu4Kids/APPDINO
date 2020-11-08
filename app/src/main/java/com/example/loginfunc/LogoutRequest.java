package com.example.loginfunc;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LogoutRequest extends StringRequest {

    final static private String URL = "http://dustn1259.cafe24.com/Logout.php";
    private Map<String, String> map;

    public LogoutRequest(String userID, String userPassword, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("userID", null);
        map.put("userPassword", null);


    }
    @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
