package com.example.staff4health;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiStafflist {

    @FormUrlEncoded
    @POST("registration")
    Call<Register_pojo> registrationData(
            @Field("FullName") String name,
            @Field("PhoneNumber") String phone,
            @Field("Email") String email,
            @Field("Profession") String profession_id
    );

    @FormUrlEncoded
    @POST("verifyOTP")
    Call<Register_pojo> verifyOtp(
            @Field("PhoneNumber") String phone,
            @Field("OTP") String otp
    );

    //for hospital same url as doctor verify and login
    @FormUrlEncoded
    @POST("login")
    Call<Login_pojo> login(
            @Field("PhoneNumber") String phone
    );

}
