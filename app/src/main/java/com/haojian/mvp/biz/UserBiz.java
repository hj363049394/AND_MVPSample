package com.haojian.mvp.biz;

import com.haojian.mvp.bean.User;

/**
 * Created by haojian12583 on 2016/10/31.
 */

public class UserBiz implements  IUserBiz{

    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {

        //模拟子线程耗时操作
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 模拟登陆成功
                if("haojian".equals(username) && "123".equals(password)){

                    User user = new User();
                    user.setmUserName(username);
                    user.setmPassword(password);
                    loginListener.loginSuccess(user);
                }else {
                    loginListener.loginFailed();
                }
            }
        }.start();

    }
}
