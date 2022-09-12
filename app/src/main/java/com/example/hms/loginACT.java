package com.example.hms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hms.Database.Loggedin;
import com.example.hms.Database.Users_DB;

public class loginACT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Loggedin l = new Loggedin(this);
        if(l.CheckIfUserLoggedin()==false){

        }
        else{
            l.seTLoggedinUserData();
            Main.username=Main.tmp_uname;
            Intent i = new Intent(loginACT.this, HomeActivity.class);
            startActivity(i);
            finish();
        }

        EditText username_input = (EditText) findViewById(R.id.username_input2);
        EditText password_input = (EditText) findViewById(R.id.password_input2);
        Button login_BTN = (Button) findViewById(R.id.login_BTN);
        TextView signup_link = (TextView) findViewById(R.id.signup_link);
        TextView alert = (TextView) findViewById(R.id.alert_login);
        CheckBox rmmbr = (CheckBox) findViewById(R.id.remember);


        Users_DB u = new Users_DB(this);

        Intent i = new Intent(loginACT.this, HomeActivity.class);

        signup_link.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                               Intent i = new Intent(loginACT.this, signupACT.class);
                                               startActivity(i);
                                               overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);


                                           }
                                       }

        );
        login_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username_input.getText().toString().equals("admin") && password_input.getText().toString().equals("admin")){
                    Intent g = new Intent(loginACT.this,HireDoctorActivity.class);
                    startActivity(g);
                    finish();

                }else{
                String flag = u.login_verification(username_input.getText().toString(), password_input.getText().toString());
                alert.setText(flag);
                if (flag.equals("Loggedin Successfully!")) {
                    if(rmmbr.isChecked()){
                        l.Loggedin_user_insert(username_input.getText().toString(),password_input.getText().toString());
                        l.seTLoggedinUserData();
                    }
                    else{
                    }
                    Main.username=username_input.getText().toString();
                    startActivity(i);
                    finish();
                }}

            }
        });


    }






}