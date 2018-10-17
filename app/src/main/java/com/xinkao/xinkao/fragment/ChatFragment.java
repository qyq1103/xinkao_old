package com.xinkao.xinkao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xinkao.xinkao.R;
import com.xinkao.xinkao.activity.ChatActivity;

/**
 * Create by 钱 on 2018/9/26 0026.
 */
public class ChatFragment extends Fragment {
    private View chatView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        chatView = inflater.inflate(R.layout.fragment_chat, null);
        chatView.findViewById(R.id.back_iv).setVisibility(View.GONE);
        chatView.findViewById(R.id.btn_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),ChatActivity.class));
            }
        });
        return chatView;
    }
}
