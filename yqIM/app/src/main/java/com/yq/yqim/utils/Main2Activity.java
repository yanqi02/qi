package com.yq.yqim.utils;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseUI;
import com.yq.yqim.model.Model;

public class Main2Activity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        EMOptions options=new EMOptions();
        options.setAcceptInvitationAlways(false);
        options.setAutoAcceptGroupInvitation(false);
        EaseUI.getInstance().init(this,options);
        Model.getInstance().init(this);

    }
}
