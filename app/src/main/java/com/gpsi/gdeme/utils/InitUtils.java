package com.gpsi.gdeme.utils;

import android.app.Application;
import android.content.Context;

import com.gpsi.gdeme.GlobalApp;

import org.greenrobot.eventbus.EventBus;
import org.xutils.x;

/**
 * 初始化库
 * Created by Administrator on 2016-11-10.
 */
public class InitUtils {

    public static void init(Application context){

        x.Ext.init(context);

    }

}
