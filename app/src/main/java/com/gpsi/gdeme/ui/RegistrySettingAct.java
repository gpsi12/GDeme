package com.gpsi.gdeme.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.gpsi.gdeme.R;
import com.gpsi.gdeme.utils.RegexUtils;

/**
 * 类描述：
 * Created by Gpsi on 2016-12-14.
 */

public class RegistrySettingAct extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register_1);
        String f = "wq1990";
        boolean pswl = RegexUtils.checkUserPasswordLength(f);
        Toast.makeText(RegistrySettingAct.this,"结果:"+pswl,Toast.LENGTH_SHORT).show();



    }
}
