package com.example.staff4health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText mobilelogin;
    MaterialButton materialButton;

    String reg_mob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Sign In");

        mobilelogin = findViewById(R.id.mobilenumberLogin);

        materialButton = findViewById(R.id.submitloginbutton);

        Intent intent=getIntent();
        reg_mob=intent.getStringExtra("mobile");

        mobilelogin.setText(reg_mob);

        materialButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (mobilelogin.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                    mobilelogin.setError("Field must be filled");
                } else if (isValideMobile(mobilelogin.getText().toString()) == false) {
                    mobilelogin.setError("Enter Valid Mobile");
                } else {

                    ApiStafflist ar=Api.getClient().create(ApiStafflist.class);

                    Call<Login_pojo> call=ar.login(mobilelogin.getText().toString());
                    call.enqueue(new Callback<Login_pojo>() {
                        @Override
                        public void onResponse(Call<Login_pojo> call, Response<Login_pojo> response) {

                            if(response.body()!=null) {

                                Login_pojo login_pojo=response.body();
                                System.out.println("check response:-" + login_pojo.getMessage());
                                if(login_pojo.getType().equals("MasterAdmin")){
                                    finish();
                                    Intent intent = new Intent(LoginActivity.this, UserLoginDashboard.class);
                                    intent.putExtra("mobile",mobilelogin.getText().toString());
                                    intent.putExtra("name",login_pojo.getName());
                                    startActivity(intent);
                                } else if(login_pojo.getType().equals("Admin")){
                                    finish();
                                    Intent intent = new Intent(LoginActivity.this, HospitalLoginDashboard.class);
                                    intent.putExtra("mobile",mobilelogin.getText().toString());
                                    intent.putExtra("userId",login_pojo.getUserid());
                                    intent.putExtra("name",login_pojo.getName());
                                    startActivity(intent);
                                } else{

                                }

                            }else{
                                System.out.println("Null response:-" + response.body().getMessage());
                            }
                        }

                        @Override
                        public void onFailure(Call<Login_pojo> call, Throwable t) {

                            Toast.makeText(LoginActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                            System.out.println("Error response:-"+t.getMessage());

                        }
                    });
                }
            }
        });
    }

    private boolean isValideMobile(String mobile) {

        //mobile number validation.....................................................................
        String validmobile = "^[7-9][0-9]{9}$";
        Matcher matcher1 = Pattern.compile(validmobile).matcher(mobile);

        if (matcher1.matches()) {
            return true;
        } else {
            return false;
        }
    }
}