package com.yq.yqim.controller.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.yq.yqim.R;
import com.yq.yqim.controller.adapter.InviteAdapter;
import com.yq.yqim.model.Model;
import com.yq.yqim.model.bean.InvationInfo;
import com.yq.yqim.utils.Constant;

import java.util.List;

//邀请信息页面
public class InviteActivity extends AppCompatActivity {
    private BroadcastReceiver ContactInviteChangedReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //接受邀请信息变化 刷新 页面
            refresh();
        }
    };
    private ListView lv_invite;
private InviteAdapter inviteAdapter;
private  LocalBroadcastManager mLBM;
     private InviteAdapter.OnInviteListener monInviteListener=new InviteAdapter.OnInviteListener() {
        @Override
        public void onAccept(final InvationInfo invationInfo) {
Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
    //通知服务器点击了接受按钮
    @Override
    public void run() {
        try{
        EMClient.getInstance().contactManager().acceptInvitation(invationInfo.getUser().getHxid());
        Model.getInstance().getDbManager().getInviteTableDao().updateInvitationStatus(InvationInfo.InvationStatus.INVITE_ACCEPT,invationInfo.getUser().getHxid());
   runOnUiThread(new Runnable() {
       @Override
       public void run() {
           Toast.makeText(InviteActivity.this,"接受邀请",Toast.LENGTH_SHORT).show();
           refresh();





       }
   });

    } catch (HyphenateException e) {
            e.printStackTrace();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(InviteActivity.this,"接受邀请失败",Toast.LENGTH_SHORT).show();

                }
            });
        }}
});}


        @Override
        public void onReject(final InvationInfo invationInfo) {
Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
    @Override
    public void run() {
        try{
            EMClient.getInstance().contactManager().declineInvitation(invationInfo.getUser().getHxid());
        Model.getInstance().getDbManager().getInviteTableDao().removeInvitation(invationInfo.getUser().getHxid());
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(InviteActivity.this,"拒绝邀请",Toast.LENGTH_SHORT).show();
refresh();
                }
            });

        } catch (HyphenateException e) {
            e.printStackTrace();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(InviteActivity.this,"拒绝失败",Toast.LENGTH_SHORT).show();

                }
            });

        }
    }
});
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);
        initView();
        initData();
    }

    private void initData() {
        //初始化ListView
         inviteAdapter = new InviteAdapter(this,monInviteListener);
        lv_invite.setAdapter(inviteAdapter);
        //刷新方法
        refresh();
        //注册邀请信息变化的广播
        mLBM= LocalBroadcastManager.getInstance(this);
        mLBM.registerReceiver(ContactInviteChangedReceiver,new IntentFilter(Constant.CONTACT_INVITE_CHANGED));
    }

    private void refresh() {
        //获取数据库中所有邀请信息
       List<InvationInfo> invitations= Model.getInstance().getDbManager().getInviteTableDao().getInvitations();
        //刷新适配器
        inviteAdapter.refresh(invitations);
    }

    private void initView() {
        lv_invite=(ListView)findViewById(R.id.lv_invite);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLBM.unregisterReceiver(ContactInviteChangedReceiver);
    }
}
