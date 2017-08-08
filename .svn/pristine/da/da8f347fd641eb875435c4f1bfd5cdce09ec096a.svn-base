package tts.moudle.api.widget;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import tts.moudle.api.utils.TimeUtils;
import tts.moudle.ttsmoduleapi.R;

/**
 * Created by sjb on 2016/1/26.
 * @deprecated Use RecyclerViewAutoRefreshUpgraded instead.
 */

@Deprecated
public class RecyclerViewAutoRefresh extends RecyclerView {

    private static final String TAG = "MyCusListView===>";
    /**
     * 操作状态:下拉刚开始、回退到顶、一次刷新结束
     */
    private static final int Head_DONE = 0x1;
    /**
     * 操作状态:松开即可刷新
     */
    private final static int Head_RELEASE_TO_REFRESH = 0x2;
    /**
     * 操作状态:下拉可以刷新
     */
    private final static int Head_PULL_TO_REFRESH = 0x3;
    /**
     * 操作状态:正在刷新
     */
    private final static int Head_REFRESHING = 0x4;

    /**
     * 自定义ListView头布局
     */

    private LinearLayout headView;
    /**
     * 刷新提示文本
     */

    private TextView txtHeadTip;
    /**
     * 最近刷新时间文本
     */

    private TextView txtLastRefresh;
    /**
     * 下拉箭头图标
     */

    private ImageView imgRefreshArrow;
    /**
     * 刷新进度条图标
     */

    private ProgressBar pbRefreshRound;
    /**
     * headView宽
     */

    private int headContentWidth;
    /**
     * headView高
     */

    private int headContentHeight;

    /**
     * 下拉时箭头旋转动画
     */
    private Animation HeadPullAnim;
    /**
     * 取消时箭头旋转动画
     */
    private Animation HeadReserveAnim;
    /**
     * 标识各种刷新状态
     */
    private int Head_refreshState;
    private boolean isHeadRecored = false;
    private boolean headVisible = false;//是否可以下拉刷新

    public boolean isHeadVisible() {
        return headVisible;
    }

    public void setHeadVisible(boolean headVisible) {
        this.headVisible = headVisible;
    }

    public void setIsHead(boolean headVisible) {
        this.headVisible = headVisible;
    }

    private int firstItemIndex = 0;
    /**
     * item 类型
     */
    public final static int TYPE_NORMAL = 0;
    public final static int TYPE_HEADER = 1;//头部--支持头部增加一个headerView
    public final static int TYPE_FOOTER = 2;//底部--往往是loading_more
    public final static int TYPE_LIST = 3;//代表item展示的模式是list模式
    public final static int TYPE_STAGGER = 4;//代码item展示模式是网格模式

    private boolean mIsLoadMore = false;//是否拉生到最后一列了
    private boolean loadMore = false;//是否支持加载更多

    public boolean isLoadMore() {
        return loadMore;
    }

    public void setLoadMore(boolean loadMore) {
        this.loadMore = loadMore;
    }

    public void setIsFooter(boolean loadMore) {
        this.loadMore = loadMore;
    }

    /**
     * 自定义实现了头部和底部加载更多的adapter
     */
    private AutoLoadAdapter mAutoLoadAdapter;

    /**
     * 加载更多的监听-业务需要实现加载数据
     */
    private OnRefreshListener mListener;

    // 向上下拉加载更多
    private LinearLayout footerView;
    private TextView txtFooterTip;
    private TextView txtRecordRefresh;
    private ImageView imgUpRefreshArrow;
    private ProgressBar pbUpRefreshRound;
    private int fotterContentWidth, footerContentHeight;
    private Animation FooterReserveAnim;
    private Animation FooterPullAnim;

    private Context context;


    //private View suspensionView;//悬浮View


    public RecyclerViewAutoRefresh(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public RecyclerViewAutoRefresh(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public RecyclerViewAutoRefresh(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init();
    }

    /**
     * 初始化-添加滚动监听
     * <p/>
     * 回调加载更多方法，前提是
     * <pre>
     *    1、有监听并且支持加载更多：null != mListener && mIsFooterEnable
     *    2、目前没有在加载，正在上拉（dy>0），当前最后一条可见的view是否是当前数据列表的最好一条--及加载更多
     * </pre>
     */
    private void init() {
        // 获取自定义头view
        headView = (LinearLayout) LayoutInflater.from(context).inflate(
                R.layout.listview_header, null);
        // // 获取headView中控件
        imgRefreshArrow = (ImageView) headView
                .findViewById(R.id.imgRefreshArrow);
        pbRefreshRound = (ProgressBar) headView
                .findViewById(R.id.pbRefreshRound);
        txtHeadTip = (TextView) headView.findViewById(R.id.txtHeadTip);
        txtLastRefresh = (TextView) headView.findViewById(R.id.txtLastRefresh);
        // 预估headView宽高
        measureView(headView);
        // 获取headView宽高
        headContentWidth = headView.getMeasuredWidth();
        headContentHeight = headView.getMeasuredHeight();
        Log.i(TAG, "headView宽:[" + headContentWidth + "],高:["
                + headContentHeight + "]");
        // 设置headView的padding值,topPadding为其本身的负值,达到在屏幕中隐藏的效果
        headView.setPadding(0, -headContentHeight, 0, 0);
        // 重绘headView
        headView.invalidate();

        // 获取箭头旋转动画
        HeadPullAnim = AnimationUtils.loadAnimation(context, R.anim.arrow_rotate);
        HeadReserveAnim = AnimationUtils.loadAnimation(context,
                R.anim.arrow_rotate_reverse);
        // 初始刷新状态
        Head_refreshState = Head_DONE;


        // 上拉加载更多
        footerView = (LinearLayout) LayoutInflater.from(context).inflate(
                R.layout.listview_footer, null);
        // 获取headView中控件
        imgUpRefreshArrow = (ImageView) footerView
                .findViewById(R.id.imgUpRefreshArrow);
        pbUpRefreshRound = (ProgressBar) footerView
                .findViewById(R.id.pbUpRefreshRound);
        txtFooterTip = (TextView) footerView.findViewById(R.id.txtFooterTip);
        txtRecordRefresh = (TextView) footerView
                .findViewById(R.id.txtRecordRefresh);
        measureView(footerView);
        fotterContentWidth = footerView.getMeasuredWidth();
        footerContentHeight = footerView.getMeasuredHeight();
        footerView.setPadding(0, 0, 0, -footerContentHeight);
        footerView.invalidate();

        FooterPullAnim = AnimationUtils.loadAnimation(context, R.anim.arrow_rotate);
        FooterReserveAnim = AnimationUtils.loadAnimation(context,
                R.anim.arrow_rotate_reverse);
        Footer_refreshState = Footer_DONE;

        super.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                firstItemIndex = getFirstVisiblePosition() - 1;
                if (firstItemIndex <= 0) {//防止第一次进来 getFirstVisiblePosition()为0
                    firstItemIndex = 0;
                }
                int lastVisiblePosition = getLastVisiblePosition();
                mIsLoadMore = lastVisiblePosition >= mAutoLoadAdapter.getItemCount() - 2;
            }
        });
    }

    /**
     * 预估headView的宽高
     *
     * @param child
     */
    private void measureView(View child) {
        Log.i("", "measureView()...");
        ViewGroup.LayoutParams p = child.getLayoutParams();
        if (p == null) {
            p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 + 0, p.width);
        int lpHeight = p.height;
        int childHeightSpec;
        if (lpHeight > 0) {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight,
                    MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0,
                    MeasureSpec.UNSPECIFIED);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }


    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if (headVisible) {
            upRefreshData(e);
        }
        if (loadMore) {
            loadMoreEvent(e);
        }
        return super.onTouchEvent(e);
    }

    private boolean upRefreshData(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:// 第一次触摸时
                if (firstItemIndex == 0) { // 开始记录 isRecored = true; // 获取首次Y位置
                    isHeadRecored = true;
                    startY = (int) ev.getY();
                    Log.i(TAG, "从首次触摸点就开始记录...");
                } else {
                    Log.i(TAG, "首次触摸时firstItemIndex不为0,不执行下拉刷新");
                }
                Log.i(TAG, "记录状态isRecored:" + isHeadRecored);
              /*  if(mAutoLoadAdapter==null||mAutoLoadAdapter.getItemCount()<=2){
                    return true;
                }*/
                break;
            case MotionEvent.ACTION_UP:// 松开屏幕时
                // 移除记录
                isHeadRecored = false;
                Log.i(TAG, "停止记录..." + ",isRecored:" + isHeadRecored);
                if (Head_refreshState == Head_PULL_TO_REFRESH) {
                    Head_refreshState = Head_DONE;
                    changeHeadView();
                    Log.i(TAG, "PULL_TO_REFRESH状态松手,回到原始状态");
                } else if (Head_refreshState == Head_RELEASE_TO_REFRESH) {
                    Head_refreshState = Head_REFRESHING;
                    changeHeadView();
                    if (mListener != null) {
                        mListener.onRefreshData();
                    }
                    Log.i(TAG, "RELEASE_TO_REFRESH状态松手,进入REFRESHING状态");
                } else if (Head_refreshState == Head_REFRESHING) {
                    if (firstItemIndex == 0) { // 保持刷新状态
                        headView.setPadding(0, 0, 0, 0);
                        Log.i(TAG, "REFRESHING状态松手,保持该状态,headView仍在顶部");
                    } else {
                        Log.i(TAG, "REFRESHING状态松手,保持该状态,headView被推出顶部");
                    }
                }

                break;
            case MotionEvent.ACTION_MOVE:// 手势移动时
                // 记录实时的手指移动时在屏幕的Y位置,用于和startY比较
                int curY = (int) ev.getY();
                if (!isHeadRecored && firstItemIndex == 0) {
                    isHeadRecored = true;
                    Log.i(TAG, "从移动状态执行下拉刷新,开始记录..." + ",isRecored:" + isHeadRecored);
                    startY = curY;
                }

                if (isHeadRecored) { // 开始或结束状态
                    if (Head_refreshState == Head_DONE) {
                        if (curY - startY > 0) {// 表示向下拉了 // 状态改为下拉刷新
                            Head_refreshState = Head_PULL_TO_REFRESH;
                            changeHeadView();
                        }
                    }
                    // 下拉刷新状态
                    if (Head_refreshState == Head_PULL_TO_REFRESH) {
                        //setSelection(0);
                        // 不断改变headView的高度
                        headView.setPadding(0, (curY - startY) / RATIO
                                - headContentHeight, 0, 0); // 下拉到RELEASE_TO_REFRESH状态
                        if ((curY - startY) / RATIO >= headContentHeight * 1.5) {
                            Head_refreshState = Head_RELEASE_TO_REFRESH;
                            isBack = true;
                            changeHeadView();
                        } else if ((curY - startY) <= 0) { // 上推到顶
                            Head_refreshState = Head_DONE;
                            changeHeadView();
                        }
                    }
                    // 松手可以刷新状态
                    if (Head_refreshState == Head_RELEASE_TO_REFRESH) {
                        //setSelection(0); // 不断改变headView的高度
                        headView.setPadding(0, (curY - startY) / RATIO
                                - headContentHeight, 0, 0); // 又往上推
                        if ((curY - startY) / RATIO < headContentHeight * 1.5) {
                            Head_refreshState = Head_PULL_TO_REFRESH;
                            changeHeadView();
                        }
                    }
                    // 正在刷新状态
                    if (Head_refreshState == Head_REFRESHING) {
                        if (curY - startY > 0) { // 只改变padding值,不做其余处理
                            headView.setPadding(0, (curY - startY) / RATIO, 0, 0);
                        }
                    }
                }

                break;
        }

        return super.onTouchEvent(ev);
    }

    /**
     * 根据上拉的状态改变HeadView
     */
    private void changeHeadView() {
        switch (Head_refreshState) {
            case Head_DONE:// 开始或结束状态
                Log.i(TAG, "当前状态:DONE"); // 回退状态清除 isBack = false; // 回复原始高度
                headView.setPadding(0, -headContentHeight, 0, 0); // 进度条隐藏
                pbRefreshRound.setVisibility(View.INVISIBLE); // 设置原始箭头图片
                imgRefreshArrow.setImageResource(R.drawable.indicator_arrow);
                imgRefreshArrow.setVisibility(View.VISIBLE);
                txtHeadTip.setText("下拉可以刷新...");
                break;
            case Head_PULL_TO_REFRESH:// 下拉刷新状态
                Log.i(TAG, "当前状态:PULL_TO_REFRESH"); // 从RELEASE_TO_REFRESH回到PULL_TO_REFRESH状态
                Log.i(TAG, "是否从松开刷新回到下拉刷新...isBack:" + isBack);
                if (isBack) { // 设置箭头回转动画
                    imgRefreshArrow.startAnimation(HeadReserveAnim);
                }
                txtHeadTip.setText("下拉可以刷新...");
                break;
            case Head_RELEASE_TO_REFRESH:
                Log.i(TAG, "当前状态:RELEASE_TO_REFRESH"); // 设置箭头旋转动画
                imgRefreshArrow.startAnimation(HeadPullAnim);
                txtHeadTip.setText("松开即可刷新...");
                break;
            case Head_REFRESHING:
                // 保持headView在屏幕顶端显示
                headView.setPadding(0, 0, 0, 0);
                // 显示出进度条
                pbRefreshRound.setVisibility(View.VISIBLE);
                // 隐藏箭头图标
                imgRefreshArrow.clearAnimation();
                imgRefreshArrow.setVisibility(View.GONE);
                txtHeadTip.setText("正在加载...");
                Log.i(TAG, "当前状态:REFRESHING");
                break;
        }
    }

    /**
     * 手指首次触摸屏幕时Y位置
     */
    private int startY;
    /**
     * 手指移动的距离和headView的padding距离的比例,防止移动时headView下拉过长
     */
    private final static int RATIO = 3;

    private boolean isFooterRecored = false;

    protected void loadMoreEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:// 第一次触摸时// 开始记录
                if (mIsLoadMore) {
                    isFooterRecored = true;
                    startY = (int) ev.getY();
                }
                break;
            case MotionEvent.ACTION_UP:// 松开屏幕时
                // 移除记录
                isFooterRecored = false;

                if (Footer_refreshState == Footer_PULL_TO_REFRESH) {
                    Footer_refreshState = Footer_DONE;
                    changeFooterView();
                } else if (Footer_refreshState == Footer_RELEASE_TO_REFRESH) {
                    Footer_refreshState = Footer_REFRESHING;
                    changeFooterView();
                    if (mListener != null) {
                        mListener.onLoadMore();
                    }
                } else if (Footer_refreshState == Footer_REFRESHING) {
                    if (mIsLoadMore) {
                        footerView.setPadding(0, 0, 0, 0);
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:// 手势移动时
                int curY = (int) ev.getY();
                if (!isFooterRecored && mIsLoadMore) {
                    isFooterRecored = true;
                    startY = curY;
                }
                if (isFooterRecored) {
                    // 开始或结束状态
                    if (Footer_refreshState == Footer_DONE) {
                        if (curY - startY < 0) {// 表示向上拉了
                            // 状态改为下拉刷新
                            Footer_refreshState = Footer_PULL_TO_REFRESH;
                            changeFooterView();
                        }
                    }

                    // 下拉刷新状态
                    if (Footer_refreshState == Footer_PULL_TO_REFRESH) {
                        // setSelection(0);
                        // 不断改变headView的高度
                        footerView.setPadding(0, 0, 0, (startY - curY) / RATIO
                                - footerContentHeight);
                        // 下拉到RELEASE_TO_REFRESH状态
                        if ((startY - curY) / RATIO >= footerContentHeight * 1.5) {
                            Footer_refreshState = Footer_RELEASE_TO_REFRESH;
                            isBack = true;
                            changeFooterView();
                        } else if ((startY - curY) <= 0) {
                            // 上推到顶
                            Footer_refreshState = Footer_DONE;
                            changeFooterView();
                        }
                    }

                    // 松手可以刷新状态
                    if (Footer_refreshState == Footer_RELEASE_TO_REFRESH) {
                        // setSelection(0);
                        // 不断改变headView的高度
                        footerView.setPadding(0, 0, 0, (startY - curY) / RATIO
                                - footerContentHeight);
                        // 又往上推
                        if ((startY - curY) / RATIO < footerContentHeight * 1.5) {
                            Footer_refreshState = Footer_PULL_TO_REFRESH;
                            changeFooterView();
                        }
                    }

                    // 正在刷新状态
                    if (Footer_refreshState == Footer_REFRESHING) {
                        if (startY - curY > 0) {
                            // 只改变padding值,不做其余处理
                            footerView.setPadding(0, 0, 0, (startY - curY)
                                    / RATIO);
                        }
                    }
                }
                break;
        }

    }

    private int Footer_refreshState;

    private static final int Footer_DONE = 0x5;
    /**
     * 操作状态:松开即可刷新
     */
    private final static int Footer_RELEASE_TO_REFRESH = 0x6;
    /**
     * 操作状态:下拉可以刷新
     */
    private final static int Footer_PULL_TO_REFRESH = 0x7;
    /**
     * 操作状态:正在刷新
     */
    private final static int Footer_REFRESHING = 0x8;


    private boolean isBack = false;

    /**
     * 根据上拉的状态改变FoorterView
     */
    private void changeFooterView() {
        switch (Footer_refreshState) {
            case Footer_DONE:// 开始或结束状态
                isBack = false;
                // 回复原始高度
                footerView.setPadding(0, 0, 0, -footerContentHeight);
                // 进度条隐藏
                pbUpRefreshRound.setVisibility(View.INVISIBLE);
                // 设置原始箭头图片
                imgUpRefreshArrow.setImageResource(R.drawable.indicator_arrow);
                imgUpRefreshArrow.setVisibility(View.VISIBLE);
                txtFooterTip.setText("上拉加载更多...");
                break;
            case Footer_PULL_TO_REFRESH:// 下拉刷新状态
                if (isBack) {
                    // 设置箭头回转动画
                    imgUpRefreshArrow.startAnimation(FooterReserveAnim);
                }
                txtFooterTip.setText("上拉加载更多...");
                break;
            case Footer_RELEASE_TO_REFRESH:
                // 设置箭头旋转动画
                imgUpRefreshArrow.startAnimation(FooterPullAnim);
                txtFooterTip.setText("松开即可加载...");
                break;
            case Footer_REFRESHING:
                // 保持headView在屏幕顶端显示
                footerView.setPadding(0, 0, 0, 0);
                // 显示出进度条
                pbUpRefreshRound.setVisibility(View.VISIBLE);
                // 隐藏箭头图标
                imgUpRefreshArrow.clearAnimation();
                imgUpRefreshArrow.setVisibility(View.GONE);
                txtFooterTip.setText("正在加载...");
                break;
        }
    }


    /**
     * 设置加载更多的监听
     *
     * @param listener
     */
    public void setOnRefreshListener(OnRefreshListener listener) {
        mListener = listener;
    }


    /**
     * 加载更多监听
     */
    public interface OnRefreshListener {
        /**
         * 加载更多
         */
        void onLoadMore();

        void onRefreshData();
    }


    /**
     *
     */
    public class AutoLoadAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        /**
         * 数据adapter
         */
        private RecyclerView.Adapter mInternalAdapter;

        public AutoLoadAdapter(RecyclerView.Adapter adapter) {
            mInternalAdapter = adapter;
        }

        @Override
        public int getItemViewType(int position) {
            int headerPosition = 0;
            int footerPosition = getItemCount() - 1;
            if (headerPosition == position) {
                return TYPE_HEADER;
            }
            if (footerPosition == position) {
                return TYPE_FOOTER;
            }
            /**
             * 这么做保证layoutManager切换之后能及时的刷新上对的布局
             */
            if (getLayoutManager() instanceof LinearLayoutManager) {
                return mInternalAdapter.getItemViewType(position);
            } else if (getLayoutManager() instanceof StaggeredGridLayoutManager) {
                return TYPE_STAGGER;
            } else {
                return TYPE_NORMAL;
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == TYPE_HEADER) {
                return new HeaderViewHolder(headView);
            }
            if (viewType == TYPE_FOOTER) {
                return new FooterViewHolder(footerView);
            } else {
                return mInternalAdapter.onCreateViewHolder(parent, viewType);
            }
        }

        public class FooterViewHolder extends RecyclerView.ViewHolder {

            public FooterViewHolder(View itemView) {
                super(itemView);
            }
        }

        public class HeaderViewHolder extends RecyclerView.ViewHolder {
            public HeaderViewHolder(View itemView) {
                super(itemView);
            }
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            int type = getItemViewType(position);
            if (type != TYPE_FOOTER && type != TYPE_HEADER) {
                mInternalAdapter.onBindViewHolder(holder, position);
            }
        }

        /**
         * 需要计算上加载更多和添加的头部俩个
         *
         * @return
         */
        @Override
        public int getItemCount() {
            int count = mInternalAdapter.getItemCount();
            count += 2;
            return count;
        }

    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            mAutoLoadAdapter = new AutoLoadAdapter(adapter);
        }
        super.swapAdapter(mAutoLoadAdapter, true);
    }

    /**
     * 切换layoutManager
     * <p/>
     * 为了保证切换之后页面上还是停留在当前展示的位置，记录下切换之前的第一条展示位置，切换完成之后滚动到该位置
     * 另外切换之后必须要重新刷新下当前已经缓存的itemView，否则会出现布局错乱（俩种模式下的item布局不同），
     * RecyclerView提供了swapAdapter来进行切换adapter并清理老的itemView cache
     *
     * @param layoutManager
     */
    public void switchLayoutManager(LayoutManager layoutManager) {
        int firstVisiblePosition = getFirstVisiblePosition();
//        getLayoutManager().removeAllViews();
        setLayoutManager(layoutManager);
        //super.swapAdapter(mAutoLoadAdapter, true);
        getLayoutManager().scrollToPosition(firstVisiblePosition);
    }

    /**
     * 获取第一条展示的位置
     *
     * @return
     */
    private int getFirstVisiblePosition() {
        int position;
        if (getLayoutManager() instanceof LinearLayoutManager) {
            position = ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
        } else if (getLayoutManager() instanceof GridLayoutManager) {
            position = ((GridLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
        } else if (getLayoutManager() instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager layoutManager = (StaggeredGridLayoutManager) getLayoutManager();
            int[] lastPositions = layoutManager.findFirstVisibleItemPositions(new int[layoutManager.getSpanCount()]);
            position = getMinPositions(lastPositions);
        } else {
            position = 0;
        }
        return position;
    }

    /**
     * 获得当前展示最小的position
     *
     * @param positions
     * @return
     */
    private int getMinPositions(int[] positions) {
        int size = positions.length;
        int minPosition = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            minPosition = Math.min(minPosition, positions[i]);
        }
        return minPosition;
    }

    /**
     * 获取最后一条展示的位置
     *
     * @return
     */
    private int getLastVisiblePosition() {
        int position;
        if (getLayoutManager() instanceof LinearLayoutManager) {
            position = ((LinearLayoutManager) getLayoutManager()).findLastVisibleItemPosition();
        } else if (getLayoutManager() instanceof GridLayoutManager) {
            position = ((GridLayoutManager) getLayoutManager()).findLastVisibleItemPosition();
        } else if (getLayoutManager() instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager layoutManager = (StaggeredGridLayoutManager) getLayoutManager();
            int[] lastPositions = layoutManager.findLastVisibleItemPositions(new int[layoutManager.getSpanCount()]);
            position = getMaxPosition(lastPositions);
        } else {
            position = getLayoutManager().getItemCount() - 1;
        }
        return position;
    }

    /**
     * 获得最大的位置
     *
     * @param positions
     * @return
     */
    private int getMaxPosition(int[] positions) {
        int size = positions.length;
        int maxPosition = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            maxPosition = Math.max(maxPosition, positions[i]);
        }
        return maxPosition;
    }

    /**
     * 使用界面执行完刷新操作时调用此方法
     */
    public void onRefreshFinished(boolean IsRefreshSuccess) {
        Head_refreshState = Head_DONE;
        Footer_refreshState = Footer_DONE;
        changeHeadView();
        changeFooterView();
        if (IsRefreshSuccess) {// 更新失败的时候 不更新时间
            // 显示最近更新
            txtRecordRefresh.setText("最近更新:"
                    + TimeUtils.getCurrentTimeString("yyyy-MM-dd"));
        }
    }

    /**
     * 使用界面执行完刷新操作时调用此方法
     */
    public void setOnRefreshFinished(boolean IsRefreshSuccess) {
        Head_refreshState = Head_DONE;
        Footer_refreshState = Footer_DONE;
        changeHeadView();
        changeFooterView();
        if (IsRefreshSuccess) {// 更新失败的时候 不更新时间
            // 显示最近更新
            txtRecordRefresh.setText("最近更新:"
                    + TimeUtils.getCurrentTimeString("yyyy-MM-dd"));
        }
    }
}

