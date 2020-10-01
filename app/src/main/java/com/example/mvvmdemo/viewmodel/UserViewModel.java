package com.example.mvvmdemo.viewmodel;

import android.util.Log;

import com.example.mvvmdemo.api.ApiObserver;
import com.example.mvvmdemo.api.RetrofitManager;
import com.example.mvvmdemo.data.UserData;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

// 繼承為被觀察者
public class UserViewModel extends Observable {
    private List<UserData> _userList;

    public UserViewModel() {
        this._userList = new ArrayList<>();
    }

    public List<UserData> getUserList()
    {
        return this._userList;
    }

    public void loadUser(final int since)
    {
        RetrofitManager.instance().users(since, 20, new ApiObserver<List<UserData>>() {
            @Override
            public void onNext(List<UserData> result) {
                if (since == 0)
                    _userList.clear();

                _userList.addAll(result);

                /*
                if (_userList.size() > 0)
                {
                    Log.e("loadUser", ""+_userList.get(0).getLogin());
                }
                */

                // 通知所有觀察者
                setChanged();
                notifyObservers();
            }
        });
    }

    public int getLastUserId()
    {
        if(_userList == null || _userList.size() == 0)
            return 0;

        UserData userData = _userList.get(_userList.size() - 1);

        return userData.getId();
    }
}
