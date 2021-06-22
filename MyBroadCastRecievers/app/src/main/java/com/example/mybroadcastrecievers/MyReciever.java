package com.example.mybroadcastrecievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

public class MyReciever extends BroadcastReceiver {
    ImageView imageView;

    public MyReciever(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
            case Intent.ACTION_POWER_CONNECTED:
                imageView.setImageResource(R.drawable.power_on);

        }

        switch (intent.getAction()) {
            case Intent.ACTION_POWER_DISCONNECTED:
                imageView.setImageResource(R.drawable.power_off);

        }
        switch (intent.getAction()) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Toast.makeText(context, "Airplane Mode is changed...", Toast.LENGTH_SHORT).show();


        }


    }
}
