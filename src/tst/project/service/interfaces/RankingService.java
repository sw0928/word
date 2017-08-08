package tst.project.service.interfaces;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.activity.ActivityBean;
import tst.project.bean.address.LocationBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.merchants.MerchantsLabelBean;
import tst.project.dao.interfaces.RankingDao;
import tst.project.page.PageBean;
import tst.project.utils.BaiduUtils;
import tst.project.utils.DistanceUtils;
import tst.project.utils.NumberUtils;

@Service
@Transactional(rollbackFor = { Exception.class })
public class RankingService {
	@Resource 
	RankingDao  rankingDao;

	@Resource
	MerchantsServiceI merchantsServiceI;
	/**
	 * 热门活动榜
	 * @return
	 */
	public List<ActivityBean> getHotActivitys(ActivityBean activityBean,PageBean pageBean){
		return rankingDao.getHotActivitys(activityBean,pageBean);
	}
	
	/**
	 * 人气店铺(按销量排行)
	 * @return
	 */
	public List<MerchantsBean> getSalesMerchantsRanking(MerchantsBean merchantsBean,PageBean pageBean){
		List<MerchantsBean> merchantsBeans=rankingDao.getSalesMerchantsRanking(merchantsBean, pageBean);
		for (int i = 0; i < merchantsBeans.size(); i++) {
			List<GoodsBean> goodsBeans=merchantsServiceI
					.getMerchantsGoodss(new GoodsBean().setMerchants_id(merchantsBeans.get(i).getMerchants_id()+""), new PageBean().setLimit(3));
			merchantsBeans.get(i).setGoodsBeans(goodsBeans);
		}
		return merchantsBeans;
	}
	
	/**
	 * 人气店铺 标签
	 * @param merchantsLabelBean
	 * @return
	 */
	public List<MerchantsLabelBean> getSalesMerchantsRankingLabel(MerchantsLabelBean merchantsLabelBean){
		return rankingDao.getSalesMerchantsRankingLabel(merchantsLabelBean);
	}
	/**
	 * 热卖榜(按销量排行)
	 * @return
	 */
	public List<GoodsBean> getSalesRanking(GoodsBean goodsBean,LocationBean locationBean,PageBean pageBean){
		List<GoodsBean> goodsBeans=rankingDao.getSalesRanking(goodsBean, pageBean);
		if(goodsBeans!=null){
			for (int i = 0; i < goodsBeans.size(); i++) {
				LocationBean locationBean2=BaiduUtils.getLLByAddress(goodsBeans.get(i).getGoods_address());
				String distance=DistanceUtils.Distan(locationBean,locationBean2);
				goodsBeans.get(i).setDistance(NumberUtils.KeepDecimal(distance,2)+"");
			}
		}
		return goodsBeans;
	}
	
	/**
	 * 热卖榜(分类列表)
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getSalesRankingClass(GoodsBean goodsBean){
		return rankingDao.getSalesRankingClass(goodsBean);
	}
	
	
	/**
	 * 降价榜(分类列表)
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getPriceCutsRankingClass(GoodsBean goodsBean){
		return rankingDao.getPriceCutsRankingClass(goodsBean);
	}
	

	/**
	 * 降价榜(现价于原价的差值)
	 * @return
	 */
	public List<GoodsBean> getPriceCutsRanking(GoodsBean goodsBean,LocationBean locationBean,PageBean pageBean){
		List<GoodsBean> goodsBeans=rankingDao.getPriceCutsRanking(goodsBean, pageBean);
		if(goodsBeans!=null){
			for (int i = 0; i < goodsBeans.size(); i++) {
				LocationBean locationBean2=BaiduUtils.getLLByAddress(goodsBeans.get(i).getGoods_address());
				String distance=DistanceUtils.Distan(locationBean,locationBean2);
				goodsBeans.get(i).setDistance(NumberUtils.KeepDecimal(distance,2)+"");
			}
		}
		return goodsBeans;
	}
	
	/**
	 * 降价榜(现价于原价的差值)
	 * @return
	 */
	public List<GoodsBean> getPriceCutsPCRanking(GoodsBean goodsBean,LocationBean locationBean,PageBean pageBean){
		List<GoodsBean> goodsBeans=rankingDao.getPriceCutsPCRanking(goodsBean, pageBean);
		if(goodsBeans!=null){
			for (int i = 0; i < goodsBeans.size(); i++) {
				LocationBean locationBean2=BaiduUtils.getLLByAddress(goodsBeans.get(i).getGoods_address());
				String distance=DistanceUtils.Distan(locationBean,locationBean2);
				goodsBeans.get(i).setDistance(NumberUtils.KeepDecimal(distance,2)+"");
			}
		}
		return goodsBeans;
	}
	
	/**
	 * 折扣榜(分类列表)
	 * @return
	 */
	public List<GoodsBean> getDiscountRankingClass(GoodsBean goodsBean){
		return rankingDao.getDiscountRankingClass(goodsBean);
	}
	/**
	 * 折扣榜(打折)
	 * @return
	 */
	public List<GoodsBean> getDiscountRanking(GoodsBean goodsBean,LocationBean locationBean,PageBean pageBean){
		List<GoodsBean> goodsBeans=rankingDao.getDiscountRanking(goodsBean, pageBean);
		if(goodsBeans!=null){
			for (int i = 0; i < goodsBeans.size(); i++) {
				LocationBean locationBean2=BaiduUtils.getLLByAddress(goodsBeans.get(i).getGoods_address());
				String distance=DistanceUtils.Distan(locationBean,locationBean2);
				goodsBeans.get(i).setDistance(NumberUtils.KeepDecimal(distance,2)+"");
			}
		}
		return goodsBeans;
	}
}
