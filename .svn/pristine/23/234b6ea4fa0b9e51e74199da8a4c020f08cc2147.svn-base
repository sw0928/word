package tst.project.service.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.banner.BannerBean;
import tst.project.dao.controller.BannerDaoC;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor = Exception.class)
public class BannerServiceC {
	@Resource
	BannerDaoC bannerDaoC;
	/**
	 * 获得所有广告列表
	 * @return
	 */
	public List<BannerBean> getAllBanners(BannerBean bannerBean,PageBean pageBean){
		return bannerDaoC.getAllBanners( bannerBean,pageBean);
	}
	/**
	 * 添加商品
	 * @param bannerBean
	 * @return
	 */
	public int insertBanner(BannerBean bannerBean){
		return bannerDaoC.insertBanner( bannerBean);
	}
	
	/**
	 * 修改商品
	 * @param bannerBean
	 * @return
	 */
	public int updateBanner(BannerBean bannerBean){
		return bannerDaoC.updateBanner(bannerBean);
	}
	
	/**
	 * 删除商品
	 * @param bannerBean
	 * @return
	 */
	public int deleteBanner(BannerBean bannerBean){
		return bannerDaoC.deleteBanner(bannerBean);
	}
}
