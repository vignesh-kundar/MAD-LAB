package com.example.visitingcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView companylogo;
    TextView txt,txt1,txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        companylogo=findViewById(R.id.logo);
        txt=findViewById(R.id.details);
        txt1 = findViewById(R.id.view1);
        txt2 = findViewById(R.id.view2);
        companylogo.setImageResource(R.drawable.easy);
        txt.setText("Vignesh Kundar");
        txt1.setText("MERN stack web developer");
        txt2.setText("vigneshkundar125@gmail.com\n+919071077931");
    }
}
