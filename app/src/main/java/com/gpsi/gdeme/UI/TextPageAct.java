package com.gpsi.gdeme.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gpsi.gdeme.R;
import com.gpsi.gdeme.utils.FirstEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2016-11-14.
 */
public class TextPageAct extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_page);
    }

    public  void TextPage_C(View view){

        Intent intent = new Intent(TextPageAct.this,LoginAct.class);
        startActivity(intent);
        EventBus.getDefault().post(new FirstEvent("、测试EventBus。"));
    }
}
