package com.example.unme.vue.authentification;

import
        androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.unme.R;
import com.example.unme.vue.Dashboard;



public class LoginActivity extends AppCompatActivity {




    EditText etEmail, etPassword;
    final int MIN_PASSWORD_LENGTH = 6;
    final int MAX_PASSWORD_LENGTH = 60;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        viewInitializations();
        getSupportActionBar().hide();

    }

    void viewInitializations() {
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
    }

    //errors
    //checking that ets not empty
    boolean validateInput() {

        if (etEmail.getText().toString().equals("")) {
            etEmail.setError("Email is required");
            return false;
        }
        if (etPassword.getText().toString().equals("")) {
            etPassword.setError("Password is required");
            return false;
        }

        // checking email format
        if (!isEmailValid(etEmail.getText().toString())) {
            etEmail.setError("Please enter a valid email address");
            return false;
        }


        // checking  password Length
        if (etPassword.getText().length() < MIN_PASSWORD_LENGTH || etPassword.getText().length() > MAX_PASSWORD_LENGTH) {
            etPassword.setError("Password Length should be between  " + MIN_PASSWORD_LENGTH +" and "+MAX_PASSWORD_LENGTH+" characters");
            return false;
        }

        return true;
    }

    boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public void login (View v) {
        if (validateInput()) {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
            goToDashboard(v);
        }
    }

    public void goToSignup(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
    public void goToDashboard(View v) {
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
    public void forgetPassword(View v) {
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
    }

}