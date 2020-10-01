package com.example.mvvmdemo.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableInt;

import com.example.mvvmdemo.UserDetailActivity;
import com.example.mvvmdemo.data.UserData;
import com.example.mvvmdemo.utils.CircleImageTransformation;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class UserInfoViewModel extends BaseObservable {
    private Context _context;
    private UserData _user;

    public ObservableInt siteAdmin;

    public UserInfoViewModel(Context context, UserData user){
        this._context = context;
        this._user = user;

        if (user.isSiteAdmin())
            this.siteAdmin = new ObservableInt(View.VISIBLE);
        else
            this.siteAdmin = new ObservableInt(View.GONE);
    }

    public void setUser(UserData user) {
        this._user = user;

        // 知databinding將所有已綁定的layout(xml)更新一次
        notifyChange();
    }

    public String getLogin()
    {
        return this._user.getLogin();
    }

    public String getAvatarUrl() { return this._user.getAvatarUrl(); }

    public void onItemClick(View v)
    {
        // Log.e("onItemClick", user.getLogin());

        Intent intent = new Intent(v.getContext(), UserDetailActivity.class);
        intent.putExtra("intent_user", (Serializable) this._user);

        _context.startActivity(intent);
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url)
    {
        Picasso.get().load(url).transform(new CircleImageTransformation()).into(imageView);
    }
}
