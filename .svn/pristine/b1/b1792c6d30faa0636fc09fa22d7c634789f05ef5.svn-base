package tts.moudle.api.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import tts.moudle.api.utils.TextUtils;
import tts.moudle.ttsmoduleapi.R;

/**
 * Created by sjb on 2016/3/15.
 */
public class ProgressBarUpdate extends View {
    private float progress;
    private Paint paint;
    private Paint paintBack;
    private Paint paintText;
    private String msg = "开始更新";

    public void setProgress(float progress) {
        this.progress = progress;
        msg=String .format("%.2f",(progress * 100))+"%";
        invalidate();
    }

    private boolean isClick=false;//是否点击

    public ProgressBarUpdate(Context context) {
        super(context);
    }

    public ProgressBarUpdate(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressBarUpdate(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.ProgressBarUpdate);
        progress = a.getInteger(R.styleable.ProgressBarUpdate_progress, 0);
        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (paint == null) {
            paint = new Paint();
            paint.setColor(getResources().getColor(R.color.RGB240_240_240));
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(getResources().getDimensionPixelOffset(R.dimen.y10));
        }
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getResources().getDimensionPixelOffset(R.dimen.y100), paint);
        if (paintBack == null) {
            paintBack = new Paint();
            paintBack.setColor(getResources().getColor(R.color.colorPrimary));
            paintBack.setAntiAlias(true);
            paintBack.setStyle(Paint.Style.STROKE);
            paintBack.setStrokeWidth(getResources().getDimensionPixelOffset(R.dimen.y10));
        }
        RectF oval = new RectF(getWidth() / 2 - getResources().getDimensionPixelOffset(R.dimen.y100), getHeight() / 2 - getResources().getDimensionPixelOffset(R.dimen.y100), getWidth() / 2 + getResources().getDimensionPixelOffset(R.dimen.y100), getHeight() / 2 + getResources().getDimensionPixelOffset(R.dimen.y100));
        canvas.drawArc(oval, -180, progress*360, false, paintBack);

        if (paintText == null) {
            paintText = new Paint();
            paintText.setColor(getResources().getColor(R.color.colorPrimary));
            paintText.setAntiAlias(true);
            //paintText.setTextAlign(Paint.Align.CENTER);
            paintText.setTextSize(getResources().getDimensionPixelOffset(R.dimen.y30));
        }
        Paint.FontMetricsInt fmi = paintText.getFontMetricsInt();
        canvas.drawText(msg, (getWidth() - paintText.measureText(msg)) / 2, (oval.bottom + oval.top - fmi.bottom - fmi.top) / 2, paintText);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(event.getX()>getWidth()/2-getResources().getDimensionPixelOffset(R.dimen.y100)
                        &&event.getX()<getWidth()/2+getResources().getDimensionPixelOffset(R.dimen.y100)
                        &&event.getY()>getHeight()/2-getResources().getDimensionPixelOffset(R.dimen.y100)
                        &&event.getY()<getHeight()/2+getResources().getDimensionPixelOffset(R.dimen.y100)){
                    if(listener!=null){
                        if(!isClick){
                            isClick=true;
                            listener.doClick();
                        }
                    }
                }
                break;
        }

        return super.onTouchEvent(event);
    }

    private OnClickListener listener;
    public void setOnClickListener(OnClickListener listener){
        this.listener=listener;
    }
    public interface OnClickListener {
        void doClick() ;
    }
}
