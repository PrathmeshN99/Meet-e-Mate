package com.example.captsonetest1;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RepeatingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeating);
        Intent i = getIntent();
        TextView text = (TextView) findViewById(R.id.textView);
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }
}