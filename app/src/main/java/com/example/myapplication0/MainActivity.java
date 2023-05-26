package com.example.myapplication0;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import db.dbHelper;

public class MainActivity extends AppCompatActivity {
    dbHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper=new dbHelper(getApplicationContext());


        /* orders table
        ContentValues Values= new ContentValues();

        SQLiteDatabase sqLiteDatabase=helper.getWritableDatabase();
        Values.put("customer_id","1");
         sqLiteDatabase.insert("orders",null,Values);

          Values= new ContentValues();
        Values.put("customer_id",1);
         sqLiteDatabase.insert("orders",null,Values);
        Values= new ContentValues();
        Values.put("customer_id",1);
        long rownum=sqLiteDatabase.insert("orders",null,Values);
        Toast.makeText(this, ""+rownum, Toast.LENGTH_SHORT).show();
*/


    }


    public void insert(View v){
        EditText e1=findViewById(R.id.name);
        EditText e2=findViewById(R.id.password);
        String val_e1=e1.getText().toString();
        String val_e2=e2.getText().toString();
        SQLiteDatabase sqLiteDatabase=helper.getWritableDatabase();
        String existpass="1";
                Cursor c=sqLiteDatabase.query("customer",null,"password =?",new String[]{val_e2},null,null,null);

        if(!c.moveToNext())
        {
            ContentValues Values= new ContentValues();
            Values.put("name",val_e1);
            Values.put("password",val_e2);
            Values.put("address","123");
            Values.put("email","123");

            long rownum=sqLiteDatabase.insert("customer",null,Values);
            Toast.makeText(this, ""+rownum+" account created", Toast.LENGTH_SHORT).show();

        }
  else {
            Toast.makeText(this,"you already has account", Toast.LENGTH_SHORT).show();

        }
    }
    public void select(View v){
        SQLiteDatabase sqLiteDatabase=helper.getWritableDatabase();
        Cursor c=sqLiteDatabase.query("customer",null,null,null,null,null,null);
        String data = "";
        while(c.moveToNext()){
            @SuppressLint("Range") String id=c.getString(c.getColumnIndex("name"));
            @SuppressLint("Range") String pass=c.getString(c.getColumnIndex("password"));
        data+=id+" "+pass+"\n";
        }
        c.close();
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
    public void delete(View v){
        EditText e2=findViewById(R.id.password);
        String val_e2=e2.getText().toString();
        SQLiteDatabase sqLiteDatabase=helper.getWritableDatabase();
        sqLiteDatabase.delete("customer","password= ?",new String[]{val_e2});

    }
    public void update(View v){
        EditText e1=findViewById(R.id.name);
        EditText e2=findViewById(R.id.password);
        String val_e1=e1.getText().toString();
        String val_e2=e2.getText().toString();
        SQLiteDatabase sqLiteDatabase=helper.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("name",val_e1);
        sqLiteDatabase.update("customer",c,"password= ?",new String[]{val_e2});
        Toast.makeText(this, "updated", Toast.LENGTH_SHORT).show();
    }
    public void join_cond(View v){
        SQLiteDatabase sqLiteDatabase=helper.getWritableDatabase();
        String s="select * from orders o join customer c where o.customer_id=c.id ";
        Cursor c=  sqLiteDatabase.rawQuery(s,null);
        int n=0;
        while(c.moveToNext()){
          n++;
        }
        c.close();
        Toast.makeText(this, ""+n, Toast.LENGTH_SHORT).show();

    }
}