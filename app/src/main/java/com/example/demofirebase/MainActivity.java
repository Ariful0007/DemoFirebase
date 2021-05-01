package com.example.demofirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText mobileno,message;
    Button sendsms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mobileno=(EditText)findViewById(R.id.editText1);
        message=(EditText)findViewById(R.id.editText2);
        sendsms=(Button)findViewById(R.id.button1);
        sendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number,message1;
                number=mobileno.getText().toString();
                message1=message.getText().toString().trim();
                if (TextUtils.isEmpty(number)||TextUtils.isEmpty(message1)) {
                    Toast.makeText(MainActivity.this, "Empty Field", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Intent in=new Intent(getApplicationContext(),MainActivity.class);
                    PendingIntent intent= PendingIntent.getActivity(getApplicationContext(),0,in,0);
                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(number,null,message1,intent,null);
                    Toast.makeText(MainActivity.this, "send SMS ", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}