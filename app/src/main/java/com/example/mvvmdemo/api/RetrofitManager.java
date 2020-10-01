package com.example.mvvmdemo.api;

import com.example.mvvmdemo.data.UserData;
import com.example.mvvmdemo.data.UserDetailData;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RetrofitManager {
    private static RetrofitManager _instance;

    public static RetrofitManager instance() {
        if(_instance == null) {
            _instance = new RetrofitManager();
        }
        return _instance;
    }

    private Retrofit _retrofit;
    private GithubService _githubService;

    public RetrofitManager()
    {
        OkHttpClient _okHttpClient = getNewHttpClient();

        _retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(_okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        _githubService = _retrofit.create(GithubService.class);
    }

    public void users(int since, int perpage, ApiObserver<List<UserData>> callback)
    {
        _githubService.users(since, perpage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    public void userDetail(String login, ApiObserver<UserDetailData> callback)
    {
        _githubService.userDetail(login)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    private OkHttpClient getNewHttpClient() {
        return new OkHttpClient.Builder()
                .followRedirects(true)
                .followSslRedirects(true)
                .retryOnConnectionFailure(true)
                .cache(null)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }
}
