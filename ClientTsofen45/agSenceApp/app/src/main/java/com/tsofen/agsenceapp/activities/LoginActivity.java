package com.tsofen.agsenceapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.tsofen.agsenceapp.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        EditText editText = (EditText) findViewById(R.id.usernameTxt);
        String username = editText.getText().toString();

        if (username != null && username.equals("Admin")) {
            Intent intent = new Intent(this, AdminDashboardActivity.class);
            startActivity(intent);
        }
        else // Noy - added 'else' here so it will not load 2 screens when logging in as admin.
        {
            Intent intent = new Intent(this, AccountDashboardActivity.class);
            startActivity(intent);
        }
    }
}