package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText inp1,inp2;
    Button add,sub,mul,div;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inp1 = findViewById(R.id.inp1);
        inp2 = findViewById(R.id.inp2);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        result = findViewById(R.id.result);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val1 = inp1.getText().toString();
                float value1 = Float.parseFloat(val1);
                String val2 = inp2.getText().toString();
                float value2 = Float.parseFloat(val2);
                float res = value1 + value2;
                result.setText(""+res);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val1 = inp1.getText().toString();
                float value1 = Float.parseFloat(val1);
                String val2 = inp2.getText().toString();
                float value2 = Float.parseFloat(val2);
                float res = value1 - value2;
                result.setText(""+res);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val1 = inp1.getText().toString();
                float value1 = Float.parseFloat(val1);
                String val2 = inp2.getText().toString();
                float value2 = Float.parseFloat(val2);
                float res = value1 * value2;
                result.setText(""+res);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val1 = inp1.getText().toString();
                float value1 = Float.parseFloat(val1);
                String val2 = inp2.getText().toString();
                float value2 = Float.parseFloat(val2);
                if(value2 == 0)
                {
                    result.setText("Divide by zero ERROR!");
                    Toast.makeText(MainActivity.this, "Error!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    float res = value1 / value2;
                    result.setText(""+res);
                }
            }
        });
    }
}
