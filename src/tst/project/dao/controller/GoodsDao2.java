package tst.project.dao.controller;

import java.util.List;
import java.util.Map;

import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsClassBean;
import tst.project.bean.goods.GoodsParameterBean;
import tst.project.bean.goods.GoodsRelationClassBean;
import tst.project.bean.goods.TagBean;
import tst.project.bean.goods.TimingGoodsBean;
import tst.project.page.PageBean;

/**
 * 商品管理
 * 版本2.0
 * 改善 一个商品 可在多个分类下  规格对应库存的问题
 * @author shenjiabo
 */
public interface GoodsDao2 {
	
	/**
	 * 
	 * @return
	 */
	public List<Map> getGoodsSales(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 删除定时记录
	 * @param timingGoodsBean
	 * @return
	 */
	public int deleteTimingGoods(TimingGoodsBean timingGoodsBean);
	/**
	 * 定时记录列表
	 * @param timingGoodsBean
	 * @param pageBean
	 * @return
	 */
	public List<TimingGoodsBean> getTimingGoodss(TimingGoodsBean timingGoodsBean,PageBean pageBean);
	
	/**
	 * 添加定时商品
	 * @param goodsBean
	 * @return
	 */
	public int insertGoodsTiming(TimingGoodsBean timingGoodsBean);
	/**
	 * 根据sku获得商品详情
	 * @param goodsBean
	 * @return
	 */
	public GoodsBean getGoodsBySku(GoodsBean goodsBean);
	
	/**
	 * 搜索商品列表
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> searchGoods(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 添加商品tag
	 * @return
	 */
	public int insertGoodsTag(TagBean tagBean);
	
	/**
	 * 修改商品tag
	 * @return
	 */
	public int updateGoodsTag(TagBean tagBean);
	
	/**
	 * 删除商品tag
	 * @return
	 */
	public int deleteGoodsTag(TagBean tagBean);
	
	/**
	 * 获得商品Tag
	 * @param tagBean
	 * @param pageBean
	 * @return
	 */
	public List<TagBean> getGoodsTags(TagBean tagBean,PageBean pageBean);
	
	
	/**
	 * 修改商品
	 * @return
	 */
	public int updateGoodsDetail(GoodsBean goodsBean);
	/**
	 * 保存商品
	 * @param goodsBean
	 * @return
	 */
	public int insertGoodsDetail(GoodsBean goodsBean);
	
	/**
	 * 获得商品 根据no
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getGoodsByNo(GoodsBean goodsBean);
	
	/**
	 * 获得参数 根据no
	 * @param goodsParameterBean
	 * @return
	 */
	public List<GoodsParameterBean> getGoodsParametersByNo(GoodsParameterBean goodsParameterBean);
	/**
	 * 添加商品规格
	 * @param goodsParameterBean
	 * @return
	 */
	public int insertGoodsParameter(GoodsParameterBean goodsParameterBean);
	/**
	 * 通过分类id和商品id 获得商品信息
	 * @param goodsRelationClassBean
	 * @return
	 */
	public GoodsRelationClassBean getClassGoodsByClassAndGodosId(GoodsRelationClassBean goodsRelationClassBean);
	/**
	 * 删除分类下商品
	 * @param goodsRelationClassBean
	 * @return
	 */
	public int deleteClassGoods(GoodsRelationClassBean goodsRelationClassBean);
 	/**
	 * 添加分类下商品
	 * @param goodsClassBean
	 * @return
	 */
	public int insertClassGoods(GoodsRelationClassBean goodsRelationClassBean);
	
	/**
	 * 分类下商品列表
	 * @return
	 */
	public  List<GoodsBean> getClassGoods(GoodsBean goodsBean,PageBean pageBean);
	
	
	/**
	 * 添加商品分类
	 * @return
	 */
	public int insertGoodsClass(GoodsClassBean goodsClassBean);
	
	/**
	 * 修改整个分类下 包邮或者不包邮
	 * @param goodsClassBean
	 * @return
	 */
	public int updateClassExpress(GoodsClassBean goodsClassBean);
	
	/**
	 * 修改商品分类
	 * @return
	 */
	public int updateGoodsClass(GoodsClassBean goodsClassBean);
	
	/**
	 * 删除商品分类
	 * @return
	 */
	public int deleteGoodsClass(GoodsClassBean goodsClassBean);
	
	/**
	 * 获得商品分类
	 * @return
	 */
	public  List<GoodsClassBean> getGoodsClasss(GoodsClassBean goodsClassBean,PageBean pageBean);
	
	/**
	 * 获得商品分类 不分页
	 * @return
	 */
	public List<GoodsClassBean> getGoodsClasssNoPage(GoodsClassBean goodsClassBean);
}
