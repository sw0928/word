package tst.project.dao.interfaces;

import java.util.List;

import tst.project.bean.goods.GoodsBean;
import tst.project.page.PageBean;

public interface IntegralShopDao {
	/**
	 * 获得是否抵扣积分的商品
	 * @return
	 */
	public List<GoodsBean> getIntegralGoodss(GoodsBean goodsBean,PageBean pageBean);
	
	
}
