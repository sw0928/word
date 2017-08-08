package tst.project.service.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import tst.project.bean.activity.ActivityBean;
import tst.project.bean.activity.GroupBuyGoodsBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsClassBean;
import tst.project.bean.goods.GoodsImgBean;
import tst.project.bean.goods.GoodsLabelBean;
import tst.project.bean.goods.GoodsParameterBean;
import tst.project.bean.goods.GoodsServiceBean;
import tst.project.bean.goods.StandardBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.dao.interfaces.GoodsDaoI;
import tst.project.dao.interfaces.GoodsDaoI2;
import tst.project.page.PageBean;
import tst.project.utils.HtmlUtils;

@Service
@Transactional(rollbackFor = { Exception.class })
public class GoodsServiceI2 {
	@Resource
	GoodsDaoI2 goodsDaoI2;

	@Resource
	GoodsServiceI goodsServiceI;

	@Resource
	MerchantsServiceI merchantsServiceI;
	@Resource
	ActivityService activityService;

	/**
	 * 获得参数 根据no
	 * 
	 * @param goodsParameterBean
	 * @return
	 */
	public List<GoodsParameterBean> getGoodsParametersByNo(GoodsParameterBean goodsParameterBean) {
		List<GoodsParameterBean> goodsParameterBeans = goodsDaoI2
				.getGoodsParametersByNo(goodsParameterBean.setParent_id("-1"));
		if (goodsParameterBeans != null) {
			for (int i = 0; i < goodsParameterBeans.size(); i++) {
				GoodsParameterBean goodsParameterBean2 = goodsParameterBeans.get(i);
				List<GoodsParameterBean> goodsParameterBeans2 = goodsDaoI2.getGoodsParametersByNo(
						goodsParameterBean.setParent_id(goodsParameterBean2.getParameter_id() + ""));
				goodsParameterBean2.setGoodsParameterBeans(goodsParameterBeans2);
			}
		}
		return goodsParameterBeans;
	}

	/**
	 * 商品详情
	 * 
	 * @return
	 */
	public Map getOneGoodsDetail(HttpServletRequest request, GoodsBean goodsBean) {
		GoodsBean goodsBean2 = goodsDaoI2.getOneGoodsDetail(goodsBean);

		List<GoodsParameterBean> goodsParameterBeans = getGoodsParametersByNo(
				new GoodsParameterBean().setGoods_no(goodsBean2.getGoods_no()));

		List<GoodsBean> goodsBeans = goodsDaoI2
				.getGoodsDetailByGoodsNo(goodsBean2.setMember_id(goodsBean.getMember_id()));

		if (goodsBeans != null) {
			for (int i = 0; i < goodsBeans.size(); i++) {
				GoodsBean goodsBean1 = goodsBeans.get(i);

				String desc = HtmlUtils.readHtml(request, goodsBean1.getGoods_url());
				goodsBean1.setGoods_url_content(desc);

				List<GoodsLabelBean> goodsLabelBeans = goodsServiceI
						.getGoodsClassLabels(new GoodsLabelBean().setGoods_id(goodsBean.getGoods_id() + ""));
				goodsBean1.setGoodsLabelBeans(goodsLabelBeans);

				List<GoodsImgBean> goodsImgBeans = goodsServiceI
						.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBean1.getGoods_id() + ""));
				goodsBean1.setGoodsImgBeans(goodsImgBeans);// 商品图片

				MerchantsBean merchantsBean = merchantsServiceI.getOneMerchantsDetail(
						new MerchantsBean().setMerchants_id(Integer.valueOf(goodsBean1.getMerchants_id()))
								.setMember_id(goodsBean.getMember_id()));
				goodsBean1.setMerchantsBean(merchantsBean);

				List<GoodsServiceBean> goodsServiceBeans = goodsServiceI.getAllServices(new GoodsServiceBean()
						.setService_type("1").setParent_id("-1").setGoods_id(goodsBean1.getGoods_id() + ""));
				goodsBean1.setGoodsServiceBeans(goodsServiceBeans);// 商品售后服务

				List<StandardBean> standardBeans = goodsServiceI
						.getGoodsStandards(new StandardBean().setGoods_id(goodsBean1.getGoods_id() + ""));
				goodsBean1.setStandardBeans(standardBeans);// 商品规格

				List<ActivityBean> activityBeans = activityService
						.getGoodsActivity(new ActivityBean().setGoods_id(goodsBean1.getGoods_id()));
				goodsBean1.setActivityBeans(activityBeans);

				if (goodsBean1.getIs_group_buy().equals("1")) {
					List<GroupBuyGoodsBean> groupBuyGoodsBeans = goodsServiceI
							.getGroupBuyGoodss(new GroupBuyGoodsBean().setGoods_id(goodsBean1.getGoods_id() + ""));
					goodsBean1.setGroupBuyGoodsBeans(groupBuyGoodsBeans);
				}
			}
		}

		Map map = new HashMap();
		map.put("goodsParameterBeans", goodsParameterBeans);
		map.put("goodsBeans", goodsBeans);
		return map;
	}

	/**
	 * 猜你喜欢--根据用户购买等习惯。。。。。
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getLoveGoodsByHabit(GoodsBean goodsBean, MemberBean memberBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI2.getMemberOrderGoods(memberBean);
		String parent_id = "";
		if (goodsBeans != null && goodsBeans.size() > 0) {
			for (int i = 0; i < goodsBeans.size(); i++) {
				parent_id += goodsBeans.get(i).getParent_id() + ",";
			}
		} else {// 没有购买记录

		}
		return goodsDaoI2.getLoveGoodsByHabit(goodsBean.setParent_id(parent_id), pageBean);
	}

	/**
	 * 猜你喜欢--根据用户购买等习惯。。。。。
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getLoveClassByHabit(GoodsBean goodsBean, MemberBean memberBean, String level,
			PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI2.getMemberOrderGoods(memberBean);
		String parent_id = "";
		if (goodsBeans != null && goodsBeans.size() > 0) {
			for (int i = 0; i < goodsBeans.size(); i++) {
				parent_id += goodsBeans.get(i).getParent_id() + ",";
			}
		} else {// 没有购买记录

		}
		if ("1".equals(level)) {
			return goodsDaoI2.getLoveClassByHabit1(goodsBean.setActivity_id(parent_id));
		} else if ("2".equals(level)) {
			return goodsDaoI2.getLoveClassByHabit2(goodsBean.setActivity_id(parent_id));
		} else {
			return goodsDaoI2.getLoveClassByHabit3(goodsBean.setActivity_id(parent_id));
		}
	}

	/**
	 * 修改商品详情
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int updateGoodsDetail(GoodsBean goodsBean) {
		return goodsDaoI2.updateGoodsDetail(goodsBean);
	}

	/**
	 * 修改商品星级
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int updateGoodsDetailStart(GoodsBean goodsBean) {
		return goodsDaoI2.updateGoodsDetailStart(goodsBean);
	}

	/**
	 * 根据各种条件 搜索商品列表
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> searchGoodsDetailList(GoodsBean goodsBean, PageBean pageBean) {

		return goodsDaoI2.searchGoodsDetailList(goodsBean, pageBean);
	}

	/**
	 * 自定义多级分类
	 */
	public List<GoodsClassBean> getGoodsClasss(GoodsClassBean goodsClassBean, int level) {
		List<GoodsClassBean> goodsClassBeans = getGoodsClasssByParent(goodsClassBean);
		if (level < 2) {// 只取一级
			return goodsClassBeans;
		}
		return getGoodsClassLevel(goodsClassBeans, level, 2);
	}

	/**
	 * 分类列表
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public List<GoodsClassBean> getGoodsClasssByParent(GoodsClassBean goodsClassBean) {
		return goodsDaoI2.getGoodsClasss(goodsClassBean);
	}

	/**
	 * 
	 * @param goodsBeans
	 * @param level
	 *            总共需要取层级
	 * @param start
	 *            目前取到的层级
	 * @return
	 */
	public List<GoodsClassBean> getGoodsClassLevel(List<GoodsClassBean> goodsClassBeans, int level, int start) {
		if (goodsClassBeans != null) {
			for (int i = 0; i < goodsClassBeans.size(); i++) {
				List<GoodsClassBean> goodsClassBeans2 = getGoodsClasssByParent(
						new GoodsClassBean().setParent_id(goodsClassBeans.get(i).getClass_id()));
				if (start < level && goodsClassBeans2 != null) {// 目前取到的层级 小于
					// 总共需要取层级时 向下取
					goodsClassBeans2 = getGoodsClassLevel(goodsClassBeans2, level, start + 1);
				}
				goodsClassBeans.get(i).setGoodsClassBeans(goodsClassBeans2);
			}
		}
		return goodsClassBeans;
	}
}
