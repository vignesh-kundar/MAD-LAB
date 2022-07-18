package com.example.signupandin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private Button signup;
    private EditText uname, pwd;
    static String Username, Password;
    private static final String password_pattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@$#%^&+=!])(?=\\S+$).{8,}$";
    Pattern psPattern = Pattern.compile(password_pattern);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup = findViewById(R.id.submit);
        uname = findViewById(R.id.uname);
        pwd = findViewById(R.id.pwd);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Username = uname.getText().toString();
                Password = pwd.getText().toString();
                if (Username.equals("") || Password.equals("")) {
                    Toast.makeText(MainActivity.this, "Username or Password cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if (isValid()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Username", Username);
                    bundle.putString("Password", Password);

                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    intent.putExtras(bundle);

                    startActivity(intent);

                }
            }
        });
    }

    private boolean isValid() {
        if (!psPattern.matcher(Password).matches()) {
            Toast.makeText(MainActivity.this, "• Password should contain uppercase and lowercase letters.\n" +
                    "• Password should contain letters and numbers.\n" +
                    "• Password should contain special characters.\n" +
                    "• Minimum length of the password (the default value is 8).", Toast.LENGTH_LONG).show();
            return false;
        } else return true;

    }
}
