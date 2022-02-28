package com.example.captsonetest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class CWPB3LinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cwpb3_links);
        ImageView join_theory = findViewById(R.id.cwp_b3_theory_joinB3);
        ImageView join_tut = findViewById(R.id.cwp_b3_tut_joinB3);
        ImageView join_lab = findViewById(R.id.cwp_b3_lab_joinB3);
        ImageView batch1 = findViewById(R.id.batch1_btn_cwplinksB3);
        ImageView batch2 = findViewById(R.id.batch2_btn_cwplinksB3);
        ImageView batch3 = findViewById(R.id.batch3_btn_cwplinksB3);

        batch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( CWPB3LinksActivity.this, CWPlinksActivity.class));
                Toast.makeText(CWPB3LinksActivity.this, "B1 MAR",Toast.LENGTH_SHORT).show();
            }
        });
        batch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( CWPB3LinksActivity.this, CWPB2LinksActivity.class));
                Toast.makeText(CWPB3LinksActivity.this, "B2 MAR",Toast.LENGTH_SHORT).show();
            }
        });
        join_theory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://meet.google.com/rhf-kahu-wka");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        join_tut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://meet.google.com/nrj-mqmu-suz");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        join_lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://meet.google.com/rhf-kahu-wka");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}