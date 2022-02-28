package com.example.captsonetest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MARLinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marlinks);
        ImageView join_theory = findViewById(R.id.mar_b1_theory_join);
        ImageView join_tut = findViewById(R.id.mar_b1_tut_join);
        ImageView join_lab = findViewById(R.id.mar_b1_lab_join);
        ImageView batch1 = findViewById(R.id.batch1_btn_marlinks);
        ImageView batch2 = findViewById(R.id.batch2_btn_marlinks);
        ImageView batch3 = findViewById(R.id.batch3_btn_marlinks);

        batch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MARLinksActivity.this, MARB2LinksActivity.class));
                Toast.makeText(MARLinksActivity.this, "B2 MAR",Toast.LENGTH_SHORT).show();
            }
        });
        batch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MARLinksActivity.this, MARB3LinksActivity.class));
                Toast.makeText(MARLinksActivity.this, "B3 MAR",Toast.LENGTH_SHORT).show();
            }
        });
        join_theory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://meet.google.com/ybv-hgou-tod?authuser=1");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        join_tut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://meet.google.com/eeb-avgf-pji");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        join_lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}