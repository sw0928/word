package tst.project.service.interfaces;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.goods.GoodsBean;
import tst.project.dao.interfaces.IntegralShopDao;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor = Exception.class)
public class IntegralShopService {
	@Resource
	IntegralShopDao integralShopDao;
	
	/**
	 * 获得是否抵扣积分的商品
	 * @return
	 */
	public List<GoodsBean> getIntegralGoodss(GoodsBean goodsBean,PageBean pageBean){
		return integralShopDao.getIntegralGoodss(goodsBean, pageBean);
	}
}
