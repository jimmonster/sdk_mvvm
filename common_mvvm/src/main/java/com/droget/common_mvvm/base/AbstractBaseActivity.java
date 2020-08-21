package com.droget.common_mvvm.base;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.droget.common_mvvm.vm.CommonViewModel;
import com.gyf.immersionbar.ImmersionBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

/**
 * @author :  Jim
 * @date :  2020-07-21
 * @description :
 */


public abstract class AbstractBaseActivity extends AppCompatActivity {
    public String extraBundle = "ExtraBundleByActivity";
    public CommonViewModel mCommonViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        ScreenUtils.setFullScreen(this);//设置全屏
        if (ScreenUtils.isLandscape()) {
            ScreenUtils.setPortrait(this);//设置竖屏
        }
        ImmersionBar.with(this).init();//沉浸式状态栏

        mCommonViewModel = ViewModelProviders.of(this).get(CommonViewModel.class);

    }

    public void toast(Object s) {
        Toast.makeText(this, "" + s, Toast.LENGTH_SHORT).show();
    }

    public void log(Object str) {
        String clazz = this.getClass().getSimpleName();
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();
        LogUtils.e("jim:" + clazz + "******" + method, "\n                        " + str + "                    \n");

    }


    /**
     * 统一界面跳转,携带参数
     *
     * @param activity
     */
    public void startActivity(Class activity, Bundle bundle) {
        Intent intent = new Intent(this, activity);
        intent.putExtra(extraBundle, bundle);
//        startActivity(intent);
        ActivityUtils.startActivity(intent);

    }


    /**
     * 统一界面跳转
     *
     * @param activity
     */
    public void startActivity(Class activity) {
        Intent intent = new Intent(this, activity);

//        startActivity(intent);

        ActivityUtils.startActivity(intent);

    }
}
