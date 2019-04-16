package com.yq.yqim.controller.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.yq.yqim.R;
import com.yq.yqim.model.Model;
import com.yq.yqim.model.bean.UserInfo;

public class LoginActivity extends AppCompatActivity {
    private EditText login_edit_account;
    private EditText login_edit_pwd;
    private Button login_btn_register;
    private Button login_btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化控件

        initView();
        //初始化监听
        initListener();
    }

    private void initView() {
        login_edit_account = (EditText) findViewById(R.id.login_edit_account);
        login_edit_pwd = (EditText) findViewById(R.id.login_edit_pwd);
        login_btn_login = (Button) findViewById(R.id.login_btn_login);
        login_btn_register = (Button) findViewById(R.id.login_btn_register);
    }

    private void initListener() {//注册
        login_btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regist();
            }
        });
        //登录
        login_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        final String loginName = login_edit_account.getText().toString();
        final String loginPwd = login_edit_pwd.getText().toString();
        if (TextUtils.isEmpty(loginName) || TextUtils.isEmpty(loginPwd)) {
            Toast.makeText(LoginActivity.this, "不能为空", Toast.LENGTH_SHORT).show();

        } else {   //登录  联网操作 new线程

            Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
                @Override
                public void run() {
                    EMClient.getInstance().login(loginName, loginPwd, new EMCallBack() {

                        @Override
                        public void onSuccess() {

                            //对model层数据处理
                            Model.getInstance().loginSuccess(new UserInfo(loginName));
                            //保存信息到本地数据库
                            Model.getInstance().getUserDao().addUser(new UserInfo(loginName));
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                }
                            });
                            //跳转主界面
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }

                        @Override
                        public void onError(int i, String s) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }

                        @Override
                        public void onProgress(int i, String s) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                                }
                            });


                        }
                    });
                }
            });
        }
    }

    private void regist() {
        final String registName = login_edit_account.getText().toString();
        final String registPwd = login_edit_pwd.getText().toString();
        if (TextUtils.isEmpty(registName) || TextUtils.isEmpty(registPwd)) {
            Toast.makeText(LoginActivity.this, "不能为空", Toast.LENGTH_SHORT).show();

        }
        Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
            @Override
            public void run() {

//    注册
                try {
                    EMClient.getInstance().createAccount(registName, registPwd);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (final HyphenateException e1) {
                    e1.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(LoginActivity.this, "注册失败" + e1.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                //更新页面显示

            }
        });
    }
}










