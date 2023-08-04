package com.example.staff4health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {

    CardView hospital,otherstaff,viewjob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Staff For Health");

        hospital=findViewById(R.id.hospitalregister);
        otherstaff=findViewById(R.id.otherstaffregister);
        viewjob=findViewById(R.id.viewjob);
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,HospitalSignUpActivity.class);
                startActivity(intent);

            }
        });

        otherstaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,OtherStaffSignUpActivity.class);
                startActivity(intent);

            }
        });

        viewjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });
    }
}