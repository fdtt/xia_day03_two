package com.example.xia_day03_two.Presenter;

import com.example.xia_day03_two.Mode.Imode;
import com.example.xia_day03_two.Mode.mode;
import com.example.xia_day03_two.User;
import com.example.xia_day03_two.View.Iview;

/**
 * Created by 只想暴富 on 2019/5/29.
 */

public class Presenter implements Ipresenter {
    Iview iview;
    Imode imode;

    public Presenter(Iview iview) {
        this.iview = iview;
        imode=new mode();
    }

    @Override
    public void fuli() {
        imode.fuli(new Callback() {
            @Override
            public void seeuccd(User user) {
                iview.seeucc(user);
            }
        });
    }
}
