package com.haojian.mvp.view;

import com.haojian.mvp.bean.User;

/**
 * Created by haojian12583 on 2016/10/31.
 */

public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();

}
