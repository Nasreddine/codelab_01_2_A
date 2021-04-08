package com.example.codelab_01_2_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button scroolBtn = findViewById(R.id.scroll_btn);
        Button coordiantorBtn = findViewById(R.id.coordinator_btn);
        Button constraintBtn = findViewById(R.id.constraint_btn);

        scroolBtn.setText(getResources().getString(R.string.app_name));

        scroolBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ScrollActivity.class);
                startActivity(i);
            }
        });
        coordiantorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CoordinatorActivity.class);
                startActivity(i);
            }
        });
        constraintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ConstraintActivity.class);
                startActivity(i);
            }
        });
    }
}