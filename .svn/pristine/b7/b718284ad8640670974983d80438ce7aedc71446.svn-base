package tst.project.dao.interfaces;

import java.util.List;

import tst.project.bean.activity.ActivityBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.merchants.MerchantsLabelBean;
import tst.project.page.PageBean;

public interface RankingDao {
	/**
	 * 热门活动榜
	 * @return
	 */
	public List<ActivityBean> getHotActivitys(ActivityBean activityBean,PageBean pageBean);

	/**
	 * 人气店铺(按销量排行)
	 * @return
	 */
	public List<MerchantsBean> getSalesMerchantsRanking(MerchantsBean merchantsBean,PageBean pageBean);
	
	/**
	 * 人气店铺 标签
	 * @param merchantsLabelBean
	 * @return
	 */
	public List<MerchantsLabelBean> getSalesMerchantsRankingLabel(MerchantsLabelBean merchantsLabelBean);
	
	/**
	 * 热卖榜(分类列表)
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getSalesRankingClass(GoodsBean goodsBean);
	
	/**
	 * 热卖榜(按销量排行)
	 * @return
	 */
	public List<GoodsBean> getSalesRanking(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 降价榜(分类列表)
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getPriceCutsRankingClass(GoodsBean goodsBean);
	
	
	/**
	 * 降价榜(现价于原价的差值)
	 * @return
	 */
	public List<GoodsBean> getPriceCutsRanking(GoodsBean goodsBean,PageBean pageBean);
	/**
	 * 降价榜(现价于原价的差值)
	 * @return
	 */
	public List<GoodsBean> getPriceCutsPCRanking(GoodsBean goodsBean,PageBean pageBean);

	/**
	 * 折扣榜(分类列表)
	 * @return
	 */
	public List<GoodsBean> getDiscountRankingClass(GoodsBean goodsBean);
	
	/**
	 * 折扣榜(打折)
	 * @return
	 */
	public List<GoodsBean> getDiscountRanking(GoodsBean goodsBean,PageBean pageBean);
}
