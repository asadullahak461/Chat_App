package com.example.chatapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.chatapp.R;
import com.google.android.material.button.MaterialButton;
import com.makeramen.roundedimageview.RoundedImageView;

public class SignUpActivity extends AppCompatActivity {

    RoundedImageView imgProfile;
    EditText inputSignUpName,inputSignUpEmail,inputSignUpPassword,inputConfirmPassword;
    MaterialButton btnSignUp;
    TextView txtSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        imgProfile = findViewById(R.id.imgProfile);
        inputSignUpName = findViewById(R.id.inputSignUpName);
        inputSignUpEmail = findViewById(R.id.inputSignUpEmail);
        inputSignUpPassword = findViewById(R.id.inputSignUpPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        txtSignIn = findViewById(R.id.txtSignIn);

        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(myintent);
            }
        });
    }
}