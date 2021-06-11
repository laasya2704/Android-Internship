package com.example.exampleintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name,num,send,web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        num = findViewById(R.id.num);
        send= findViewById(R.id.mail);
        web = findViewById(R.id.web);
    }

    public void save(View view) {
        //Intent i = new Intent(presentactivity,nextactivity);
        // start activity(i);
        String s = name.getText().toString();
        Intent i = new Intent(this,SecondActivity.class);
        i.putExtra("key",s);
        startActivity(i);
    }

    public void dial(View view) {
        //Implicit intent
        String s = num.getText().toString().trim();
        //tel: -phone number/ https:// -website /geo: - location
        Uri u = Uri.parse("tel:" + s);
        Intent i = new Intent(Intent.ACTION_DIAL,u);
        startActivity(i);
    }

    public void send(View view) {
        //Implicit intent
        String s = send.getText().toString().trim();
        //tel: -phone number/ https:// -website /geo: - location
        Uri u = Uri.parse("mailto:" + s);
        Intent i = new Intent(Intent.ACTION_SENDTO,u);
        startActivity(i);
    }

    public void search(View view) {
        //Implicit intent
        String s = web.getText().toString().trim();
        //tel: -phone number/ https:// -website /geo: - location
        Uri u = Uri.parse("https:" + s);
        Intent i = new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }
}