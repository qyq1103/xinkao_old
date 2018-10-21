package com.xinkao.xinkao.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xinkao.xinkao.R;
import com.xinkao.xinkao.fragment.ConversationList;
import com.xinkao.xinkao.fragment.HomeFragment;
import com.xinkao.xinkao.fragment.MeFragment;
import com.xinkao.xinkao.fragment.ShareFragment;

/**
 * 1、FragmentActivity布局
 * 2、四个Fragment布局
 * 3、添加四个Fragment
 * Create by 钱 on 2018/9/26 0026.
 */
public class MainActivity extends FragmentActivity {
    private RadioGroup mRadioGroup;
    private String tabs[] = {"首页", "聊天", "分享", "我"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRadioGroup = findViewById(R.id.m_radio_group);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /**
             * 按钮组的点击事件
             * @param group
             * @param checkedId
             */
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        switchFragmentSupport(R.id.content, tabs[0]);
                        break;
                    case R.id.radioButton2:
                        switchFragmentSupport(R.id.content, tabs[1]);
                        break;
                    case R.id.radioButton3:
                        switchFragmentSupport(R.id.content, tabs[2]);
                        break;
                    case R.id.radioButton4:
                        switchFragmentSupport(R.id.content, tabs[3]);
                        break;
                }
            }
        });

        RadioButton btn = (RadioButton) mRadioGroup.getChildAt(0);
        btn.toggle();

    }

    /**
     * @param containerId
     * @param tag
     */
    public void switchFragmentSupport(int containerId, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment destFragment = fragmentManager.findFragmentByTag(tag);
        if (destFragment == null) {
            if (tag.equals(tabs[0]))
                destFragment = new HomeFragment();
            if (tag.equals(tabs[1])) {
                destFragment = new ConversationList();
            }
            if (tag.equals(tabs[2]))
                destFragment = new ShareFragment();
            if (tag.equals(tabs[3]))
                destFragment = new MeFragment();
        }
        FragmentTransaction ft = fragmentManager.beginTransaction();

        ft.replace(containerId, destFragment, tag);
        ft.commit();
    }
}
