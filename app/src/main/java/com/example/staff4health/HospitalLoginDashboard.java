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

public class HospitalLoginDashboard extends AppCompatActivity {

    CardView hospitaldetail,addrequitment,moreinfo;

    TextView hospitalname;

    AlertDialog.Builder builder;
    ImageView logout;

    String mobile,userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_login_dashboard);

        hospitaldetail = findViewById(R.id.hospitaldetail);
        addrequitment = findViewById(R.id.hospitalrecruitment);
        hospitalname = findViewById(R.id.hospitaltitlename);
        logout = findViewById(R.id.logout);

        Intent intent=getIntent();
        mobile=intent.getStringExtra("mobile");
        userid=intent.getStringExtra("userId");
        hospitalname.setText(intent.getStringExtra("name"));

        hospitaldetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HospitalLoginDashboard.this,HospitalDetailsActivity.class);
                intent.putExtra("mobile",mobile);
                startActivity(intent);
            }
        });

        addrequitment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HospitalLoginDashboard.this,AddRequitmentActivity.class);
                intent.putExtra("userId",userid);
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