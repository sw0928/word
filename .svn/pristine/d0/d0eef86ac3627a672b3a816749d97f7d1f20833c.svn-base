package tst.project.service.interfaces;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.picture.PictureBean;
import tst.project.bean.picture.PictureImgBean;
import tst.project.bean.picture.PictureVoteBean;
import tst.project.dao.interfaces.PictureDao;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor = Exception.class)
public class PictureService {
	@Resource 
	PictureDao pictureDao;
	
	/**
	 * 投票晒图
	 * @param pictureVoteBean
	 * @return
	 * @throws Exception 
	 */
	public int votePicture(PictureVoteBean pictureVoteBean) throws Exception{
		int num=pictureDao.votePicture(pictureVoteBean);
		if(num>0){
			num=pictureDao.updatePictureVote(new PictureBean().setPicture_id(pictureVoteBean.getPicture_id()));
			if(num<=0){
				throw new Exception("晒图投票数更新失败");
			}
		}
		return num;
	}
	
	/**
	 * 用户投票详情
	 * @param pictureVoteBean
	 * @return
	 */
	public PictureVoteBean getVotePicture(PictureVoteBean pictureVoteBean){
		return pictureDao.getVotePicture(pictureVoteBean);
	}
	
	/**
	 * 晒图列表
	 * @param pictureBean
	 * @param pageBean
	 * @return
	 */
	public List<PictureBean> getPictures(PictureBean pictureBean,PageBean pageBean){
		List<PictureBean> pictureBeans=pictureDao.getPictures(pictureBean, pageBean);
		if(pictureBeans!=null){
			for (int i = 0; i < pictureBeans.size(); i++) {
				List<PictureImgBean> pictureImgBeans=pictureDao.getPictureImgs(new PictureImgBean()
						.setPicture_id(pictureBeans.get(i).getPicture_id()+""));
				
				pictureBeans.get(i).setPictureImgBeans(pictureImgBeans);
			}
		}
		return pictureBeans;
	}
	
	/**
	 * 上周优选
	 * @param pictureBean
	 * @param pageBean
	 * @return
	 */
	public List<PictureBean> getLastWeekPictures(PictureBean pictureBean,PageBean pageBean){
		List<PictureBean> pictureBeans=pictureDao.getLastWeekPictures(pictureBean, pageBean);
		if(pictureBeans!=null){
			for (int i = 0; i < pictureBeans.size(); i++) {
				List<PictureImgBean> pictureImgBeans=pictureDao.getPictureImgs(new PictureImgBean()
						.setPicture_id(pictureBeans.get(i).getPicture_id()+""));
				
				pictureBeans.get(i).setPictureImgBeans(pictureImgBeans);
			}
		}
		return pictureBeans;
	}
	
	/**
	 * 用户晒图列表
	 * @param pictureBean
	 * @param pageBean
	 * @return
	 */
	public List<PictureBean> getMemberPictures(PictureBean pictureBean,PageBean pageBean){
		List<PictureBean> pictureBeans=pictureDao.getMemberPictures(pictureBean, pageBean);
		if(pictureBeans!=null){
			for (int i = 0; i < pictureBeans.size(); i++) {
				List<PictureImgBean> pictureImgBeans=pictureDao.getPictureImgs(new PictureImgBean()
						.setPicture_id(pictureBeans.get(i).getPicture_id()+""));
				
				pictureBeans.get(i).setPictureImgBeans(pictureImgBeans);
			}
		}
		return pictureBeans;
	}
	
	
	/**
	 * 晒图入库
	 * @return
	 */
	public int insertPicture(PictureBean pictureBean,String [] imgs){
		int num=pictureDao.insertPicture(pictureBean);
		if(num>0){
			if(imgs!=null){
				for (int i = 0; i < imgs.length; i++) {
					insertPictureImg(new PictureImgBean()
							.setPicture_id(pictureBean.getPicture_id()+"")
							.setPicture_img(imgs[i]));
				}
			}
		}
		return num;
	}
	
	/**
	 * 晒图 图片入库
	 * @return
	 */
	public int insertPictureImg(PictureImgBean pictureImgBean){
		return pictureDao.insertPictureImg(pictureImgBean);
	}
}
