package tst.project.dao.controller;

import java.util.List;

import tst.project.bean.order.AssessmentBean;
import tst.project.bean.order.AssessmentImgBean;
import tst.project.page.PageBean;

public interface AssessmentDao {
	/**
	 * 评价详情
	 * @return
	 */
	public AssessmentBean getAssessmentDetail(AssessmentBean assessmentBean);
	/**
	 * 评价图片
	 * @param assessmentImgBean
	 * @return
	 */
	public List<AssessmentImgBean> getAssessmentImgs(AssessmentImgBean assessmentImgBean);
	
	/**
	 * 获得所有评价列表
	 * @param assessmentBean
	 * @return
	 */
	public List<AssessmentBean> getAssessments(AssessmentBean assessmentBean,PageBean pageBean);
	
	/**
	 * 删除评价
	 * @param assessmentBean
	 * @return
	 */
	public int deleteAssessment(AssessmentBean assessmentBean);
	
	
}
