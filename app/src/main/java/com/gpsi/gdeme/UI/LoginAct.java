package com.gpsi.gdeme.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gpsi.gdeme.R;
import com.gpsi.gdeme.api.ApiContants;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 类描述：登陆注册页面
 * Created by Gpsi on 2016-11-15.
 */
public class LoginAct extends Activity implements View.OnClickListener {

    LinearLayout lin_login;
    LinearLayout lin_register;
    View include_log;
    View include_register;
    Button btn_login;

    EditText editText_login_name;
    EditText editText_login_psw;

    View underscore;

    private static final String TAG = "Gpsi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lin_login = (LinearLayout) findViewById(R.id.login_log_click);
        lin_login.setOnClickListener(this);
        lin_register = (LinearLayout) findViewById(R.id.login_register_click);
        lin_register.setOnClickListener(this);
        include_log = findViewById(R.id.login_log_vib);
        include_register = findViewById(R.id.login_register_vib);
        btn_login = (Button) findViewById(R.id.btn_login_send);
        btn_login.setOnClickListener(this);
        editText_login_name = (EditText) findViewById(R.id.editText_login_name);
        editText_login_psw = (EditText) findViewById(R.id.editText_login_psw);

        underscore = findViewById(R.id.login_underscore);
        ;

    }

    @Override
    public void onClick(View v) {
        int log_isvis = include_log.getVisibility();
        int register_isvis = include_register.getVisibility();
        switch (v.getId()) {
            case R.id.login_log_click:
                if (log_isvis == 8) {
                    include_log.setVisibility(View.VISIBLE);
                    underscore.setBackgroundColor(Color.blue(55));
                    include_register.setVisibility(View.GONE);
                }
                break;
            case R.id.login_register_click:
                if (register_isvis == 8) {
                    include_register.setVisibility(View.VISIBLE);
                    include_log.setVisibility(View.GONE);
                }
                break;
            case R.id.btn_login_send:
                //登陆按钮点击
                login();

                break;

            case R.id.btn_register_send:
                //注册

                break;
        }
    }


    /**
     * 登陆功能实现
     */
    private void login() {
        if (TextUtils.isEmpty(editText_login_name.getText())) {

            Toast.makeText(LoginAct.this, "账户不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(editText_login_psw.getText())) {
            Toast.makeText(LoginAct.this, "密码不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        String account = editText_login_name.getText().toString();
        String password = editText_login_psw.getText().toString();

        RequestParams params = new RequestParams(ApiContants.api_login);
        params.addHeader("safetyId", "100088");
        params.addHeader("token", "d41d8cd9-07c0-9c10dbd0-d5cecf52");
        params.addBodyParameter("account", account);
        params.addBodyParameter("password", password);
        params.addBodyParameter("deviceId", "honor6");
        params.addBodyParameter("token", "d41d8cd9-07c0-9c10dbd0-d5cecf52");

        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.i(TAG, "成功：" + s.toString());
            }

            @Override
            public void onError(Throwable throwable, boolean b) {

                Log.i(TAG, "onError:" + throwable.toString());
            }

            @Override
            public void onCancelled(CancelledException e) {
                Log.i(TAG, "onCancelled:" + e.toString());
            }

            @Override
            public void onFinished() {
                Log.i(TAG, "onFinished");
            }
        });
    }


}
