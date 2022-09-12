package com.example.hms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hms.Database.Book_DB;

public class Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        // Doctor Information
        TextView t1=(TextView) findViewById(R.id.doctorName);//doctorName
        TextView t2=(TextView) findViewById(R.id.specialist);//specialist
        TextView t3=(TextView) findViewById(R.id.exp);//yearOfExp
        TextView t4=(TextView) findViewById(R.id.fee);//Fee
        Intent data=getIntent();
        String doctorName=data.getExtras().getString("doctorName");
        String specialist=data.getExtras().getString("specialist");
        int yearOfExp=data.getExtras().getInt("yearOfExp");
        int fee=data.getExtras().getInt("fee");
        t1.setText("Name : Dr/"+doctorName);
        t2.setText("Specialist : "+specialist);
        t3.setText("Year Of Experience : "+yearOfExp);
        t4.setText("Appointment Fee : "+fee+"EGP");

        //Patient Information



        //Payment Details
        TextView t20= (TextView) findViewById(R.id.textView20);//fee
        TextView service=(TextView) findViewById(R.id.service);
        TextView total=(TextView) findViewById(R.id.totalfee);

        t20.setText("Appointment Fee : "+fee+"EGP");
        service.setText("Service Charge : 20EGP ");
        int sum=fee+20;
        total.setText("Total : "+sum+"EGP");


        //Buttons
        Button back=(Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
        Button pay=(Button) findViewById(R.id.pay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name=(EditText) findViewById(R.id.name);
                EditText age=(EditText) findViewById(R.id.age);
                EditText address=(EditText) findViewById(R.id.addrress);
                EditText mobile=(EditText) findViewById(R.id.mobile);

                String PatientName=name.getText().toString();
                String PatientAge=age.getText().toString();
                String PatientAddress=address.getText().toString();
                String PatientMobile=mobile.getText().toString();
                Main.Patient=PatientName;
                Book_DB book_db=new Book_DB(Form.this);
                String t=book_db.insert_Data(doctorName,specialist,PatientName,PatientAge,PatientAddress,PatientMobile);
                Toast.makeText(Form.this,t,Toast.LENGTH_LONG).show();
                Intent i=new Intent(Form.this,FianlStepInBook.class);
                startActivity(i);
                finish();




            }
        });




    }
}