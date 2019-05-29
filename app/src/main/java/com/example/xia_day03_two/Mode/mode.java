package com.example.xia_day03_two.Mode;

import com.example.xia_day03_two.Presenter.Callback;
import com.example.xia_day03_two.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 只想暴富 on 2019/5/29.
 */

public class mode implements  Imode {
    @Override
    public void fuli(final Callback callback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder()
                .url("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1")
                .build();
        okHttpClient.newCall(build).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(string);
                    JSONArray results = jsonObject.getJSONArray("results");
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject jsonObject1 = results.getJSONObject(i);
                        String desc = jsonObject1.getString("desc");
                        String url = jsonObject1.getString("url");
                        User user = new User(desc,url);
                        callback.seeuccd(user);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
