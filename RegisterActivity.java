package com.example.bluedot.myhealths;

import android.app.Activity;
import android.content.DialogInterface;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {

    EditText etFName;
    EditText etLName;
    EditText etAddress;
    EditText etBlood;

    EditText etUsername;
    EditText etPassword;

    TextView textView1;
    DBhelper controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFName = (EditText) findViewById(R.id.etFName);
        etLName = (EditText) findViewById(R.id.etLName);
        etAddress = (EditText) findViewById(R.id.etAddress);
        etBlood = (EditText) findViewById(R.id.etBlood);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);

        textView1 = (TextView) findViewById(R.id.textView1);

        controller = new DBhelper(this,"",null,5);
    }

    public void btn_click(View view){
        switch (view.getId()){
            case R.id.bRegister:
                try {
                    controller.insertUser(etFName.getText().toString(),
                            etLName.getText().toString(),
                            etAddress.getText().toString(),
                            etBlood.getText().toString(),
                            etUsername.getText().toString(),
                            etPassword.getText().toString());
                }catch (SQLiteException e){
                    Toast.makeText(RegisterActivity.this,"ADD ALREADY",Toast.LENGTH_SHORT).show();
                }
                //claer data on edit text
                etFName.setText(null);
                etLName.setText(null);
                etAddress.setText(null);
                etBlood.setText(null);
                etUsername.setText(null);
                etPassword.setText(null);

                break;
            case R.id.bView:
                controller.listUser(textView1);
                break;
            case R.id.bDelete:
                controller.deleteUser(etFName.getText().toString());
                break;
        }//switch
    }

}//main
