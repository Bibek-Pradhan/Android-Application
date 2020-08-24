package com.iic.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        String username = getIntent().getStringExtra("username");

        TextView textView = findViewById(R.id.welcomeName);
        textView.setText("Hello, " + username + "!");
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
       switch (id){
           case R.id.save:
               Toast.makeText(this, "Save is clicked!", Toast.LENGTH_LONG).show();
               break;

           case  R.id.setting:
//               Toast.makeText(this, "Setting is clicked!", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(WelcomeActivity.this, SettingActivity.class);
               startActivity(intent);
               break;

           case R.id.power:
               finishAffinity();
               break;

           case R.id.about:
               Toast.makeText(this, "This application is created by Mr.Bibek Pradhan.", Toast.LENGTH_LONG).show();
               break;
       }
        return super.onOptionsItemSelected(item);
    }
}
