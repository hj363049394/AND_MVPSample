package com.haojian.mvp.biz;

import com.haojian.mvp.bean.User;

/**
 * Created by haojian12583 on 2016/10/31.
 */

public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();

}
