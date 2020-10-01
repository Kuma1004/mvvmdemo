package com.example.mvvmdemo.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import com.example.mvvmdemo.data.UserData;
import com.example.mvvmdemo.data.UserDetailData;

import java.util.List;

public interface GithubService {
    @GET("users")
    Observable<List<UserData>> users(@Query("since") int since, @Query("per_page") int perpage);

    @GET("users/{login}")
    Observable<UserDetailData> userDetail(@Path("login") String login);
}
