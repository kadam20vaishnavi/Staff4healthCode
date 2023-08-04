package com.example.staff4health;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponce {

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

    @SerializedName("userid")
    @Expose
    String userid;

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
}
