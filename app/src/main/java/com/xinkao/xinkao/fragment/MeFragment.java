package com.xinkao.xinkao.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xinkao.xinkao.R;

/**
 * Create by 钱 on 2018/9/26 0026.
 */
public class MeFragment extends Fragment {
    private View meView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    meView = inflater.inflate(R.layout.fragment_me,null);
    return meView;
    }
}
