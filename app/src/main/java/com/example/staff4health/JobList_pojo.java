package com.example.staff4health;

import java.util.ArrayList;
import java.util.List;

public class JobList_pojo {

    public ArrayList<JobData_pojo> data;
    public String message;

    public ArrayList<JobData_pojo> getData() {
        return data;
    }

    public void setData(ArrayList<JobData_pojo> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
