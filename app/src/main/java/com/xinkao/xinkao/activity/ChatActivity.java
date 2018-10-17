package com.xinkao.xinkao.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.xinkao.xinkao.R;

/**
 * 聊天详细页面
 * 1、布局文件
 * Create by 钱 on 2018/10/11 0011.
 */
public class ChatActivity extends AppCompatActivity {

    private ListView mChat;
    private EditText mEditChat;
    private Button mSendChat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        //隐藏控件
        findViewById(R.id.add_chat).setVisibility(View.GONE);
        mChat = findViewById(R.id.lv_chat);
        mEditChat = findViewById(R.id.ed_chat);
        mSendChat = findViewById(R.id.btn_send_chat);

    }

}