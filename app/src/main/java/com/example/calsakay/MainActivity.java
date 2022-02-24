package com.example.calsakay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dd.CircularProgressButton;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DatabaseAccessCallback{

    private CircularProgressButton btLogin;
    private EditText etUsername, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLogin = findViewById(R.id.btLogin);
        etUsername = findViewById(R.id.etLoginUsername);
        etPassword = findViewById(R.id.etLoginPassword);

        btLogin.setProgress(0);
        DatabaseAccess dbAccess = new DatabaseAccess(this);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btLogin.setProgress(0);
                String inputUsername = etUsername.getText().toString();
                String inputPassword = etPassword.getText().toString();

                btLogin.setIndeterminateProgressMode(true);
                btLogin.setProgress(50);

                dbAccess.executeQuery("SELECT id," +
                        "first_name," +
                        "last_name," +
                        "birthday," +
                        "gender," +
                        "mobile_number," +
                        "address," +
                        "medical_job," +
                        "company_name," +
                        "company_address," +
                        "company_number," +
                        "front_image_name," +
                        "back_image_name," +
                        "orcr_back_img," +
                        "email," +
                        "user_image," +
                        "username," +
                        "password," +
                        "account_status," +
                        "date_joined " +
                        "FROM `calsakay_tbl_users` WHERE username = '" + inputUsername + "' AND password  = '" + inputPassword +"' AND role = 1");

            }
        });

    }

    @Override
    public void QueryResponse(List<String[]> data) {
        if(data.size() > 0){
            Intent mIntent = new Intent(this, Dashboard.class);
            writeConfig(data.get(0)[0]);
            mIntent.putExtra("userData", (Serializable) data);
            startActivity(mIntent);
        } else {
            btLogin.setProgress(-1);

            etUsername.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    btLogin.setProgress(0);
                }
            });

            etPassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    btLogin.setProgress(0);
                }
            });
        }
    }


    private void writeConfig(String id){
        File file = new File(MainActivity.this.getFilesDir(), "text");
        try {
            File gpxfile = new File(file, "config");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(id);
            writer.flush();
            writer.close();
        } catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

}