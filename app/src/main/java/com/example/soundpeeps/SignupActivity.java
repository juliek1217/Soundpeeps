package com.example.soundpeeps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    private Button mSignup;
    private EditText mEmail, mPassword, mName;

    private RadioGroup mRadioGroup;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();
        firebaseAuthStateListner = firebaseAuth -> {
            final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user !=null){
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        };

        mSignup = findViewById(R.id.signup);

        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mName = findViewById(R.id.name);

        mRadioGroup = findViewById(R.id.radioGroup);

        mSignup.setOnClickListener(view -> {
            int selectId = mRadioGroup.getCheckedRadioButtonId();

            final RadioButton radioButton = findViewById(selectId);

            if(radioButton.getText() == null){
                return;
            }

            final String email = mEmail.getText().toString();
            final String password = mPassword.getText().toString();
            final String name = mName.getText().toString();
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignupActivity.this, task -> {
                if(!task.isSuccessful()){
                    Toast.makeText(SignupActivity.this, "sign up error", Toast.LENGTH_SHORT).show();
                }else{
                    String userId = mAuth.getCurrentUser().getUid();
                    DatabaseReference currentUserDb = FirebaseDatabase.getInstance().getReference().child("Users").child(userId);
                    Map userInfo = new HashMap<>();
                    userInfo.put("name", name);
                    userInfo.put("sex", radioButton.getText().toString());
                    userInfo.put("profileImageUrl", "default");
                    currentUserDb.updateChildren(userInfo);
                }
            });
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthStateListner);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthStateListner);
    }
}
