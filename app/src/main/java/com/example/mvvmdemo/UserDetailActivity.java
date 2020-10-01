package com.example.mvvmdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.mvvmdemo.data.UserData;
import com.example.mvvmdemo.databinding.ActivityUserDetailBinding;
import com.example.mvvmdemo.viewmodel.UserDetailViewModel;

import java.util.Observable;
import java.util.Observer;

// 實作觀察者
public class UserDetailActivity extends AppCompatActivity implements Observer {
    private ActivityUserDetailBinding activityUserDetailBinding;
    private UserDetailViewModel userDetailViewModel;

    private UserData userdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 建立databinding
        activityUserDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail);

        // 透過databinding取得layout上的元件並設定屬性
        activityUserDetailBinding.userDetailViewBody.setVisibility(View.GONE);

        // 建立view model
        userDetailViewModel = new UserDetailViewModel(this);

        // 連結 databinding 和 view model
        activityUserDetailBinding.setUserDetailViewModel(userDetailViewModel);

        // get extra data
        userdata = (UserData) getIntent().getSerializableExtra("intent_user");

        // 被觀察者.addObserver(觀察者)
        userDetailViewModel.addObserver(this);

        // 透過view model去取得資料
        userDetailViewModel.loadUserDetail(userdata.getLogin());
    }

    // 被觀察者通知我更新時會進來這裡
    @Override
    public void update(Observable o, Object arg) {
        // 判斷是哪個被觀察者
        if (o instanceof UserDetailViewModel)
        {
            // 透過databinding取得layout上的元件並設定屬性
            activityUserDetailBinding.userDetailViewBody.setVisibility(View.VISIBLE);
        }
    }
}
