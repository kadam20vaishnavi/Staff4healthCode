package com.example.staff4health;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Register_pojo {

    @SerializedName("message")
    @Expose
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
