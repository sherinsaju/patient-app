package com.example.patientapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PatientActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    AppCompatButton b1;
    String getpcode,getname,getaddress,getmobile,getdoctor;
Patientdb mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        e1=(EditText) findViewById(R.id.pcode);
        e2=(EditText) findViewById(R.id.name);
        e3=(EditText) findViewById(R.id.add);
        e4=(EditText) findViewById(R.id.mob);
        e5=(EditText) findViewById(R.id.dname);
        b1=(AppCompatButton) findViewById(R.id.submit);
        mydb=new Patientdb(this);
        mydb.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getpcode = e1.getText().toString();
                getname = e2.getText().toString();
                getaddress = e3.getText().toString();
                getmobile = e4.getText().toString();
                getdoctor=e5.getText().toString();

                boolean status =mydb.InsertPatient(getpcode,getname,getaddress,getmobile,getdoctor);

                if (status == true){
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    e5.setText("");

                    Toast.makeText(getApplicationContext(), "successfully inserted", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}