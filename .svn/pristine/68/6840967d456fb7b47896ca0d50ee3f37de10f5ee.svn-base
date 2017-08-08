package tts.moudle.api.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import tts.moudle.ttsmoduleapi.R;

/**
 * Created by sjb on 2016/1/6.
 */
public class TTSRadioButton extends RadioButton {
    private String widthSize;
    private String heightSize;
    private Drawable ttsDrawableLeft = null, ttsDrawableTop = null, ttsDrawableRight = null, ttsDrawableBottom = null;
    private Drawable ttsDrawableLeft_check = null, ttsDrawableTop_check = null, ttsDrawableRight_check = null, ttsDrawableBottom_check = null;
    private TypedArray a;


    public TTSRadioButton(Context context) {
        this(context, null, 0);
    }

    public TTSRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TTSRadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub

        a = context.obtainStyledAttributes(attrs,
                R.styleable.TTSRadioButton);

        widthSize = a.getString(R.styleable.TTSRadioButton_widthSize);
        heightSize = a.getString(R.styleable.TTSRadioButton_heightSize);
        ttsDrawableTop = a.getDrawable(R.styleable.TTSRadioButton_ttsDrawableTop);
        ttsDrawableLeft = a.getDrawable(R.styleable.TTSRadioButton_ttsDrawableLeft);
        ttsDrawableRight = a.getDrawable(R.styleable.TTSRadioButton_ttsDrawableRight);
        ttsDrawableBottom = a.getDrawable(R.styleable.TTSRadioButton_ttsDrawableBottom);


        ttsDrawableTop_check = a.getDrawable(R.styleable.TTSRadioButton_ttsDrawableTop_check);
        ttsDrawableLeft_check = a.getDrawable(R.styleable.TTSRadioButton_ttsDrawableLeft_check);
        ttsDrawableRight_check = a.getDrawable(R.styleable.TTSRadioButton_ttsDrawableRight_check);
        ttsDrawableBottom_check = a.getDrawable(R.styleable.TTSRadioButton_ttsDrawableBottom_check);
        a.recycle();
        if (isChecked()) {
            setCompoundDrawablesWithIntrinsicBounds(ttsDrawableLeft_check, ttsDrawableTop_check, ttsDrawableRight_check, ttsDrawableBottom_check);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(ttsDrawableLeft, ttsDrawableTop, ttsDrawableRight, ttsDrawableBottom);
        }
    }

    private void init() {

    }

    @Override
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        if (checked) {
            setCompoundDrawablesWithIntrinsicBounds(ttsDrawableLeft_check, ttsDrawableTop_check, ttsDrawableRight_check, ttsDrawableBottom_check);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(ttsDrawableLeft, ttsDrawableTop, ttsDrawableRight, ttsDrawableBottom);
        }
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        super.setOnClickListener(l);
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left,
                                                        Drawable top, Drawable right, Drawable bottom) {

        if (left != null) {
            left.setBounds(0, 0, (int) ((float) (Float.valueOf(widthSize.substring(0, widthSize.length() - 2)))), (int) ((float) (Float.valueOf(heightSize.substring(0, heightSize.length() - 2)))));
        }
        if (right != null) {
            right.setBounds(0, 0, (int) ((float) (Float.valueOf(widthSize.substring(0, widthSize.length() - 2)))), (int) ((float) (Float.valueOf(heightSize.substring(0, heightSize.length() - 2)))));
        }
        if (top != null) {
            top.setBounds(0, 0, (int) ((float) (Float.valueOf(widthSize.substring(0, widthSize.length() - 2)))), (int) ((float) (Float.valueOf(heightSize.substring(0, heightSize.length() - 2)))));
        }
        if (bottom != null) {
            bottom.setBounds(0, 0, (int) ((float) (Float.valueOf(widthSize.substring(0, widthSize.length() - 2)))), (int) ((float) (Float.valueOf(heightSize.substring(0, heightSize.length() - 2)))));
        }
        setCompoundDrawables(left, top, right, bottom);
    }

}

