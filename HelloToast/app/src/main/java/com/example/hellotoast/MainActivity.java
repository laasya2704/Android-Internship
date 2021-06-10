package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button toast,count,countdown;
    TextView tv;
    int i = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toast = findViewById(R.id.toast);
        count = findViewById(R.id.count);
        tv = findViewById(R.id.tv);
        countdown = findViewById(R.id.countdown);
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                tv.setText("" + i);
            }

        });

        countdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i > 0) {
                    i--;
                } else {
                    Toast.makeText(MainActivity.this, "Error: Value cannot be less than 0", Toast.LENGTH_SHORT).show();
                }
                tv.setText("" + i);
                // tv.setText(String.valueOf(i));
            }
        });

        toast.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Welcome to Android. Your count is "+i, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}