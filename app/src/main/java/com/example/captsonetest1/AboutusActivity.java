package com.example.captsonetest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class AboutusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(AboutusActivity.this, DashboardActivity.class);
        startActivity(i);
    }
}