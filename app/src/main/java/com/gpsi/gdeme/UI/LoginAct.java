package com.gpsi.gdeme.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.gpsi.gdeme.R;
import com.gpsi.gdeme.api.ApiContants;
import com.gpsi.gdeme.bean.LoginBean;
import com.gpsi.gdeme.utils.MessageEvent;
import com.gpsi.gdeme.widget.WithDelEditText;

import org.greenrobot.eventbus.EventBus;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 类描述：登陆注册页面
 * Created by Gpsi on 2016-11-15.
 */
public class LoginAct extends Activity implements View.OnClickListener {

    LinearLayout lin_login_click;
    LinearLayout lin_register_click;
    View include_log;
    View include_register;
    Button btn_login;
    Button register_getcode;
    Button btn_register_next;
    WithDelEditText register_et_phone;
    WithDelEditText register_et_code;

    EditText editText_login_name;
    EditText editText_login_psw;
    TextView login_reg_tt;
    TextView login_log_tt;
    TextView register_protocol;
    View login_underscore;
    View register_underscore;

    private CountDownTimer mTimer;
    private static final String TAG = "Gpsi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lin_login_click = (LinearLayout) findViewById(R.id.login_log_click);
        lin_login_click.setOnClickListener(this);
        lin_register_click = (LinearLayout) findViewById(R.id.login_register_click);
        lin_register_click.setOnClickListener(this);
        include_log = findViewById(R.id.login_log_vib);
        include_register = findViewById(R.id.login_register_vib);
        btn_login = (Button) findViewById(R.id.btn_login_send);
        btn_login.setOnClickListener(this);
        btn_register_next = (Button) findViewById(R.id.btn_register_next);
        btn_register_next.setOnClickListener(this);
        register_getcode = (Button) findViewById(R.id.register_getcode);
        register_getcode.setOnClickListener(this);
        editText_login_name = (EditText) findViewById(R.id.editText_login_name);
        editText_login_psw = (EditText) findViewById(R.id.editText_login_psw);

        login_underscore = findViewById(R.id.login_underscore);
        register_underscore = findViewById(R.id.register_underscore);
        login_reg_tt = (TextView) findViewById(R.id.login_reg_tt);
        login_log_tt = (TextView) findViewById(R.id.login_log_tt);
        register_et_phone = (WithDelEditText) findViewById(R.id.register_et_phone);
        register_et_code = (WithDelEditText) findViewById(R.id.register_et_code);

        register_protocol = (TextView) findViewById(R.id.register_protocol);
        register_protocol.setOnClickListener(this);
//        EventBus.getDefault().register(this);
        mTimer = new CountDownTimer(50000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                register_getcode.setText((millisUntilFinished / 1000) + "秒后重新获取");
                register_getcode.setBackgroundColor(0xe4e5e4);
                register_getcode.setClickable(false);
            }

            @Override
            public void onFinish() {
                register_getcode.setEnabled(true);
                register_getcode.setText("点击获取验证码");
            }
        };

    }

    @Override
    public void onClick(View v) {
        int log_isvis = include_log.getVisibility();
        int register_isvis = include_register.getVisibility();
        switch (v.getId()) {
            case R.id.login_log_click:
                if (log_isvis == 8) {
                    include_log.setVisibility(View.VISIBLE);
                    change(1);
                    include_register.setVisibility(View.GONE);
                }
                break;
            case R.id.login_register_click:
                if (register_isvis == 8) {
                    include_register.setVisibility(View.VISIBLE);
                    change(2);
                    include_log.setVisibility(View.GONE);
                }
                break;
            case R.id.register_protocol:
                //注册协议
//                Toast.makeText(LoginAct.this, "注册协议", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginAct.this, RegisterprotocolAct.class);
                startActivity(intent);
                break;
            case R.id.btn_login_send:
                //登陆按钮点击
                login();

                break;
            case R.id.btn_register_next:
                //注册
                register_next();
                break;
            case R.id.register_getcode:
                //获取验证码
                getVerifyCode();
                restart();
                break;

        }
    }

    /**
     * 注册下一步
     */
    private void register_next() {
        Intent intent = new Intent(LoginAct.this, RegistrySettingAct.class);
        startActivity(intent);
        //携带手机号码过去

    }


    /**
     * 登陆功能实现，简单实现
     */
    private void login() {
        if (TextUtils.isEmpty(editText_login_name.getText())) {

            Toast.makeText(LoginAct.this, "账户不能为空!", Toast.LENGTH_SHORT).show();
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
                dealData(s);
//                Log.i(TAG, "成功：" + s.toString());
            }

            @Override
            public void onError(Throwable throwable, boolean b) {

                Log.i(TAG, "onError1:" + throwable.toString());
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

    private void dealData(String result) {
        Gson g = new Gson();
        LoginBean logB = g.fromJson(result, LoginBean.class);

        if (null != logB && logB.isStatus()) {
            Log.i(TAG, logB.getDescription().toString());
            EventBus.getDefault().post(new MessageEvent(logB.getResult().getAccount()));
            Log.i(TAG, logB.getResult().getAccount());
            Log.i(TAG, logB.getDescription().toString() + ",跳转");
            PhotoAlbumAct.newIntent(this, logB.getResult().getAccount());
//            finish();
        } else {
            Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 改变下划线颜色,1:登陆,2:注册
     *
     * @param i
     */
    public void change(int i) {
        if (i == 2) {
            login_log_tt.setTextColor(Color.BLACK);
            login_underscore.setBackgroundColor(Color.WHITE);
            login_reg_tt.setTextColor(Color.RED);
            register_underscore.setBackgroundColor(Color.RED);
        } else {
            login_log_tt.setTextColor(Color.RED);
            login_underscore.setBackgroundColor(Color.RED);
            login_reg_tt.setTextColor(Color.BLACK);
            register_underscore.setBackgroundColor(Color.WHITE);

        }


    }

    /**
     * 开始倒计时
     */
    public void restart() {
        mTimer.start();
    }

    /**
     * 结束倒计时
     */
    public void oncancel() {
        mTimer.cancel();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }

    /**
     * 获取验证码
     */
    public void getVerifyCode() {
        String code = register_et_phone.getText().toString();
        Log.i(TAG, code);
    }
}
