package com.gpsi.gdeme.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import com.gpsi.gdeme.R;

/**
 * 类描述：
 * Created by Gpsi on 2016-11-24.
 */

public class WithDelEditText extends EditText {

    private Context mContext;
    private Drawable imgDelete;

    public WithDelEditText(Context context) {
        super(context);
        mContext = context;
        init();

    }

    public WithDelEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public WithDelEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        //imgInable = mContext.getResources().getDrawable(R.drawable.delete_gray);
        imgDelete = ContextCompat.getDrawable(mContext, R.mipmap.login_edittext_delete);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                setDrawable();
            }
        });
        setDrawable();
    }
    //设置删除图片
    private void setDrawable() {
        setCompoundDrawablesWithIntrinsicBounds(null,null,imgDelete,null);
    }

    //删除内容
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        setText(null);
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
