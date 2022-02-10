package com.example.patientapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
EditText e1,e2,e3,e4,e5;
AppCompatButton b1;
String getMob,getPcode,getPname,getAddress,getDname;
Patientdb mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        e1=(EditText) findViewById(R.id.mobile);
        b1=(AppCompatButton) findViewById(R.id.search);
        e2=(EditText) findViewById(R.id.patcode);
        e3=(EditText) findViewById(R.id.name);
        e4=(EditText) findViewById(R.id.addr);
        e5=(EditText) findViewById(R.id.doc);
        mydb=new Patientdb(this);
        mydb.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getMob=e1.getText().toString();
                getPcode=e2.getText().toString();
                getPname=e3.getText().toString();
                getAddress=e4.getText().toString();
                getDname=e5.getText().toString();
                 Cursor c=mydb.Searchpatient(getMob);
                if (c.getCount()==0){
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    e5.setText("");
                    Toast.makeText(getApplicationContext(), "No patient Found", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while(c.moveToNext()){
                        getPcode=c.getString(1);
                        getPname=c.getString(2);
                        getAddress=c.getString(3);
                        getDname=c.getString(5);
                    }
                    e2.setText(getPcode);
                    e3.setText(getPname);
                    e4.setText(getAddress);
                    e5.setText(getDname);
                }



            }
        });



    }
}