package com.huyhuynh.applazada.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.huyhuynh.applazada.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Trong styles.xml tạo một thuộc tính declare-styleable name="CustomEditextPassword" (Xem ở file)
 * Sau đó đổi định dạng edittext thành Class này thay vì class EditText truyền thống.
 * */
public class CustomEditextPassword extends TextInputEditText {

    Drawable drawableEye, drawableInviEye,drawable;
    boolean visible = false;
    boolean userStrike = false;
    boolean userValid = false;
    Pattern pattern;
    Matcher matcher;

    String VALID_PASS = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}";
    public CustomEditextPassword(Context context) {
        super(context);
        init(null);
    }

    public CustomEditextPassword(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomEditextPassword(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    //Phương thức này dùng để khởi tạo thêm các thuộc tính
    private void init(AttributeSet attrs){
        this.pattern = Pattern.compile(VALID_PASS);
        if (attrs!=null){
            TypedArray array = getContext().getTheme().obtainStyledAttributes(attrs
                    ,R.styleable.CustomEditextPassword,0,0);
            this.userStrike = array.getBoolean(R.styleable.CustomEditextPassword_useStrike,false);
            this.userValid = array.getBoolean(R.styleable.CustomEditextPassword_useValid,false);
        }
        drawableEye = ContextCompat.getDrawable(getContext(), R.drawable.ic_visibility_black_24dp).mutate();
        drawableInviEye = ContextCompat.getDrawable(getContext(), R.drawable.ic_visibility_off_black_24dp).mutate();

        //Xử lí hiện thị thông báo nếu ko đúng định dạng pass:
        if (this.userValid){
            setOnFocusChangeListener(new OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus){
                        String userPass = getText().toString();
                        matcher = pattern.matcher(userPass);
                        if (!matcher.matches()){
                            setError("Mật khẩu phải lớn hơn 6 kí tự bao gồm có chữ số, chữ viết hoa!");
                        } else {

                        }
                    }
                }
            });
        }

        setupOnClickDrawable();
    }

    //Phương thức này dùng để cấu hình hiển thị drawable bên phải
    private void setupOnClickDrawable(){
        setInputType(InputType.TYPE_CLASS_TEXT|(visible ? InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD :
                InputType.TYPE_TEXT_VARIATION_PASSWORD));
        Drawable drawables[] = getCompoundDrawables();
        drawable = (userStrike && !visible) ? drawableInviEye : drawableEye;
        drawable.setAlpha((int)(255* .50f));
        setCompoundDrawablesWithIntrinsicBounds(drawables[0],drawables[1],drawable,drawables[3]);
    }

    //Phương thức này dùng để bắt sự kiện chạm trúng drawable
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()== MotionEvent.ACTION_DOWN && (event.getX()>=(getRight()-drawable.getBounds().width()))){
            visible = !visible;
            setupOnClickDrawable();
            invalidate();
        }
        return super.onTouchEvent(event);
    }
}
