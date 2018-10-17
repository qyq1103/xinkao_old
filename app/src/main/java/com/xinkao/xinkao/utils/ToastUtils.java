package com.xinkao.xinkao.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Create by 钱 on 2018/9/29 0029.
 */
public class ToastUtils{
    public static void showToast(Context context,String text){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
