package tst.project.dao.interfaces;

import java.util.List;

import tst.project.bean.HostBean;
import tst.project.bean.hx.HXSettingBean;
import tst.project.bean.order.PingSettingBean;
import tst.project.bean.others.HtmlBean;
import tst.project.bean.others.HtmlStyleBean;
import tst.project.bean.others.MsgBean;
import tst.project.bean.others.PercentBean;
import tst.project.bean.others.QrcodeBean;
import tst.project.bean.wx.WXSetingBean;

public interface OthersDao {
	/**
	 * 单个网站的网页导航列表
	 * @param htmlBean
	 * @return
	 */
	public HtmlBean getHtml(HtmlBean htmlBean);
	/**
	 * 网站的网页导航列表
	 * @param htmlBean
	 * @return
	 */
	public List<HtmlBean> getHtmls(HtmlBean htmlBean);
	
	/**
	 * 
	 * @param htmlStyleBean
	 * @return
	 */
	public HXSettingBean getHXSetting(HXSettingBean hxSettingBean);
	
	/**
	 * 二维码内容配置
	 * @param htmlStyleBean
	 * @return
	 */
	public QrcodeBean getQrcodeSetting(QrcodeBean qrcodeBean);
	
	/**
	 * html基础样式
	 * @param htmlStyleBean
	 * @return
	 */
	public HtmlStyleBean getHtmlStyle(HtmlStyleBean htmlStyleBean);
	/**
	 * 获得ping++设置
	 * @param hostBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public PingSettingBean getPingSetting(PingSettingBean pingSettingBean);
	
	/**
	 * 域名获得
	 * @param hostBean
	 * @return
	 */
	public HostBean getHost(HostBean hostBean);
	
	/**
	 * 获得微信设置信息
	 * @param percentBean
	 * @return
	 */
	public WXSetingBean getWXSeting(WXSetingBean wxSetingBean);
	
	/**
	 * 获得单个兑换积分
	 * @param percentBean
	 * @return
	 */
	public PercentBean getPercent(PercentBean percentBean);
	
	/**
	 * 获得多个兑换积分
	 * @param percentBean
	 * @return
	 */
	public List<PercentBean> getPercents(PercentBean percentBean);
	
	/**
	 * 团购系统消息
	 * @return
	 */
	public List<MsgBean> getGroupSystemMsgs(MsgBean msgBean);
	
	/**
	 *  预售系统消息
	 * @return
	 */
	public List<MsgBean> getPreSystemMsgs(MsgBean msgBean);
}
