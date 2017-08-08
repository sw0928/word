package tst.project.dao.interfaces;

import java.util.List;

import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsClassBean;
import tst.project.bean.goods.GoodsImgBean;
import tst.project.bean.goods.GoodsLabelBean;
import tst.project.bean.goods.GoodsParameterBean;
import tst.project.bean.member.MemberBean;
import tst.project.page.PageBean;

public interface GoodsDaoI2 {
	
	/**
	 * 单个商品详情
	 * @param goodsBean
	 * @return
	 */
	public GoodsBean getOneGoodsDetail(GoodsBean goodsBean);
	
	/**
	 * 获得参数 根据no
	 * @param goodsParameterBean
	 * @return
	 */
	public List<GoodsParameterBean> getGoodsParametersByNo(GoodsParameterBean goodsParameterBean);
	
	/**
	 * 商品列表 根据no
	 * @param memberBean
	 * @return
	 */
	public List<GoodsBean> getGoodsDetailByGoodsNo(GoodsBean goodsBean);
	
	/**
	 * 获得用户购买的商品列表
	 * @param memberBean
	 * @return
	 */
	public List<GoodsBean> getMemberOrderGoods(MemberBean memberBean);
	
	/**
	 *  猜你喜欢--根据用户购买等习惯。。。。。
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getLoveGoodsByHabit(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 *  猜你喜欢--根据用户购买等习惯。。。。。
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getLoveClassByHabit1(GoodsBean goodsBean);
	
	/**
	 *  猜你喜欢--根据用户购买等习惯。。。。。
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getLoveClassByHabit2(GoodsBean goodsBean);
	
	/**
	 *  猜你喜欢--根据用户购买等习惯。。。。。
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getLoveClassByHabit3(GoodsBean goodsBean);
	
	/**
	 * 修改商品详情
	 * @param goodsBean
	 * @return
	 */
	public int updateGoodsDetail(GoodsBean goodsBean);
	
	/**
	 * 修改商品星级
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int updateGoodsDetailStart(GoodsBean goodsBean) ;
	
	/**
	 * 根据各种条件 搜索商品列表
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> searchGoodsDetailList(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 分类列表
	 * @param goodsClassBean
	 * @return
	 */
	public List<GoodsClassBean> getGoodsClasss(GoodsClassBean goodsClassBean);
}
