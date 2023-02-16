package com.example.tpintentwithresultreturn;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int ACCOUNT_CREATION_ACTIVITY_ID = 10;
    EditText editTextUserName;
    EditText editTextPassword;

    Button buttonLogin;
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserName = (EditText) findViewById(R.id.EditTextUserName);
        editTextPassword = (EditText) findViewById(R.id.EditTextPassword);

        buttonLogin = (Button) findViewById(R.id.ButtonLogin);
        buttonRegister = (Button) findViewById(R.id.ButtonRegister);

        ((Button) findViewById(R.id.ButtonLogin)).setOnClickListener(this);
        ((Button) findViewById(R.id.ButtonRegister)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.ButtonLogin:
                //if the username and password are empty or not sent from the register activity then show an error message in a dialog
                if (editTextUserName.getText().toString().isEmpty() || editTextPassword.getText().toString().isEmpty()) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("Username or password is empty");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            (dialog, which) -> dialog.dismiss());
                    alertDialog.show();
                    alertDialog.setCancelable(true);
                } else {
                    intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("username", editTextUserName.getText().toString());
                    startActivity(intent);
                }
                break;
            case R.id.ButtonRegister:
                intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivityForResult(intent, ACCOUNT_CREATION_ACTIVITY_ID);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACCOUNT_CREATION_ACTIVITY_ID) {
            if (resultCode == RESULT_OK) {
                editTextUserName.setText(data.getStringExtra("username"));
                editTextPassword.setText(data.getStringExtra("password"));

                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }
}