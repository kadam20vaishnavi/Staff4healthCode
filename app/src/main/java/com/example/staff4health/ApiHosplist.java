package com.example.staff4health;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiHosplist {

    @FormUrlEncoded
    @POST("hospitalregistration")
    Call<Register_pojo> registerhospital(
            @Field("FullName") String name,
            @Field("PhoneNumber") String phone,
            @Field("Email") String email,
            @Field("url") String url,
            @Field("pin") String pin
    );

    @FormUrlEncoded
    @POST("verifyOTP")
    Call<Register_pojo> verifyhospitalOtp(
            @Field("PhoneNumber") String phone,
            @Field("OTP") String otp
    );

    //for hospital same url as doctor verify and login
    @FormUrlEncoded
    @POST("login")
    Call<Register_pojo> loginhospital(
            @Field("PhoneNumber") String phone
    );

    @FormUrlEncoded
    @POST("getHospital")
    Call<HospitalResponce_pojo> getHospitalDetail(
            @Field("PhoneNumber") String phone
    );

    @FormUrlEncoded
    @POST("editHospital")
    Call<HospitalResponce_pojo> editHospitalDetail(
            @Field("user_id") String id,
            @Field("first_name") String firstname,
            @Field("token") String token,
            @Field("email") String email,
            @Field("address") String address,
            @Field("url") String url,
            @Field("pincode") String pincode
    );

    @FormUrlEncoded
    @POST("getHospitalreq")
    Call<JobList_pojo> getJobRequirment(
            @Field("UserID") String id
    );
}
