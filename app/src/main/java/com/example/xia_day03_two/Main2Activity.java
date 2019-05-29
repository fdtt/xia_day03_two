package com.example.xia_day03_two;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ViewPager mVp;
    private List<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        EventBus.getDefault().register(this);
    }
    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public  void initmore(Myeven myeven){
        list = myeven.list;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        myadater_vp myadater_vp = new myadater_vp(list);
        mVp.setAdapter(myadater_vp);
    }
    class  myadater_vp extends PagerAdapter{
        private List<User>list;

        public myadater_vp(List<User> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view==o;
        }



        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            User user = list.get(position);
            View inflate = LayoutInflater.from(Main2Activity.this).inflate(R.layout.item_vp, null);
           ImageView iv= inflate.findViewById(R.id.iv_vp);
            Glide.with(Main2Activity.this).load(user.getUrl()).into(iv);
            container.addView(inflate);
            return inflate;
        }
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
