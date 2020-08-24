package com.iic.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void launchWelcome(View view) {
        EditText usernameText = findViewById(R.id.fullName);
        EditText passwordText = findViewById(R.id.password);

        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        SharedPreferences preferences = getSharedPreferences(PREF_KEYS.PREF_NAME, MODE_PRIVATE);
        String savedusername = preferences.getString(PREF_KEYS.USERNAME, "");
        String savedPassword = preferences.getString(PREF_KEYS.PASSWORD, "");


//        if(username.trim().equals("") || password.equals("")){
//            Toast.makeText(this, "Please fill all the field.", Toast.LENGTH_LONG).show();
//            return;
//        }

        if(username.equals(savedusername) && password.equals(savedPassword)){
            startActivity(new Intent(LoginActivity.this, WelcomeActivity.class).putExtra("username", username));
        }else{
            Toast.makeText(this, "Username or Password don't match.", Toast.LENGTH_LONG).show();
        }


    }
}
