package com.gpsi.gdeme.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Editable;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.gpsi.gdeme.R;

/**
 * 类描述：自定义的EditText
 * Created by Gpsi on 2016-11-16.
 */

public class OwnEditText extends FrameLayout {

    private EditText editText;
    private ImageView imageBtn;
    private Paint mpaint;
    private float textSize;

    public OwnEditText(Context context) {
        super(context);
    }

    public OwnEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.own_edittext, this, true);
        mpaint = new Paint();
        TypedArray tarray = context.obtainStyledAttributes(attrs, R.styleable.OwnEditText);
        textSize = tarray.getDimension(R.styleable.OwnEditText_mtextSize, 26);//26是默认值
        int textColor = tarray.getColor(R.styleable.OwnEditText_mtextColor, 0xFF1214);//默认颜色
        String hint = tarray.getString(R.styleable.OwnEditText_mhint);//没有默认值。。。
        mpaint.setTextSize(textSize);
        mpaint.setColor(textColor);
        //editText.setHint(hint); //不确定是否可行，测试


        this.editText = (EditText) findViewById(R.id.edittext_own);
        this.imageBtn = (ImageView) findViewById(R.id.imageview_own);
        this.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //可以判断框内是否有内容，是否显示、隐藏一些东西。

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        this.imageBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(null);
                //是否显示、隐藏一些东西
            }
        });
    }

    public String getContent() {
        return editText.getText().toString();
    }

    public void setText(CharSequence text, TextView.BufferType type) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mpaint.setColor(Color.BLUE);
        mpaint.setStyle(Paint.Style.FILL);

        canvas.drawRect(new Rect(10, 10, 100, 100), mpaint);
        mpaint.setColor(Color.WHITE);
        mpaint.setTextSize(textSize);
        canvas.drawText("你好", 10, 100, mpaint);
    }
}
