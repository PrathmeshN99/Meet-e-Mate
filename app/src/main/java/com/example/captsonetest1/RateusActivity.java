package com.example.captsonetest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class RateusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rateus);
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(RateusActivity.this, DashboardActivity.class);
        startActivity(i);
    }
}