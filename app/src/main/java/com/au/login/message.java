package com.au.login;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

import java.security.Permission;

public class message extends AppCompatActivity {
    EditText no,msg;
    SmsManager sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        no=findViewById(R.id.edno);
        msg=findViewById(R.id.edmsg);
        sms=SmsManager.getDefault();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void send(View view) {
        if(checkSelfPermission(Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.SEND_SMS},0);
        }
        sms.sendTextMessage(no.getText().toString(),null,msg.getText().toString(),null,null);
    }

    public void logout(View view) {
        Intent i= new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void call(View view) {
        Intent i= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+no.getText().toString()));
        startActivity(i);
    }
}