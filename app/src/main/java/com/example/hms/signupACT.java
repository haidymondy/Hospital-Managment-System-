package com.example.hms;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hms.Database.Users_DB;

public class signupACT extends AppCompatActivity {

    EditText fname,username,password,cpassword,email;
    String  f_name,u_name , pass  ,  cpass ,  e_mail ;
    Button signup;
    Spinner gender;
    Users_DB udb;
    User user;
    AlertDialog.Builder al ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

            fname = (EditText)findViewById(R.id.fname_input);
            username = (EditText)findViewById(R.id.username_input);
            password = (EditText)findViewById(R.id.password_input);
            cpassword = (EditText)findViewById(R.id.confirm_password_input);
            email = (EditText)findViewById(R.id.email_input);
            signup = (Button) findViewById(R.id.signup_BTN);
            gender = (Spinner)findViewById(R.id.gender);
            udb = new Users_DB(signupACT.this);
            user = new User();


        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                 f_name = fname.getText().toString();
                 u_name = username.getText().toString();
                 pass  = password.getText().toString();
                 cpass = cpassword.getText().toString();
                 e_mail = email.getText().toString();
         user.setFullname(fname.getText().toString());
         user.setUsername(username.getText().toString());
         user.setPassword(password.getText().toString());
         user.setGender(gender.getSelectedItem().toString());
         user.setEmail(email.getText().toString());
                validation();

            }

        });

    }
    protected void validation(){
        if(f_name.equals(""))
            fname.setError("This Cell Cannot be Empty");
        else if(udb.checkIfuserIsfound(u_name))
            username.setError("This username is already taken");
        else if(u_name.length()<6)
            username.setError("Username length should be at least 6");
        else if(pass.length()<5)
            password.setError("Password length should be at least 5");
        else if(!cpass.equals(pass))
            cpassword.setError("Password doesn't match");
        else if(!e_mail.contains("@") || email.equals(""))
            email.setError("Invalid Email");
        else{
            udb.insert_user(user);
            al =  new AlertDialog.Builder(this);
    al.setTitle("Registeration Process").setMessage("Account Created Successfully").setCancelable(true).setPositiveButton("OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            finish();
        }
    }).show();


        }



    }


    public void buttonClick(View view) {
        Toast.makeText(this,"HELLO",Toast.LENGTH_SHORT).show();
    }
}