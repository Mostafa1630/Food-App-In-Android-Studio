package com.example.myapplication0;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import db.Customer;
import db.dbHelper;

public class login extends AppCompatActivity {
    dbHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button=findViewById(R.id.login_loginBtn);

        helper=new dbHelper(getApplicationContext());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase sqLiteDatabase=helper.getWritableDatabase();

                Cursor c=sqLiteDatabase.query("customer",null,null,null,null,null,null);
                String data = "";
                while(c.moveToNext()){
                    @SuppressLint("Range") String id=c.getString(c.getColumnIndex("email"));
                    @SuppressLint("Range") String pass=c.getString(c.getColumnIndex("password"));
                    data+=id+" "+pass+"\n";
                }
                c.close();
                Toast.makeText(login.this, data, Toast.LENGTH_SHORT).show();



//
            }
            });



     }



    public void register(View view) {

        startActivity(new Intent(login.this , register.class));
    }
}