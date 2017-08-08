package tst.project.service.interfaces;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.HostBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsClassBean;
import tst.project.bean.home.ActivityBean;
import tst.project.bean.home.HomeGoodsBean;
import tst.project.bean.home.LabelBean;
import tst.project.bean.member.BillBean;
import tst.project.bean.member.IntegralBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.ShareBean;
import tst.project.bean.others.PercentBean;
import tst.project.dao.interfaces.HBRDao;
import tst.project.page.PageBean;
import tst.project.utils.HBRUtils;
import tst.project.utils.TimeUtils;
import tst.project.utils.XmlUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class HBRService {
	@Resource
	HBRDao hbrDao;
	
	@Resource
	MemberService memberService;
	
	@Resource
	OthersService othersService;
	/**
	 * 储值卡消费记录
	 * @return
	 */
	public List<BillBean> getMemberStoredRecord(BillBean billBean,PageBean pageBean){
		return hbrDao.getMemberStoredRecord(billBean, pageBean);
	}
	
	/**
	 * 根据储值卡号 获得用户信息
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByStore(MemberBean memberBean){
		return hbrDao.getMemberByStore(memberBean);
	}
	
	/**
	 * 用户绑定储值卡
	 * @return
	 * @throws Exception 
	 */
	public int bindMemberStored(MemberBean memberBean) throws Exception{
		int num=hbrDao.bindMemberStored(memberBean);
		if(num<=0){
			return num;
		}
		String xml="";
		xml=HBRUtils.cardBinding(memberBean);
		String error=XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "error");
		if(error!=null&&!"".equals(error)){
			throw new Exception(error);
		}else{
			String success=XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "success");
			String arr[] = success.split(",");
			String vip_level=arr[2].substring("储值卡级别:".length(), arr[2].length());
			if("普卡".equals(vip_level)){
				vip_level="vip_common";
			}else if("银卡".equals(vip_level)){
				vip_level="vip_silver";
			}else if("金卡".equals(vip_level)){
				vip_level="vip_golden";
			}else if("白金卡".equals(vip_level)){
				vip_level="vip_platinum";
			}else if("至尊卡".equals(vip_level)){
				vip_level="vip_extreme";
			}else{
				vip_level="vip_common";
			}
			num = memberService.updateMemberDetailVip(memberBean.setVip_level(vip_level).setMember_code(memberBean.getStored_code()));		
		}
		return num;
	}
	
	/**
	 * 用户分享过的某一个商品
	 * @param shareBean
	 * @return
	 * @throws Exception 
	 */
	public ShareBean getMemberShareByMemberIDAndGoodsID(ShareBean shareBean) throws Exception{	
		return hbrDao.getMemberShareByMemberIDAndGoodsID(shareBean);
	}
	/**
	 * 用户分享商品得积分
	 * @param shareBean
	 * @return
	 * @throws Exception 
	 * @throw 
	 */
	public int insertMemberShare(ShareBean shareBean) throws Exception {
		PercentBean percentBean2=othersService.getPercent(new PercentBean().setPercent_type("max_integral"));
		HostBean hostBean=othersService.getHost(new HostBean().setHost_type("1"));
	
		MemberBean memberBean=memberService.getMemberByID(new MemberBean()
				.setMember_id(shareBean.getMember_id()));
		if(memberBean==null){
			throw new Exception("该用户不存在");
		}
		
		int num=0;
		String month_time=TimeUtils.getCurrentTime("yyyy-MM-dd");
		int month_integral=memberBean.getMonth_integral();
		
		boolean is_update=true;//标签是否更新用户信息
		
		if(memberBean.getMonth_time()==null||memberBean.getMonth_time().equals("")){//从未获得积分
			month_integral=shareBean.getShare_integral();
		}else if(!memberBean.getMonth_time().equals(month_time+" 00:00:00.0")){//当月还未获得积分
			month_integral=shareBean.getShare_integral();
		}else{
			if(month_integral+shareBean.getShare_integral()>Integer.valueOf(percentBean2.getPercent_value())){//当月获得积分 已经大于最大获得积分
				is_update=false;
			}else{
				month_integral+=shareBean.getShare_integral();
			}
		}
		
		num=hbrDao.insertMemberShare(shareBean);
		if(num<=0){
			throw new Exception("分享入库失败");	
		}
		
		if(is_update){//需要更新用户积分
			if ("hbr".equals(hostBean.getCompany_name())) {
				String xml = HBRUtils.modifyIntegral(memberBean.getMember_code(),"share"+ shareBean.getMember_share_id(),
						shareBean.getShare_integral() + "", "1","22");
				String error = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "error");
				if (error != null && !"".equals(error)) {
					throw new Exception(error);
				}
			} 
			
			memberService.insertMemberIntegral(new IntegralBean()
					.setMember_id(memberBean.getMember_id() + "")
					.setIntegral_type("share")
					.setIntegral_value(shareBean.getShare_integral() +"")
					.setRelation_id(shareBean.getMember_share_id()+""));
			
			num=memberService.updateMemberDetail(new MemberBean()
					.setMember_id(shareBean.getMember_id())
					.setIntegral((Float.valueOf(memberBean.getIntegral())+shareBean.getShare_integral())+"")
					.setMonth_integral(month_integral)
					.setMonth_time(month_time));
			if(num<=0){
				throw new Exception("更新用户积分失败");
			}
		}   
		
		return num;
	}
	/**
	 * 可分享的商品列表
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getShareGoodss(GoodsBean goodsBean,PageBean pageBean){
		return hbrDao.getShareGoodss(goodsBean, pageBean);
	}
	
	/**
	 * 首页商品（何柏瑞）
	 * @return
	 */
	public List<HomeGoodsBean> getHomeGoods(HomeGoodsBean homeGoodsBean){
		List<HomeGoodsBean> goodsBeans=hbrDao.getHomeGoods(homeGoodsBean.setParent_id("-1"));
		if(goodsBeans!=null){
			for (int i = 0; i < goodsBeans.size(); i++) {
				List<HomeGoodsBean> goodsBeans2=hbrDao.
						getHomeGoods(homeGoodsBean.setParent_id(goodsBeans.get(i).getHome_goods_id()+""));
				goodsBeans.get(i).setHomeGoodsBeans(goodsBeans2);
			}
		}
		return goodsBeans;
	}
	/**
	 * 首页分类
	 * @return
	 */
	public List<GoodsBean> getHomeClasss(GoodsBean goodsBean){
		return hbrDao.getHomeClasss(goodsBean);
	}
	
	/**
	 * 首页分类
	 * @return
	 */
	public List<GoodsClassBean> getHomeClasss2(GoodsClassBean goodsClassBean){
		return hbrDao.getHomeClasss2(goodsClassBean);
	}
	/**
	 * 首页标签（何柏瑞）
	 * @param labelBean
	 * @return
	 */
	public List<LabelBean> getHomeLabels(LabelBean labelBean){
		return hbrDao.getHomeLabels(labelBean);
	}
	
	/**
	 * 首页活动（）
	 * @param activityBean
	 * @return
	 */
	public List<ActivityBean> getHomeActivitys(ActivityBean activityBean){
		List<ActivityBean> activityBeans=hbrDao.getHomeActivitys(activityBean.setParent_id("-1"));
		if(activityBeans!=null){
			for (int i = 0; i < activityBeans.size(); i++) {
				List<ActivityBean> activityBeans2=hbrDao.
						getHomeActivitys(new ActivityBean().setParent_id(activityBeans.get(i).getActivity_id()+""));
				activityBeans.get(i).setActivityBeans(activityBeans2);
			}		
		}
		return activityBeans;
	}
}
