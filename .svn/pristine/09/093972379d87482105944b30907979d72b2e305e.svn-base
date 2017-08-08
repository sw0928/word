package tts.moudle.api.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.AbsListView.OnScrollListener;

import tts.moudle.api.utils.TimeUtils;
import tts.moudle.ttsmoduleapi.R;

public class AutoRefreshListView extends ListView implements OnScrollListener {
	private static final String TAG = "MyCusListView===>";
	/** 操作状态:下拉刚开始、回退到顶、一次刷新结束 */
	private static final int Head_DONE = 0x1;
	/** 操作状态:松开即可刷新 */
	private final static int Head_RELEASE_TO_REFRESH = 0x2;
	/** 操作状态:下拉可以刷新 */
	private final static int Head_PULL_TO_REFRESH = 0x3;
	/** 操作状态:正在刷新 */
	private final static int Head_REFRESHING = 0x4;
	/** 操作状态:下拉刚开始、回退到顶、一次刷新结束 */
	private static final int Footer_DONE = 0x5;
	/** 操作状态:松开即可刷新 */
	private final static int Footer_RELEASE_TO_REFRESH = 0x6;
	/** 操作状态:下拉可以刷新 */
	private final static int Footer_PULL_TO_REFRESH = 0x7;
	/** 操作状态:正在刷新 */
	private final static int Footer_REFRESHING = 0x8;

	/** 自定义ListView头布局 */

	private LinearLayout headView;
	/** 刷新提示文本 */

	private TextView txtHeadTip;
	/** 最近刷新时间文本 */

	private TextView txtLastRefresh;
	/** 下拉箭头图标 */

	private ImageView imgRefreshArrow;
	/** 刷新进度条图标 */

	private ProgressBar pbRefreshRound;
	/** headView宽 */

	private int headContentWidth;
	/** headView高 */

	private int headContentHeight;

	/** 下拉时箭头旋转动画 */
	private Animation HeadPullAnim;
	private Animation FooterPullAnim;
	/** 取消时箭头旋转动画 */
	private Animation HeadReserveAnim;
	private Animation FooterReserveAnim;
	/** 标识各种刷新状态 */
	private int Head_refreshState;
	private int Footer_refreshState;
	/** 首次触摸屏幕设为true,松手时设为false,控制一次触摸事件的记录状态 */
	private boolean isHeadRecored = false;
	private boolean isFooterRecored = false;
	/** 手指首次触摸屏幕时Y位置 */
	private int startY;
	/** 手指移动的距离和headView的padding距离的比例,防止移动时headView下拉过长 */
	private final static int RATIO = 3;
	/** 表示已经下拉到可以刷新状态,可以拉回 */
	private boolean isBack = false;
	/** 刷新监听回调接口 */
	private OnRefreshListener refreshListener;
	/** 列表在屏幕顶端第一个完整可见项的position */
	private int firstItemIndex;

	// 向上下拉加载更多
	private LinearLayout footerView;
	private TextView txtFooterTip;
	private TextView txtRecordRefresh;
	private ImageView imgUpRefreshArrow;
	private ProgressBar pbUpRefreshRound;
	private int fotterContentWidth, footerContentHeight;
	private boolean IsUpRefresh = false;// 当listview处于最后一个位置的时候 上拉加载更多
	private boolean IsMoreData = true;// 当现实数据 不能占满一屏幕时 不可加载

	private boolean IsHeadVisible=false;//是否可以下拉刷新
	private boolean IsFooterVisible=false;//是否可以上拉加载

	public boolean isIsHeadVisible() {
		return IsHeadVisible;
	}

	public void setIsHeadVisible(boolean isHeadVisible) {
		IsHeadVisible = isHeadVisible;
	}

	public boolean isIsFooterVisible() {
		return IsFooterVisible;
	}

	public void setIsFooterVisible(boolean isFooterVisible) {
		IsFooterVisible = isFooterVisible;
	}

	public AutoRefreshListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	/** 初始化 */
	private void init(Context context) {
		Log.i(TAG, "init()...");
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
		this.addFooterView(footerView, null, false);

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
		// 将headView添加到自定义的ListView头部
		this.addHeaderView(headView, null, false);
		// 设置ListView的滑动监听
		this.setOnScrollListener(this);
		// 获取箭头旋转动画
		HeadPullAnim = AnimationUtils.loadAnimation(context, R.anim.arrow_rotate);
		HeadReserveAnim = AnimationUtils.loadAnimation(context,
				R.anim.arrow_rotate_reverse);
		FooterPullAnim = AnimationUtils.loadAnimation(context, R.anim.arrow_rotate);
		FooterReserveAnim = AnimationUtils.loadAnimation(context,
				R.anim.arrow_rotate_reverse);
		// 初始刷新状态
		Head_refreshState = Head_DONE;
		Footer_refreshState = Footer_DONE;
	}

	/**
	 * 预估headView的宽高
	 *
	 * @param child
	 */
	private void measureView(View child) {
		Log.i(TAG, "measureView()...");
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
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
						 int visibleItemCount, int totalItemCount) {
		// 记录滚动时列表第一个完整可见项的position
		firstItemIndex = firstVisibleItem;
		IsUpRefresh = (firstVisibleItem + visibleItemCount == totalItemCount);
		IsMoreData = totalItemCount > visibleItemCount;
	}

	/** 监听触摸事件 */
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		if(IsHeadVisible){
			upRefreshData(ev);
		}
		if(IsFooterVisible){
			downMoreData(ev);
		}
		return super.onTouchEvent(ev);
	}

	private void upRefreshData(MotionEvent ev) {
		switch (ev.getAction()) {
			case MotionEvent.ACTION_DOWN:// 第一次触摸时
				if (firstItemIndex == 0) { // 开始记录 isRecored = true; // 获取首次Y位置
					startY = (int) ev.getY();
					Log.i(TAG, "从首次触摸点就开始记录...");
				} else {
					Log.i(TAG, "首次触摸时firstItemIndex不为0,不执行下拉刷新");
				}
				Log.i(TAG, "记录状态isRecored:" + isHeadRecored);
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
					onRefreshing(1);
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
						setSelection(0);
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
						setSelection(0); // 不断改变headView的高度
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
	}

	private void downMoreData(MotionEvent ev) {
		if (IsMoreData) {
			switch (ev.getAction()) {
				case MotionEvent.ACTION_DOWN:// 第一次触摸时
					if (IsUpRefresh) {
						// 开始记录
						isFooterRecored = true;
						// 获取首次Y位置
						startY = (int) ev.getY();
					}
					break;
				case MotionEvent.ACTION_UP:// 松开屏幕时
					// 移除记录
					isFooterRecored = false;
					Log.i(TAG, "停止记录..." + ",isRecored:" + isFooterRecored);
					if (Footer_refreshState == Footer_PULL_TO_REFRESH) {
						Footer_refreshState = Footer_DONE;
						changeFooterView();
						Log.i(TAG, "PULL_TO_REFRESH状态松手,回到原始状态");
					} else if (Footer_refreshState == Footer_RELEASE_TO_REFRESH) {
						Footer_refreshState = Footer_REFRESHING;
						changeFooterView();
						onRefreshing(2);
						Log.i(TAG, "RELEASE_TO_REFRESH状态松手,进入REFRESHING状态");
					} else if (Footer_refreshState == Footer_REFRESHING) {
						if (IsUpRefresh) {
							// 保持刷新状态
							footerView.setPadding(0, 0, 0, 0);
							Log.i(TAG, "REFRESHING状态松手,保持该状态,headView仍在顶部");
						} else {
							Log.i(TAG, "REFRESHING状态松手,保持该状态,headView被推出顶部");
						}
					}
					break;
				case MotionEvent.ACTION_MOVE:// 手势移动时
					int curY = (int) ev.getY();
					if (!isFooterRecored && IsUpRefresh) {
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
	}

	/** 进入刷新的方法 */
	private void onRefreshing(int refreshType) {
		// 调用回调接口中的刷新方法
		if (refreshListener != null) {
			switch (refreshType) {
				case 1:
					refreshListener.toHeadRefresh();
					break;
				case 2:
					refreshListener.toFooterRefresh();
					break;
				default:
					break;
			}
		}
	}

	/** 使用界面传递给此ListView的回调接口,用于两者间通信 */
	public interface OnRefreshListener {
		public void toHeadRefresh();
		public void toFooterRefresh();
	}

	/**
	 * 注册一个用于刷新的回调接口
	 *
	 * @param refreshListener
	 */
	public void setOnRefreshListener(OnRefreshListener refreshListener) {
		// 获取传递过来的回调接口
		this.refreshListener = refreshListener;
	}

	/** 使用界面执行完刷新操作时调用此方法 */
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

	/** 根据上拉的状态改变FoorterView */
	private void changeFooterView() {
		switch (Footer_refreshState) {
			case Footer_DONE:// 开始或结束状态
				Log.i(TAG, "当前状态:DONE");
				// 回退状态清除
				isBack = false;
				// 回复原始高度
				footerView.setPadding(0, 0, 0, -footerContentHeight);
				// 进度条隐藏
				pbUpRefreshRound.setVisibility(View.GONE);
				// 设置原始箭头图片
				imgUpRefreshArrow.setImageResource(R.drawable.indicator_arrow);
				imgUpRefreshArrow.setVisibility(View.VISIBLE);
				txtFooterTip.setText("上拉加载更多...");
				break;
			case Footer_PULL_TO_REFRESH:// 下拉刷新状态
				Log.i(TAG, "当前状态:PULL_TO_REFRESH");
				// 从RELEASE_TO_REFRESH回到PULL_TO_REFRESH状态
				Log.i(TAG, "是否从松开刷新回到下拉刷新...isBack:" + isBack);
				if (isBack) {
					// 设置箭头回转动画
					imgUpRefreshArrow.startAnimation(FooterReserveAnim);
				}
				txtFooterTip.setText("上拉加载更多...");
				break;
			case Footer_RELEASE_TO_REFRESH:
				Log.i(TAG, "当前状态:RELEASE_TO_REFRESH");
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
				Log.i(TAG, "当前状态:REFRESHING");
				break;
		}
	}

	/** 根据上拉的状态改变HeadView */
	private void changeHeadView() {
		switch (Head_refreshState) {
			case Head_DONE:// 开始或结束状态
				Log.i(TAG, "当前状态:DONE"); // 回退状态清除 isBack = false; // 回复原始高度
				headView.setPadding(0, -headContentHeight, 0, 0); // 进度条隐藏
				pbRefreshRound.setVisibility(View.GONE); // 设置原始箭头图片
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

	@Override
	public void setAdapter(ListAdapter adapter) {
		super.setAdapter(adapter);
		txtRecordRefresh.setText("最近更新:"
				+ TimeUtils.getCurrentTimeString("yyyy-MM-dd"));
	}
}
