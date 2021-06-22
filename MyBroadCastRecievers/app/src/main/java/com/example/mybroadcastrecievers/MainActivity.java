package com.example.mybroadcastrecievers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.iv);
        IntentFilter myIntentFilter = new IntentFilter();
        myIntentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        myIntentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        myIntentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        MyReciever reciever = new MyReciever(img);
        this.registerReceiver(reciever,myIntentFilter);
    }
}