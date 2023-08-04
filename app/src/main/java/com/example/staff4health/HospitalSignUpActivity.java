package com.example.staff4health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HospitalSignUpActivity extends AppCompatActivity {

    TextView login;

    TextInputEditText mobilenumber,hospitalname,hospitalemail,hospitalmobile,hospitaladdress,hospitalpin,hospitalurl;

    MaterialButton submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_here);

        login=findViewById(R.id.loginhospitalbutton);
        hospitalname=findViewById(R.id.hospitalname);
        hospitalemail=findViewById(R.id.hospitalemail);
        hospitalmobile=findViewById(R.id.hospitalmobile);
        hospitaladdress=findViewById(R.id.hospitaladdress);
        hospitalpin=findViewById(R.id.hospitalpincode);
        hospitalurl=findViewById(R.id.hospitalurl);
        submit=findViewById(R.id.submithospitalbutton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(HospitalSignUpActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (hospitalname.getText().toString().isEmpty()) {
                    hospitalname.setError("Field must be filled");
                } else if (hospitalmobile.getText().toString().isEmpty()) {
                    hospitalmobile.setError("Field must be filled");
                } else if (hospitalemail.getText().toString().isEmpty()) {
                    hospitalemail.setError("Field must be filled");
                } else {

                    System.out.println("url" + hospitalurl.getText().toString());
                    ApiHosplist ar = Api.getClient().create(ApiHosplist.class);

                    Call<Register_pojo> call = ar.registerhospital(hospitalname.getText().toString(), hospitalmobile.getText().toString(), hospitalemail.getText().toString(), hospitalurl.getText().toString(), hospitalpin.getText().toString());
                    call.enqueue(new Callback<Register_pojo>() {
                        @Override
                        public void onResponse(Call<Register_pojo> call, Response<Register_pojo> response) {

                            if (response.body() != null) {

                                Register_pojo register_pojo = response.body();
                                System.out.println("check response:-" + register_pojo.getMessage());
                                Intent intent = new Intent(HospitalSignUpActivity.this, VerifyOtpFormActivity.class);
                                intent.putExtra("mobile", hospitalmobile.getText().toString());
                                startActivity(intent);

                            } else {
                                System.out.println("Null response:-" + response.body().getMessage());
                            }
                        }

                        @Override
                        public void onFailure(Call<Register_pojo> call, Throwable t) {

                            Toast.makeText(HospitalSignUpActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            System.out.println("Error response:-" + t.getMessage());
                        }
                    });
                }
            }
        });
    }
}