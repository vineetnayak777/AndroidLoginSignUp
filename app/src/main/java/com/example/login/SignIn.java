package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    EditText userid2,password2;
    Button sign_in;
    int Count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        userid2=findViewById(R.id.userid2);
        password2=findViewById(R.id.password2);
        sign_in = findViewById(R.id.signin);

        Bundle bundle = getIntent().getExtras();
        String uname = bundle.getString("userid");
        String pwd = bundle.getString("password");

        sign_in.setOnClickListener(v -> {
            String user = userid2.getText().toString();
            String password = password2.getText().toString();

            if(user.equals(uname) && password.equals(pwd)){
                Toast.makeText(SignIn.this, "SignIn Successful", Toast.LENGTH_SHORT).show();
            }
            else{
                Count++;
                if(Count >= 3){
                    sign_in.setEnabled(false);
                }
                else{
                    Toast.makeText(SignIn.this, "SignIn Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}