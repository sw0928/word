package tst.project.webservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import tst.project.bean.ExcelBean;
import tst.project.bean.HostBean;
import tst.project.bean.TestBean;
import tst.project.bean.activity.GroupBuyGoodsBean;
import tst.project.bean.address.LocationBean;
import tst.project.bean.goods.BrandBean;
import tst.project.bean.goods.BrandPackageBean;
import tst.project.bean.goods.BrandPackageGoodsBean;
import tst.project.bean.goods.BrandPackageImgBean;
import tst.project.bean.goods.BusinessGoodsBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsImgBean;
import tst.project.bean.goods.GoodsLabelBean;
import tst.project.bean.goods.GoodsParameterBean;
import tst.project.bean.goods.GoodsServiceBean;
import tst.project.bean.goods.SSPClassBean;
import tst.project.bean.goods.StandardBean;
import tst.project.bean.goods.StoreHouseBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.others.HtmlStyleBean;
import tst.project.bean.others.SearchBean;
import tst.project.module.ClassMoudle;
import tst.project.page.PageBean;
import tst.project.service.controller.GoodsService;
import tst.project.service.controller.MerchantsService;
import tst.project.service.controller.OthersServiceC;
import tst.project.service.controller.SystemService;
import tst.project.utils.ExcelUtils;
import tst.project.utils.FileUtils;
import tst.project.utils.QRCodeUtils;
import tst.project.utils.QueryUtils;
import tst.project.utils.TimeUtils;


/**
 * 商品管理模块
 * @author shenjiabo
 *
 */
@Controller
@RequestMapping("/goodsController.api")
public class GoodsController extends BaseController{
	@Resource
	SystemService systemService;
	
	@Resource
	GoodsService goodsService;
	
	@Resource
	MerchantsService merchantsService;
	
	@Resource
	OthersServiceC othersServiceC;
	
	/**
	 * 商品重新随机分类
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "test1", method = RequestMethod.POST)
	public void test1(SearchBean searchBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		goodsService.test1();
		WriteError(response, "ok");
	}
	
	/**
	 * json导入分类
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "test", method = RequestMethod.POST)
	public void test(SearchBean searchBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		String json=request.getParameter("json");
		String parent_id=request.getParameter("parent_id");
		
		List<TestBean> testBeans=new Gson().fromJson(json, new TypeToken<List<TestBean>>() {}.getType());
		for (int i = 0; i < testBeans.size(); i++) {
			TestBean testBean=testBeans.get(i);
			GoodsBean goodsBean=new GoodsBean()
					.setGoods_name(testBean.getName())
					.setParent_id(parent_id)
					.setGoods_type("1")
					.setSort(i+"")
					.setGoods_state("1")
					.setGoods_uuid(UUID.randomUUID().toString());
			int num=goodsService.insertGoodsClass(goodsBean);
			
			List<String> goodsBeans2=testBean.getList();
			for (int j = 0; j < goodsBeans2.size(); j++) {
				num=goodsService.insertGoodsClass(
						new GoodsBean().setGoods_name(goodsBeans2.get(j))
						.setParent_id(goodsBean.getGoods_id()+"")
						.setGoods_type("1")
						.setSort(i+"")
						.setGoods_state("1")
						.setGoods_uuid(UUID.randomUUID().toString()));
			}
		}
		
		WriteMsg(response, "ok");
	}
	
	/**
	 * 修改首页设置(服装)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertHomeActivity", method = RequestMethod.POST)
	public void insertHomeActivity(MerchantsAccountBean merchantsAccountBean,tst.project.bean.home.ActivityBean activityBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.insertHomeActivity(activityBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}		
	}
	

	/**
	 * 删除首页设置(服装)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteHomeActivity", method = RequestMethod.POST)
	public void deleteHomeActivity(MerchantsAccountBean merchantsAccountBean,tst.project.bean.home.ActivityBean activityBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.deleteHomeActivity(activityBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}		
	}
	
	/**
	 * 修改首页设置(服装)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateHomeActivity", method = RequestMethod.POST)
	public void updateHomeActivity(MerchantsAccountBean merchantsAccountBean,tst.project.bean.home.ActivityBean activityBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.updateHomeActivity(activityBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}		
	}
	
	/**
	 * 修改首页设置(服装)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateHomeActivityState", method = RequestMethod.POST)
	public void updateHomeActivityState(MerchantsAccountBean merchantsAccountBean,tst.project.bean.home.ActivityBean activityBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.updateHomeActivityState(activityBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}		
	}
	
	/**
	 * 首页设置(服装)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHomeActivitys", method = RequestMethod.POST)
	public void getHomeActivitys(MerchantsAccountBean merchantsAccountBean,tst.project.bean.home.ActivityBean activityBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, goodsService.getHomeActivitys(activityBean));
	}
	
	/**
	 * 导出商品信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "exportGoodsExcel", method = RequestMethod.POST)
	public void exportGoodsExcel(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		String fileName=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+".xls";
		
		List<ExcelBean> excelBeans=new ArrayList<ExcelBean>();
		excelBeans.add(new ExcelBean().setName("商品ID").setType("goods_id"));
		excelBeans.add(new ExcelBean().setName("商品名称").setType("goods_name"));
		excelBeans.add(new ExcelBean().setName("编码").setType("goods_skus"));
		excelBeans.add(new ExcelBean().setName("SKU").setType("goods_sku"));
		excelBeans.add(new ExcelBean().setName("原价").setType("goods_origin_price"));
		excelBeans.add(new ExcelBean().setName("现价").setType("goods_now_price"));
		excelBeans.add(new ExcelBean().setName("库存").setType("goods_stock"));
		excelBeans.add(new ExcelBean().setName("关税").setType("cross_border_tax"));
		excelBeans.add(new ExcelBean().setName("消费税").setType("goods_excise_tax"));
		excelBeans.add(new ExcelBean().setName("是否赠送积分").setType("is_give_integral"));
		excelBeans.add(new ExcelBean().setName("赠送积分").setType("give_integral_value"));
		excelBeans.add(new ExcelBean().setName("是否抵扣积分").setType("is_deduct_integral"));
		excelBeans.add(new ExcelBean().setName("抵扣积分").setType("deduct_integral_value"));
		excelBeans.add(new ExcelBean().setName("是否分享积分").setType("is_share"));
		excelBeans.add(new ExcelBean().setName("分享积分").setType("share_integral"));
		excelBeans.add(new ExcelBean().setName("库存").setType("goods_stock"));
		excelBeans.add(new ExcelBean().setName("状态").setType("goods_state_show"));
		
		List<Object> goodsBeans=goodsService.exportGoodsExcel(goodsBean);
		
		boolean is_success=ExcelUtils.exportExcel(request.getSession().getServletContext()
				.getRealPath("/")+"/excel/"+fileName, excelBeans,goodsBeans,response);
		if(is_success){
			WriteMsg(response, "/excel/"+fileName);
		}else{
			WriteError(response, "导出失败");
		}
	}
	
	
	/**
	 * 添加仓库信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertStorehouse", method = RequestMethod.POST)
	public void insertStorehouse(MerchantsAccountBean merchantsAccountBean,StoreHouseBean storeHouseBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		String addr = storeHouseBean.getStorehouse_province()+storeHouseBean.getStorehouse_city()+storeHouseBean.getStorehouse_area();
		LocationBean loc  = QueryUtils.postForLocation(addr);
		if(loc==null){
			WriteError(response, "请输入正确的地址");
			return;
		}else{
			storeHouseBean.setLongitude(loc.getLng()).setLatitude(loc.getLat());
		}
		int num=goodsService.insertStorehouse(storeHouseBean);
		if(num>0){
			WriteMsg(response, "添加成功");		
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 修改仓库信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateStorehouse", method = RequestMethod.POST)
	public void updateStorehouse(MerchantsAccountBean merchantsAccountBean,StoreHouseBean storeHouseBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		String addr = storeHouseBean.getStorehouse_province()+storeHouseBean.getStorehouse_city()+storeHouseBean.getStorehouse_area();
		LocationBean loc  = QueryUtils.postForLocation(addr);
		if(loc==null){
			WriteError(response, "请输入正确的地址");
			return;
		}else{
			storeHouseBean.setLongitude(loc.getLng()).setLatitude(loc.getLat());
		}
		int num=goodsService.updateStorehouse(storeHouseBean);
		
		if(num>0){
			WriteMsg(response, "修改成功");		
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	/**
	 * 删除仓库信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteStorehouse", method = RequestMethod.POST)
	public void deleteStorehouse(MerchantsAccountBean merchantsAccountBean,StoreHouseBean storeHouseBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		int num=goodsService.deleteStorehouse(storeHouseBean);
		if(num>0){
			WriteMsg(response, "删除成功");		
		}else{
			WriteError(response, "删除失败");
		}
	}
	
	/**
	 * 所有仓库信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsStorehouses", method = RequestMethod.POST)
	public void getGoodsStorehouses(MerchantsAccountBean merchantsAccountBean,
			StoreHouseBean storeHouseBean,PageBean pageBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService.getGoodsStorehouses(storeHouseBean,pageBean),pageBean.getTotal());
	}
	/**
	 * 所有仓库信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsStorehousesNoPage", method = RequestMethod.POST)
	public void getGoodsStorehousesNoPage(MerchantsAccountBean merchantsAccountBean,
			StoreHouseBean storeHouseBean,PageBean pageBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService.getGoodsStorehousesNoPage(storeHouseBean));
	}
	/**
	 * 所有网点信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsStorehouses2", method = RequestMethod.POST)
	public void getGoodsStorehouses2(MerchantsAccountBean merchantsAccountBean,
			StoreHouseBean storeHouseBean,PageBean pageBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService.getGoodsStorehouses2(storeHouseBean,pageBean),pageBean.getTotal());
	}
	/**
	 * 所有网点信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsStorehousesNoPage", method = RequestMethod.POST)
	public void getGoodsStorehouses2NoPage(MerchantsAccountBean merchantsAccountBean,
			StoreHouseBean storeHouseBean,PageBean pageBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService.getGoodsStorehouses2NoPage(storeHouseBean));
	}
	/**
	 * 添加某个商品的团购信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertGoodsGroupBuy", method = RequestMethod.POST)
	public void insertGoodsGroupBuy(MerchantsAccountBean merchantsAccountBean,GroupBuyGoodsBean groupBuyGoodsBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.insertGoodsGroupBuy(groupBuyGoodsBean);
		
		if(num>0){
			WriteMsg(response, "添加成功");		
		}else{
			WriteError(response, "添加失败");
		}
	}
	/**
	 * 修改某个商品的团购信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateGoodsGroupBuy", method = RequestMethod.POST)
	public void updateGoodsGroupBuy(MerchantsAccountBean merchantsAccountBean,GroupBuyGoodsBean groupBuyGoodsBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.updateGoodsGroupBuy(groupBuyGoodsBean);
		if(num>0){
			WriteMsg(response, "修改成功");		
		}else{
			WriteError(response, "修改失败");
		}	
	}
	
	/**
	 * 删除某个商品的团购信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteGoodsGroupBuy", method = RequestMethod.POST)
	public void deleteGoodsGroupBuy(MerchantsAccountBean merchantsAccountBean,GroupBuyGoodsBean groupBuyGoodsBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.deleteGoodsGroupBuy(groupBuyGoodsBean);
		if(num>0){
			WriteMsg(response, "删除成功");		
		}else{
			WriteError(response, "删除失败");
		}	
	}
	/**
	 * 获得某个商品的团购信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsGroupBuys", method = RequestMethod.POST)
	public void getGoodsGroupBuys(MerchantsAccountBean merchantsAccountBean,GroupBuyGoodsBean groupBuyGoodsBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService.getGoodsGroupBuys(groupBuyGoodsBean));
	}
	
	
	/**
	 * 添加商品的规格参数
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertStandard", method = RequestMethod.POST)
	public void insertStandard(MerchantsAccountBean merchantsAccountBean,StandardBean standardBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.insertStandard(standardBean);
		if(num>0){
			WriteObject(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 修改商品的规格参数
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateStandard", method = RequestMethod.POST)
	public void updateStandard(MerchantsAccountBean merchantsAccountBean,StandardBean standardBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.updateStandard(standardBean);
		if(num>0){
			WriteObject(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	/**
	 * 删除商品的规格参数
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteStandard", method = RequestMethod.POST)
	public void deleteStandard(MerchantsAccountBean merchantsAccountBean,StandardBean standardBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.deleteStandard(standardBean);
		if(num>0){
			WriteObject(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	
	/**
	 * 获得商品的规格参数
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsStandard", method = RequestMethod.POST)
	public void getGoodsStandard(MerchantsAccountBean merchantsAccountBean,StandardBean standardBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService.getGoodsStandard(standardBean));
	}

	/**
	 * 获得某个分类的所有标签
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsClassLabels", method = RequestMethod.POST)
	public void getGoodsClassLabels(MerchantsAccountBean merchantsAccountBean,GoodsLabelBean goodsLabelBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService.getGoodsClassLabels(goodsLabelBean));
	}

	/**
	 * 获得某个分类的所有标签
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllGoodsClassLabels", method = RequestMethod.POST)
	public void getAllGoodsClassLabels(MerchantsAccountBean merchantsAccountBean,GoodsLabelBean goodsLabelBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService.getAllGoodsClassLabels(goodsLabelBean.setGoods_id("")));
	}

	
	
	/**
	 * 添加某个分类的标签
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertGoodsClassLabel", method = RequestMethod.POST)
	public void insertGoodsClassLabel(MerchantsAccountBean merchantsAccountBean,GoodsLabelBean goodsLabelBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.insertGoodsClassLabel(goodsLabelBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	/**
	 * 修改某个分类的标签
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateGoodsClassLabel", method = RequestMethod.POST)
	public void updateGoodsClassLabel(MerchantsAccountBean merchantsAccountBean,GoodsLabelBean goodsLabelBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.updateGoodsClassLabel(goodsLabelBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	/**
	 * 删除某个分类的标签
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteGoodsClassLabel", method = RequestMethod.POST)
	public void deleteGoodsClassLabel(MerchantsAccountBean merchantsAccountBean,GoodsLabelBean goodsLabelBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.deleteGoodsClassLabel(goodsLabelBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	/**
	 * 通过父id 获得商品分类
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsClassByParentId", method = RequestMethod.POST)
	public void getGoodsClassByParentId(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService.getGoodsClassByParentId(goodsBean));
	}
	/**
	 * 获得所有分类数据
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllGoodsClassNoPage", method = RequestMethod.POST)
	public void getAllGoodsClassNoPage(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService.getAllGoodsClassNoPage(goodsBean));
	}
	
	/**
	 * 获得所有分类数据
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllGoodsClass", method = RequestMethod.POST)
	public void getAllGoodsClass(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService.getAllGoodsClass(goodsBean.setParent_id("-1").setGoods_type("1")));
	}
	
	/**
	 * 添加商品分类
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertGoodsClass", method = RequestMethod.POST)
	public void insertGoodsClass(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		String uuid=UUID.randomUUID().toString();
		int num=goodsService.insertGoodsClass(goodsBean.setGoods_uuid(uuid));
		if(num>0){
			ClassMoudle.getInstance().setGoods1Beans(null);
			ClassMoudle.getInstance().setGoods2Beans(null);
			ClassMoudle.getInstance().setGoods3Beans(null);
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 批量添加商品分类
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "loadGoodsClassExcel", method = RequestMethod.POST)
	public void loadGoodsClassExcel(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		String json=uploadFile(request, "/excel/");
		
		if(json.equals("-1")){
			WriteError(response, "文件不可为空");
			return;
		}else if(json.equals("-2")){
			WriteError(response, "上传失败");	
			return;
		}	
		
		String result=ExcelUtils.readExcel(request.getSession().getServletContext()
				.getRealPath("/")+json);	
		List<GoodsBean> goodsBeans=new Gson().fromJson(result, new TypeToken<List<GoodsBean>>() {}.getType());

		
		int num=goodsService.loadGoodsClassExcel(goodsBeans,request);
		if(num>0){
			ClassMoudle.getInstance().setGoods1Beans(null);
			ClassMoudle.getInstance().setGoods2Beans(null);
			ClassMoudle.getInstance().setGoods3Beans(null);
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 添加商品分类
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertGoodsClasss", method = RequestMethod.POST)
	public void insertGoodsClasss(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String parent_id=request.getParameter("parent_id");
		String json=request.getParameter("json");
		List<String> par=new Gson().fromJson(json, new TypeToken<List<String>>() {}.getType());
		int num=goodsService.insertGoodsClasss(par,parent_id);
		if(num>0){
			ClassMoudle.getInstance().setGoods1Beans(null);
			ClassMoudle.getInstance().setGoods2Beans(null);
			ClassMoudle.getInstance().setGoods3Beans(null);
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 修改商品分类
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateGoodsClass", method = RequestMethod.POST)
	public void updateGoodsClass(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.updateGoodsClass(goodsBean);
		if(num>0){
			ClassMoudle.getInstance().setGoods1Beans(null);
			ClassMoudle.getInstance().setGoods2Beans(null);
			ClassMoudle.getInstance().setGoods3Beans(null);
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}

	
	/**
	 * 删除商品分类
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteGoodsClass", method = RequestMethod.POST)
	public void deleteGoodsClass(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		int num=goodsService.deleteGoodsClass(goodsBean);
		if(num>0){
			ClassMoudle.getInstance().setGoods1Beans(null);
			ClassMoudle.getInstance().setGoods2Beans(null);
			ClassMoudle.getInstance().setGoods3Beans(null);
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	
	/**
	 * 上传商品图片
	 * @param merchantsAccountBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "uploadGoodsImg")
	public void uploadGoodsImg(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		String json=uploadFile(request, "/images/goods/");
		if(json.equals("-1")){
			WriteError(response, "文件不可为空");
		}else if(json.equals("-2")){
			WriteError(response, "上传失败");	
		}else{
			WriteMsg(response, json);
		}
	}	
	
	/**
	 * 批量上传品牌照片(zip格式)
	 * @param merchantsAccountBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "uploadGoodsImgs")
	public void uploadGoodsImgs(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		String json=uploadFile(request, "/images/goods/");
		if(json.equals("-1")){
			WriteError(response, "文件不可为空");
			return;
		}
		
		if(json.equals("-2")){
			WriteError(response, "上传失败");	
			return;
		}
		
		boolean is_success=FileUtils.unZipFiles(request.getSession().getServletContext()
							.getRealPath("/")+json,request.getSession().getServletContext()
							.getRealPath("/")+"/images/goods/");
		if(is_success){
			WriteMsg(response, "成功");
		}else{
			WriteError(response, "失败");
		}
	}
	
	/**
	 * 得到所有品牌信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllBrands", method = RequestMethod.POST)
	public void getAllBrands(MerchantsAccountBean merchantsAccountBean,BrandBean brandBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService.getAllBrands(brandBean));
	}

	/**
	 * 批量添加品牌
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "loadBrandExcel", method = RequestMethod.POST)
	public void loadBrandExcel(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		String json=uploadFile(request, "/excel/");
		
		if(json.equals("-1")){
			WriteError(response, "文件不可为空");
			return;
		}else if(json.equals("-2")){
			WriteError(response, "上传失败");	
			return;
		}	
		
		String result=ExcelUtils.readExcel(request.getSession().getServletContext()
				.getRealPath("/")+json);	
		List<BrandBean> brandBeans=new Gson().fromJson(result, new TypeToken<List<BrandBean>>() {}.getType());

		int num=goodsService.loadBrandExcel(brandBeans,request);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 添加品牌
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertBrand", method = RequestMethod.POST)
	public void insertBrand(MerchantsAccountBean merchantsAccountBean,BrandBean brandBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}		
		String fileName=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+".html";	
		String path="/html/brand/";
		writeHtml(request, path+fileName,"品牌展示",othersServiceC.getHtmlStyle(new HtmlStyleBean().setStyle_type("brand")));
		
		int num=goodsService.insertBrand(brandBean.setBrand_url(path+"/"+fileName));
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	@RequestMapping(params = "getBrandUrlHtml")
	public void getBrandUrlHtml(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request, HttpServletResponse response) {
		String url=request.getParameter("url");
		WriteOnlyMsg(response,  readHtml(request,url));
	}

	@RequestMapping(params = "setBrandUrlHtml")
	public void setBrandUrlHtml(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request, HttpServletResponse response) {
		String desc=request.getParameter("desc");
		String url=request.getParameter("url");
		if(writeHtml(request,url,desc,othersServiceC.getHtmlStyle(new HtmlStyleBean().setStyle_type("brand")))){
			WriteMsg(response, "保存成功");
		}else{
			WriteError(response, "保存失败");
		}
	}
	
	/**
	 * 修改品牌
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateBrand", method = RequestMethod.POST)
	public void updateBrand(MerchantsAccountBean merchantsAccountBean,BrandBean brandBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.updateBrand(brandBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	/**
	 * 删除品牌
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteBrand", method = RequestMethod.POST)
	public void deleteBrand(MerchantsAccountBean merchantsAccountBean,BrandBean brandBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.deleteBrand(brandBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	/**
	 * 批量上传品牌照片(zip格式)
	 * @param merchantsAccountBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "uploadBrandImgs")
	public void uploadBrandImgs(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		String json=uploadFile(request, "/images/brand/");
		if(json.equals("-1")){
			WriteError(response, "文件不可为空");
			return;
		}
		
		if(json.equals("-2")){
			WriteError(response, "上传失败");	
			return;
		}
		
		boolean is_success=FileUtils.unZipFiles(request.getSession().getServletContext()
							.getRealPath("/")+json,request.getSession().getServletContext()
							.getRealPath("/")+"/images/brand/");
		if(is_success){
			WriteMsg(response, "成功");
		}else{
			WriteError(response, "失败");
		}
	}
	
	/**
	 * 上传品牌照片
	 * @param merchantsAccountBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "uploadBrandImg")
	public void uploadBrandImg(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		String json=uploadFile(request, "/images/brand/");
		if(json.equals("-1")){
			WriteError(response, "文件不可为空");
		}else if(json.equals("-2")){
			WriteError(response, "上传失败");	
		}else{
			WriteMsg(response, json);
		}
	}

	
	/**
	 * 获得所有商品详情
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllGoodsDetail", method = RequestMethod.POST)
	public void getAllGoodsDetail(MerchantsAccountBean merchantsAccountBean,PageBean pageBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService.getAllGoodsDetail(goodsBean,pageBean),pageBean.getTotal());
	}
	/**
	 * 获得所有商品详情 不分页
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllGoodsDetailNoPage", method = RequestMethod.POST)
	public void getAllGoodsDetailNoPage(MerchantsAccountBean merchantsAccountBean,PageBean pageBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService.getAllGoodsDetailNoPage(goodsBean));
	}
	
	/**
	 * 获得所有商品详情 不分页
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllGoodsDetailNoPageqqq", method = RequestMethod.POST)
	public void getAllGoodsDetailNoPageqqq(MerchantsAccountBean merchantsAccountBean,PageBean pageBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		if(!systemService.verToken(merchantsAccountBean)){
//			WritePending(response, "token failed");
//			return;
//		}
		
		WriteObject(response, goodsService.getAllGoodsDetailNoPage(goodsBean));
	}
	/**
	 * 获得单个商品详情
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOneGoodsDetail", method = RequestMethod.POST)
	public void getOneGoodsDetail(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}		
		WriteObject(response, goodsService.getOneGoodsDetail(goodsBean));
	}
	/**
	 * 获得单个商品详情
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsImgs", method = RequestMethod.POST)
	public void getGoodsImgs(MerchantsAccountBean merchantsAccountBean,GoodsImgBean goodsImgBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}		
		WriteObject(response, goodsService.getGoodsImgs(goodsImgBean));
	}
	
	/**
	 * 添加商品详情（所有信息一次性填充）
	 * @param merchantsAccountBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertGoodsDetailAll")
	public void insertGoodsDetailAll(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		GoodsBean goodsBean3=goodsService.getOneGoodsDetailBySku(goodsBean);
		if(goodsBean3!=null){
			WriteError(response, "此sku已存在");
			return;
		}
		
		
		String fileName=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+".html";	
		String path="/html/goods/";
		writeHtml(request, path+fileName,"产品展示",othersServiceC.getHtmlStyle(new HtmlStyleBean().setStyle_type("goods")));
		
		String uuid=UUID.randomUUID().toString();
	
		List<GoodsLabelBean> goodsLabelBeans=new Gson().fromJson(request.getParameter("goods_labels"), new TypeToken<List<GoodsLabelBean>>(){}.getType());
		List<GoodsImgBean> goodsImgBeans=new Gson().fromJson(request.getParameter("imgs"), new TypeToken<List<GoodsImgBean>>(){}.getType());
		List<GoodsParameterBean> goodsParameterBeans=new Gson().fromJson(request.getParameter("parameters"), new TypeToken<List<GoodsParameterBean>>(){}.getType());
		List<StandardBean> standardBeans=new Gson().fromJson(request.getParameter("standards"), new TypeToken<List<StandardBean>>(){}.getType());
	
		String sort="";
		if(goodsBean.getSort_time()==null||goodsBean.getSort_time().equals("")){
			sort=TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss");
		}else{
			sort=goodsBean.getSort_time();
		}
		
		int num=goodsService.insertGoodsDetailAll(goodsBean.setGoods_uuid(uuid).setGoods_url( path+"/"+fileName)
				.setSort_time(sort),goodsLabelBeans,goodsImgBeans,goodsParameterBeans,standardBeans);
		
		if(num>0){
			ClassMoudle.getInstance().setGoods1Beans(null);
			ClassMoudle.getInstance().setGoods2Beans(null);
			ClassMoudle.getInstance().setGoods3Beans(null);
			GoodsBean goodsBean2=goodsService.getOneGoodsDetail(goodsBean);
			WriteObject(response, goodsBean2);
		}else{			
			WriteError(response, "添加失败");	
		}
	}
	

	/**
	 * 批量商品
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "nnnnn")
	public void nnnnn(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String result=ExcelUtils.readExcel(request.getSession().getServletContext()
				.getRealPath("/")+"/excel/1484992306301.xlsx");	
		List<GoodsBean> goodsBeans=new Gson().fromJson(result, new TypeToken<List<GoodsBean>>() {}.getType());
		int num=goodsService.loadGoodsDetailExcel(goodsBeans,request);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 批量商品
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "mmmm")
	public void mmmm(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<GoodsBean> goodsBeans=goodsService.getAllGoodsDetailNoPage(new GoodsBean());
		int num=goodsService.loadGoodsDetailExcel(goodsBeans,request);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 批量商品
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "loadGoodsDetailExcel", method = RequestMethod.POST)
	public void loadGoodsDetailExcel(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String json=uploadFile(request, "/excel/");		
		if(json.equals("-1")){
			WriteError(response, "文件不可为空");
			return;
		}else if(json.equals("-2")){
			WriteError(response, "上传失败");	
			return;
		}	
		System.out.println("=========-------------------");

		String result=ExcelUtils.readExcel(request.getSession().getServletContext()
				.getRealPath("/")+json);	

		System.out.println(result+"===========================");
		List<GoodsBean> goodsBeans=new Gson().fromJson(result, new TypeToken<List<GoodsBean>>() {}.getType());
		System.out.println(goodsBeans.size()+"------------------");
		int num=goodsService.loadGoodsDetailExcel(goodsBeans,request);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 添加商品详情
	 * @param merchantsAccountBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertGoodsDetail")
	public void insertGoodsDetail(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		String fileName=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+".html";	
		String path="/html/goods/";
		writeHtml(request, path+fileName,"产品展示",othersServiceC.getHtmlStyle(new HtmlStyleBean().setStyle_type("goods")));
		
		String uuid=UUID.randomUUID().toString();
	
		List<GoodsLabelBean> goodsLabelBeans=new Gson().fromJson(request.getParameter("goods_labels"), new TypeToken<List<GoodsLabelBean>>(){}.getType());

		String sort="";
		if(goodsBean.getSort_time()==null||goodsBean.getSort_time().equals("")){
			sort=TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss");
		}else{
			sort=goodsBean.getSort_time();
		}
		
		int num=goodsService.insertGoodsDetail(goodsBean
				.setGoods_uuid(uuid).setGoods_url( path+"/"+fileName)
				.setSort_time(sort),goodsLabelBeans,request);
		if(num>0){
			ClassMoudle.getInstance().setGoods1Beans(null);
			ClassMoudle.getInstance().setGoods2Beans(null);
			ClassMoudle.getInstance().setGoods3Beans(null);
			GoodsBean goodsBean2=goodsService.getOneGoodsDetail(goodsBean);
			WriteObject(response, goodsBean2);
		}else{			
			WriteError(response, "添加失败");	
		}
	}
	

	@RequestMapping(params = "insertGoodsImg")
	public void insertGoodsImg(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		List<GoodsImgBean> imgs=new Gson().fromJson(request.getParameter("imgs"), new TypeToken<List<GoodsImgBean>>(){}.getType());
		int num=goodsService.insertGoodsImg(goodsBean, imgs);
		if(num>0){
			WriteMsg(response, "保存成功");
		}else{
			WriteError(response, "保存失败");
		}
	}
	
	
	@RequestMapping(params = "getGoodsUrlHtml")
	public void getGoodsUrlHtml(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request, HttpServletResponse response) {
		String url=request.getParameter("url");
		WriteOnlyMsg(response,  readHtml(request,url));
	}
	/**
	 * 批量修改商品详情的信息
	 * @param merchantsAccountBean
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "setGoodsUrlHtmls")
	public void setGoodsUrlHtmls(HttpServletRequest request, HttpServletResponse response) {
		List<GoodsBean> goodsBeans=goodsService.getAllGoodsDetailNoPage(new GoodsBean());
		for (int i = 0; i < goodsBeans.size(); i++) {
			String url=goodsBeans.get(i).getGoods_url();
			String desc=readHtml(request,url);
			String result=desc.replace("jf.tstweiguanjia.com", "www.wee-home.com");
			writeHtml(request,url,result,othersServiceC.getHtmlStyle(new HtmlStyleBean().setStyle_type("goods")));
		}
	}
	
	@RequestMapping(params = "setGoodsUrlHtml")
	public void setGoodsUrlHtml(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request, HttpServletResponse response) {
		String desc=request.getParameter("desc");
		String url=request.getParameter("url");
		if(writeHtml(request,url,desc,othersServiceC.getHtmlStyle(new HtmlStyleBean().setStyle_type("goods")))){
			WriteMsg(response, "保存成功");
		}else{
			WriteError(response, "保存失败");
		}
	}
	
	
	/**
	 * 修改商品详情
	 * @param merchantsAccountBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateGoodsDetailAll")
	public void updateGoodsDetailAll(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		List<GoodsLabelBean> goodsLabelBeans=new Gson().fromJson(request.getParameter("goods_labels"), new TypeToken<List<GoodsLabelBean>>(){}.getType());

		List<GoodsImgBean> goodsImgBeans=new Gson().fromJson(request.getParameter("imgs"), new TypeToken<List<GoodsImgBean>>(){}.getType());
		List<GoodsParameterBean> goodsParameterBeans=new Gson().fromJson(request.getParameter("parameters"), new TypeToken<List<GoodsParameterBean>>(){}.getType());
		List<StandardBean> standardBeans=new Gson().fromJson(request.getParameter("standards"), new TypeToken<List<StandardBean>>(){}.getType());
		int num=goodsService.updateGoodsDetailAll(goodsBean,goodsLabelBeans,goodsImgBeans,goodsParameterBeans,standardBeans);
		if(num>0){
			ClassMoudle.getInstance().setGoods1Beans(null);
			ClassMoudle.getInstance().setGoods2Beans(null);
			ClassMoudle.getInstance().setGoods3Beans(null);
			GoodsBean goodsBean2=goodsService.getOneGoodsDetail(goodsBean);
			WriteObject(response, goodsBean2);
		}else{			
			WriteError(response, "修改失败");	
		}
	}
	/**
	 * 修改商品详情
	 * @param merchantsAccountBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateGoodsDetail")
	public void updateGoodsDetail(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		List<GoodsLabelBean> goodsLabelBeans=new Gson().fromJson(request.getParameter("goods_labels"), new TypeToken<List<GoodsLabelBean>>(){}.getType());

		int num=goodsService.updateGoodsDetail(goodsBean,goodsLabelBeans);
		if(num>0){
			ClassMoudle.getInstance().setGoods1Beans(null);
			ClassMoudle.getInstance().setGoods2Beans(null);
			ClassMoudle.getInstance().setGoods3Beans(null);
			GoodsBean goodsBean2=goodsService.getOneGoodsDetail(goodsBean);
			WriteObject(response, goodsBean2);
		}else{			
			WriteError(response, "修改失败");	
		}
	}
	
	/**
	 * 删除商品详情
	 * @param merchantsAccountBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteAllGoods")
	public void deleteAllGoods(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		int num=goodsService.deleteAllGoods(goodsBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{			
			WriteError(response, "删除失败");	
		}
	}
	
	/**
	 * 删除商品详情
	 * @param merchantsAccountBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateAllGoodsPrice")
	public void updateAllGoodsPrice(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		int num=goodsService.updateAllGoodsPrice(goodsBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{			
			WriteError(response, "修改失败");	
		}
	}
	
	/**
	 * 删除商品详情
	 * @param merchantsAccountBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteGoodsDetail")
	public void deleteGoodsDetail(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		int num=goodsService.deleteGoodsDetail(goodsBean);
		if(num>0){
			ClassMoudle.getInstance().setGoods1Beans(null);
			ClassMoudle.getInstance().setGoods2Beans(null);
			ClassMoudle.getInstance().setGoods3Beans(null);
			WriteMsg(response, "删除成功");
		}else{			
			WriteError(response, "删除失败");	
		}
	}
	
	/**
	 * 得到所有商品参数信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllParameters", method = RequestMethod.POST)
	public void getAllParameters(MerchantsAccountBean merchantsAccountBean,GoodsParameterBean parameterBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, goodsService.
								getAllParameters(parameterBean.setParameter_type("1").setParent_id("-1")));
	}

	/**
	 * 添加商品参数
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertParameter", method = RequestMethod.POST)
	public void insertParameter(MerchantsAccountBean merchantsAccountBean,GoodsParameterBean parameterBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		String uuid=UUID.randomUUID().toString();
		
		int num=goodsService.insertParameter(parameterBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 修改商品参数
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateParameter", method = RequestMethod.POST)
	public void updateParameter(MerchantsAccountBean merchantsAccountBean,GoodsParameterBean parameterBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.updateParameter(parameterBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	/**
	 * 删除商品参数
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteParameter", method = RequestMethod.POST)
	public void deleteParameter(MerchantsAccountBean merchantsAccountBean,GoodsParameterBean parameterBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.deleteParameter(parameterBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}	
	
	
	
	/**
	 * 得到所有商品服务信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllServices", method = RequestMethod.POST)
	public void getAllServices(MerchantsAccountBean merchantsAccountBean,GoodsServiceBean goodsServiceBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, goodsService.
				getAllServices(goodsServiceBean.setService_type("1").setParent_id("-1")));
	}

	/**
	 * 添加商品参数
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertService", method = RequestMethod.POST)
	public void insertService(MerchantsAccountBean merchantsAccountBean,GoodsServiceBean goodsServiceBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		String uuid=UUID.randomUUID().toString();
		
		int num=goodsService.insertService(goodsServiceBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 修改商品参数
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateService", method = RequestMethod.POST)
	public void updateService(MerchantsAccountBean merchantsAccountBean,GoodsServiceBean goodsServiceBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.updateService(goodsServiceBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	/**
	 * 删除商品参数
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteService", method = RequestMethod.POST)
	public void deleteService(MerchantsAccountBean merchantsAccountBean,GoodsServiceBean goodsServiceBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.deleteService(goodsServiceBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}	
	
	
	
	
	/**
	 * 获得品牌套餐
	 * @param merchantsAccountBean
	 * @param brandPackageBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getBrandPackages", method = RequestMethod.POST)
	public void getBrandPackages(MerchantsAccountBean merchantsAccountBean,BrandPackageBean brandPackageBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, goodsService.getBrandPackages(brandPackageBean,pageBean));
	}
	
	
	/**
	 * 添加品牌套餐
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertBrandPackage", method = RequestMethod.POST)
	public void insertBrandPackage(MerchantsAccountBean merchantsAccountBean,BrandPackageBean brandPackageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		String fileName=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+".html";	
		String path="/html/brand/package";
		writeHtml(request, path+fileName,"品牌详情展示",othersServiceC.getHtmlStyle(new HtmlStyleBean().setStyle_type("brand")));
		
		List<BrandPackageImgBean> imgs=new Gson().fromJson(request.getParameter("imgs"), new TypeToken<List<BrandPackageImgBean>>(){}.getType());
		int num=goodsService.insertBrandPackage(brandPackageBean.setPackage_url(path+"/"+fileName),imgs);
		if(num>0){
			WriteMsg(response, brandPackageBean.getBrand_id()+"");
		}else{
			WriteError(response, "添加失败");
		}
	}	
	/**
	 * 添加品牌套餐
	 * @param merchantsAccountBean
	 * @param goodsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateBrandPackage", method = RequestMethod.POST)
	public void updateBrandPackage(MerchantsAccountBean merchantsAccountBean,BrandPackageBean brandPackageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		List<BrandPackageImgBean> imgs=new Gson().fromJson(request.getParameter("imgs"), new TypeToken<List<BrandPackageImgBean>>(){}.getType());
		int num=goodsService.updateBrandPackage(brandPackageBean,imgs);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}	
	/**
	 * 上传品牌套餐图片
	 * @param merchantsAccountBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "uploadBrandPackageImg")
	public void uploadBrandPakcageImg(HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		String json=uploadFile(request, "/images/brand/package/");
		if(json.equals("-1")){
			WriteError(response, "文件不可为空");
		}else if(json.equals("-2")){
			WriteError(response, "上传失败");	
		}else{
			WriteMsg(response, json);
		}
	}	
	
	/**
	 * 获得某个品牌的所有商品
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getGoodsByBrand")
	public void getGoodsByBrand(MerchantsAccountBean merchantsAccountBean,GoodsBean goodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response,goodsService.getGoodsByBrand(goodsBean));
		
	}	
	
	/**
	 * 获得某个品牌套餐的选择商品
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getBrandPackageGoods")
	public void getBrandPackageGoods(MerchantsAccountBean merchantsAccountBean,BrandPackageGoodsBean brandPackageGoodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
				
		WriteObject(response, goodsService.getBrandPackageGoods(brandPackageGoodsBean));
	}	
	
	/**
	 * 添加某个品牌的套餐商品
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertBrandPackageGoods")
	public void insertBrandGoods(MerchantsAccountBean merchantsAccountBean,BrandPackageGoodsBean brandPackageGoodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.insertBrandPackageGoods(brandPackageGoodsBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}	
	/**
	 * 删除某个品牌的套餐商品
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteBrandPackageGoods")
	public void deleteBrandPackageGoods(MerchantsAccountBean merchantsAccountBean,BrandPackageGoodsBean brandPackageGoodsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=goodsService.deleteBrandPackageGoods(brandPackageGoodsBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}	
	
	/**
	 * 获得商家商品
	 * @param merchantsAccountBean
	 * @param businessGoodsBean
	 * @param pageBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getBusinessGoods")
	public void getBusinessGoods(MerchantsAccountBean merchantsAccountBean,BusinessGoodsBean  businessGoodsBean,
			PageBean pageBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, goodsService.getBusinessGoods(businessGoodsBean,pageBean),pageBean.getTotal());
	}	
	/**
	 * 导出商家商品 二维码
	 * @param merchantsAccountBean
	 * @param businessGoodsBean
	 * @param pageBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "dowmloadBusinessGoods")
	public void dowmloadBusinessGoods(MerchantsAccountBean merchantsAccountBean,
			BusinessGoodsBean  businessGoodsBean,MerchantsBean merchantsBean,
			PageBean pageBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		MerchantsBean merchantsBean2=merchantsService.getOneMerchantsDetail(merchantsBean);
		if(merchantsBean2!=null){
			String out=merchantsBean2.getMerchants_id()+TimeUtils.getCurrentTime("yyyyMMddHHmmss")+".zip";
			List<String> paths=goodsService.getBusinessGoodsQRCodePath(businessGoodsBean);
			if(paths==null||paths.size()<=0){
				WriteError(response, "暂无任何二维码");
				return;
			}
			boolean is_success=FileUtils.packZip(paths, request.getSession().getServletContext()
					.getRealPath("/")+"/images/qrcode/business_goods/"+out,request);
			if(is_success){
				WriteMsg(response, "/images/qrcode/business_goods/"+out);
			}else{
				WriteError(response, "下载失败");
			}	
		}else{
			WriteError(response, "无此商家");
		}
		
	}	
	
	
	@RequestMapping(params = "test1")
	public void test1(MerchantsAccountBean merchantsAccountBean,
				BusinessGoodsBean  businessGoodsBean,GoodsBean goodsBean,
				HttpServletRequest request,
				HttpServletResponse response) throws Exception{	
		String out=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+".zip";
		
		List<String> a=new ArrayList<String>();
		a.add("/images/qrcode/business_goods/201611111548051.png");
		boolean is_success=FileUtils.packZip(a, request.getSession().getServletContext()
				.getRealPath("/")+"/images/qrcode/business_goods/"+out,request);
		if(is_success){
			WriteMsg(response, "/images/qrcode/business_goods/"+out);
		}else{
			WriteError(response, "失败");
		}
	}
	
	/**
	 * 添加商家商品
	 * @param merchantsAccountBean
	 * @param businessGoodsBean
	 * @param pageBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertBusinessGoods")
	public void insertBusinessGoods(MerchantsAccountBean merchantsAccountBean,
			BusinessGoodsBean  businessGoodsBean,GoodsBean goodsBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		if(goodsService.getBusinessGood(businessGoodsBean)!=null){
			WriteError(response, "此商品已添加");
			return;
		}
		
		GoodsBean goodsBean2=goodsService.getOneGoodsDetail(goodsBean);
		
		
		String qrcode_img=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+"1.png";
		HostBean hostBean=othersServiceC.getHost(new HostBean().setHost_type("1"));

		boolean is_success=
				QRCodeUtils.CreateQrcode(request,"/images/qrcode/business_goods/"+qrcode_img, 
						hostBean.getHost_url()+"weixinhome/index.html#/shop_xq?"
								+ "list="+goodsBean2.getGoods_id()
								+ "&dp_id="+goodsBean2.getMerchants_id()
								+ "&business_id="+businessGoodsBean.getMerchants_id());
		if(!is_success){
			WriteError(response, "添加失败");
			return;
		}
		
		is_success=QRCodeUtils.composeQrcode(goodsBean2.getGoods_name(),request.getSession().getServletContext()
				.getRealPath("/")+goodsBean2.getGoods_img(), request.getSession().getServletContext()
				.getRealPath("/")+"/images/qrcode/business_goods/"+qrcode_img, request.getSession().getServletContext()
				.getRealPath("/")+"/images/qrcode/business_goods/"+qrcode_img);
		if(!is_success){
			WriteError(response, "合成失败");
			return;
		}
		
//		WXSetingBean wxSetingBean = othersServiceC.getWXSeting(new WXSetingBean().setWeixin_type("1"));
//
//		String access_token = WXUtils.getAccess_token(wxSetingBean.getWeixin_appid(), wxSetingBean.getWeixin_secret());
//
//		String result = WXUtils.getQrcode(access_token,
//				"wx_type=business&business_id="+businessGoodsBean.getMerchants_id()
//				+"&merchants_id="+goodsBean2.getMerchants_id()
//				+"&goods_id="+goodsBean2.getGoods_id());
//		String qrcode_img=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+"1.png";
//		boolean is_success=HttpUtils.downloadFile(result,request.getSession().getServletContext()
//				.getRealPath("/")+"/images/qrcode/business_goods/"+qrcode_img);
//		if(!is_success){
//			WriteError(response, "下载失败");
//			return;
//		}
//		
//		is_success=QRCodeUtils.composeQrcode(goodsBean2.getGoods_name(),request.getSession().getServletContext()
//				.getRealPath("/")+goodsBean2.getGoods_img(), request.getSession().getServletContext()
//				.getRealPath("/")+"/images/qrcode/business_goods/"+qrcode_img, request.getSession().getServletContext()
//				.getRealPath("/")+"/images/qrcode/business_goods/"+qrcode_img);
//		if(!is_success){
//			WriteError(response, "合成失败");
//			return;
//		}
		
		int num= goodsService.insertBusinessGoods(businessGoodsBean.setQrcode_img("/images/qrcode/business_goods/"+qrcode_img));
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	 
	
	/**
	 * 删除商家商品
	 * @param merchantsAccountBean
	 * @param businessGoodsBean
	 * @param pageBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteBusinessGoods")
	public void deleteBusinessGoods(MerchantsAccountBean merchantsAccountBean,BusinessGoodsBean  businessGoodsBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		int num= goodsService.deleteBusinessGoods(businessGoodsBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}	
	
	
	//**顺手拍
	@RequestMapping(params = "getSSPHomeClasss")
	public void getSSPHomeClasss(MerchantsAccountBean merchantsAccountBean,SSPClassBean sspClassBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, goodsService.getSSPHomeClasss(sspClassBean));
	}	
	@RequestMapping(params = "insertSSPHomeClass")
	public void insertSSPHomeClass(MerchantsAccountBean merchantsAccountBean,SSPClassBean sspClassBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		int num=goodsService.insertSSPHomeClass(sspClassBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}	
	
	@RequestMapping(params = "updateSSPHomeClass")
	public void updateSSPHomeClass(MerchantsAccountBean merchantsAccountBean,SSPClassBean sspClassBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		int num=goodsService.updateSSPHomeClass(sspClassBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}	
	
	@RequestMapping(params = "deleteSSPHomeClass")
	public void deleteSSPHomeClass(MerchantsAccountBean merchantsAccountBean,SSPClassBean sspClassBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}

		int num=goodsService.deleteSSPHomeClass(sspClassBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}	
}
