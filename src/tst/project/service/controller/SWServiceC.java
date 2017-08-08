package tst.project.service.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tst.project.bean.activity.AlbumBean;
import tst.project.bean.banner.ClassBannerBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.dao.controller.SWDaoC;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor = Exception.class)
public class SWServiceC {
	@Resource
	SWDaoC swDaoC;
	
	public int insertClassBanner(ClassBannerBean classBannerBean){
		return swDaoC.insertClassBanner(classBannerBean);
	}
	public int updateClassBanner(ClassBannerBean classBannerBean){
		return swDaoC.updateClassBanner(classBannerBean);
	}
	public int deleteClassBanner(ClassBannerBean classBannerBean){
		return swDaoC.deleteClassBanner(classBannerBean);
	}
	
	public List<ClassBannerBean> getClassBanners(ClassBannerBean classBannerBean){
		return swDaoC.getClassBanners(classBannerBean);
	}
	
	/**
	 * 获得好货精选
	 * @param goodsBean
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getExactGoodss(GoodsBean goodsBean,PageBean pageBean){
		return swDaoC.getExactGoodss(goodsBean, pageBean);
	}
	
	/**
	 * 获得单个好货专辑商品
	 * @param albumBean
	 * @return
	 */
	public AlbumBean getAlbumGoods(AlbumBean albumBean){
		return swDaoC.getAlbumGoods(albumBean);
	}
	/**
	 * 删除好货专辑商品
	 * @param albumBean
	 * @return
	 */
	public int deleteAlbumGoods(AlbumBean albumBean){
		return swDaoC.deleteAlbumGoods(albumBean);
	}
	
	/**
	 * 添加好货专辑商品
	 * @param albumBean
	 * @return
	 */
	public int insertAlbumGoods(AlbumBean albumBean){
		return swDaoC.insertAlbumGoods(albumBean);
	}
	
	/**
	 * 好货专辑 商品列表
	 * @param albumBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getAlbumGoodss(AlbumBean albumBean,PageBean pageBean){
		return swDaoC.getAlbumGoodss(albumBean, pageBean);
	}
	
	/**
	 * 好货专辑
	 * @return
	 */
	public List<AlbumBean> getAlbums(AlbumBean albumBean,PageBean pageBean){
		return swDaoC.getAlbums(albumBean, pageBean);
	}
	
	/**
	 * 添加好货专辑
	 * @param albumBean
	 * @return
	 */
	public int insertAlbum(AlbumBean albumBean){
		return swDaoC.insertAlbum(albumBean);
	}
	
	/**
	 * 修改好货专辑
	 * @param albumBean
	 * @return
	 */
	public int updateAlbum(AlbumBean albumBean){
		return swDaoC.updateAlbum(albumBean);
	}
	
	/**
	 * 删除好货专辑
	 * @param albumBean
	 * @return
	 */
	public int deleteAlbum(AlbumBean albumBean){
		return swDaoC.deleteAlbum(albumBean);
	}
	
}
