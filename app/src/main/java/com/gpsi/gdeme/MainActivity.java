package com.gpsi.gdeme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.xutils.x;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //123
    }

    public void oneCl(View view){
        Toast.makeText(MainActivity.this, "就是吐一下!", Toast.LENGTH_SHORT).show();
    }

}
