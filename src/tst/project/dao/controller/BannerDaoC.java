package tst.project.dao.controller;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.banner.BannerBean;
import tst.project.page.PageBean;

public interface BannerDaoC {
	/**
	 * 获得所有广告列表
	 * @return
	 */
	public List<BannerBean> getAllBanners(BannerBean bannerBean,PageBean pageBean);
	
	/**
	 * 添加商品
	 * @param bannerBean
	 * @return
	 */
	public int insertBanner(BannerBean bannerBean);
	
	/**
	 * 修改商品
	 * @param bannerBean
	 * @return
	 */
	public int updateBanner(BannerBean bannerBean);
	
	/**
	 * 删除商品
	 * @param bannerBean
	 * @return
	 */
	public int deleteBanner(BannerBean bannerBean);
}
