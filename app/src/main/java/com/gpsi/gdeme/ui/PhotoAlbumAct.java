package com.gpsi.gdeme.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.gpsi.gdeme.R;
import com.gpsi.gdeme.utils.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 类描述：相册
 * Created by Gpsi on 2016-11-23.
 */
public class PhotoAlbumAct extends Activity {

    private TextView textView;
    private static String mAccount;

    public static void newIntent(Context context, String account) {
        mAccount = account;
        Intent intent = new Intent(context, PhotoAlbumAct.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photoalbum);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(mAccount);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
