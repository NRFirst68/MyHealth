package com.example.bluedot.myhealths;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
//Variable

    private EditText etUsername;
    private EditText etPassword;

    private Button bLogin;
    public  Button b1Register;

    private Context mContext;

    private DBhelper controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//log in and check in

        //controller = new DBhelper(this);
        mContext = this;

        b1Register = (Button) findViewById(R.id.b1Register);
        bLogin = (Button) findViewById(R.id.bLogin);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);


        bLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //checkLogin();
                Intent i1Login = new Intent(LoginActivity.this, UserActivity.class);
                startActivity(i1Login);
            }
        });

//link register

        b1Register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i2Login = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i2Login);
            }
        });
    }

}
