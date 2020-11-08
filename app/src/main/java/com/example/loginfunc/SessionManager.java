package com.example.loginfunc;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
 SharedPreferences sharedPreferences;
 SharedPreferences.Editor editor;


 //create constructor
    public SessionManager(Context context){
        sharedPreferences = context.getSharedPreferences("sfile",0);
        editor = sharedPreferences.edit();
        editor.apply();

    }

    //create set login method
    public void setLogin(boolean login){
        editor.putBoolean("KEY_LOGIN",login);
        editor.commit();
    }
    public boolean getLogin(){
       return sharedPreferences.getBoolean("KEY_LOGIN",false);
    }

    public void setUserID(String userID){
        editor.putString("UserID",userID);
        editor.commit();
    }

    public String getUserID(){
        return sharedPreferences.getString("userID","");

    }
    public void setUserPassword(String userPassword){
        editor.putString("userPassword",userPassword);
        editor.commit();
    }

    public String getUserPassword(){
        return sharedPreferences.getString("userPassword","");

    }
    public void setUserNickname(String usernickName){
        editor.putString("usernickName",usernickName);
        editor.commit();
    }

    public String getUsernickName(){
        return sharedPreferences.getString("usernickName","");

    }

}
