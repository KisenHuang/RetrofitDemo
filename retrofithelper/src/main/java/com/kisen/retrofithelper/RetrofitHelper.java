package com.kisen.retrofithelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * description:
 * author: Kisenhuang
 * email: Kisenhuang@163.com
 * time: 2019/3/27 下午9:00
 */
public class RetrofitHelper {

    private Retrofit mRetrofit;

    private RetrofitHelper(Retrofit retrofit) {
        mRetrofit = retrofit;
    }

    static RetrofitHelper get(Retrofit retrofit) {
        return new RetrofitHelper(retrofit);
    }

    public <T> void create(CallFun<T> callFun, final HttpCallback<T> callback) {
        if (callFun == null)
            throw new NullPointerException("CallFun 不能为空");
        Call<T> fun = callFun.fun(mRetrofit);
        fun.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (callback != null) {
                    if (response.isSuccessful()) {
                        callback.success(response.body());
                    } else {
                        callback.fail(null);
                    }
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                if (callback != null) {
                    callback.fail(t);
                }
            }
        });
    }

}
