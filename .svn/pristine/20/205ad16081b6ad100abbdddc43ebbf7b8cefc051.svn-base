package tts.moudle.api.widget.NestedScrollView;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/**
 * Created by sjb on 2016/2/1.
 */
public class ScrollerCompatGingerBreadWithClick {
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static Object createScroller(Context context, Interpolator interpolator) {
        return interpolator != null ?
                new OverScroller(context, interpolator) : new OverScroller(context);
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean isFinished(Object scroller) {
        return ((OverScroller) scroller).isFinished();
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static int getCurrX(Object scroller) {
        return ((OverScroller) scroller).getCurrX();
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static int getCurrY(Object scroller) {
        return ((OverScroller) scroller).getCurrY();
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean computeScrollOffset(Object scroller) {
        return ((OverScroller) scroller).computeScrollOffset();
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static void startScroll(Object scroller, int startX, int startY, int dx, int dy) {
        ((OverScroller) scroller).startScroll(startX, startY, dx, dy);
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static void startScroll(Object scroller, int startX, int startY, int dx, int dy,
                                   int duration) {
        ((OverScroller) scroller).startScroll(startX, startY, dx, dy, duration);
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static void fling(Object scroller, int startX, int startY, int velX, int velY,
                             int minX, int maxX, int minY, int maxY) {
        ((OverScroller) scroller).fling(startX, startY, velX, velY, minX, maxX, minY, maxY);
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static void fling(Object scroller, int startX, int startY, int velX, int velY,
                             int minX, int maxX, int minY, int maxY, int overX, int overY) {
        ((OverScroller) scroller).fling(startX, startY, velX, velY,
                minX, maxX, minY, maxY, overX, overY);
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static void abortAnimation(Object scroller) {
        ((OverScroller) scroller).abortAnimation();
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static void notifyHorizontalEdgeReached(Object scroller, int startX, int finalX,
                                                   int overX) {
        ((OverScroller) scroller).notifyHorizontalEdgeReached(startX, finalX, overX);
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static void notifyVerticalEdgeReached(Object scroller, int startY, int finalY, int overY) {
        ((OverScroller) scroller).notifyVerticalEdgeReached(startY, finalY, overY);
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean isOverScrolled(Object scroller) {
        return ((OverScroller) scroller).isOverScrolled();
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static int getFinalX(Object scroller) {
        return ((OverScroller) scroller).getFinalX();
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static int getFinalY(Object scroller) {
        return ((OverScroller) scroller).getFinalY();
    }

}
