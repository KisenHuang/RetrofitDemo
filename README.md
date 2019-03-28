# RetrofitDemo

项目简单使用Retrofit和Okhttp封装了网络请求工具类

### 使用方法

```
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

```

其中Services是自定义网络请求接口类，getList是Retrofit请求方法。通过CallFun接口的形式获取到Call请求，将返回结果通过HttpCallback返回给调用者。