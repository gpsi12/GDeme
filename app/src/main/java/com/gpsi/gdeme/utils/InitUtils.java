package com.gpsi.gdeme.utils;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.gpsi.gdeme.GlobalApp;
import com.gpsi.gdeme.api.ApiContants;

import org.greenrobot.eventbus.EventBus;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 初始化库
 * Created by Administrator on 2016-11-10.
 */
public class InitUtils {


    public static void init(Application context) {

        x.Ext.init(context);
        x.Ext.setDebug(true);
    }

}
