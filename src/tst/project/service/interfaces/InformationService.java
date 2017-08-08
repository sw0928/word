package tst.project.service.interfaces;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.information.InformationBean;
import tst.project.bean.information.InformationImgBean;
import tst.project.dao.interfaces.InformationDao;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor = { Exception.class })
public class InformationService {
	@Resource
	InformationDao informationDao;
	
	/**
	 * 咨询详情
	 * @param informationBean
	 * @return
	 */
	public InformationBean getInformationDetail(InformationBean informationBean){
		int num=updateInformationDetail(informationBean);
		InformationBean informationBean1=informationDao.getInformationDetail(informationBean);
		if(informationBean1!=null){
			List<InformationImgBean> informationImgBeans=informationDao
					.getInformationImgs(new InformationImgBean().setInformation_id(informationBean.getInformation_id()));
			informationBean1.setInformationImgBeans(informationImgBeans);
		}
		return informationBean1;
	}
	
	/**
	 * 修改咨询详情
	 * @param informationBean
	 * @return
	 */
	public int updateInformationDetail(InformationBean informationBean){
		return informationDao.updateInformationDetail(informationBean);
	}
	/**
	 * 获得所有咨询列表
	 * @return
	 */
	public List<InformationBean> getInformations(InformationBean informationBean,PageBean pageBean){
		return informationDao.getInformations(informationBean,pageBean);
	}
	
	/**
	 * 首页推荐咨询
	 * @param informationBean
	 * @return
	 */
	public List<InformationBean> getRecomendInformations(InformationBean informationBean){
		return informationDao.getRecomendInformations(informationBean);
	}
	
}
