package com.example.timer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  static int count = 1;
  Button start,stop;
  TextView counter;
  Handler customHandler=new Handler();
  @Override

  protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
 
  setContentView(R.layout.activity_main);
  start = findViewById(R.id.start);
  stop = findViewById(R.id.stop);
  counter = findViewById(R.id.textView);

 }

  private final Runnable updateTimerThread = new Runnable() {
  @Override

  public void run() {
    counter.setText(""+count);
    customHandler.postDelayed(updateTimerThread,1000);
    count++;
    }
   };
  
  public void onStrt(View view)
  {
    customHandler.postDelayed(updateTimerThread,0);
  }

  public void onStp(View view)
  { 
    customHandler.removeCallbacks(updateTimerThread);
    counter.setText(String.valueOf(count));
  }
}
