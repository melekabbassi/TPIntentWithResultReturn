package com.example.tpintentwithresultreturn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextUserName;
    EditText editTextPassword;
    EditText editTextConfirmPassword;

    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        editTextConfirmPassword = (EditText) findViewById(R.id.EditTextConfirmPassword);

        buttonRegister = (Button) findViewById(R.id.ButtonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextUserName = (EditText) findViewById(R.id.EditTextUserName);
                editTextPassword = (EditText) findViewById(R.id.EditTextPassword);

                if (editTextPassword.getText().toString().equals(editTextConfirmPassword.getText().toString()) && !editTextUserName.getText().toString().isEmpty()) {
                    Intent intent = new Intent();
                    intent.putExtra("username", editTextUserName.getText().toString());
                    intent.putExtra("password", editTextPassword.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    // Alert Dialog to show error message
                    AlertDialog alertDialog = new AlertDialog.Builder(RegisterActivity.this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("Passwords do not match or username is empty");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            (dialog, which) -> dialog.dismiss());
                    alertDialog.show();
                    alertDialog.setCancelable(true);
                }
            }
        });
    }
}