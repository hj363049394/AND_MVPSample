package com.haojian.mvp.presenter;

import android.os.Handler;

import com.haojian.mvp.bean.User;
import com.haojian.mvp.biz.IUserBiz;
import com.haojian.mvp.biz.OnLoginListener;
import com.haojian.mvp.biz.UserBiz;
import com.haojian.mvp.view.IUserLoginView;

/**
 * Created by haojian12583 on 2016/10/31.
 */

public class UserLoginPresenter {

    private IUserBiz  mUserBiz;
    private IUserLoginView mUserLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView)
    {
        this.mUserLoginView = userLoginView;
        this.mUserBiz = new UserBiz();
    }

    public void login(){
        mUserBiz.login(mUserLoginView.getUserName(), mUserLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserLoginView.toMainActivity(user);
                    }
                });

            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserLoginView.showFailedError();
                    }
                });
            }
        });
    }

    public void clear(){

        mUserLoginView.clearPassword();
        mUserLoginView.clearUserName();

    }


}
