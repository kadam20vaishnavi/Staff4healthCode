package com.example.staff4health;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AllJobs extends AppCompatActivity {

    TextView countlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_jobs);

        countlist=findViewById(R.id.totaljob);
    }
}