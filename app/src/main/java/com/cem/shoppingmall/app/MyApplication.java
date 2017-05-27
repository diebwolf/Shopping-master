package com.cem.shoppingmall.app;

import android.app.Application;
import android.content.Context;

import org.xutils.x;

/**
 * Created by huangqigen on 2017/5/25.
 */

public class MyApplication extends Application{
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext=this;
        x.Ext.init(this);
    }

    //获取全局上下文
    public static Context getContext(){
        return mContext;
    }
}
