package tst.project.service.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsClassBean;
import tst.project.bean.goods.GoodsParameterBean;
import tst.project.bean.goods.GoodsRelationClassBean;
import tst.project.bean.goods.TagBean;
import tst.project.bean.goods.TimingGoodsBean;
import tst.project.dao.controller.GoodsDao2;
import tst.project.page.PageBean;

/**
 * 商品管理 版本2.0 改善 一个商品 可在多个分类下 规格对应库存的问题
 * 
 * @author shenjiabo
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsService2 {
	@Resource
	GoodsDao2 goodsDao2;

	/**
	 * 
	 * @return
	 */
	public List<Map> getGoodsSales(GoodsBean goodsBean,PageBean pageBean){
		return goodsDao2.getGoodsSales(goodsBean, pageBean);
	}
	
	/**
	 * 删除定时记录
	 * 
	 * @param timingGoodsBean
	 * @return
	 */
	public int deleteTimingGoods(TimingGoodsBean timingGoodsBean) {
		return goodsDao2.deleteTimingGoods(timingGoodsBean);
	}

	/**
	 * 定时记录列表
	 * 
	 * @param timingGoodsBean
	 * @param pageBean
	 * @return
	 */
	public List<TimingGoodsBean> getTimingGoodss(TimingGoodsBean timingGoodsBean, PageBean pageBean) {
		return goodsDao2.getTimingGoodss(timingGoodsBean, pageBean);
	}

	public int loadGoodsTimings(List<TimingGoodsBean> timingGoodsBeans) throws Exception {
		String modify_time="";
		for (int i = 0; i < timingGoodsBeans.size(); i++) {
			TimingGoodsBean timingGoodsBean=timingGoodsBeans.get(i);
			if(i==0){
				modify_time=timingGoodsBean.getModify_time();//记录第一条的修改时间
			}
			timingGoodsBean.setTiming_state("1");
			timingGoodsBean.setModify_time(modify_time);
			GoodsBean goodsBean2 = goodsDao2.getGoodsBySku(new GoodsBean().setGoods_sku(timingGoodsBean.getGoods_sku()));
			if (goodsBean2 == null) {
				timingGoodsBean.setTiming_state("0");
				timingGoodsBean.setRemark("此sku不存在!");
			}else if (!goodsBean2.getGoods_now_price().equals(timingGoodsBean.getGoods_now_price())) {
				timingGoodsBean.setTiming_state("0");
				timingGoodsBean.setRemark("商品现价错误！");
			}else if (!goodsBean2.getGoods_origin_price().equals(timingGoodsBean.getGoods_origin_price())) {
				timingGoodsBean.setTiming_state("0");
				timingGoodsBean.setRemark("商品原价错误！");
			}
			int num = goodsDao2.insertGoodsTiming(timingGoodsBean);
		}
		if(modify_time==null||modify_time.equals("")){
			throw new Exception("第一条数据 修改时间为空");
		}
		
		String shpath = "/tomcat/tomcat3/webapps/hbr/WEB-INF/classes/TimingUpdateGoodsPrice.sh"; // 程序路径
		String command2 = "/bin/sh " + shpath + " " + modify_time.replace(" ", "");
		Process process = Runtime.getRuntime().exec(command2);

		// InputStream stdin=process.getErrorStream();
		// InputStreamReader isr=new InputStreamReader(stdin);
		// BufferedReader br=new BufferedReader(isr);
		// String line=null;
		// while((line=br.readLine())!=null)
		// if(line!=null){
		// throw new Exception(line);
		// }
		// process.waitFor();
		
		return 1;
	}

	/**
	 * 添加定时商品
	 * 
	 * @param goodsBean
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public int insertGoodsTiming(TimingGoodsBean timingGoodsBean) throws Exception {
		
		int num = goodsDao2.insertGoodsTiming(timingGoodsBean.setTiming_state("1"));

		if (num > 0) {
			String shpath = "/tomcat/tomcat3/webapps/hbr/WEB-INF/classes/TimingUpdateGoodsPrice.sh"; // 程序路径
			String var = timingGoodsBean.getModify_time(); // 参数
			String command2 = "/bin/sh " + shpath + " " + var.replace(" ", "");
			Process process = Runtime.getRuntime().exec(command2);

			// InputStream stdin=process.getErrorStream();
			// InputStreamReader isr=new InputStreamReader(stdin);
			// BufferedReader br=new BufferedReader(isr);
			// String line=null;
			// while((line=br.readLine())!=null)
			// if(line!=null){
			// throw new Exception(line);
			// }
			// process.waitFor();
		}
		return num;
	}

	/**
	 * 根据sku获得商品详情
	 * 
	 * @param goodsBean
	 * @return
	 */
	public GoodsBean getGoodsBySku(GoodsBean goodsBean) {
		return goodsDao2.getGoodsBySku(goodsBean);
	}

	/**
	 * 搜索商品列表
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> searchGoods(GoodsBean goodsBean, PageBean pageBean) {
		return goodsDao2.searchGoods(goodsBean, pageBean);
	}

	/**
	 * 添加商品tag
	 * 
	 * @return
	 */
	public int insertGoodsTag(TagBean tagBean) {
		return goodsDao2.insertGoodsTag(tagBean);
	}

	/**
	 * 修改商品tag
	 * 
	 * @return
	 */
	public int updateGoodsTag(TagBean tagBean) {
		return goodsDao2.updateGoodsTag(tagBean);
	}

	/**
	 * 删除商品tag
	 * 
	 * @return
	 */
	public int deleteGoodsTag(TagBean tagBean) {
		return goodsDao2.deleteGoodsTag(tagBean);
	}

	/**
	 * 获得商品Tag
	 * 
	 * @param tagBean
	 * @param pageBean
	 * @return
	 */
	public List<TagBean> getGoodsTags(TagBean tagBean, PageBean pageBean) {
		return goodsDao2.getGoodsTags(tagBean, pageBean);
	}

	/**
	 * 修改商品
	 * 
	 * @return
	 */
	public int updateGoodsDetail(GoodsBean goodsBean) {
		return goodsDao2.updateGoodsDetail(goodsBean);
	}

	/**
	 * 保存商品
	 * 
	 * @param goodsBean
	 * @return
	 * @throws Exception
	 */
	public int insertGoodsDetail(GoodsBean goodsBean, List<GoodsParameterBean> goodsParameterBeans) throws Exception {
		String goods_parameters = "";
		if (goodsParameterBeans != null) {
			String goods_no = "";
			if (goodsBean.getGoods_no() == null || "".equals(goodsBean.getGoods_no())) {
				goods_no = UUID.randomUUID().toString();
				goodsBean.setGoods_no(goods_no);
			} else {
				goods_no = goodsBean.getGoods_no();
			}

			for (int i = 0; i < goodsParameterBeans.size(); i++) {
				GoodsParameterBean goodsParameterBean = goodsParameterBeans.get(i);
				if (goodsParameterBean.getParameter_id() == 0) {
					goodsParameterBean.setGoods_no(goods_no);
					goodsParameterBean.setParent_id("-1");
					goodsParameterBean.setParameter_type("1");
					int num = goodsDao2.insertGoodsParameter(goodsParameterBean);
					if (num <= 0) {
						throw new Exception("添加失败");
					}
				}

				List<GoodsParameterBean> goodsParameterBeans2 = goodsParameterBean.getGoodsParameterBeans();
				if (goodsParameterBeans2 != null) {
					for (int j = 0; j < goodsParameterBeans2.size(); j++) {
						GoodsParameterBean goodsParameterBean2 = goodsParameterBeans2.get(j);
						if (goodsParameterBean2.getParameter_id() == 0) {
							goodsParameterBean2.setGoods_no(goods_no);
							goodsParameterBean2.setParent_id(goodsParameterBean.getParameter_id() + "");
							goodsParameterBean2.setParameter_type("2");
							int h = goodsDao2.insertGoodsParameter(goodsParameterBean2);
							if (h <= 0) {
								throw new Exception("添加失败1");
							}
						}
						if ("1".equals(goodsParameterBean2.getIs_select())) {
							goods_parameters += goodsParameterBean2.getParameter_id() + ",";
						}
					}
				}
			}
		}
		if (goods_parameters.length() > 0) {
			goods_parameters = goods_parameters.substring(0, goods_parameters.length() - 1);
		}
		return goodsDao2.insertGoodsDetail(goodsBean.setGoods_parameters(goods_parameters));
	}

	/**
	 * 获得商品 根据no
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getGoodsByNo(GoodsBean goodsBean) {
		return goodsDao2.getGoodsByNo(goodsBean);
	}

	/**
	 * 获得参数 根据no
	 * 
	 * @param goodsParameterBean
	 * @return
	 */
	public List<GoodsParameterBean> getGoodsParametersByNo(GoodsParameterBean goodsParameterBean) {
		List<GoodsParameterBean> goodsParameterBeans = goodsDao2
				.getGoodsParametersByNo(goodsParameterBean.setParent_id("-1"));
		if (goodsParameterBeans != null) {
			for (int i = 0; i < goodsParameterBeans.size(); i++) {
				GoodsParameterBean goodsParameterBean2 = goodsParameterBeans.get(i);
				List<GoodsParameterBean> goodsParameterBeans2 = goodsDao2.getGoodsParametersByNo(
						goodsParameterBean.setParent_id(goodsParameterBean2.getParameter_id() + ""));
				goodsParameterBean2.setGoodsParameterBeans(goodsParameterBeans2);
			}
		}
		return goodsParameterBeans;
	}

	/**
	 * 添加商品参数
	 * 
	 * @param goodsParameterBean
	 * @return
	 * @throws Exception
	 */
	public String insertGoodsParameters(List<GoodsParameterBean> goodsParameterBeans, String goods_no)
			throws Exception {
		if (goods_no == null || "".equals(goods_no)) {
			goods_no = UUID.randomUUID().toString();
		}
		if (goodsParameterBeans != null) {
			for (int i = 0; i < goodsParameterBeans.size(); i++) {
				GoodsParameterBean goodsParameterBean = goodsParameterBeans.get(i);

				if (goodsParameterBean.getParameter_id() == 0) {
					goodsParameterBean.setGoods_no(goods_no);
					goodsParameterBean.setParent_id("-1");
					goodsParameterBean.setParameter_type("1");
					int num = goodsDao2.insertGoodsParameter(goodsParameterBean);
					if (num <= 0) {
						throw new Exception("添加失败");
					}
				}

				List<GoodsParameterBean> goodsParameterBeans2 = goodsParameterBean.getGoodsParameterBeans();
				if (goodsParameterBeans2 != null) {
					for (int j = 0; j < goodsParameterBeans2.size(); j++) {
						GoodsParameterBean goodsParameterBean2 = goodsParameterBeans2.get(j);
						if (goodsParameterBean2.getParameter_id() == 0) {
							goodsParameterBean2.setGoods_no(goods_no);
							goodsParameterBean2.setParent_id(goodsParameterBean.getParameter_id() + "");
							goodsParameterBean2.setParameter_type("2");
							int h = goodsDao2.insertGoodsParameter(goodsParameterBean2);
							if (h <= 0) {
								throw new Exception("添加失败1");
							}
						}
					}
				}
			}
		}
		return goods_no;
	}

	/**
	 * 通过分类id和商品id 获得商品信息
	 * 
	 * @param goodsRelationClassBean
	 * @return
	 */
	public GoodsRelationClassBean getClassGoodsByClassAndGodosId(GoodsRelationClassBean goodsRelationClassBean) {
		return goodsDao2.getClassGoodsByClassAndGodosId(goodsRelationClassBean);
	}

	/**
	 * 删除分类下商品
	 * 
	 * @param goodsRelationClassBean
	 * @return
	 */
	public int deleteClassGoods(GoodsRelationClassBean goodsRelationClassBean) {
		return goodsDao2.deleteClassGoods(goodsRelationClassBean);
	}

	/**
	 * 添加分类下商品
	 * 
	 * @param goodsClassBean
	 * @return
	 */
	public int insertClassGoods(GoodsRelationClassBean goodsRelationClassBean) {
		String uuid = UUID.randomUUID().toString();
		return goodsDao2.insertClassGoods(goodsRelationClassBean.setUuid(uuid));
	}

	/**
	 * 分类下商品列表
	 * 
	 * @return
	 */
	public List<GoodsBean> getClassGoods(GoodsBean goodsBean, PageBean pageBean) {
		return goodsDao2.getClassGoods(goodsBean, pageBean);
	}

	/**
	 * 添加商品分类
	 * 
	 * @return
	 */
	public int insertGoodsClass(GoodsClassBean goodsClassBean) {
		String class_uuid = UUID.randomUUID().toString();
		return goodsDao2.insertGoodsClass(goodsClassBean.setClass_uuid(class_uuid));
	}

	public int updateClassExpress(GoodsClassBean goodsClassBean){
		int num=goodsDao2.updateGoodsClass(goodsClassBean);
		if(num>0){
			goodsDao2.updateClassExpress(goodsClassBean);
		}
		return num;
	}
	/**
	 * 修改商品分类
	 * 
	 * @return
	 */
	public int updateGoodsClass(GoodsClassBean goodsClassBean) {
		return goodsDao2.updateGoodsClass(goodsClassBean);
	}

	/**
	 * 删除商品分类
	 * 
	 * @return
	 */
	public int deleteGoodsClass(GoodsClassBean goodsClassBean) {
		return goodsDao2.deleteGoodsClass(goodsClassBean);
	}

	/**
	 * 获得商品分类
	 * 
	 * @return
	 */
	public List<GoodsClassBean> getGoodsClasss(GoodsClassBean goodsClassBean, PageBean pageBean) {
		return goodsDao2.getGoodsClasss(goodsClassBean, pageBean);
	}

	/**
	 * 获得商品分类 不分页
	 * 
	 * @return
	 */
	public List<GoodsClassBean> getGoodsClasssNoPage(GoodsClassBean goodsClassBean) {
		return goodsDao2.getGoodsClasssNoPage(goodsClassBean);
	}
}
