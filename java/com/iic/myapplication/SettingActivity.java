package com.iic.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public void passwordChange(View view) {
        EditText usernameText1 = findViewById(R.id.userName1);
        EditText usernameText2 = findViewById(R.id.userName2);
        EditText oldPasswordText = findViewById(R.id.oldPassword);
        EditText newPasswordText1 = findViewById(R.id.newPassword1);
        EditText newPasswordText2 = findViewById(R.id.newPassword2);

        String username1 = usernameText1.getText().toString();
        String username2 = usernameText2.getText().toString();
        String oldPassword = oldPasswordText.getText().toString();
        String newPassword1 = newPasswordText1.getText().toString();
        String newPassword2 = newPasswordText2.getText().toString();

        SharedPreferences preferences = getSharedPreferences(PREF_KEYS.PREF_NAME, MODE_PRIVATE);
        String savedUsername = preferences.getString(PREF_KEYS.USERNAME, "");
        String savedPassword = preferences.getString(PREF_KEYS.PASSWORD, "");

        if(newPassword1.equals("") || username2.equals("")){
            Toast.makeText(this, "Please, fill all the field.", Toast.LENGTH_SHORT).show();
            return;

        }

        if (!username1.equals(savedUsername) || !oldPassword.equals(savedPassword)){
            Toast.makeText(this, "Username or Old password don't match!", Toast.LENGTH_LONG).show();
            return;

        }

        if(!newPassword1.equals(newPassword2)){
            Toast.makeText(this, "New password don't match!", Toast.LENGTH_LONG).show();
        }else{
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(PREF_KEYS.IS_FIRST_TIME, false);
            editor.putString(PREF_KEYS.USERNAME, username2);
            editor.putString(PREF_KEYS.PASSWORD, newPassword1);
            editor.apply();
            Toast.makeText(this, "Username & Password change sucessfully.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
