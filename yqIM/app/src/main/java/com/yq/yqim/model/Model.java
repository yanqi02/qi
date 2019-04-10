package com.yq.yqim.model;

import android.content.Context;

import com.baidu.mapapi.map.MarkerOptions;
import com.yq.yqim.model.dao.UserAccount;
import com.yq.yqim.model.dao.UserDao;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Model全局类
public class Model {
private Context mcontext;
private ExecutorService executors  = Executors.newCachedThreadPool();//线程池
private  static  Model model=new Model();
    UserDao userDao;
    private Model(){}
    public static Model getInstance(){return  model;}
    public void init(Context context)
    { mcontext=context;
         userDao = new UserDao(mcontext);
    }
    //获取全局线程池对象
public  ExecutorService getGlobalThreadPool() {

return executors;
}
public void  loginSuccess()
{

}
//获取用户账号数据库操作类对象
public UserDao getUserDao()
{return userDao;}
}
