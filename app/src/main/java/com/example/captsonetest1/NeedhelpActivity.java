package com.example.captsonetest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class NeedhelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needhelp);
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(NeedhelpActivity.this, DashboardActivity.class);
        startActivity(i);
    }
}