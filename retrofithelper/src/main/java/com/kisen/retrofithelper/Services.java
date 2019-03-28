package com.kisen.retrofithelper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * description:
 * author: Kisenhuang
 * email: Kisenhuang@163.com
 * time: 2019/3/27 下午8:54
 */
public interface Services {

    @GET("headline/T1348647853363/{start}-{end}.html")
    Call<String> getList(@Path("start") int start, @Path("end") int end);

}
