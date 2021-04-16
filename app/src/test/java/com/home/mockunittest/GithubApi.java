package com.home.mockunittest;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @ClassName GithubApi
 * @Description TODO
 * @Author Administrator
 * @Date 2021/4/14 11:55
 * @Version 1.0
 */
public interface GithubApi {

    String BASE_URL = "https://api.github.com/";

    @GET("users/{username}")
    Observable<User> getUser(@Path("username") String username);
}

