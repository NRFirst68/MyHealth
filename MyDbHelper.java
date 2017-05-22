package com.example.nplawhale.myapplicationfin;

/**
 * Created by nplawhale on 5/22/2017 AD.
 */

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.graphics.Typeface;
        import android.widget.TextView;

/**
 * Created by blueSKY on 22-May-17.
 */

public class MyDbHelper extends SQLiteOpenHelper{

    public MyDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, "TEST.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MEDICINE(ID INTEGER PRIMARY KEY AUTOINCREMENT,MEDICINENAME TEXT, AMOUNT TEXT, FORCURE TEXT, DETAILMED TEXT, EXPDATE TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP EXISTS MEDICINE");
        onCreate(db);
    }

    public void insertMedicine(String etMedName, String etAmount, String etForCure, String etDetailMed, String etExpDate) {
        ContentValues cv = new ContentValues();
        cv.put("MEDICINENAME",etMedName);
        cv.put("AMOUNT",etAmount);
        cv.put("FORCURE",etForCure);
        cv.put("DETAILMED",etDetailMed);
        cv.put("EXPDATE",etExpDate);


        this.getWritableDatabase().insertOrThrow("MEDICINE","",cv);
    }

    public void listMedicine(TextView textView1){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM MEDICINE",null);
        textView1.setText("");
        textView1.setTypeface(null, Typeface.BOLD);
        textView1.append("\nMedicine Information\n");
        while (cursor.moveToNext()){
            textView1.append("\n"+"MED ID: "+cursor.getString(0)+
                    "\n"+"Name > "+cursor.getString(1) +
                    "\n"+"Amount >"+cursor.getString(2)+ "Tablets" +
                    "\n"+"For Cure >"+cursor.getString(3) +
                    "\n"+"Expired Date > "+cursor.getString(5)+
                    "\n");
        }
    }





}//main
