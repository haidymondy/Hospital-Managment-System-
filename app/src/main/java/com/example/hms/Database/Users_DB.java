package com.example.hms.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hms.Main;
import com.example.hms.User;
public class Users_DB extends SQLiteOpenHelper {
    Context c;
public static Main user = new Main();
    public static final String DatabaseName ="Users.db";
    SQLiteDatabase Users;
    public Users_DB(Context con){
     super(con,DatabaseName,null,1);
     c=con;
    }
    public void onCreate(SQLiteDatabase sq) {
    sq.execSQL("CREATE TABLE Users (ID INTEGER PRIMARY KEY AUTOINCREMENT ,FULLNAME TEXT ,USERNAME TEXT,PASSWORD TEXT ,EMAIL TEXT ,GENDER TEXT)");}
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Users");
        onCreate(sqLiteDatabase);

    }
    public void insert_user(User user){
        Users = this.getWritableDatabase();
        ContentValues info = new ContentValues();
        info.put("FULLNAME", user.getFullname());
        info.put("USERNAME", user.getUsername());
        info.put("PASSWORD", user.getPassword());
        info.put("EMAIL", user.getEmail());
        info.put("GENDER", user.getGender());
        Users.insert("Users",null,info);
    }
    public boolean checkIfuserIsfound(User user){
        String q = "Select * from Users where USERNAME = '"+user.getUsername()+"'";
        Cursor cursor = getReadableDatabase().rawQuery(q, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
    public boolean checkIfuserIsfound(String username){
        String q = "Select * from Users where USERNAME = '"+username+"'";
        Cursor cursor = getReadableDatabase().rawQuery(q, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
    public boolean checkIfpasswordIsCorrect(String username , String password){
        String q = "Select PASSWORD from Users where USERNAME = '"+username+"'";
        Cursor cursor = getReadableDatabase().rawQuery(q, null);
        cursor.moveToFirst();
        if(!(cursor.getString(0).equals(password))){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
    public String login_verification(String username , String password){
        if(!checkIfuserIsfound(username))
            return "Username is not found, please try again!";
        else {
            if(checkIfpasswordIsCorrect(username,password))
                return"Loggedin Successfully!";
            else
            return "Incorrect Password!";

        }

    }
    public User Get_info(){
       SQLiteDatabase userdatabase = this.getReadableDatabase();
       String[] args={Main.username};
       User user = new User();
       Cursor cursor = userdatabase.rawQuery("Select * from Users where USERNAME like ?",args);
       cursor.moveToFirst();
       user.setFullname(cursor.getString(1));
       user.setEmail(cursor.getString(4));
       user.setUsername(cursor.getString(2));
       user.setPassword(cursor.getString(3));
       user.setGender(cursor.getString(5));
       return user;

}
    public boolean Updatedata(String Fullname,String username,String email,String password,String GENDER){
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("USERNAME", username);
        cv.put("PASSWORD", password);
        cv.put("EMAIL", email);
        cv.put("GENDER", GENDER);
        sq.update("USERS",cv,"FULLNAME like ?",new String[] {Fullname});
        return true;
}
}