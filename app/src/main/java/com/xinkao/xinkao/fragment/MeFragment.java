package com.xinkao.xinkao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.xinkao.xinkao.R;
import com.xinkao.xinkao.activity.LoginActivity;

/**
 * Create by 钱 on 2018/9/26 0026.
 */
public class MeFragment extends Fragment {
    private View meView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    meView = inflater.inflate(R.layout.fragment_me,null);
    meView.findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            singout();
        }
    });
    return meView;
    }

    private void singout() {
        EMClient.getInstance().logout(false, new EMCallBack() {
            @Override
            public void onSuccess() {
                startActivity(new Intent(getContext(), LoginActivity.class));
            }

            @Override
            public void onError(int i, String s) {
                Log.e("tag",i+"退出失败"+s);
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }
}
