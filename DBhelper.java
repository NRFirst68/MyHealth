package com.example.bluedot.myhealths;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by blueSKY on 22-May-17.
 */

public class DBhelper extends SQLiteOpenHelper{

    private final String KEY_PREFS = "prefs_user";
    private final String KEY_USERNAME = "username";
    private final String KEY_PASSWORD = "password";
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;



    public DBhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, "TEST.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USER(ID INTEGER PRIMARY KEY AUTOINCREMENT,USERFNAME TEXT, USERLNAME TEXT, ADDRESS TEXT, BLOOD TEXT, USERNAME TEXT, PASSWORD TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP EXISTS USER");
        onCreate(db);
    }

    public void insertUser(String etFName, String etLName, String etAddress, String etBlood, String etUsername, String etPassword) {
        ContentValues cv = new ContentValues();
        cv.put("USERFNAME",etFName);
        cv.put("USERLNAME",etLName);
        cv.put("ADDRESS",etAddress);
        cv.put("BLOOD",etBlood);
        cv.put("USERNAME",etUsername);
        cv.put("PASSWORD",etPassword);

        this.getWritableDatabase().insertOrThrow("USER","",cv);
    }

    public void listUser(TextView textView1){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM USER",null);
        textView1.setText("");
        textView1.setTypeface(null, Typeface.BOLD);
        textView1.append("\nUser Information\n");
        while (cursor.moveToNext()){
            textView1.append("\n"+"USER ID: "+cursor.getString(0)+
                    "\n"+"Name > "+cursor.getString(1)+"  " + cursor.getString(2)+
                    "\n"+"Address >"+cursor.getString(3) +
                    "\n"+"Blood: "+cursor.getString(4)+
                    "\n");
        }
    }

    public void deleteUser(String etFName){
        this.getWritableDatabase().delete("USER","USERFNAME='"+etFName+"'",null);
    }

}//main
