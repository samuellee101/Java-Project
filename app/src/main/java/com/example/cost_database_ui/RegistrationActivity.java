package com.example.cost_database_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class RegistrationActivity extends AppCompatActivity {

    private Button Register;
    private EditText RegisterName;
    private EditText RegisterPass;
    public static Credentials credentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //Assigning our private variables to widgets.
        Register = findViewById(R.id.RegisterButton);
        RegisterName = findViewById(R.id.RegisterNameInput);
        RegisterPass = findViewById(R.id.RegisterPassInput);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String RegName = RegisterName.getText().toString();
                String RegPass = RegisterPass.getText().toString();

                //call Credentials because this is where credentials are stored/going to be stored
                if (validate(RegName,RegPass)==true)
                {
                    credentials = new Credentials(RegName,RegPass);
                    Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(RegistrationActivity.this, "Registered.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validate (String username, String password)
    {
        if (username.isEmpty() || password.isEmpty())
        {
            Toast.makeText(this, "Please enter something.",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}