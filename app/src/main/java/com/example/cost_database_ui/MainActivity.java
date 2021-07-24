package com.example.cost_database_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button Btn2Move;
    private Button Btn3Move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn2Move = findViewById(R.id.button2);
        Btn2Move.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                moveToSecondActivity();
            }
        });

        Btn3Move = findViewById(R.id.button3);
        Btn3Move.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                moveToThirdActivity();
            }
        });
    }

    //Method responsible for allowing the button to open the second activity.
    private void moveToSecondActivity()
    {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    //Method responsible for allowing the button to open the third activity.
    private void moveToThirdActivity()
    {
        Intent INTENT = new Intent(MainActivity.this, ThirdActivity.class);
        startActivity(INTENT);
    }
}