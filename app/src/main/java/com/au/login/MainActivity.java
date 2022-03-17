package com.au.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText uname,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=findViewById(R.id.editTextTextPersonName);
        pass=findViewById(R.id.editTextTextPassword);
    }

    public void login(View view) {
        SharedPreferences sp=getSharedPreferences("demo",MODE_PRIVATE);
        if(uname.getText().toString().equals(sp.getString("name",null)) && pass.getText().toString().equals(sp.getString("password",null)))
        {
            Intent i=new Intent(this,message.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "Invalid Credentials.......", Toast.LENGTH_SHORT).show();
        }
    }
}