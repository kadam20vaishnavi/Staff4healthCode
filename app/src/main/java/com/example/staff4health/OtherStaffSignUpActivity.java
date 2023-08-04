package com.example.staff4health;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.android.volley.AuthFailureError;
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
import com.skydoves.powerspinner.OnSpinnerItemSelectedListener;
import com.skydoves.powerspinner.PowerSpinnerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtherStaffSignUpActivity extends AppCompatActivity {
    TextView login,prof_warning;
    EditText username,email,mobile;
    Button submitinfo;

    int profession_status=0;
    String selecteddropdown;
    PowerSpinnerView profession;

    String otp;
//    private RequestQueue mRequestQueue;

    String server_url = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_staff_sign_up);

        getSupportActionBar().setTitle("Sign Up");

        login=findViewById(R.id.loginstaffbutton);
        username=findViewById(R.id.staffname);
        email=findViewById(R.id.staffemail);
        mobile=findViewById(R.id.staffmobile);
        submitinfo=findViewById(R.id.submitstaffbutton);
        profession=findViewById(R.id.spinnerView);
        prof_warning=findViewById(R.id.professionwarning);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(OtherStaffSignUpActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

        profession.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener<String>() {
            @Override public void onItemSelected(int oldIndex, @Nullable String oldItem, int newIndex, String newItem) {
                Log.e(newItem + " : selected!","");
                selecteddropdown = newItem.toString();
                if(selecteddropdown.equals("Doctor")){
                    profession_status=1;
                    prof_warning.setVisibility(View.GONE);
                } else if (selecteddropdown.equals("Nurse")) {
                    profession_status=2;
                    prof_warning.setVisibility(View.GONE);
                } else if (selecteddropdown.equals("Paramedical Staff")) {
                    profession_status=4;
                    prof_warning.setVisibility(View.GONE);
                } else if (selecteddropdown.equals("Other")) {
                    profession_status=3;
                    prof_warning.setVisibility(View.GONE);
                } else{
                    profession_status=0;
                    prof_warning.setVisibility(View.VISIBLE);
                    Log.e("profession:",""+profession_status);
                }
            }
        });

        submitinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().isEmpty()){
                    username.setError("must be filled");
                }else if(email.getText().toString().isEmpty()){
                    email.setError("must be filled");
                }else if(mobile.getText().toString().isEmpty()) {
                    mobile.setError("must be filled");
                }else {

                    int randomPin = (int) (Math.random() * 9000) + 1000;
                    otp = String.valueOf(randomPin);
                   // postUserData(username.getText().toString(), mobile.getText().toString(),email.getText().toString(), String.valueOf(profession_status));
//                    if(profession_status!=0){
//                    prof_warning.setVisibility(View.GONE);
//
//                }else{
//                    prof_warning.setVisibility(View.VISIBLE);
//                }

//                    String type = "register";
//                    Backgroundtask backgroundWorker = new Backgroundtask(OtherStaffSignUpActivity.this);
//                    backgroundWorker.execute(type,username.getText().toString(), mobile.getText().toString(),email.getText().toString(), String.valueOf(profession_status));

//                    StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {

//                    Intent intent = new Intent(OtherStaffSignUpActivity.this, VerifyOtpFormActivity.class);
//                    intent.putExtra("mobile",mobile.getText().toString());
//                    startActivity(intent);

                    ApiStafflist ar=Api.getClient().create(ApiStafflist.class);

                    Call<Register_pojo> call=ar.registrationData(username.getText().toString(), mobile.getText().toString(), email.getText().toString(), String.valueOf(profession_status));
                    call.enqueue(new Callback<Register_pojo>() {
                        @Override
                        public void onResponse(Call<Register_pojo> call, Response<Register_pojo> response) {

                            if(response.body()!=null) {

                                Register_pojo register_pojo=response.body();
                                System.out.println("check response:-" + register_pojo.getMessage());
                                Intent intent = new Intent(OtherStaffSignUpActivity.this, VerifyOtpFormActivity.class);
                                intent.putExtra("mobile",mobile.getText().toString());
                                startActivity(intent);

                            }else{
                                System.out.println("Null response:-" + response.body().getMessage());
                            }
                        }

                        @Override
                        public void onFailure(Call<Register_pojo> call, Throwable t) {

                            Toast.makeText(OtherStaffSignUpActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                            System.out.println("Error response:-"+t.getMessage());
                            Log.e("profession status:",""+profession_status);
                        }
                    });
                }
            }
        });
    }

//    void postUserData(String name,String email,String mobile,String status){
//        mRequestQueue = Volley.newRequestQueue(OtherStaffSignUpActivity.this);
//        String url = "http://192.168.0.101/staff4healt.com/v1/api/registration";
//        StringRequest stringRequest
//                = new StringRequest(
//                Request.Method.POST,
//                url,
//                new Response.Listener() {
//                    @Override
//                    public void onResponse(Object response) {
//                        Toast.makeText(OtherStaffSignUpActivity.this, "Response;"+response.toString(), Toast.LENGTH_SHORT).show();
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error)
//                    {
//                        Toast.makeText(OtherStaffSignUpActivity.this, "Error Response;", Toast.LENGTH_SHORT).show();
//
//                    }
//                }){
//        @Nullable
//        @Override
//        protected Map<String, String> getParams() throws AuthFailureError {
//            Map<String, String> params = new HashMap<String, String>();
//            // on below line we are passing our key
//            // and value pair to our parameters.
//            params.put("FullName", name);
//            params.put("PhoneNumber", mobile);
//            params.put("Email",email);
//            params.put("Profession",status);
//            return params;
//        }
//    };
//    // adding request to queue to post the data.
//        mRequestQueue.add(stringRequest);
//    }
}