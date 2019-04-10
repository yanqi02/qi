package com.yq.yqim.controller.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;

import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.EaseUI;
import com.hyphenate.easeui.ui.EaseContactListFragment;
import com.yq.yqim.R;
import com.yq.yqim.controller.activity.AddContactActivity;

//联系人
public class ContactFragment extends EaseContactListFragment {
    @Override
    protected void initView() {
        super.initView();
        titleBar.setRightImageResource(R.drawable.ease_blue_add);
        //添加头布局
        View headView =View.inflate(getActivity(),R.layout.header_fragment_contact,null);
        listView.addHeaderView(headView );
    }

    @Override
    protected void setUpView() {
        super.setUpView();
        //添加按钮点击事件
        titleBar.setRightLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), AddContactActivity.class);
                startActivity(intent);
            }
        });
    }
}
