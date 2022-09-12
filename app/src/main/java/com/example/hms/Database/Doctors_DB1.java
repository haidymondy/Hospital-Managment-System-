package com.example.hms.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Doctors_DB1 extends SQLiteOpenHelper {
    public static final String databaseName="Doctors.db";
    SQLiteDatabase s;
    public Doctors_DB1(Context con)
    {
        super(con,databaseName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Doctors (" +
                "id integer primary key autoincrement ," +
                "specialist text," +
                "doctorName text," +
                "yearOfExp integer," +
                "fee integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Doctors");
        onCreate(sqLiteDatabase);

    }
    public String inser_Data(String sp,String d,int y,int f)
    {
        s=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("specialist",sp);
        values.put("doctorName",d);
        values.put("yearOfExp",y);
        values.put("fee",f);
      long result=  s.insert("Doctors",null,values);
        s.close();
        if(result==-1)
        {
            return "error";
        }
        else
        {
            return "Doctor Added succesfully to Hms Hospital";
        }

    }
    public ArrayList<Doctor_Information> get_Data(String name)
    {
        ArrayList<Doctor_Information> arrayList=new ArrayList<Doctor_Information>();
        s=this.getReadableDatabase();
        String[] args={name};
        Cursor cursor=s.rawQuery("select * from Doctors where specialist like ?",args);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            arrayList.add(new Doctor_Information(cursor.getInt(0),cursor.getString(2),cursor.getInt(3),cursor.getInt(4)));
            cursor.moveToNext();
        }
            s.close();
            cursor.close();
            return arrayList;
    }
}
