package com.example.mvvmdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.example.mvvmdemo.adapter.UserAdapter;
import com.example.mvvmdemo.viewmodel.UserViewModel;
import com.example.mvvmdemo.databinding.ActivityMainBinding;

import java.util.Observable;
import java.util.Observer;

// 實作觀察者
public class MainActivity extends AppCompatActivity implements Observer {

    private ActivityMainBinding activityMainBinding;
    private UserViewModel userViewModel;

    private LinearLayoutManager layoutManager;

    final int HIDE_THRESHOLD = 20;

    int firstVisibleItems = 0;
    int visibleItemCount = 0;
    int totalItemCount = 0;

    boolean isScrolling = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 建立databinding
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // 建立view model
        userViewModel = new UserViewModel();

        // 連結 databinding 和 view model
        activityMainBinding.setUserViewModel(userViewModel);

        layoutManager = new LinearLayoutManager(this);

        // 建立 RecyclerView 的 adapter
        UserAdapter userAdapter = new UserAdapter();

        // 餵資料給adapter並通知RecyclerView更新
        userAdapter.setUserList(userViewModel.getUserList());

        // 連結 databinding 和 adapter
        activityMainBinding.listUser.setAdapter(userAdapter);

        // 設定 RecyclerView 的 layout
        activityMainBinding.listUser.setLayoutManager(layoutManager);

        // 設定 SwipeRefreshLayout 監聽事件
        activityMainBinding.listUserSwipeRefresh.setOnRefreshListener(onSwipeToRefresh);

        // 設定 RecyclerView 的 scroll 監聽事件
        activityMainBinding.listUser.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int scrolledDistance = 0;
            private boolean isVisible = true;

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (scrolledDistance > HIDE_THRESHOLD && isVisible)
                {
                    isVisible = false;
                    scrolledDistance = 0;
                }
                else if (scrolledDistance < -HIDE_THRESHOLD && !isVisible)
                {
                    isVisible = true;
                    scrolledDistance = 0;
                }

                if((isVisible && dy > 0) || (!isVisible && dy < 0))
                {
                    scrolledDistance += dy;
                }

                if(dy > 0)
                {
                    // 目前可見的項目數
                    visibleItemCount = layoutManager.getChildCount();

                    // 目前所有的項目數
                    totalItemCount = layoutManager.getItemCount();

                    // 第一個可見的項目位置
                    firstVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    // 已下拉到超過所有項目底端了
                    if ((firstVisibleItems + visibleItemCount) >= totalItemCount)
                    {
                        // 避免重複進入
                        if (isScrolling == false)
                        {
                            isScrolling = true;

                            // 透過view model去取得資料
                            userViewModel.loadUser(userViewModel.getLastUserId());
                        }
                    }
                }
            }
        });

        // 被觀察者.addObserver(觀察者)
        userViewModel.addObserver(this);

        // 透過view model去取得資料
        userViewModel.loadUser(0);
    }

    private SwipeRefreshLayout.OnRefreshListener onSwipeToRefresh = new SwipeRefreshLayout.OnRefreshListener() {

        @Override
        public void onRefresh() {
            activityMainBinding.listUserSwipeRefresh.setRefreshing(true);

            userViewModel.loadUser(0);
        }
    };

    // 被觀察者通知我更新時會進來這裡
    @Override
    public void update(Observable o, Object arg) {
        // 判斷是哪個被觀察者
        if (o instanceof UserViewModel)
        {
            // 透過 databinding 取得 RecyclerView 的 adapter
            UserAdapter userAdapter = (UserAdapter)activityMainBinding.listUser.getAdapter();

            // adapter通知RecyclerView更新
            userAdapter.notifyDataSetChanged();

            activityMainBinding.listUserSwipeRefresh.setRefreshing(false);

            this.isScrolling = false;
        }
    }
}
