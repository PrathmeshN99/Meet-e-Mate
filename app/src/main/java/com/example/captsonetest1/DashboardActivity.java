package com.example.captsonetest1;

import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Date;
import java.util.zip.Inflater;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private ImageView timetable;
    private ImageView links;
    private ImageView attendance;
    private ImageView study_material;
    private FirebaseAuth mAuth;
    private Menu menu;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createNotificationChannel();
        setContentView(R.layout.activity_dashboard);
        DrawerLayout drawerLayout;
        Menu menu;
        NavigationView navigation_View;
        Toolbar toolbar;
        ImageView right_menu;
        TextView textView;

        mAuth = FirebaseAuth.getInstance();
        ImageView rightmenu = findViewById(R.id.right_menu);
        registerForContextMenu(rightmenu);
        drawerLayout=findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle=new
                ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(DashboardActivity.this);
        navigationView.setCheckedItem(R.id.home);
        
        Date currentTime = Calendar.getInstance().getTime();
        Intent i = getIntent();
        ImageView timetable = (ImageView)findViewById(R.id.timetable);
        ImageView links = (ImageView)findViewById(R.id.links);
        ImageView Attendance = (ImageView)findViewById(R.id.attendance);
        ImageView study_material = (ImageView)findViewById(R.id.studymaterial);


        Calendar calender = Calendar.getInstance();
        calender.set(Calendar.HOUR_OF_DAY,16);
        calender.set(Calendar.MINUTE,45);
        calender.set(Calendar.SECOND,0);
        calender.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        /*calender.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);
        calender.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
        calender.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);*/

        Calendar calender2 = Calendar.getInstance();
        calender2.set(Calendar.HOUR_OF_DAY,22);
        calender2.set(Calendar.MINUTE,12);
        calender2.set(Calendar.SECOND,10);
        calender2.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        /*calender2.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);
        calender2.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
        calender2.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);*/


        Date calender_time = calender.getTime();
        Date calender2_time = calender2.getTime();

        Intent intent = new Intent(DashboardActivity.this, NotificationReceiver.class);
        if (calender_time.compareTo(currentTime)==0){
                intent.putExtra("Monday","1");
        }
        else if(calender2_time.compareTo(currentTime)==0){
            intent.putExtra("Monday","CWP Lecture in 5 minutes, join!");
        }
        PendingIntent pendingIntent = PendingIntent.getBroadcast(DashboardActivity.this, 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calender.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calender2.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);

        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Timetable(SEM-2,Div L)", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(DashboardActivity.this, TimetableActivity.class);
                startActivity(i);
            }
        });
        links.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Lecture links", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(DashboardActivity.this, LinksActivity.class);
                startActivity(i);
            }
        });
        Attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Attendance", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(DashboardActivity.this, AttendanceActivity.class);
                startActivity(i);
            }
        });
        study_material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Welcome to the treasure of study material!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(DashboardActivity.this, StudyMaterialActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.right_menu,menu);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser == null) {
            sendToStart();
        }
    }

    private void sendToStart() {
        startActivity(new Intent(DashboardActivity.this, MainActivity.class));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.about_us:
                Intent i = new Intent(this, AboutusActivity.class);
                startActivity(i);
                Toast.makeText(this, "About us", Toast.LENGTH_SHORT).show();

                break;
            case R.id.rate_us:
                Intent i2 = new Intent( this, RateusActivity.class);
                startActivity(i2);
                Toast.makeText(this, "Rate us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.need_help:
                Intent i3 = new Intent(this, NeedhelpActivity.class);
                startActivity(i3);
                Toast.makeText(this, "Need help", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home:
                Intent i4 = new Intent(this, DashboardActivity.class);
                startActivity(i4);
                Toast.makeText(this, "Get Home", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    private void createNotificationChannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "My notif";
            String description = "Your notif";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Prathmesh",name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    public void toggleNavDrawer(View view) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }
}
