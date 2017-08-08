package tst.project.service.interfaces;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.HostBean;
import tst.project.bean.member.IntegralBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.SignBean;
import tst.project.bean.member.SignStatisticsBean;
import tst.project.bean.others.PercentBean;
import tst.project.dao.interfaces.SignDao;
import tst.project.utils.HBRUtils;
import tst.project.utils.NumberUtils;
import tst.project.utils.TimeUtils;
import tst.project.utils.XmlUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class SignService {
	@Resource
	SignDao signDao;
	
	@Resource 
	MemberService memberService;
	
	@Resource
	OthersService othersService;
	/**
	 * 当月签到列表
	 * @param signBean
	 * @return
	 */
	public List<SignBean> getMonthSigns(SignBean signBean){
		String time=TimeUtils.getCurrentTime("yyyy-MM");
		return signDao.getMonthSigns(signBean.setCreate_time(time));
	}
	/**
	 * 签到列表
	 * @param signBean
	 * @return
	 */
	public List<SignBean> getSigns(SignBean signBean){
		return signDao.getSigns(signBean);
	}
	/**
	 * 用户签到
	 * @param signBean
	 * @return
	 * @throws Exception 
	 */
	public int insertSign(SignBean signBean) throws Exception{
		PercentBean percentBean2=othersService.getPercent(new PercentBean().setPercent_type("max_integral"));
		HostBean hostBean=othersService.getHost(new HostBean().setHost_type("1"));
		MemberBean memberBean=memberService.getMemberByID(new MemberBean().setMember_id(Integer.valueOf(signBean.getMember_id())));
		if(memberBean==null){
			throw new Exception("该用户不存在");
		}
		int num=0;
		String month_time=TimeUtils.getCurrentTime("yyyy-MM-dd");
		int month_integral=memberBean.getMonth_integral();
		
		boolean is_update=true;//标签是否更新用户信息
		
		if(memberBean.getMonth_time()==null||memberBean.getMonth_time().equals("")){//从未获得积分
			month_integral=signBean.getSign_integral();
		}else if(!memberBean.getMonth_time().equals(month_time+" 00:00:00.0")){//当月还未获得积分
			month_integral=signBean.getSign_integral();
		}else{
			if(month_integral+signBean.getSign_integral()>Integer.valueOf(percentBean2.getPercent_value())){//当月获得积分 已经大于最大获得积分
				is_update=false;
			}else{
				month_integral+=signBean.getSign_integral();
			}
		}
		
		num=signDao.insertSign(signBean);
		if(num<=0){
			throw new Exception("签到入库失败");
		}
		
		
		if(is_update){//需要更新用户积分
			if ("hbr".equals(hostBean.getCompany_name())) {
				String xml = HBRUtils.modifyIntegral(memberBean.getMember_code(),"sign"+ signBean.getSign_id(),
						signBean.getSign_integral() + "", "1","22");
				String error = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "error");
				if (error != null && !"".equals(error)) {
					throw new Exception(error);
				}
			} 
			
			memberService.insertMemberIntegral(new IntegralBean()
					.setMember_id(memberBean.getMember_id() + "")
					.setIntegral_type("sign")
					.setIntegral_value(signBean.getSign_integral()+"")
					.setRelation_id(signBean.getSign_id()+""));
			
			num=memberService.updateMemberDetail(new MemberBean()
					.setMember_id(Integer.valueOf(signBean.getMember_id()))
					.setIntegral((Float.valueOf(memberBean.getIntegral())+signBean.getSign_integral())+"")
					.setMonth_integral(month_integral)
					.setMonth_time(month_time));
			if(num<=0){
				throw new Exception("更新用户积分失败");
			}	
		}   
		
		
		return num;
	}
	
	/**
	 * 当月签到统计
	 * @param signBean
	 * @return
	 */
	public SignStatisticsBean getMonthSignStatistics(SignBean signBean){
		String time=TimeUtils.getCurrentTime("yyyy-MM");
		return signDao.getMonthSignStatistics(signBean.setCreate_time(time));
	}
	
	/**
	 * 当天的签到信息
	 * @param signBean
	 * @return
	 */
	public SignBean getSignToday(SignBean signBean){
		return signDao.getSignToday(signBean);
	}
}
