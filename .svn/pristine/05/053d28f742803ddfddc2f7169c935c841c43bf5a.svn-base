package tst.project.service.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tst.project.bean.HostBean;
import tst.project.bean.member.MemberBean;
import tst.project.dao.controller.MemberDaoC;
import tst.project.page.PageBean;
import tst.project.utils.HBRUtils;
import tst.project.utils.XmlUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberServiceC {
	@Resource
	MemberDaoC memberDaoC;

	@Resource
	OthersServiceC othersServiceC;

	/**
	 * 根据手机号获得用户信息
	 * 
	 * @return
	 */
	public MemberBean getMemberByMobile(MemberBean memberBean) {
		return memberDaoC.getMemberByMobile(memberBean);
	}

	/**
	 * 用户绑定储值卡
	 * 
	 * @return
	 * @throws Exception
	 */
	public int bindMemberStored(MemberBean memberBean) throws Exception {
		int num = memberDaoC.updateMemberDetail(memberBean);
		if (num <= 0) {
			return num;
		}
		String xml = "";
		xml = HBRUtils.cardBinding(memberBean);
		String error = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "error");
		if (error != null && !"".equals(error)) {
			throw new Exception(error);
		} else {
			String success = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "success");
			String arr[] = success.split(",");
			String vip_level = arr[2].substring("储值卡级别:".length(), arr[2].length());
			if ("普卡".equals(vip_level)) {
				vip_level = "vip_common";
			} else if ("银卡".equals(vip_level)) {
				vip_level = "vip_silver";
			} else if ("金卡".equals(vip_level)) {
				vip_level = "vip_golden";
			} else if ("白金卡".equals(vip_level)) {
				vip_level = "vip_platinum";
			} else if ("至尊卡".equals(vip_level)) {
				vip_level = "vip_extreme";
			} else {
				vip_level = "vip_common";
			}
			num = memberDaoC
					.updateMemberDetail(memberBean.setVip_level(vip_level).setMember_code(memberBean.getStored_code()));
		}
		return num;
	}

	/**
	 * 根据储值卡号 获得用户信息
	 * 
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByStore(MemberBean memberBean) {
		return memberDaoC.getMemberByStore(memberBean);
	}

	/**
	 * 清除储值卡
	 * 
	 * @param memberBean
	 * @return
	 */
	public int deleteMemberStored(MemberBean memberBean) {
		return memberDaoC.deleteMemberStored(memberBean);
	}

	/**
	 * 获得分销的用户列表
	 * 
	 * @param memberBean
	 * @return
	 */
	public List<MemberBean> getDistributionMembers(MemberBean memberBean, PageBean pageBean) {
		return memberDaoC.getDistributionMembers(memberBean, pageBean);
	}

	/**
	 * 修改用户详情
	 * 
	 * @param memberBean
	 * @return
	 */
	public int updateMemberDetail(MemberBean memberBean) {
		return memberDaoC.updateMemberDetail(memberBean);
	}

	/**
	 * 修改用户详情
	 * 
	 * @param memberBean
	 * @return
	 */
	public int updateMemberDetailZSSG(MemberBean memberBean) {
		return memberDaoC.updateMemberDetailZSSG(memberBean);
	}

	/**
	 * 单个用户详情
	 * 
	 * @return
	 * @throws Exception
	 */
	public MemberBean getOneMemberDetail(MemberBean memberBean) throws Exception {
		MemberBean memberBean2 = memberDaoC.getOneMemberDetail(memberBean);
		if (memberBean2 != null && memberBean2.getMember_code() != null && !"".equals(memberBean2.getMember_code())) {
			HostBean hostBean = othersServiceC.getHost(new HostBean().setHost_type("1"));
			if ("hbr".equals(hostBean.getCompany_name())) {
				String xml = "";
				xml = HBRUtils.getScore(memberBean2.getMember_code());
				String integral = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "integral");
				if (integral != null && !integral.equals("")) {
					memberBean2.setIntegral(integral);
				}
			}
		}
		return memberBean2;
	}

	/**
	 * 单个用户详情
	 * 
	 * @return
	 */
	public MemberBean getOneMemberDetailZSSG(MemberBean memberBean) {
		return memberDaoC.getOneMemberDetailZSSG(memberBean);
	}

	/**
	 * 导出用户信息
	 * 
	 * @param memberBean
	 * @return
	 * @throws Exception 
	 */
	public List<Map> exportMemberExcel(MemberBean memberBean) throws Exception {
		HostBean hostBean = othersServiceC.getHost(new HostBean().setHost_type("1"));
		List<Map> maps = memberDaoC.exportMemberExcel(memberBean);
		if ("hbr".equals(hostBean.getCompany_name())) {
			for (int i = 0; i < maps.size(); i++) {
				Map map = maps.get(i);
				String xml = "";
				xml = HBRUtils.getScore(map.get("member_code").toString());
				String integral = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "integral");
				if (integral != null && !integral.equals("")) {
					map.put("integral", integral);
				}
			}
		}
		return maps;

	}

	/**
	 * 获得所有普通用户信息
	 * 
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberBean> getAllMembers(MemberBean memberBean, PageBean pageBean) {
		return memberDaoC.getAllMembers(memberBean, pageBean);
	}

	public Map getAllMembersCount(MemberBean memberBean) {
		return memberDaoC.getAllMembersCount(memberBean);
	}

	/**
	 * 获得所有普通用户信息
	 * 
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberBean> getAllMembersZSSG(MemberBean memberBean, PageBean pageBean) {
		return memberDaoC.getAllMembersZSSG(memberBean, pageBean);
	}
}
