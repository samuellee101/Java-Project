package com.example.cost_database_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText eName;
    private EditText ePassword;
    private TextView eAttempts;
    private Button eLogin;
    private TextView TextViewRegister;

    //private String real_username = "Team1";
    //private String real_password = "best_team";

    boolean valid = false;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eName = findViewById(R.id.Username);
        ePassword = findViewById(R.id.Password);
        eAttempts = findViewById(R.id.attempts);
        eLogin = findViewById(R.id.login_button);
        TextViewRegister = findViewById(R.id.ViewRegister);

        TextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
            }
        });

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if (inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(LoginActivity.this,"Please enter both a username and a password.",Toast.LENGTH_SHORT).show();

                }
                else
                {
                        valid = validate(inputName,inputPassword);

                        if (!valid)
                        {
                            counter--;
                            Toast.makeText(LoginActivity.this, "Incorrect Username/Password!",Toast.LENGTH_SHORT).show();
                            eAttempts.setText("Attempts Remaining: " + counter);

                            if (counter == 0)
                            {
                                eLogin.setEnabled(false);
                            }
                        }

                        else
                        {
                            Toast.makeText(LoginActivity.this, "Success!",Toast.LENGTH_SHORT).show();
                            Intent tentent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(tentent);
                        }
                }

            }
        });
    }
    private boolean validate(String name, String password)
    {

        if (RegistrationActivity.credentials != null)
        {
            if (name.equals(RegistrationActivity.credentials.getUsername()) && password.equals(RegistrationActivity.credentials.getPassword()))
            {
                return true;
            }
        }

            return false;

    }
}