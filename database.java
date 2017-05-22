package com.example.tachachompoonpracha.myhealth;

/**
 * Created by tachachom poonpracha on 5/19/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Typeface;
import android.widget.TextView;

public class Database extends SQLiteOpenHelper {
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "TEST.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE PATIENT( ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRSTNAME TEXT UNIQUE, LASTNAME TEXT, HIGHT INTEGER, WEIGHT INTEGER, BIRTHDAY INTEGER, BLOOD TEXT, ALLERGIC TEXT, ADDRESS TEXT, TELEPHONE INTEGER, EMAIL TEXT );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PATIENT;");
        onCreate(sqLiteDatabase);
    }

    public void insert(String firstname,String lastname, String hight, String weight, String birthday, String blood, String allergic, String address, String telephone, String email
    ){
        ContentValues contentValues = new ContentValues();
        contentValues.put("FIRSTNAME",firstname);
        contentValues.put("LASTNAME",lastname);
        contentValues.put("HIGHT",hight);
        contentValues.put("WEIGHT",weight);
        contentValues.put("BIRTHDAY",birthday);
        contentValues.put("BLOOD",blood);
        contentValues.put("ALLERGIC",allergic);
        contentValues.put("ADDRESS",address);
        contentValues.put("TELEPHONE",telephone);
        contentValues.put("EMAIL",email);
        this.getWritableDatabase().insertOrThrow("PATIENT","",contentValues);
    }

    public void update(String old_firstname,String new_firstname){
        //this.getWritableDatabase().execSQL("UPDATE PATIENT SET PROFILE='" +new_profile+ "' WHERE PROFILE='"+old_profile+"'");
        //this.getWritableDatabase().execSQL("UPDATE PATIENT SET FIRSTNAME='" +new_firstname+ "' WHERE FIRSTNAME='"+old_firstname+"'");
        this.getWritableDatabase().execSQL("UPDATE PATIENT SET WEIGHT='" +new_firstname+ "' WHERE WEIGHT='"+old_firstname+"'");
    }

   /* public boolean updateProfile(String firstname, String lastname, String hight, String weight, String allergic, String address, String telephone, String email)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("FIRSTNAME",firstname);
        values.put("LASTNAME",lastname);
        values.put("HIGHT",hight);
        values.put("WEIGHT",weight);
        values.put("ALLERGIC",allergic);
        values.put("ADDRESS",address);
        values.put("TELEPHONE",telephone);
        values.put("EMAIL",email);

        sqLiteDatabase.update("PATIENT",values,"FIRSTNAME" + "=?",new String[]{firstname});
        sqLiteDatabase.close();
        return true;
    }*/

    public void delete(String firstname){
        this.getWritableDatabase().delete("PATIENT","FIRSTNAME='"+firstname+"'",null);
    }

    public void list(TextView textView){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM PATIENT",null);
                textView.setText(" ");
                textView.setTypeface(null, Typeface.NORMAL);
                while(cursor.moveToNext()){
                    textView.append("\n"+"ID: "+ cursor.getString(0)+"\n"+"Name: "+cursor.getString(1) +"   " +cursor.getString(2)+"\n"+"Hight: "+ cursor.getString(3)+"\n"+"Weight: "+ cursor.getString(4)+"\n"+"Birthday: "+ cursor.getString(5)+"\n"+"Blood: "+ cursor.getString(6)+"\n"+"Allergic: "+ cursor.getString(7)+"\n"+"Address: "+ cursor.getString(8)+"\n"+"Telephone: "+ cursor.getString(9)+"\n"+"Email: "+ cursor.getString(10)+"\n");
                }
    }
}





