package com.example.tachachompoonpracha.myhealth;



import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstname,lastname,hight,weight,birthday,blood,allergic,address,telephone,email;
    TextView textView;
    Database database;
    Button second,edit;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstname =(EditText)findViewById(R.id.firstname_input);
        lastname = (EditText)findViewById(R.id.lastname_input);
        hight =(EditText)findViewById(R.id.hight_input);
        weight =(EditText)findViewById(R.id.weight_input);
        birthday =(EditText)findViewById(R.id.birthday_input);
        blood = (EditText)findViewById(R.id.blood_input);
        allergic = (EditText)findViewById(R.id.allergic_input);
        address = (EditText)findViewById(R.id.address_input);
        telephone =(EditText)findViewById(R.id.telephone_input);
        email = (EditText)findViewById(R.id.email_input);


        textView = (TextView)findViewById(R.id.textView);

        database = new Database(this,"",null,9);
    }

    public void btn_click(View view){
        switch (view.getId()){
            case R.id.button_add:
                try{
                    database.insert(firstname.getText().toString(),
                            lastname.getText().toString(),
                            hight.getText().toString(),
                            weight.getText().toString(),
                            birthday.getText().toString(),
                            blood.getText().toString(),
                            allergic.getText().toString(),
                            address.getText().toString(),
                            telephone.getText().toString(),
                            email.getText().toString());
                }catch (SQLiteException e){
                    Toast.makeText(MainActivity.this,"ALREADY EXISTS", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.button_update:


                //LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("ENTER NEW WEIGHT");

                //final EditText new_profile = new EditText(this);

                //dialog.setView(inflater.inflate(R.layout.activity_main3, null));

                //dialog.setView(new_profile);

                //AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                //dialog.setTitle("ENTER NEW FIRSTNAME");
                //dialog.setTitle("ENTER NEW LASTNAME");

                final EditText new_firstname = new EditText(this);
                dialog.setView(new_firstname);
                /*final EditText new_profile = new EditText(this);
                dialog.setView(new_profile);*/
                //dialog.setView(inflater.inflate(R.layout.activity_main, null));

                //final EditText new_lastname = new EditText(this);
                //dialog.setView(new_lastname);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener(){


                    @Override
                public void onClick(DialogInterface dialog, int i)    {
                    //public void onClick(DialogInterface dialogInterface, int i)    {
                       database.update(weight.getText().toString(),new_firstname.getText().toString());
                       // database.update(weight.getText().toString(),new_profile.getText().toString());
                        //database.update(lastname.getText().toString(),new_lastname.getText().toString());
/*
                        boolean isUpdate = database.updateProfile(firstname.getText().toString(),
                                lastname.getText().toString(),
                                hight.getText().toString(),
                                weight.getText().toString(),
                                allergic.getText().toString(),
                                address.getText().toString(),
                                telephone.getText().toString(),
                                email.getText().toString());
                        if(isUpdate == true) {
                            Toast.makeText(getBaseContext(), "Update Success", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(i);
                            finish();

                        }
                        else
                        {
                            Toast.makeText(getBaseContext(), "Data Not Updated", Toast.LENGTH_LONG).show();
                        }
*/

                    }

            });

               /* dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){


                    @Override
                    public void onClick(DialogInterface dialog, int which)    {

                    }

                });*/
            dialog.show();

                /*edit =(Button) findViewById(R.id.second);
                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this,MainActivity.class);
                        i.putExtra("Firstname", firstname.getText().toString());;
                        i.putExtra("Lastname",lastname.getText().toString());;
                        i.putExtra("Hight",hight.getText().toString());
                        i.putExtra("Hight",weight.getText().toString());
                        i.putExtra("Hight",allergic.getText().toString());
                        i.putExtra("Hight",address.getText().toString());
                        i.putExtra("Hight",telephone.getText().toString());
                        i.putExtra("Hight",email.getText().toString());

                        startActivity(i);
                        finish();




                    }
                });*/
            break;

            case R.id.delete:

                AlertDialog.Builder dialogs = new AlertDialog.Builder(MainActivity.this);
                dialogs.setTitle("DELETE SUCCESS");
                /*final EditText newName = new EditText(this);
                dialogs.setView(newName);*/

                dialogs.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        database.delete(firstname.getText().toString());


                    }
                });
                dialogs.show();

                break;

            //case R.id.list:
                /*second =(Button) findViewById(R.id.second);
                second.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v){
                        startActivity(new Intent(MainActivity.this,Main2Activity.class));

                    }
                });*/
               //database.list(textView);
                //break;

            case R.id.second:

                second =(Button) findViewById(R.id.second);
                second.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v){
                        startActivity(new Intent(MainActivity.this,Main2Activity.class));
                    }
                });
                break;

        }
    }

}