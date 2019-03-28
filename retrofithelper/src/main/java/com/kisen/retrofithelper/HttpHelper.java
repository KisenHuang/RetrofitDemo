package com.kisen.retrofithelper;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求工具类
 */
public class HttpHelper {

    private static final String BASE_URL = "http://c.m.163.com/nc/article/";

    public static RetrofitHelper getRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        return RetrofitHelper.get(retrofit);
    }



}
