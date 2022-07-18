package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button start;
    Button stop;
    Button reset;
    TextView counter;
    static int count = 1;
    Handler clickHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        counter = findViewById(R.id.count);
        reset = findViewById(R.id.reset);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "counter started", Toast.LENGTH_SHORT).show();
                clickHandler.postDelayed(updateTimerThread,0);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickHandler.removeCallbacks(updateTimerThread);
                Toast.makeText(MainActivity.this, "counter stopped, count = "+count, Toast.LENGTH_SHORT).show();
//                count = 0;
                counter.setText(""+count);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "counter reset", Toast.LENGTH_SHORT).show();
                count = 0;
                counter.setText(""+count);
            }
        });
    }
    private  final Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            counter.setText(""+count);
            clickHandler.postDelayed(this,1000);
            count++;
        }
    };
}
