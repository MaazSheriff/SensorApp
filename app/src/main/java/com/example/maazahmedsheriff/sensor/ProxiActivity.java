package com.example.maazahmedsheriff.sensor;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ProxiActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxi);

        sensorManager =
                (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor proximitySensor =
                sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (proximitySensor == null) {
            Toast.makeText(this, "No proximity sensor", Toast.LENGTH_SHORT)
                    .show();
            finish(); // Close app
        }
    }

        // Create listener

            public void onSensorChanged(SensorEvent sensorEvent) {
                // More code goes here
                if(sensorEvent.values[0] < sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY).getMaximumRange()) {
                    // Detected something nearby
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                } else {
                    // Nothing is nearby
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }


// Register it, specifying the polling interval in
// microseconds
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY), 2 * 1000 * 1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}

