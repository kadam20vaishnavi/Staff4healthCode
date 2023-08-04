package com.example.staff4health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class UserLoginDashboard extends AppCompatActivity {

    CardView userdetails,useraddress,usereducation,alldetails;

    TextView doctorname;

    AlertDialog.Builder builder;
    ImageView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_dashboard);

        getSupportActionBar().setTitle("Dashboard");

        userdetails=findViewById(R.id.userdetail);
        useraddress=findViewById(R.id.useraddress);
        usereducation=findViewById(R.id.usereducation);
        alldetails=findViewById(R.id.alldetails);
        doctorname=findViewById(R.id.doctorname);
        logout=findViewById(R.id.logout);

        Intent intent=getIntent();
        doctorname.setText(intent.getStringExtra("name"));

        userdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(UserLoginDashboard.this,UserDetailsActivity.class);
                startActivity(intent);

            }
        });

        useraddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(UserLoginDashboard.this,UserAddressActivity.class);
                startActivity(intent);

            }
        });

        usereducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(UserLoginDashboard.this,UserEducationActivity.class);
                startActivity(intent);

            }
        });

        alldetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(UserLoginDashboard.this,UserDetailsActivity.class);
                startActivity(intent);

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

        builder.setMessage("Do you want Log Out ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();

                    }
                });
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("Exit");
        alert.show();
    }
}