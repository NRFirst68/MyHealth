package com.example.nplawhale.myapplicationfin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.database.sqlite.SQLiteException;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etMedName;
    EditText etAmount;
    EditText etForCure;
    EditText etDetailMed;
    EditText etExpDate;


    TextView textView1;
    MyDbHelper controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMedName = (EditText) findViewById(R.id.etMedName);
        etAmount = (EditText) findViewById(R.id.etAmount);
        etForCure = (EditText) findViewById(R.id.etForCure);
        etDetailMed = (EditText) findViewById(R.id.etDetailMed);
        etExpDate = (EditText) findViewById(R.id.etExpDate);


        textView1 = (TextView) findViewById(R.id.textView1);

        controller = new MyDbHelper(this,"",null,5);
    }

    public void btn_click(View view){
        switch (view.getId()){
            case R.id.bAdd:
                try {
                    controller.insertMedicine(etMedName.getText().toString(),
                            etAmount.getText().toString(),
                            etForCure.getText().toString(),
                            etDetailMed.getText().toString(),
                            etExpDate.getText().toString());
                }catch (SQLiteException e){
                    Toast.makeText(MainActivity.this,"ALREADY ADD MEDICINE",Toast.LENGTH_SHORT).show();
                }
                break;
                case R.id.bView:
                controller.listMedicine(textView1);
                break;

        }//switch
    }
}
