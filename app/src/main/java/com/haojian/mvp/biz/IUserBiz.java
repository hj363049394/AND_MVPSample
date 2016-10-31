package com.haojian.mvp.biz;

/**
 * Created by haojian12583 on 2016/10/31.
 */

public interface IUserBiz {

    public void login(String username,String password,OnLoginListener loginListener);

}
