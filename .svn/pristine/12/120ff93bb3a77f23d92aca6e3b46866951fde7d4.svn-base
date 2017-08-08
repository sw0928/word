package tst.project.dao.interfaces;

import java.util.List;

import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsClassBean;
import tst.project.bean.home.ActivityBean;
import tst.project.bean.home.HomeGoodsBean;
import tst.project.bean.home.LabelBean;
import tst.project.bean.member.BillBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.ShareBean;
import tst.project.page.PageBean;

public interface HBRDao {
	/**
	 * 储值卡消费记录
	 * @return
	 */
	public List<BillBean> getMemberStoredRecord(BillBean billBean,PageBean pageBean);
	/**
	 * 根据储值卡号 获得用户信息
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByStore(MemberBean memberBean);
	
	/**
	 * 用户绑定储值卡
	 * @return
	 */
	public int bindMemberStored(MemberBean memberBean);
	/**
	 * 用户分享过的某一个商品
	 * @param shareBean
	 * @return
	 */
	public ShareBean getMemberShareByMemberIDAndGoodsID(ShareBean shareBean);
	/**
	 * 用户分享商品得积分
	 * @param shareBean
	 * @return
	 */
	public int insertMemberShare(ShareBean shareBean);
	/**
	 * 可分享的商品列表
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getShareGoodss(GoodsBean goodsBean,PageBean pageBean);
	/**
	 * 首页商品（何柏瑞）
	 * @return
	 */
	public List<HomeGoodsBean> getHomeGoods(HomeGoodsBean homeGoodsBean);
	
	/**
	 * 首页分类
	 * @return
	 */
	public List<GoodsBean> getHomeClasss(GoodsBean goodsBean);
	/**
	 * 首页分类
	 * @return
	 */
	public List<GoodsClassBean> getHomeClasss2(GoodsClassBean goodsClassBean);
	
	/**
	 * 首页标签（何柏瑞）
	 * @param labelBean
	 * @return
	 */
	public List<LabelBean> getHomeLabels(LabelBean labelBean);
	
	/**
	 * 首页活动（）
	 * @param activityBean
	 * @return
	 */
	public List<ActivityBean> getHomeActivitys(ActivityBean activityBean);
}
