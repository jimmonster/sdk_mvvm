package com.droget.sdk_mvvm.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.droget.common_mvvm.base.AbstractBaseActivity;
import com.droget.sdk_mvvm.R;

import androidx.annotation.Nullable;

/**
 * @author :  Jim
 * @date :  2020/8/21
 * @description :
 */
@Route(path = "/ui/MainActivity")
public class MainActivity extends AbstractBaseActivity implements View.OnClickListener {
    private Button mBtn0;
    private Button mBtn1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtn0 = (Button) findViewById(R.id.btn_0);
        mBtn0.setOnClickListener(this);
        mBtn1 = (Button) findViewById(R.id.btn_1);
        mBtn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_0:
                ARouter.getInstance().build("/ui/SecondActivityTest")
                        .navigation();
                break;
            case R.id.btn_1:
                Bundle bundle = new Bundle();
                bundle.putString("data", "测试数据");
                ARouter.getInstance().build("/ui/SecondActivityTest")
                        .withBundle(extraBundle, bundle)
                        .navigation();

                break;
        }
    }
}
