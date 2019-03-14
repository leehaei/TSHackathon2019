package com.example.haeim.tshackathon2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        Button goButton =  (Button) findViewById(R.id.go_button);

        goButton.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view) {
                Intent homeIntent = new Intent(ScrollingActivity.this, BotActivity.class);
                startActivity(homeIntent);
            }
        });
    }
}
