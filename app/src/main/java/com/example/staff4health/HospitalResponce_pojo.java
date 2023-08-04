package com.example.staff4health;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HospitalResponce_pojo {

    @SerializedName("FirstName")
    @Expose
    private String firstName;

    @SerializedName("PhoneNumber")
    @Expose
    private String phoneNumber;

    @SerializedName("Email")
    @Expose
    private String email;

    @SerializedName("Type")
    @Expose
    private String type;

    @SerializedName("UserID")
    @Expose
    private String userID;

    @SerializedName("Address")
    @Expose
    private String address;

    @SerializedName("Pincode")
    @Expose
    private String pincode;

    @SerializedName("URL")
    @Expose
    private String url;

    @SerializedName("active")
    @Expose
    private Boolean active;

    @SerializedName("status")
    @Expose
    private Integer status;

    @SerializedName("message")
    @Expose
    private String message;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
