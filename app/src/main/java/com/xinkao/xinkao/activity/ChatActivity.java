package com.xinkao.xinkao.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hyphenate.easeui.ui.EaseChatFragment;
import com.xinkao.xinkao.R;

/**
 * 聊天详细页面
 * 1、布局文件
 * Create by 钱 on 2018/10/11 0011.
 */
public class ChatActivity extends AppCompatActivity {

//    private ListView mChat;
//    private EditText mEditChat;
//    private Button mSendChat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        //隐藏控件
//        mChat = findViewById(R.id.lv_chat);
//        mEditChat = findViewById(R.id.ed_chat);
//        mSendChat = findViewById(R.id.btn_send_chat);

        //EaseUI封装好的聊天界面
        EaseChatFragment easeChatFragment = new EaseChatFragment();
        //将参数传给聊天界面
        easeChatFragment.setArguments(getIntent().getExtras());
        //加载EaseUI封装的的聊天界面Fragment
        getSupportFragmentManager().beginTransaction().add(R.id.ec_layout_container,easeChatFragment).commit();
    }

}