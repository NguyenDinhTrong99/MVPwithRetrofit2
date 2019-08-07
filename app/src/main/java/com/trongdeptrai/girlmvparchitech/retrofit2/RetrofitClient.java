package com.trongdeptrai.girlmvparchitech.retrofit2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.trongdeptrai.girlmvparchitech.utils.Constrants;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit getClient(String baseUrl) {
        Gson gson = new GsonBuilder().setLenient().create();
        OkHttpClient client =
                new OkHttpClient.Builder().readTimeout(Constrants.TIME_OUT, TimeUnit.MILLISECONDS)
                        .writeTimeout(Constrants.TIME_OUT, TimeUnit.MILLISECONDS)
                        .connectTimeout(Constrants.TIME_OUT, TimeUnit.MILLISECONDS)
                        .retryOnConnectionFailure(true)
                        .build();
        return new Retrofit.Builder().baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
