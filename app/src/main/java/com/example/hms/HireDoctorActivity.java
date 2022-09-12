package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hms.Database.Doctors_DB1;

public class HireDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Doctors_DB1 doctors = new Doctors_DB1(HireDoctorActivity.this);
        setContentView(R.layout.activity_hire_doctor);
        EditText name = findViewById(R.id.doc_name);
        EditText exp = findViewById(R.id.doc_exp);
        EditText spec = findViewById(R.id.doc_spec);
        EditText app = findViewById(R.id.doc_app);
        Button add = findViewById(R.id.add_btn);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doctors.inser_Data(spec.getText().toString(),name.getText().toString(),Integer.parseInt(exp.getText().toString()),Integer.parseInt(app.getText().toString()));
                Toast.makeText(HireDoctorActivity.this, "Doctor Added succesfully to Hms Hospital", Toast.LENGTH_SHORT).show();
            }
        });

    }
}