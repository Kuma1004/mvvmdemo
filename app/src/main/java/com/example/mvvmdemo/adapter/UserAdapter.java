package com.example.mvvmdemo.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmdemo.R;
import com.example.mvvmdemo.data.UserData;
import com.example.mvvmdemo.databinding.UserinfoBinding;
import com.example.mvvmdemo.viewmodel.UserInfoViewModel;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterViewHolder> {
    private List<UserData> userList;

    public UserAdapter() {
    }

    @NonNull
    @Override
    public UserAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 建立databinding
        UserinfoBinding userInfoBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.userinfo, parent, false);

        return new UserAdapterViewHolder(userInfoBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterViewHolder holder, int position) {
        holder.bindUser(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void setUserList(List<UserData> userList)
    {
        this.userList = userList;

        //通知RecyclerView更新
        notifyDataSetChanged();
    }

    public static class UserAdapterViewHolder extends RecyclerView.ViewHolder {

        UserinfoBinding _userInfoBinding;

        public UserAdapterViewHolder(UserinfoBinding userInfoBinding) {
            super(userInfoBinding.itemUser);
            this._userInfoBinding = userInfoBinding;
            this._userInfoBinding.siteAdmin.setVisibility(View.GONE);
        }

        void bindUser(UserData user){
            // Log.e("bindUser", ""+user.getLogin());

            if (_userInfoBinding.getUserInfoViewModel() == null)
            {
                // 連結 databinding 和 view model
                _userInfoBinding.setUserInfoViewModel(new UserInfoViewModel(itemView.getContext(), user));
            }
            else
            {
                // 透過view model設定資料, setUser裡面會通知databinding將所有已綁定的layout(xml)更新一次
                _userInfoBinding.getUserInfoViewModel().setUser(user);
            }
        }
    }
}
