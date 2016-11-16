package com.gpsi.gdeme.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.gpsi.gdeme.R;

/**
 * 类描述：登陆注册页面
 * Created by Gpsi on 2016-11-15.
 */
public class LoginAct extends Activity implements View.OnClickListener {

    LinearLayout lin_login;
    LinearLayout lin_register;
    View include_log;
    View include_register;

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

    }

    @Override
    public void onClick(View v) {
        int log_isvis = include_log.getVisibility();
        int register_isvis = include_register.getVisibility();
        switch (v.getId()){
            case R.id.login_log_click:
                if (log_isvis == 8){
                    include_log.setVisibility(View.VISIBLE);
                    include_register.setVisibility(View.GONE);
                }
                break;
            case R.id.login_register_click:
                if (register_isvis == 8){
                    include_register.setVisibility(View.VISIBLE);
                    include_log.setVisibility(View.GONE);
                }
        }
    }
}
