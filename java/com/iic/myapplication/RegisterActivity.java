package com.iic.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void launchNewActivity(View view) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void lunchLogin(View view) {
        EditText usernameText = findViewById(R.id.userName);
        EditText passwordText = findViewById(R.id.password1);
        EditText passwordText2 = findViewById(R.id.password2);
        EditText emailText = findViewById(R.id.email);
        EditText phoneNum = findViewById(R.id.phone);

        String username = usernameText.getText().toString();
        String password1 = passwordText.getText().toString();
        String password2 = passwordText2.getText().toString();
        String email = emailText.getText().toString();
        String phone = phoneNum.getText().toString();

        if (!password1.equals(password2)){
            Toast.makeText(this, "Password don't match.", Toast.LENGTH_LONG).show();
            return;
        }
        if (username.trim().equals(" ") || phone.length() != 10 || email.equals(" ") || password1.equals(" ")){
            Toast.makeText(this, "Please, fill all the field properly.", Toast.LENGTH_LONG).show();
            return;
        }

        SharedPreferences preferences = getSharedPreferences(PREF_KEYS.PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(PREF_KEYS.IS_FIRST_TIME, false);
        editor.putString(PREF_KEYS.USERNAME, username);
        editor.putString(PREF_KEYS.PASSWORD, password1);
        editor.apply();

        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}