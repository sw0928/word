package tst.project.dao.controller;

import java.util.List;

import org.aopalliance.aop.Advice;

import tst.project.bean.HostBean;
import tst.project.bean.order.PingSettingBean;
import tst.project.bean.others.AdviceBean;
import tst.project.bean.others.AdviceImgBean;
import tst.project.bean.others.HtmlBean;
import tst.project.bean.others.HtmlStyleBean;
import tst.project.bean.others.PercentBean;
import tst.project.bean.wx.WXMenuBean;
import tst.project.bean.wx.WXSetingBean;
import tst.project.page.PageBean;

public interface OthersDaoC {
	
	/**
	 * 修改微信菜单
	 * @return
	 */
	public List<WXMenuBean> getWxMenus(WXMenuBean wxMenuBean);
	
	/**
	 * 添加微信菜单
	 * @param wxMenuBean
	 * @return
	 */
	public int insertWXMenu(WXMenuBean wxMenuBean);
	
	/**
	 * 修改微信菜单
	 * @param wxMenuBean
	 * @return
	 */
	public int updateWXMenu(WXMenuBean wxMenuBean);
	/**
	 * 删除微信菜单
	 * @param wxMenuBean
	 * @return
	 */
	public int deleteWXMenu(WXMenuBean wxMenuBean);
	/**
	 * 添加帮助中心
	 * @param htmlBean
	 * @return
	 */
	public int insertHelpDetail(HtmlBean htmlBean);
	/**
	 * 修改帮助中心
	 * @param htmlBean
	 * @return
	 */
	public int updateHelpDetail(HtmlBean htmlBean);
	/**
	 * 删除帮助中心
	 * @param htmlBean
	 * @return
	 */
	public int deleteHelpDetail(HtmlBean htmlBean);
	
	/**
	 * 帮助中心分类
	 * @param htmlBean
	 * @return
	 */
	public List<HtmlBean> getHelpClasss(HtmlBean htmlBean);
	
	/**
	 * ping++设置
	 * @param pingSettingBean
	 * @return
	 */
	public PingSettingBean getPingSetting(PingSettingBean pingSettingBean);
	/**
	 * html基础样式
	 * @param htmlStyleBean
	 * @return
	 */
	public HtmlStyleBean getHtmlStyle(HtmlStyleBean htmlStyleBean);
	
	/**
	 * 微信设置
	 * @param wxSetingBean
	 * @return
	 */
	public WXSetingBean getWXSeting(WXSetingBean wxSetingBean);
	/**
	 * 域名获得
	 * @param hostBean
	 * @return
	 */
	public HostBean getHost(HostBean hostBean);
	
	/**
	 * 删除意见
	 * @return
	 */
	public int deleteAdvice(AdviceBean adviceBean);
	
	/**
	 * 意见的图片列表
	 * @param asAdviceImgBean
	 * @return
	 */
	public List<AdviceImgBean> getAdviceImgs(AdviceImgBean asAdviceImgBean);
	/**
	 * 反馈详情
	 * @param adviceBean
	 * @return
	 */
	public AdviceBean getAdviceDetail(AdviceBean adviceBean);
	/**
	 * 意见反馈列表
	 * @return
	 */
	public List<AdviceBean> getAdvices(AdviceBean adviceBean,PageBean pageBean);
	
	/**
	 * 平台百分比
	 * @param percentBean
	 * @return
	 */
	public List<PercentBean> getPercents(PercentBean percentBean);
	
	public PercentBean getPercent(PercentBean percentBean);
	
	public int updatePercent(PercentBean percentBean);
	
	public int updatePercentByType(PercentBean percentBean);
}
