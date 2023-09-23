package com.example.chatapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chatapp.R;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class SignInActivity extends AppCompatActivity {

    EditText inputEmail,inputPassword;
    MaterialButton btnSignIn;
    TextView txtCreateNewAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        txtCreateNewAcc = findViewById(R.id.txtCreateNewAcc);
        setListeners();
    }

    private void setListeners(){

        txtCreateNewAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
               startActivity(intent);
            }
        });
        btnSignIn.setOnClickListener(view -> addDataToFirestore());
    }
    private void addDataToFirestore() {
        FirebaseFirestore dataBase = FirebaseFirestore.getInstance();
        HashMap<String,Object> data = new HashMap<>();
        data.put("first_name","Asad");
        data.put("laste_name","Khan");
        dataBase.collection("users").add(data)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(exception -> {
                    Toast.makeText(this, exception.getMessage(), Toast.LENGTH_SHORT).show();
                } );
    }
}