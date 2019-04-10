package com.yq.yqim.controller.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.yq.yqim.R;
import com.yq.yqim.controller.fragment.ChatFragment;
import com.yq.yqim.controller.fragment.ContactFragment;
import com.yq.yqim.controller.fragment.SettingFragment;

public class MainActivity extends FragmentActivity {
private RadioGroup rg_main;
private ChatFragment chatFragment;
private   ContactFragment contactFragment;
private   SettingFragment settingFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    initView();

initData();
initListener();
    }
    private void initView(){
        rg_main=(RadioGroup)findViewById(R.id.rg_main);
    }
    private  void  initData(){
        //创建Fragment对象
       chatFragment=new ChatFragment();
         contactFragment=new ContactFragment();
        settingFragment=new SettingFragment();
    }
    private  void initListener()
    {
        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Fragment fragment=null;
                switch (checkedId)
                {
                    case R.id.rb_main_chat:
                        fragment=chatFragment;
                        break;
                    case  R.id.rb_main_contact:
                        fragment=contactFragment;
                        break;
                    case R.id.rb_main_setting:
                        fragment=settingFragment;
                        break;
                }
                //切换布局
                switchFragment(fragment);
            }


        });
        //默认选择布局
        rg_main.check(R.id.rb_main_chat);
    }private void switchFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.f1_main,fragment).commit();
    }

}
