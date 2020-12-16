package com.example.loginfunc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.unity3d.player.UnityPlayerActivity;

public class UnityHolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unity_holder);

        Intent intent = new Intent(UnityHolderActivity.this, UnityPlayerActivity.class); //로그인 버튼 클릭시 RegisterActivty로 이동
        startActivity(intent);
    }
}