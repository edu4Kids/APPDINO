package com.example.loginfunc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Unitystory extends AppCompatActivity {
  private Button unityBtn;

    private final String packageName = "com.JKS.HelloWorld_AR";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unitystory);

        unityBtn = findViewById(R.id.unitybtn);
        unityBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            //set 버튼 클릭했을 때
            public void onClick(View view) {
            Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
                //로그인 버튼 클릭시 RegisterActivty로 이동



        Intent intent1 = new Intent(Unitystory.this, Story1btn.class); //로그인 버튼 클릭시 RegisterActivty로 이동

        startActivity(intent1);


                startActivity(intent);

            }
        });
    }
}