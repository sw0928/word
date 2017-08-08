package tst.project.service.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.information.InformationBean;
import tst.project.bean.information.InformationImgBean;
import tst.project.dao.controller.InformationDaoC;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor = Exception.class)
public class InformationServiceC {	
	
	@Resource
	InformationDaoC informationDaoC;
	/**
	 * 删除咨询
	 * @param informationBean
	 * @return
	 */
	public int deleteInformation(InformationBean informationBean){
		return informationDaoC.deleteInformation(informationBean);
	}
	/**
	 * 添加咨询图片
	 * @param informationImgBean
	 * @return
	 */
	public int insertInformationImg(InformationImgBean informationImgBean){
		return informationDaoC.insertInformationImg(informationImgBean);
	}
	/**
	 * 修改咨询
	 * @param informationBean
	 * @return
	 * @throws Exception 
	 */
	public int updateInformation(InformationBean informationBean,List<InformationImgBean> informationImgBeans) throws Exception{
		int h=informationDaoC.deleteInformationImgs(new InformationImgBean().setInformation_id(informationBean.getInformation_id()));
		if(informationImgBeans!=null){
				for (int i = 0; i < informationImgBeans.size(); i++) {
					int num=insertInformationImg(informationImgBeans.get(i));
					if(num<=0){
						throw new Exception("添加咨询图片失败");
					}
				}
		}	
		return informationDaoC.updateInformation(informationBean);
	}
	/**
	 * 添加咨询
	 * @param informationBean
	 * @return
	 * @throws Exception 
	 */
	public int insertInformation(InformationBean informationBean,List<InformationImgBean> informationImgBeans) throws Exception{
		int num=informationDaoC.insertInformation(informationBean);
		if(num>0){
			if(informationImgBeans!=null){
				for (int i = 0; i < informationImgBeans.size(); i++) {
					num=insertInformationImg(informationImgBeans.get(i)
							.setInformation_id(informationBean.getInformation_id()));
					if(num<=0){
						throw new Exception("添加咨询图片失败");
					}
				}
		}	
		}
		return num;
	}
	
	/**
	 * 咨询分类列表
	 * @return
	 */
	public List<InformationBean> getInformations(InformationBean informationBean,PageBean pageBean){
		List<InformationBean> informationBeans=informationDaoC.getInformations(informationBean,pageBean);
		for (int i = 0; i < informationBeans.size(); i++) {
			InformationBean informationBean2=informationBeans.get(i);
			List<InformationImgBean> informationImgBeans=informationDaoC
					.getInformationImgs(new InformationImgBean().setInformation_id(informationBean2.getInformation_id()));
			informationBean2.setInformationImgBeans(informationImgBeans);
		}
		return informationBeans;
	}
	
}
