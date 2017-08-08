package tst.project.dao.controller;

import java.util.List;

import tst.project.bean.information.InformationBean;
import tst.project.bean.information.InformationImgBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.page.PageBean;

public interface InformationDaoC {
	/**
	 * 删除咨询图片
	 * @param informationImgBean
	 * @return
	 */
	public int deleteInformationImgs(InformationImgBean informationImgBean);
	
	/**
	 * 添加咨询图片
	 * @param informationImgBean
	 * @return
	 */
	public int insertInformationImg(InformationImgBean informationImgBean);
	
	/**
	 * 咨询图片列表
	 * @param informationImgBean
	 * @return
	 */
	public List<InformationImgBean> getInformationImgs(InformationImgBean informationImgBean); 
	
	
	
	/**
	 * 删除咨询
	 * @param informationBean
	 * @return
	 */
	public int deleteInformation(InformationBean informationBean);
	
	/**
	 * 修改咨询
	 * @param informationBean
	 * @return
	 */
	public int updateInformation(InformationBean informationBean);
	
	/**
	 * 添加咨询
	 * @param informationBean
	 * @return
	 */
	public int insertInformation(InformationBean informationBean);
	
	/**
	 * 咨询分类列表
	 * @return
	 */
	public List<InformationBean> getInformations(InformationBean informationBean,PageBean pageBean);
}
