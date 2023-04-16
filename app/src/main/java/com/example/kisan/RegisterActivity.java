package com.example.kisan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername,edEmail,edPassword,edConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextRegUsername);
        edEmail = findViewById(R.id.editTextRegEmail);
        edPassword = findViewById(R.id.editTextRegPassword);
        edConfirm = findViewById(R.id.editTextRegConfirmPassword);
        btn = findViewById(R.id.buttonRegister);
        tv = findViewById(R.id.textViewExistingUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                database db = new database(getApplicationContext(),"KISAN",null,1);
                if(username.length()==0 || email.length()==0 ||password.length()==0 || confirm.length()==0){
                    Toast.makeText(getApplicationContext(),"Please fill all Details",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.compareTo(confirm)==0) {
                        if(isValid(password)) {
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(),"Record Inserted",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Password must contain 8 character,having letter, digit and special characters",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"Password and Confirmed Password don't match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public static boolean isValid(String Passwordhere) {
        int f1=0,f2=0,f3=0;
        if (Passwordhere.length() < 8){
            return false;
        }else {
            for (int p = 0; p < Passwordhere.length(); p++) {
                if (Character.isLetter(Passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < Passwordhere.length(); r++) {
                if (Character.isDigit(Passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < Passwordhere.length(); s++) {
                char c = Passwordhere.charAt(s);
                if (c >= 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }
            if (f1 == 1 && f2 == 1 && f3 == 1) {
                return true;
            }
            return false;
        }
    }
}