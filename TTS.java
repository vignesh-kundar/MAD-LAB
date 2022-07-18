package com.example.tts;

import androidx.appcompat.app.AppCompatActivity;
import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import java.util.Locale;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed;
    Button btn;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = findViewById(R.id.text);
        btn = findViewById(R.id.btn);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.ERROR)
                {
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech.speak(ed.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}
