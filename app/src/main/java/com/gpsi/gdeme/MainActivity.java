package com.gpsi.gdeme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gpsi.gdeme.ui.TextPageAct;
import com.gpsi.gdeme.utils.FirstEvent;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {

    private TextView TView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //123
        TView = (TextView) findViewById(R.id.TView);
    }

    public void oneCl(View view){
        //Toast.makeText(MainActivity.this, "就是吐一下!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, TextPageAct.class);
        startActivity(intent);
        /**
         * 借用
         *
         *     private String mMsg;
         public TakeEvent(String msg){
         mMsg = msg;
         }
         public String getMsg(){
         return mMsg;
         }
         */
    }

    public void onEventMainThread(FirstEvent event){

        String msg = "收到了："+event.getMsg();
        TView.setText(msg);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销EventBus
        EventBus.getDefault().unregister(this);
    }
}
