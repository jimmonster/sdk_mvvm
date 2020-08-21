package com.droget.sdk_mvvm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.droget.common_mvvm.base.AbstractBaseActivity;
import com.droget.sdk_mvvm.R;

/**
 * @author :  Jim
 * @date :  2020/8/21
 * @description :
 */
@Route(path = "/ui/SecondActivityTest")
public class SecondActivityTest extends AbstractBaseActivity {


    private TextView mTvTest;
    private String mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initData();
        initView();
    }

    private void initData() {
        mTvTest = (TextView) findViewById(R.id.tv_test);
        Intent intent = getIntent();
        Bundle bundleExtra = intent.getBundleExtra(extraBundle);
        if (bundleExtra != null) {
            mData = bundleExtra.getString("data");
        } else {
            mData = "";
        }
    }

    public void initView() {
        mTvTest = (TextView) findViewById(R.id.tv_test);
        mTvTest.setText(mData);
    }
}
