package com.example.cost_database_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    private Button ThirdToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ThirdToMain = findViewById(R.id.ThirdToMainButton);
        ThirdToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToMain();
            }
        });
    }

    //Method responsible for allowing the button to open the main activity.
    private void moveToMain()
    {
        Intent asdfasdf = new Intent(ThirdActivity.this,MainActivity.class);
        startActivity(asdfasdf);
    }
}