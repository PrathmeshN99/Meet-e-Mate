package com.example.captsonetest1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private ImageView getstarted;
    private ImageView alreadyregistered;
    private EditText name;
    private EditText email;
    private EditText PRN;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        ImageView get_started = (ImageView)findViewById(R.id.imageView);
        get_started.setOnClickListener(v -> {
            EditText name = (EditText) findViewById(R.id.student_name);
            EditText email = (EditText) findViewById(R.id.student_email);
            EditText PRN = (EditText) findViewById(R.id.student_PRN);
            String name_txt = name.getText().toString();
            String email_txt = email.getText().toString();
            String PRN_txt = PRN.getText().toString();
            if (email_txt.equals("") || PRN_txt.equals("")) {
                Toast.makeText(MainActivity.this, "Please fill both e-mail and password", Toast.LENGTH_SHORT).show();
            } else if (PRN_txt.length() != 8) {
                Toast.makeText(MainActivity.this, "Please enter a password with more than 6 letters", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Registration was successful", Toast.LENGTH_SHORT).show();

                registerUser(email_txt, PRN_txt);

                Intent i = new Intent(MainActivity.this, LoginActivity.class );
                startActivity(i);
                Toast.makeText(MainActivity.this, "Button clicked!", Toast.LENGTH_SHORT).show();
            }
    });
    ImageView alreadyregistered = (ImageView)findViewById(R.id.alreadyregistered_imageview);
    alreadyregistered.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Welcome back!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
        }
    });

    }
    private void registerUser(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, task -> {
            if (task.isSuccessful()) {
                Toast.makeText(MainActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
            }
        });

    }


}