package com.kisen.retrofithelper;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * description:
 * author: Kisenhuang
 * email: Kisenhuang@163.com
 * time: 2019/3/27 下午9:06
 */
public interface CallFun<T> {

    Call<T> fun(Retrofit retrofit);

}
