package com.yq.yqim.controller.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.yq.yqim.R;
import com.yq.yqim.controller.activity.LoginActivity;
import com.yq.yqim.model.Model;


public class SettingFragment  extends Fragment {
    private Button bt_setting_out;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view   =View.inflate(getActivity(), R.layout.fragment_setting,null);
        initView(view);
        return  view;

    }
    private  void initView(View view){
        bt_setting_out=(Button)view.findViewById(R.id.bt_setting_logout);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    initData();
    }
    private void initData(){
        //显示用户名
        bt_setting_out.setText("退出登录（"+ EMClient.getInstance().getCurrentUser()+"）");
        //退出
        bt_setting_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
                    @Override
                    public void run() {
                        //退出服务器登陆
                        EMClient.getInstance().logout(false, new EMCallBack() {
                            @Override
                            public void onSuccess() {
                                //关闭DBHelper
                                Model.getInstance().getDbManager().close();
                                //回到登录页面
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getActivity(),"退出成功",Toast.LENGTH_SHORT).show();
                                        Intent intent =new Intent(getActivity(), LoginActivity.class);
                                        startActivity(intent);
                                        getActivity().finish();
                                    }
                                });
                            }

                            @Override
                            public void onError(int i, final String s) {
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getActivity(),"退出失败"+s,Toast.LENGTH_SHORT).show();

                                    }
                                });

                            }

                            @Override
                            public void onProgress(int i, String s) {

                            }
                        });
                    }
                });
            }
        });

    }
}
