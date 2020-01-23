package com.example.soundpeeps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectLoginSignupActivity extends AppCompatActivity {

    private Button mLogin, mSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_login_signup);

        mLogin = findViewById(R.id.login);
        mSignup = findViewById(R.id.signup);

        mLogin.setOnClickListener(view -> {
            Intent intent = new Intent(SelectLoginSignupActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        });

        mSignup.setOnClickListener(view -> {
            Intent intent = new Intent(SelectLoginSignupActivity.this, SignupActivity.class);
            startActivity(intent);
            finish();
            return;
        });
    }
}
