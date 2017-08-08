package tst.project.dao.interfaces;

import java.util.List;

import tst.project.bean.banner.BannerBean;

public interface BannerDao {
	/**
	 * 获得所有广告列表
	 * @return
	 */
	public List<BannerBean> getAllBanners(BannerBean bannerBean);
}
