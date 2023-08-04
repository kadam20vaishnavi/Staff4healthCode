package com.example.staff4health;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UserDetailsActivity extends AppCompatActivity {

    TextView username,useremail,userphone, useraddress,userdob,userbloodgroup,usergender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        getSupportActionBar().setTitle("Personal Information");
        init();

    }

    public void init(){

        username = findViewById(R.id.username);
        useremail = findViewById(R.id.useremail);
        userphone = findViewById(R.id.phone);
        useraddress = findViewById(R.id.useraddress);
        userdob = findViewById(R.id.dob);
        userbloodgroup = findViewById(R.id.bloodgroup);
        usergender = findViewById(R.id.gender);

    }
}