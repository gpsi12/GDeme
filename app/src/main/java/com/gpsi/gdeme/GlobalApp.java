package com.gpsi.gdeme;

import android.app.Application;

import com.gpsi.gdeme.utils.InitUtils;

import org.xutils.x;

/**
 * Created by Administrator on 2016-11-10.
 */
public class GlobalApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        InitUtils.init(this);
    }
}
