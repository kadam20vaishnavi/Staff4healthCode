package com.example.staff4health;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private static String BASE_URL1 = "https://staff4health.com/v1/api/";
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL1)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
