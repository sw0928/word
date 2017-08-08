package tst.project.dao.interfaces;

import java.util.List;

import tst.project.bean.picture.PictureBean;
import tst.project.bean.picture.PictureImgBean;
import tst.project.bean.picture.PictureVoteBean;
import tst.project.page.PageBean;

public interface PictureDao {
	/**
	 * 投票晒图
	 * @param pictureVoteBean
	 * @return
	 */
	public int votePicture(PictureVoteBean pictureVoteBean);
	
	/**
	 * 更新晒图投票数
	 * @return
	 */
	public int updatePictureVote(PictureBean pictureBean);
	
	/**
	 * 用户投票详情
	 * @param pictureVoteBean
	 * @return
	 */
	public PictureVoteBean getVotePicture(PictureVoteBean pictureVoteBean);
	/**
	 * 晒图列表
	 * @param pictureBean
	 * @param pageBean
	 * @return
	 */
	public List<PictureBean> getPictures(PictureBean pictureBean,PageBean pageBean);
	
	/**
	 * 晒图列表
	 * @param pictureBean
	 * @param pageBean
	 * @return
	 */
	public List<PictureBean> getMemberPictures(PictureBean pictureBean,PageBean pageBean);
	
	/**
	 * 晒图 图片列表
	 * @param pictureBean
	 * @param pageBean
	 * @return
	 */
	public List<PictureImgBean> getPictureImgs(PictureImgBean pictureImgBean);
	/**
	 * 上周优选
	 * @param pictureBean
	 * @param pageBean
	 * @return
	 */
	public List<PictureBean> getLastWeekPictures(PictureBean pictureBean,PageBean pageBean);
	
	/**
	 * 晒图入库
	 * @return
	 */
	public int insertPicture(PictureBean pictureBean);
	
	/**
	 * 晒图 图片入库
	 * @return
	 */
	public int insertPictureImg(PictureImgBean pictureImgBean);
}
