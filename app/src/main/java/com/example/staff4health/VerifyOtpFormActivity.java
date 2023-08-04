package com.example.staff4health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerifyOtpFormActivity extends AppCompatActivity {

    TextInputEditText otp;
    TextView mobile;
    String reg_mob;
    MaterialButton verifybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp_form);

        otp = findViewById(R.id.otpverify);
        verifybutton = findViewById(R.id.verifybutton);
        mobile = findViewById(R.id.verifynumber);

        Intent intent=getIntent();
        reg_mob = intent.getStringExtra("mobile");

        mobile.setText(reg_mob);

        verifybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ApiStafflist ar=Api.getClient().create(ApiStafflist.class);
                Call<Register_pojo> call=ar.verifyOtp(reg_mob,otp.getText().toString());
                call.enqueue(new Callback<Register_pojo>() {
                    @Override
                    public void onResponse(Call<Register_pojo> call, Response<Register_pojo> response) {

                        if(response.body()!=null) {

                            Register_pojo register_pojo=response.body();
                            System.out.println("check response:-" + register_pojo.getMessage());

                            if(register_pojo.getMessage().equals("success")) {

                                Intent intent = new Intent(VerifyOtpFormActivity.this, LoginActivity.class);
                                intent.putExtra("mobile", mobile.getText().toString());
                                startActivity(intent);

                            }else{

                                Toast.makeText(VerifyOtpFormActivity.this, "Otp Failed To Verify", Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            System.out.println("Null response:-" + response.body().getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<Register_pojo> call, Throwable t) {

                        Toast.makeText(VerifyOtpFormActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                        System.out.println("Error response:-"+t.getMessage());

                    }
                });
            }
        });

    }
}