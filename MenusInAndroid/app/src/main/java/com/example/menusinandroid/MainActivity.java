package com.example.menusinandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int date,month,year,minutes,hours;
    TextView day,tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        day = findViewById(R.id.date);
        tv = findViewById(R.id.tv);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.alert:
                showAlert();
                break;
            case R.id.datepicker:
                showDate();
                break;
            case R.id.timepicker:
                showTime();
                break;
            case R.id.search:
                Toast.makeText(this, "Search Item Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDate() {
        Calendar c = Calendar.getInstance();
        date = c.get(Calendar.DATE);
        month = c.get(Calendar.MONTH);

        year = c.get(Calendar.YEAR);

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int i, int i1, int i2) {
                i1 = i1 + 1;
                String Date = i + "-" + i1 + "-"  + i2;
                //month in android studio starts from 0
                day.setText("" + Date);

            }
        },year,month,date);
        dialog.show();
    }

    private void showTime() {
        Calendar c = Calendar.getInstance();
        minutes = c.get(Calendar.MINUTE);
        hours = c.get(Calendar.HOUR_OF_DAY);

        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int i, int i1) {
                String time = i + ":" + i1;
                tv.setText("" + time);
            }
        },hours,minutes,false);
        dialog.show();
    }

    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert..!");
        builder.setMessage("Do you want to close the app..?");
        builder.setIcon(R.drawable.ic_baseline_warning_24);
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
}