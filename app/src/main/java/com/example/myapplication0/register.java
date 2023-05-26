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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication0.ui.home.HomeFragment;

import db.Customer;
import db.dbHelper;


public class register extends AppCompatActivity {
    public static final String TAG="TAG";
    EditText mFullName,mEmail,mPassword,mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    ProgressBar progressBar;
    dbHelper helper;
    SQLiteDatabase sqLiteDatabase;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.register_Name);
        mEmail =findViewById(R.id.register_email);
        mPassword = findViewById(R.id.register_password);
        mPhone = findViewById(R.id.register_phone);
        mRegisterBtn = findViewById(R.id.register_registerBtn);
        mLoginBtn = findViewById(R.id.register_LoginBtn);
//        ProgressBar = findViewById(R.id.progressBar);
        helper=new dbHelper(getApplicationContext());

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //////// //validation
                final String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                final String Name = mFullName.getText().toString().trim();
                final String phone = mPhone.getText().toString().trim();


                if(TextUtils.isEmpty(email)){
                    mEmail.setError(("Email is Required"));
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mEmail.setError(("Password is Required"));
                    return;
                }
                if (password.length() <6){
                    mPassword.setError("password must Be >=6 character");
                    return;
                }
                /////////  ///register

                EditText e1 = findViewById(R.id.register_Name);
                EditText e2 = findViewById(R.id.register_password);
                EditText e3 = findViewById(R.id.register_email);
                EditText e4 = findViewById(R.id.register_phone);
                EditText e5 = findViewById(R.id.register_address);
                String val_e1 = e1.getText().toString();
                String val_e2 = e2.getText().toString();
                String val_e3 = e1.getText().toString();
                String val_e4 = e2.getText().toString();
                String val_e5 = e1.getText().toString();
                SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();

                Cursor c = sqLiteDatabase.query("customer", null, "password=? AND email=?", new String[]{val_e2, val_e3}, null, null, null);

                if (!c.moveToNext()) {
                    ContentValues Values = new ContentValues();
                    Values.put("name", val_e1);
                    Values.put("password", val_e2);
                    Values.put("email", val_e3);
                    Values.put("phone", val_e4);
                    Values.put("address", val_e5);

                    long rownum = sqLiteDatabase.insert("customer", null, Values);
                    Toast.makeText(getApplicationContext(),   rownum+"  " +getString(R.string.accountcreated),Toast.LENGTH_SHORT).show();

                    Customer customer=new Customer(val_e1,val_e3,val_e4,val_e5,val_e2);
                    Intent intent= new Intent(getApplicationContext(), MainActivity2.class);
                    intent.putExtra("customerName",customer.getName());
                    intent.putExtra("customerEmail",customer.getEmail());
                    startActivity(intent);

                }
                else {
                    Toast.makeText(getApplicationContext(),"you already has account", Toast.LENGTH_SHORT).show();

                }
//
                 }
       });
    }


//    public void register_register(View view){
//         sqLiteDatabase=helper.getWritableDatabase();
//        Cursor c=sqLiteDatabase.query("customer",null,null,null,null,null,null);
//        String data = "";
//        while(c.moveToNext()){
//            @SuppressLint("Range") String id=c.getString(c.getColumnIndex("name"));
//            @SuppressLint("Range") String pass=c.getString(c.getColumnIndex("password"));
//            data+=id+" "+pass+"\n";
//        }
//        c.close();
//        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
//
//    }
    public void register_login(View view) {
        startActivity(new Intent(getApplicationContext(),login.class));


    }
}