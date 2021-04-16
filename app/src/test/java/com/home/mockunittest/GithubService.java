package com.home.mockunittest;


import org.robolectric.shadows.ShadowLog;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ClassName GithubService
 * @Description TODO
 * @Author Administrator
 * @Date 2021/4/14 11:56
 * @Version 1.0
 */
public class GithubService {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(GithubApi.BASE_URL)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    public static GithubApi createGithubService() {
        return retrofit.create(GithubApi.class);
    }

    private static OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        ShadowLog.stream.println("request:" + chain.request().url().toString());
                        return chain.proceed(chain.request());
                    }
                })
                .build();
    }
}

