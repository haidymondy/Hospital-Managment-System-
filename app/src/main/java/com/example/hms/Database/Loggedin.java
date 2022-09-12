package com.example.hms.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.hms.Main;

public class Loggedin extends SQLiteOpenHelper {
    private Context c;
    public static final String DatabaseName ="Loggedin.db";
    SQLiteDatabase Loggedin;


    public Loggedin(Context con){
        super(con,DatabaseName,null,1);
        c=con;
    }

    public void onCreate(SQLiteDatabase sq) {
        sq.execSQL("CREATE TABLE Loggedin_User (USERNAME TEXT,PASSWORD TEXT)");}



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void Loggedin_user_insert(String uname , String pass){
        Loggedin = this.getWritableDatabase();
        ContentValues info = new ContentValues();
        info.put("USERNAME", uname);
        info.put("PASSWORD", pass);
        Loggedin.insert("Loggedin_User",null,info);
    }
    public boolean CheckIfUserLoggedin(){
        Loggedin = this.getReadableDatabase();
        Cursor mCursor = Loggedin.rawQuery("SELECT * FROM " + "Loggedin_User", null);
        Boolean rowExists;

        if (mCursor.moveToFirst())
        {
            // DO SOMETHING WITH CURSOR
            rowExists = true;

        }
        else
        {
            rowExists = false;
        }
        return rowExists;
    }
    public void cleardata(){
        Loggedin = this.getWritableDatabase();
        Loggedin.execSQL("DELETE FROM Loggedin_User"); //delete all rows in a table
        Loggedin.close();
    }
    public void seTLoggedinUserData(){
        Loggedin = this.getReadableDatabase();
        Cursor cursor = Loggedin.rawQuery("SELECT * FROM " + "Loggedin_User", null);
        cursor.moveToFirst();
        Main.tmp_uname =   cursor.getString(0);
        Main.tmp_pass =    cursor.getString(1);
    }

}