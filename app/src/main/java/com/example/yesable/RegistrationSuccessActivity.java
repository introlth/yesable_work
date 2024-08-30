package com.example.yesable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_success);

        Button loginButton = findViewById(R.id.button_login);  // 로그인 버튼 참조

        // 로그인 버튼 클릭 시 StartActivity로 이동하는 로직
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // StartActivity로 이동하는 Intent 생성
                Intent intent = new Intent(RegistrationSuccessActivity.this, StartActivity.class);
                startActivity(intent);  // StartActivity로 이동
                finish();  // 현재 액티비티 종료
            }
        });
    }
}
