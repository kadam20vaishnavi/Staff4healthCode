package com.example.staff4health;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Login_pojo {

    @SerializedName("FirstName")
    @Expose
    String name;

    @SerializedName("PhoneNumber")
    @Expose
    String phone;

    @SerializedName("Type")
    @Expose
    String type;

    @SerializedName("Profestion")
    @Expose
    String profession;

    @SerializedName("UserID")
    @Expose
    String userid;

    @SerializedName("active")
    @Expose
    String active;

    @SerializedName("status")
    @Expose
    String status;

    @SerializedName("message")
    String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
