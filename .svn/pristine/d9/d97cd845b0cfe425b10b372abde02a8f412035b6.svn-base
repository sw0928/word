package tst.project.service.interfaces;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.HostBean;
import tst.project.bean.hx.HXSettingBean;
import tst.project.bean.order.PingSettingBean;
import tst.project.bean.others.HtmlBean;
import tst.project.bean.others.HtmlStyleBean;
import tst.project.bean.others.MsgBean;
import tst.project.bean.others.PercentBean;
import tst.project.bean.others.QrcodeBean;
import tst.project.bean.wx.WXSetingBean;
import tst.project.dao.interfaces.OthersDao;

@Service
@Transactional(rollbackFor = Exception.class)
public class OthersService {
	@Resource
	OthersDao othersDao;
	/**
	 * 单个网站的网页导航列表
	 * @param htmlBean
	 * @return
	 */
	public HtmlBean getHtml(HtmlBean htmlBean){
		return othersDao.getHtml(htmlBean);
	}
	
	/**
	 * 网站的网页导航列表
	 * @param htmlBean
	 * @return
	 */
	public List<HtmlBean> getHtmls(HtmlBean htmlBean,String level){
		List<HtmlBean> htmlBeans=othersDao.getHtmls(htmlBean);
		if("2".equals(level)){
			for (int i = 0; i < htmlBeans.size(); i++) {
				HtmlBean htmlBean2=htmlBeans.get(i);
				List<HtmlBean> htmlBeans2=othersDao.getHtmls(htmlBean.setParent_id(htmlBean2.getHtml_id()+""));
				htmlBean2.setHtmlBeans(htmlBeans2);
			}
		}else if("3".equals(level)){
			for (int i = 0; i < htmlBeans.size(); i++) {
				HtmlBean htmlBean2=htmlBeans.get(i);
				List<HtmlBean> htmlBeans2=othersDao.getHtmls(htmlBean.setParent_id(htmlBean2.getHtml_id()+""));
				if(htmlBeans2!=null){
					for (int j = 0; j < htmlBeans2.size(); j++) {
						HtmlBean htmlBean3=htmlBeans2.get(j);
						List<HtmlBean> htmlBeans3=othersDao.getHtmls(htmlBean.setParent_id(htmlBean3.getHtml_id()+""));
						htmlBean3.setHtmlBeans(htmlBeans3);
					}
				}
				htmlBean2.setHtmlBeans(htmlBeans2);
			}
		}else{
			
		}
		return htmlBeans;
	}
	
	/**
	 * 
	 * @param htmlStyleBean
	 * @return
	 */
	public HXSettingBean getHXSetting(HXSettingBean hxSettingBean){
		return othersDao.getHXSetting(hxSettingBean);
	}
	
	
	/**
	 * 二维码内容配置
	 * @param htmlStyleBean
	 * @return
	 */
	public QrcodeBean getQrcodeSetting(QrcodeBean qrcodeBean){
		return othersDao.getQrcodeSetting(qrcodeBean);
	}
	
	
	/**
	 * html基础样式
	 * @param htmlStyleBean
	 * @return
	 */
	public HtmlStyleBean getHtmlStyle(HtmlStyleBean htmlStyleBean){
		return othersDao.getHtmlStyle(htmlStyleBean);
	}
	
	/**
	 * 获得ping++设置
	 * @param hostBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public PingSettingBean getPingSetting(PingSettingBean pingSettingBean){
		return othersDao.getPingSetting(pingSettingBean);
	}
	
	/**
	 * 域名获得
	 * @param hostBean
	 * @return
	 */
	public HostBean getHost(HostBean hostBean){
		return othersDao.getHost(hostBean);
	}
	
	/**
	 * 获得微信设置信息
	 * @param percentBean
	 * @return
	 */
	public WXSetingBean getWXSeting(WXSetingBean wxSetingBean){
		return othersDao.getWXSeting(wxSetingBean);
	}
	
	/**
	 * 获得单个兑换积分
	 * @param percentBean
	 * @return
	 */
	public PercentBean getPercent(PercentBean percentBean){
		return othersDao.getPercent(percentBean);
	}
	/**
	 * 获得多个兑换积分
	 * @param percentBean
	 * @return
	 */
	public List<PercentBean> getPercents(PercentBean percentBean){
		return othersDao.getPercents(percentBean);
	}
	
	/**
	 * 团购系统消息
	 * @return
	 */
	public List<MsgBean> getGroupSystemMsgs(MsgBean msgBean){
		return othersDao.getGroupSystemMsgs(msgBean);
	}
	
	/**
	 * 预售系统消息
	 * @return
	 */
	public List<MsgBean> getPreSystemMsgs(MsgBean msgBean){
		return othersDao.getPreSystemMsgs(msgBean);
	}
}
