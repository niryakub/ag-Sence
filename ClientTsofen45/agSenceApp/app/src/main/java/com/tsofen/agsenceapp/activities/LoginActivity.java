package com.tsofen.agsenceapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tsofen.agsenceapp.R;
import com.tsofen.agsenceapp.adaptersInterfaces.onUserLoginHandler;
import com.tsofen.agsenceapp.dataAdapters.UserDataAdapter;
import com.tsofen.agsenceapp.entities.User;

public class LoginActivity extends AppCompatActivity {
    public static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        EditText editText = (EditText) findViewById(R.id.usernameTxt);
        final String username = editText.getText().toString();
//
//        if (username != null && username.equals("Admin")) {
//            Intent intent = new Intent(this, AdminDashboardActivity.class);
//            AppBaseActivity.setUserType(username);
//            startActivity(intent);
//        }
//
//        else if(username != null && username.equals("Account")) // Noy - added 'else' here so it will not load 2 screens when logging in as admin.
//        {
//            Intent intent = new Intent(this, AccountDashboardActivity.class);
//            AppBaseActivity.setUserType(username);
//            startActivity(intent);
//        }else{
//            Toast.makeText(this,"Please enter a valid username",Toast.LENGTH_LONG).show();
//        }

        UserDataAdapter.userLogin(username, "", new onUserLoginHandler() {
            @Override
            public void onAdminLoginSuccess(User user) {
                Intent intent = new Intent(LoginActivity.this, AdminDashboardActivity.class);
                AppBaseActivity.setUserType(username);
                startActivity(intent);
            }

            @Override
            public void onAccountLoginSuccess(User user) {

            }

            @Override
            public void onUserLoginFailed() {

            }
        });

    }
}