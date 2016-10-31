package com.haojian.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.haojian.mvp.bean.User;
import com.haojian.mvp.presenter.UserLoginPresenter;
import com.haojian.mvp.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView{

    private EditText mUserNameEt;
    private EditText mPasswordEt;
    private Button mLoginBtn;
    private Button mClearBtn;
    private ProgressBar mLoadingPb;

    private UserLoginPresenter mUserLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        mUserNameEt = (EditText) findViewById(R.id.username_et);
        mPasswordEt = (EditText) findViewById(R.id.password_et);
        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mClearBtn = (Button) findViewById(R.id.clear_btn);

        mUserLoginPresenter = new UserLoginPresenter(this);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login();
            }
        });

        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.clear();
            }
        });

    }

    @Override
    public String getUserName() {
        return mUserNameEt.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPasswordEt.getText().toString();
    }

    @Override
    public void clearUserName() {
        mUserNameEt.setText("");
    }

    @Override
    public void clearPassword() {
        mPasswordEt.setText("");
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getmUserName() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
}
