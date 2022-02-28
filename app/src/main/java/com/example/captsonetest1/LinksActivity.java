package com.example.captsonetest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import android.view.View;
import android.widget.Toast;

public class LinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_links);
        ImageView mar_btn = findViewById(R.id.mar_btn);
        ImageView cwp_btn = findViewById(R.id.cwp_btn);
        ImageView ca_btn = findViewById(R.id.ca_btn);
        ImageView mad_btn = findViewById(R.id.mad_btn);
        ImageView he_btn = findViewById(R.id.he_btn);
        ImageView capstone_btn = findViewById(R.id.capstone_btn);
        mar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LinksActivity.this, MARLinksActivity.class));
                Toast.makeText(LinksActivity.this, "MAR", Toast.LENGTH_SHORT).show();
            }
        });

        cwp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LinksActivity.this, CWPlinksActivity.class));
                Toast.makeText(LinksActivity.this, "CWP", Toast.LENGTH_SHORT).show();
            }
        });
        ca_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LinksActivity.this, HECAlinksActivity.class));
                Toast.makeText(LinksActivity.this, "CA", Toast.LENGTH_SHORT).show();
            }
        });
        mad_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LinksActivity.this, MADCapstonelinksActivity.class));
                Toast.makeText(LinksActivity.this, "MAD", Toast.LENGTH_SHORT).show();
            }
        });
        he_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LinksActivity.this, HECAlinksActivity.class));
                Toast.makeText(LinksActivity.this, "HE", Toast.LENGTH_SHORT).show();
            }
        });
        capstone_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LinksActivity.this, MADCapstonelinksActivity.class));
                Toast.makeText(LinksActivity.this, "Capstone", Toast.LENGTH_SHORT).show();
            }
        });
    }


}