package com.xinkao.xinkao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xinkao.xinkao.R;
import com.xinkao.xinkao.utils.MD5Utils;
import com.xinkao.xinkao.utils.ToastUtils;

/**
 * 步骤：
 * 1、布局文件
 * 2、MD5对密码进行加密
 * 3、登录账号密码判断
 * 4、跳转主页
 */
public class LoginActivity extends AppCompatActivity {

    private Button mButton;
    private EditText mPhone;
    private EditText mPassword;
//    //测试的账号密码
    String savePhone = "15732892375";
    String savePwd = MD5Utils.encrypt("123456");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mPhone = findViewById(R.id.ed_phone);
        mPassword = findViewById(R.id.ed_pwd);
        mButton = findViewById(R.id.btn_login);
        //注册按钮监听
//        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
////                singup();
//            }
//        });
        //登录按钮监听
//        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                singin();
//            }
//        });
                mButton.setOnClickListener(new Login());
    }
//    //注册按钮点击事件处理
//    private void singup() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    EMClient.getInstance().createAccount(mPhone.getText().toString().trim(),MD5Utils.encrypt(mPassword.getText().toString().trim()));
//                    Log.i("tag","注册成功");
//                } catch (HyphenateException e) {
//                    e.printStackTrace();
//                    Log.e("tag","注册失败");
//                }
//            }
//        }).start();
//    }

    /**
     * 返回按钮点击事件
     * @param view
     */
    public void back(View view) {
        Toast.makeText(getApplicationContext(), "回不去咯", Toast.LENGTH_SHORT).show();
    }

    /**
     * 登录按钮点击事件处理
     */
    class Login implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            String phone = mPhone.getText().toString().trim();
            String pwd = mPassword.getText().toString().trim();

            if (!phone.isEmpty()){
                if (!pwd.isEmpty()){
                    if (phone.equals(savePhone)){
                        if (MD5Utils.encrypt(pwd).equals(savePwd)){
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else {
                            ToastUtils.showToast(getApplicationContext(),"密码错误");
                        }
                    }else{
                        ToastUtils.showToast(getApplicationContext(),"手机号未注册");
                    }
                }else{
                    ToastUtils.showToast(getApplicationContext(),"密码不能为空");
                }
            }else{
                ToastUtils.showToast(getApplicationContext(),"手机号不能为空");
            }
        }
    }

//    public void singin(){
//        EMClient.getInstance().login(mPhone.getText().toString().trim(), MD5Utils.encrypt(mPassword.getText().toString().trim()), new EMCallBack() {
//            @Override
//            public void onSuccess() {
//                Log.i("tag","登录成功，密码为："+MD5Utils.encrypt(mPassword.getText().toString().trim()));
//                startActivity(new Intent(LoginActivity.this,MainActivity.class));
//                finish();
//            }
//
//            @Override
//            public void onError(int i, String s) {
//                Log.e("tag","登录失败"+i+","+s);
//            }
//
//            @Override
//            public void onProgress(int i, String s) {
//
//            }
//        });
//    }

    /**
     * 遇到问题点击监听
     * @param view
     */
    public void problem(View view) {
        Toast.makeText(getApplicationContext(), "遇到问题找警察啦", Toast.LENGTH_SHORT).show();
    }

    /**
     * 忘记密码点击监听
     * @param view
     */
    public void forgetPwd(View view) {
        Toast.makeText(getApplicationContext(), "没有办法咯", Toast.LENGTH_SHORT).show();
    }
}
