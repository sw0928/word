package tst.project.dao.controller;

import java.util.List;

import tst.project.bean.activity.AlbumBean;
import tst.project.bean.banner.ClassBannerBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.page.PageBean;

public interface SWDaoC {
	
	public int insertClassBanner(ClassBannerBean classBannerBean);
	public int updateClassBanner(ClassBannerBean classBannerBean);
	public int deleteClassBanner(ClassBannerBean classBannerBean);
	
	public List<ClassBannerBean> getClassBanners(ClassBannerBean classBannerBean);
	
	/**
	 * 获得好货精选
	 * @param goodsBean
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getExactGoodss(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 删除好货专辑商品
	 * @param albumBean
	 * @return
	 */
	public int deleteAlbumGoods(AlbumBean albumBean);
	
	/**
	 * 获得单个好货专辑商品
	 * @param albumBean
	 * @return
	 */
	public AlbumBean getAlbumGoods(AlbumBean albumBean);
	
	/**
	 * 添加好货专辑商品
	 * @param albumBean
	 * @return
	 */
	public int insertAlbumGoods(AlbumBean albumBean);
	
	/**
	 * 好货专辑 商品列表
	 * @param albumBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getAlbumGoodss(AlbumBean albumBean,PageBean pageBean);
	
	/**
	 * 好货专辑
	 * @return
	 */
	public List<AlbumBean> getAlbums(AlbumBean albumBean,PageBean pageBean);
	
	/**
	 * 添加好货专辑
	 * @param albumBean
	 * @return
	 */
	public int insertAlbum(AlbumBean albumBean);
	
	/**
	 * 修改好货专辑
	 * @param albumBean
	 * @return
	 */
	public int updateAlbum(AlbumBean albumBean);
	
	/**
	 * 删除好货专辑
	 * @param albumBean
	 * @return
	 */
	public int deleteAlbum(AlbumBean albumBean);
}
