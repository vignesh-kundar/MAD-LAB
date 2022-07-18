package com.example.signupandin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button btnLogin;
    private EditText password, username;
    private String strname, strpwd;
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.login);
        password = findViewById(R.id.loginpwd);
        username = findViewById(R.id.loginuname);

        Bundle bundle = getIntent().getExtras();
        strname = bundle.getString("Username");
        strpwd = bundle.getString("Password");

        Intent intent = new Intent(getApplicationContext(), LoginSuccess.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter<=2) {
                    if (username.getText().toString().equals(strname) && password.getText().toString().equals(strpwd)) {
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Login.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                        counter++;
                        username.setText(null);
                        password.setText(null);
                    }
                }
                else {
                    Toast.makeText(Login.this, "Maximum attempts reached", Toast.LENGTH_SHORT).show();
                    btnLogin.setEnabled(false);
                }
            }
        });
    }
}
