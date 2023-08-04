package com.example.staff4health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddRequitmentActivity extends AppCompatActivity {

    Button addjob;
    RecyclerView joblist;

    String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_requitment);

        addjob=findViewById(R.id.addjob);
        joblist=findViewById(R.id.joblist);

        Intent intent=getIntent();
        userid=intent.getStringExtra("userId");

        System.out.println("Responseid:"+userid);

        ApiHosplist Ar = Api.getClient().create(ApiHosplist.class);
        Call<JobList_pojo> call = Ar.getJobRequirment("50");

        call.enqueue(new Callback<JobList_pojo>() {
            @Override
            public void onResponse(Call<JobList_pojo> call, Response<JobList_pojo> response) {

                if (response.body()!=null){

                    System.out.println(response.body()+"Response");

                }else {

                    System.out.println("Null Response");
                }
            }

            @Override
            public void onFailure(Call<JobList_pojo> call, Throwable t) {
                System.out.println("error Response");
            }
        });

    }
}