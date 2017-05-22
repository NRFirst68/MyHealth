package com.example.tachachompoonpracha.myhealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Database database;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = (TextView)findViewById(R.id.textView);
        database = new Database(this,"",null,9);
    }


    public void btn_click(View view) {
        switch (view.getId()){
            case R.id.list:
                        database.list(textView);
                break;
        }

    }

}
