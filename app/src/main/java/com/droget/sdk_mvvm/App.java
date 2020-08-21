package com.droget.sdk_mvvm;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author :  Jim
 * @date :  2020-06-08
 * @description :
 */
public class App extends Application {
    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        initaRoute();
        app = this;

    }

    private void initaRoute() {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }


    public static App getInstance() {
        return app;
    }
}
