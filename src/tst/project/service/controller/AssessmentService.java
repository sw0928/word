package tst.project.service.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.order.AssessmentBean;
import tst.project.bean.order.AssessmentImgBean;
import tst.project.dao.controller.AssessmentDao;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor = Exception.class)
public class AssessmentService {
	
	@Resource
	AssessmentDao assessmentDao;
	
	@Resource
	GoodsService goodsService;
	
	@Resource
	MerchantsService merchantsService;
	
	@Resource
	MemberServiceC memberServiceC;
	
	/**
	 * 评价详情
	 * @return
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public AssessmentBean getAssessmentDetail(AssessmentBean assessmentBean) throws NumberFormatException, Exception{
		AssessmentBean assessmentBean2=assessmentDao.getAssessmentDetail(assessmentBean);
		if(assessmentBean2!=null){
			if(assessmentBean2.getAssessment_type().equals("goods")){
				GoodsBean goodsBean=goodsService.
						getOneGoodsDetail(new GoodsBean().setGoods_id(Integer.valueOf(assessmentBean2.getRelation_id())));
				assessmentBean2.setGoodsBean(goodsBean);
			}
			if(assessmentBean2.getAssessment_type().equals("merchants")){
				MerchantsBean merchantsBean=merchantsService.
						getOneMerchantsDetail(new MerchantsBean().setMerchants_id(Integer.valueOf(assessmentBean2.getRelation_id())));
				assessmentBean2.setMerchantsBean(merchantsBean);
			}
			
			MemberBean memberBean=memberServiceC.getOneMemberDetail(new MemberBean().setMember_id(Integer.valueOf(assessmentBean2.getMember_id())));
			assessmentBean2.setMemberBean(memberBean);
			
			List<AssessmentImgBean> assessmentImgBeans=getAssessmentImgs(new AssessmentImgBean()
													.setAssessment_id(assessmentBean2.getAssessment_id()+""));
			assessmentBean2.setAssessmentImgBeans(assessmentImgBeans);
		}
		return assessmentBean2;
	}
	
	/**
	 * 评价图片
	 * @param assessmentImgBean
	 * @return
	 */
	public List<AssessmentImgBean> getAssessmentImgs(AssessmentImgBean assessmentImgBean){
		return assessmentDao.getAssessmentImgs(assessmentImgBean);
	}
	
	/**
	 * 获得所有评价列表
	 * @param assessmentBean
	 * @return
	 */
	public List<AssessmentBean> getAssessments(AssessmentBean assessmentBean,PageBean pageBean){
		return assessmentDao.getAssessments(assessmentBean, pageBean);
	}
	
	/**
	 * 删除评价
	 * @param assessmentBean
	 * @return
	 */
	public int deleteAssessment(AssessmentBean assessmentBean){
		return assessmentDao.deleteAssessment(assessmentBean);
	}
}
