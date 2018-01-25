package com.example.maazahmedsheriff.sensor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button maccel;
    Button mcompass;
    Button mproxi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maccel = (Button) findViewById(R.id.accel);
        mcompass = (Button) findViewById(R.id.compass);
        mproxi = (Button) findViewById(R.id.proximity);
    }
    public void openAccel(View view) {
        Intent i = new Intent(getApplicationContext(), AccelActivity.class);
        startActivity(i);
    }

    public void openCompass(View view) {
        Intent i = new Intent(getApplicationContext(), CompassActivity.class);
        startActivity(i);
    }
    public void openProxi(View view) {
        Intent i = new Intent(getApplicationContext(), ProxiActivity.class);
        startActivity(i);
    }
}
