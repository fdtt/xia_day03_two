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

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String url1 = intent.getStringExtra("url1");
        String url2 = intent.getStringExtra("url2");
        List<String>list=new ArrayList<>();
        list.add(url);
        list.add(url1);
        list.add(url2);
        myadater_vp myadater_vp = new myadater_vp(list);
        mVp.setAdapter(myadater_vp);
    }
    class  myadater_vp extends PagerAdapter{
        private List<String>list;

        public myadater_vp(List<String> list) {
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
            String s = list.get(position);
            View inflate = LayoutInflater.from(Main2Activity.this).inflate(R.layout.item_vp, null);
           ImageView iv= inflate.findViewById(R.id.iv_vp);
            Glide.with(Main2Activity.this).load(s).into(iv);
            container.addView(inflate);
            return inflate;
        }
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
