package com.example.demofirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Message_2 extends AppCompatActivity {

    EditText mobileno,message;
    Button sendsms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_2);
        mobileno=(EditText)findViewById(R.id.editText1);
        message=(EditText)findViewById(R.id.editText2);
        sendsms=(Button)findViewById(R.id.button1);
        sendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPermission();
            }
        });

    }

    private void getPermission()
    {
        int permission= ContextCompat.checkSelfPermission(Message_2.this, Manifest.permission.SEND_SMS);
        if (permission== PackageManager.PERMISSION_GRANTED) {
            sending();
        }
        else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},0);
        }
    }

    private void sending() {
        ///+66
        String phone_number1233=mobileno.getText().toString().trim();
        String sm333s=message.getText().toString().trim();
        SmsManager smsManager=SmsManager.getDefault();
        smsManager.sendTextMessage(phone_number1233,null,sm333s,null,null);
        Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case 0:
                if (grantResults.length>=0 && grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                    sending();;
                }
                else {
                    Toast.makeText(this, "Don't  Have permission", Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }
}