package com.example.xia_day03_two;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.xia_day03_two.Presenter.Presenter;
import com.example.xia_day03_two.View.Iview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview {

    private XRecyclerView mXrv;
    private List<User> list;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mvp();
    }

    private void mvp() {
        Presenter presenter = new Presenter(this);
        presenter.fuli();
    }

    private void initView() {
        mXrv = (XRecyclerView) findViewById(R.id.xrv);
        mXrv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        mXrv.setAdapter(myAdapter);
        mXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mXrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                mXrv.loadMoreComplete();
            }
        });
        myAdapter.setOnClick(new MyAdapter.OnClick() {
            @Override
            public void OnClick(int psoition) {
                Myeven myeven = new Myeven();
                myeven.list=list;
                EventBus.getDefault().postSticky(myeven);

                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
    }

    @Override
    public void seeucc(final User user) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                list.add(user);
                myAdapter.notifyDataSetChanged();
            }
        });
    }
}
