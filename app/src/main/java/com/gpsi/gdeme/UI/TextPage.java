package com.gpsi.gdeme.UI;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import com.gpsi.gdeme.R;
import com.gpsi.gdeme.utils.FirstEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2016-11-14.
 */
public class TextPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_page);
    }

    public  void TextPage_C(View view){

        EventBus.getDefault().post(new FirstEvent("、测试EventBus。"));
    }
}
