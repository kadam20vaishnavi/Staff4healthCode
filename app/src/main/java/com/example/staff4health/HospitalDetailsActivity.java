package com.example.staff4health;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HospitalDetailsActivity extends AppCompatActivity {

    TextView editdetails,hospitalname,hospitalmobile,hospitalemail,hospitaladdress,hospitalurl,hospitalpin,cancle;
    EditText hname,hemail,haddress,hurl,hpin;
    LinearLayout detailslayout,editlayout;

    ProgressDialog pd;
    String mobile;

    MaterialButton submit;

    HospitalResponce_pojo hospitalResponce_pojo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_details);

        editdetails = findViewById(R.id.edithospidetail);
        detailslayout = findViewById(R.id.detailslayout);
        editlayout = findViewById(R.id.editdetailslayout);

        hospitaladdress = findViewById(R.id.hospitaldaddress);
        hospitalname = findViewById(R.id.hospitaldname);
        hospitalemail = findViewById(R.id.hospitaldemail);
        hospitalurl = findViewById(R.id.hospitaldurl);
        hospitalmobile = findViewById(R.id.hospitalmobile);
        hospitalpin = findViewById(R.id.hospitalpin);
        cancle = findViewById(R.id.cancel);
        submit = findViewById(R.id.save);

        hname = findViewById(R.id.edithospitaldname);
        hemail = findViewById(R.id.edithospitaldemail);
        haddress = findViewById(R.id.edithospitaldaddress);
        hurl = findViewById(R.id.edithospitaldurl);
        hpin = findViewById(R.id.edithospitalpin);

        Intent intent=getIntent();
        mobile=intent.getStringExtra("mobile");

        showDetails();

        editdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailslayout.setVisibility(View.GONE);
                editdetails.setVisibility(View.GONE);

                cancle.setVisibility(View.VISIBLE);
                editlayout.setVisibility(View.VISIBLE);
            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailslayout.setVisibility(View.VISIBLE);
                editdetails.setVisibility(View.VISIBLE);

                cancle.setVisibility(View.GONE);
                editlayout.setVisibility(View.GONE);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiHosplist ar=Api.getClient().create(ApiHosplist.class);

                Call<HospitalResponce_pojo> call=ar.editHospitalDetail(hospitalResponce_pojo.getUserID(),hname.getText().toString(),mobile,hemail.getText().toString(),haddress.getText().toString(),hurl.getText().toString(),hpin.getText().toString());
                call.enqueue(new Callback<HospitalResponce_pojo>() {
                    @Override
                    public void onResponse(Call<HospitalResponce_pojo> call, Response<HospitalResponce_pojo> response) {

                        if(response.body()!=null) {
                            System.out.println("Null response:-" + response.body().getMessage());
                            if(response.body().getMessage().equals("success")) {
                                Toast.makeText(HospitalDetailsActivity.this, "UPDATE SUCCESSFULLY!!!!", Toast.LENGTH_SHORT).show();
                                showDetails();
                                detailslayout.setVisibility(View.VISIBLE);
                                editdetails.setVisibility(View.VISIBLE);

                                cancle.setVisibility(View.GONE);
                                editlayout.setVisibility(View.GONE);
                            }else{
                                Toast.makeText(HospitalDetailsActivity.this, "UPDATE SUCCESSFULLY!!!!", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            System.out.println("Null response:-" + response.body().getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<HospitalResponce_pojo> call, Throwable t) {

                        Toast.makeText(HospitalDetailsActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                        System.out.println("Error response:-"+t.getMessage());
                        pd.dismiss();
                    }
                });
            }
        });

    }
    public void showDetails(){
        pd = new ProgressDialog(HospitalDetailsActivity.this);
        pd.setTitle("Checking Your Data!");
        pd.setMessage("Please Wait..");
        pd.show();
        ApiHosplist ar=Api.getClient().create(ApiHosplist.class);

        Call<HospitalResponce_pojo> call=ar.getHospitalDetail(mobile);
        call.enqueue(new Callback<HospitalResponce_pojo>() {
            @Override
            public void onResponse(Call<HospitalResponce_pojo> call, Response<HospitalResponce_pojo> response) {

                if(response.body()!=null) {

                    hospitalResponce_pojo=response.body();
                    hospitaladdress.setText(hospitalResponce_pojo.getAddress());
                    hospitalmobile.setText(hospitalResponce_pojo.getPhoneNumber());
                    hospitalpin.setText(hospitalResponce_pojo.getPincode());
                    hospitalurl.setText(hospitalResponce_pojo.getUrl());
                    hospitalname.setText(hospitalResponce_pojo.getFirstName());
                    hospitalemail.setText(hospitalResponce_pojo.getEmail());

                    haddress.setText(hospitalResponce_pojo.getAddress());
                    hpin.setText(hospitalResponce_pojo.getPincode());
                    hurl.setText(hospitalResponce_pojo.getUrl());
                    hname.setText(hospitalResponce_pojo.getFirstName());
                    hemail.setText(hospitalResponce_pojo.getEmail());

                    System.out.println("check response:-" + hospitalResponce_pojo.getMessage());
                    pd.dismiss();

                }else{
                    System.out.println("Null response:-" + response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<HospitalResponce_pojo> call, Throwable t) {

                Toast.makeText(HospitalDetailsActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                System.out.println("Error response:-"+t.getMessage());
                pd.dismiss();
            }
        });
    }
}