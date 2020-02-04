package com.example.soundpeeps.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.soundpeeps.R;

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
            Intent intent = new Intent(SelectLoginSignupActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
            return;
        });
    }
}
