package com.huyhuynh.applazada.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.huyhuynh.applazada.R;

public class CustomEdittextEmailDangNhap extends androidx.appcompat.widget.AppCompatEditText {

    Drawable dropX, nonDropX, drawable;
    boolean visible = false;

    public CustomEdittextEmailDangNhap(@NonNull Context context) {
        super(context);
        init();
    }

    public CustomEdittextEmailDangNhap(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomEdittextEmailDangNhap(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        dropX = ContextCompat.getDrawable(getContext(), R.drawable.ic_clear_black_24dp).mutate();
        dropX.setAlpha((int)(255* .50f));
        nonDropX = ContextCompat.getDrawable(getContext(), android.R.drawable.screen_background_light_transparent).mutate();
        setupDropButton();
    }

    private void setupDropButton(){
        setInputType(InputType.TYPE_CLASS_TEXT);
        Drawable drawables[] = getCompoundDrawables();
        drawable = visible ? dropX : nonDropX;
        setCompoundDrawablesWithIntrinsicBounds(drawables[0],drawables[1],drawable,drawables[3]);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if (lengthAfter == 0 && start == 0){
            visible=false;
            setupDropButton();
        } else {
            visible = true;
            setupDropButton();
        }
    }

    //Phương thức này dùng để bắt sự kiện chạm trúng drawable
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()== MotionEvent.ACTION_DOWN && (event.getX()>=(getRight()-drawable.getBounds().width()))){
            setText("");
        }
        return super.onTouchEvent(event);
    }
}
