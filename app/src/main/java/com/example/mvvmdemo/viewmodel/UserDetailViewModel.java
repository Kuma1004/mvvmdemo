package com.example.mvvmdemo.viewmodel;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.example.mvvmdemo.api.ApiObserver;
import com.example.mvvmdemo.api.RetrofitManager;
import com.example.mvvmdemo.data.UserDetailData;

import java.util.Observable;

// 繼承為被觀察者
public class UserDetailViewModel extends Observable {
    private Activity activity;
    private UserDetailData userdata;

    public ObservableField<String> avatarUrl = new ObservableField<>();
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> bio = new ObservableField<>();
    public ObservableField<String> loginname = new ObservableField<>();
    public ObservableInt siteAdmin = new ObservableInt();
    public ObservableField<String> location = new ObservableField<>();
    public ObservableField<String> blog = new ObservableField<>();

    public UserDetailViewModel(Activity activity) {
        this.activity = activity;
    }

    public void loadUserDetail(String login) {
        // Log.e("loadUserDetail", login);

        RetrofitManager.instance().userDetail(login, new ApiObserver<UserDetailData>() {
            @Override
            public void onNext(UserDetailData userDetailData) {
                userdata = userDetailData;

                avatarUrl.set(userdata.getAvatarUrl());
                name.set(userdata.getName());
                bio.set(userdata.getBio());
                loginname.set(userdata.getLogin());

                if(userdata.isSiteAdmin())
                    siteAdmin.set(View.VISIBLE);
                else
                    siteAdmin.set(View.GONE);

                location.set(userdata.getLocation());
                blog.set(userdata.getBlog());

                // 通知所有觀察者
                setChanged();
                notifyObservers();
            }
        });
    }

    public void onBack(View view) {
        this.activity.finish();
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url)
    {
        imageView.setImageURI(Uri.parse(url));
    }
}
