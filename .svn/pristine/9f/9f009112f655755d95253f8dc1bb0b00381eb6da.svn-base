package tts.moudle.api.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View.MeasureSpec;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

public class WebViewScrollView extends ScrollView {
	private GestureDetector mGestureDetector;
	View.OnTouchListener mGestureListener;

	public WebViewScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		/*
		 * mGestureDetector = new GestureDetector(context, new
		 * YScrollDetector()); setFadingEdgeLength(0);
		 */
	}

	@Override
	/**
	 * 重写该方法，达到使ListView适应ScrollView的效果
	 */
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}

	/*@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			this.requestDisallowInterceptTouchEvent(true);
			break;
		default:
			break;
		}
		return super.onInterceptTouchEvent(ev);
	}*/

	/*
	 * @Override public boolean onInterceptTouchEvent(MotionEvent ev) { return
	 * super.onInterceptTouchEvent(ev) && mGestureDetector.onTouchEvent(ev); }
	 * 
	 * @Override public boolean onTouchEvent(MotionEvent ev) { // TODO
	 * Auto-generated method stub return super.onTouchEvent(ev); }
	 * 
	 * // Return false if we're scrolling in the x direction class
	 * YScrollDetector extends SimpleOnGestureListener {
	 * 
	 * @Override public boolean onScroll(MotionEvent e1, MotionEvent e2, float
	 * distanceX, float distanceY) { if (Math.abs(distanceY) >
	 * Math.abs(distanceX)) { return true; } return false; } }
	 */
}
