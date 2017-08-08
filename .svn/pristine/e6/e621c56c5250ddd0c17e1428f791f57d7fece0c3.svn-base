package tst.project.service.interfaces;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.banner.BannerBean;
import tst.project.dao.interfaces.BannerDao;

@Service
@Transactional(rollbackFor = Exception.class)
public class BannerService {

	@Resource
	BannerDao bannerDao;
	
	/**
	 * 获得所有广告列表
	 * @return
	 */
	public List<BannerBean> getAllBanners(BannerBean bannerBean){
		return bannerDao.getAllBanners( bannerBean);
	}
}
