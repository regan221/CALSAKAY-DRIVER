package com.example.calsakay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        showFragment();
    }

    private void showFragment(){
        SignUp1Fragment signUp1Fragment = new SignUp1Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.signupLayout, signUp1Fragment)
                .commit();
    }
}