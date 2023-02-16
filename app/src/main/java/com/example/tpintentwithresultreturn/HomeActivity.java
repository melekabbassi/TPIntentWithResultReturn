package com.example.tpintentwithresultreturn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView textViewWelcome;
    TextView textViewUserName;

    Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textViewWelcome = (TextView) findViewById(R.id.TextViewWelcome);

        Intent intent = getIntent();
        String username = "";

        if (intent != null) {
            if (intent.hasExtra("username")) {
                username = intent.getStringExtra("username");
            }
            textViewUserName = (TextView) findViewById(R.id.TextViewUserName);
            textViewUserName.setText(username);
        }

        buttonLogout = (Button) findViewById(R.id.ButtonLogout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}