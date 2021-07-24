package com.example.cost_database_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button SecondToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SecondToMain = findViewById(R.id.SecondToMainButton);
        SecondToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToMain();
            }
        });
    }

    //Method responsible for allowing the button to open the main activity.
    private void moveToMain()
    {
        Intent asdf = new Intent(SecondActivity.this,MainActivity.class);
        startActivity(asdf);
    }
}