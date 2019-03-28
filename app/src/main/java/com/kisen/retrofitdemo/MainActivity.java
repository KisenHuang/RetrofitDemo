package com.kisen.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kisen.retrofithelper.CallFun;
import com.kisen.retrofithelper.HttpCallback;
import com.kisen.retrofithelper.HttpHelper;
import com.kisen.retrofithelper.RetrofitHelper;
import com.kisen.retrofithelper.Services;

import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpHelper.getRetrofit()
                .create(new CallFun<String>() {
                    @Override
                    public Call<String> fun(Retrofit retrofit) {
                        return retrofit.create(Services.class).getList(0, 10);
                    }
                }, new HttpCallback<String>() {
                    @Override
                    public void success(String result) {

                    }

                    @Override
                    public void fail(Throwable t) {

                    }
                });
    }
}
