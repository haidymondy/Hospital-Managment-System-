package com.example.hms.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hms.Main;
import com.example.hms.displayItems;

import java.util.ArrayList;

public class Book_DB extends SQLiteOpenHelper {
    public static final String dataBaseName="Book.db";
    SQLiteDatabase c;
    public Book_DB(Context con)
    {
        super(con,dataBaseName,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Book (id integer primary key autoincrement " +
                ",doctorName text," +
                "specialist text," +
                "patientName text," +
                "patientAge text," +
                "patientAddress text," +
                "patientMobile text,username text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Book");
        onCreate(sqLiteDatabase);

    }
    public String insert_Data(String d,String sp,String pname,String page,String paddress ,String pmobile)
    {
        c=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("doctorName",d);
        values.put("specialist",sp);
        values.put("patientName",pname);
        values.put("patientAge",page);
        values.put("patientAddress",paddress);
        values.put("patientMobile",pmobile);
        values.put("username", Main.username);
       long re= c.insert("Book",null,values);
       if(re==-1)
           return "Error";
       else
           return "Payment Sucessfully";
    }
    public ArrayList<displayItems> GET_DATa()
    {
        ArrayList<displayItems> arrayList=new ArrayList<>();
        c=this.getReadableDatabase();
        String[] args={Main.username};
        Cursor cursor=c.rawQuery("select * from Book where username like ?", args);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            arrayList.add(new displayItems(cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4),
                    cursor.getString(5), cursor.getString(6)));
            cursor.moveToNext();
        }
        c.close();
        cursor.close();

        return arrayList;
    }
}
