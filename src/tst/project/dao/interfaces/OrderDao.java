package tst.project.dao.interfaces;

import java.util.List;
import java.util.Map;
import tst.project.bean.distribution.DistributionBean;
import tst.project.bean.goods.GoodsParameterBean;
import tst.project.bean.goods.GoodsServiceBean;
import tst.project.bean.goods.ShoppingCarMemberBean;
import tst.project.bean.goods.ShoppingCarShareBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.order.AssessmentBean;
import tst.project.bean.order.AssessmentImgBean;
import tst.project.bean.order.BusinessProfitBean;
import tst.project.bean.order.InviseBean;
import tst.project.bean.order.LogisticsBean;
import tst.project.bean.order.LogisticsDetailBean;
import tst.project.bean.order.OrderActivityBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.order.OrderGoodsBean;
import tst.project.bean.order.OrderLineBean;
import tst.project.bean.order.OrderParameterBean;
import tst.project.bean.order.OrderServiceBean;
import tst.project.bean.order.RefundBean;
import tst.project.bean.order.RefundImgBean;
import tst.project.bean.order.RefundReasonBean;
import tst.project.page.PageBean;

public interface OrderDao {
	
	/**
	 * 更新分享购物车状态
	 * @param shoppingCarShareBean
	 * @return
	 */
	public int updateShareCarState(ShoppingCarShareBean shoppingCarShareBean);
	/**
	 * 修改分享购物车状态
	 * @return
	 */
	public int updateMemberCarState(ShoppingCarMemberBean shoppingCarMemberBean);
	
	/**
	 * 获得订单活动
	 * @return
	 */
	public int insertOrderActivity(OrderActivityBean orderActivityBean);
	
	/**
	 * 物流公司信息
	 * @return
	 */
	public LogisticsBean getOneLogistics(LogisticsBean logisticsBean);
	
	/**
	 * 物流信息入库
	 * @param logisticsDetailBean
	 * @return
	 */
	public int insertLogisticsDetail(LogisticsDetailBean logisticsDetailBean);
	
	/**
	 * 此物流单号 最后一次录入信息
	 * @param logisticsDetailBean
	 * @return
	 */
	public LogisticsDetailBean getLastLogistics(LogisticsDetailBean logisticsDetailBean);
	
	/**
	 * 获得订单的物流详情列表  不分页
	 * @param map
	 * @return
	 */
	public List<LogisticsDetailBean> getOrderLogisticsDetails(LogisticsDetailBean logisticsDetailBean);
	
	/**
	 * 获得订单的物流详情列表 
	 * @param map
	 * @return
	 */
	public List<LogisticsDetailBean> getOrderLogisticsDetails(LogisticsDetailBean logisticsDetailBean,PageBean pageBean);
	
	/**
	 * 获得订单发票内容
	 * @param inviseBean
	 * @return
	 */
	public List<InviseBean> getOrderInviseContents(InviseBean inviseBean);
	
	/**
	 * 线下订单
	 * @param orderLineBean
	 * @return
	 */
	public List<OrderLineBean> getOrderLines(OrderLineBean orderLineBean,PageBean pageBean);
	
	/**
	 * 分销收益修改
	 * @param distributionBean
	 * @return
	 */
	public int updateDistribution(DistributionBean distributionBean);
	
	
	/**
	 * 分销收益入库
	 * @param distributionBean
	 * @return
	 */
	public int insertDistribution(DistributionBean distributionBean);
	
	/**
	 * 通过订单商品id获得收益列表
	 * @param businessProfitBean
	 * @return
	 */
	public List<BusinessProfitBean> getBusinessProfitByOrderGoods(BusinessProfitBean businessProfitBean);
	
	/**
	 * 
	 * @param businessProfitBean
	 * @return
	 */
	public int updateBusinessProfit(BusinessProfitBean businessProfitBean);
	
	/**
	 * 添加店铺收益
	 * @return
	 */
	public int insertBusinessProfit(BusinessProfitBean businessProfitBean);
	
	
	/**
	 * 获得订单原因列表
	 * @param refundReasonBean
	 * @return
	 */
	public List<RefundReasonBean> getRefundsReasons(RefundReasonBean refundReasonBean);
	
	/**
	 * 用户的退款列表 各个状态统计
	 * @param refundBean
	 * @return
	 */
	public Map getMemberRefundCount(RefundBean refundBean);
	
	/**
	 * 用户的退款列表
	 * @param refundBean
	 * @return
	 */
	public List<RefundBean> getMemberRefunds(RefundBean refundBean,PageBean pageBean);
	
	/**
	 * 单个退款详情
	 * @param refundBean
	 * @return
	 */
	public RefundBean getRefundDetail(RefundBean refundBean);
	
	
	/**
	 * 单个退款图片详情
	 * @param refundBean
	 * @return
	 */
	public List<RefundImgBean> getRefundImgs(RefundImgBean refundImgBean);
	
	
	/**
	 * 查询某个商品的订单详情
	 * @param refundBean
	 * @return
	 */
	public RefundBean getRefundByGoods(RefundBean refundBean);
	
	/**
	 * 退款信息入库
	 * @param refundBean
	 * @param files
	 * @return
	 */
	public int insertRefund(RefundBean refundBean);
	
	/**
	 * 退款图片信息入库
	 * @param refundBean
	 * @param files
	 * @return
	 */
	public int insertRefundImg(RefundImgBean refundImgBean);
	
	/**
	 * 添加订单
	 * 
	 * @param orderBean
	 * @return
	 * @throws Exception
	 */
	public int insertRechargeOrder(OrderBean orderBean);
	/**
	 * 添加订单
	 * @param orderBean
	 * @return
	 */
	public int insertOrder(OrderBean orderBean);
	
	/**
	 * 添加订单商品
	 * @param orderGoodsBean
	 * @return
	 */
	public int insertOrderGoods(OrderGoodsBean orderGoodsBean);
	
	/**
	 * 修改订单商品
	 * @return
	 */
	public int updateOrderGoods(OrderGoodsBean orderGoodsBean);
	/**
	 * 获得单个商品参数详情
	 * @param goodsParameterBean
	 * @return
	 */
	public GoodsParameterBean getOneParameter(GoodsParameterBean goodsParameterBean);
	
	
	/**
	 * 添加订单商品参数
	 * @param orderParameterBean
	 * @return
	 */
	public int insertOrderParameter(OrderParameterBean orderParameterBean);
	
	/**
	 * 获得订单选择的商品参数
	 * @param orderParameterBean
	 * @return
	 */
	public List<OrderParameterBean> getOrderParameters(OrderParameterBean orderParameterBean);
	
	/**
	 * 获得订单选择的服务列表
	 * @param orderServiceBean
	 * @return
	 */
	public List<OrderServiceBean> getOrderServices(OrderServiceBean orderServiceBean);
	
	/**
	 * 添加单个商品服务详情
	 * @param goodsServiceBean
	 * @return
	 */
	public GoodsServiceBean getOneService(GoodsServiceBean goodsServiceBean);
	
	/**
	 * 添加订单商品服务
	 * @param orderServiceBean
	 * @return
	 */
	public int insertOrderService(OrderServiceBean orderServiceBean);
	
	/**
	 * 更新订单信息
	 * @param orderBean
	 * @return
	 */
	public int updateOrderDetail(OrderBean orderBean);
	
	/**
	 * 获得订单列表
	 * @return
	 */
	public List<OrderBean> getOrders(OrderBean orderBean,PageBean pageBean);
	
	
	/**
	 * 获得订单列表
	 * 
	 * @return
	 */
	public List<OrderBean> getOrdersByPayNo(OrderBean orderBean);
	
	/**
	 *  获得订单列表 每个状态统计
	 * @param orderBean
	 * @return
	 */
	public Map getOrdersCount(OrderBean orderBean);
	/**
	 * 订单活动列表
	 * @param orderActivityBean
	 * @return
	 */
	public List<OrderActivityBean> getOrderActivitys(OrderActivityBean orderActivityBean);
	
	/**
	 * 获得订单商品列表
	 * @return
	 */
	public List<OrderGoodsBean> getOrderGoodss(OrderGoodsBean orderGoodsBean);
	/**
	 * 获得单个订单商品
	 * @return
	 */
	public OrderGoodsBean getOrderGoodssByGoods(OrderGoodsBean orderGoodsBean);
	
	/**
	 * 单个订单详情
	 * @param orderBean
	 * @return
	 */
	public OrderBean getOneOrderDetail(OrderBean orderBean);
	
	/**
	 * 单个订单详情
	 * 
	 * @param orderBean
	 * @return
	 */
	public OrderBean getOneOrderDetailZSSG(OrderBean orderBean);
	/**
	 * 取消订单
	 * @param orderBean
	 * @return
	 */
	public int cancelOrder(OrderBean orderBean);
	/**
	 * 删除订单
	 * @return
	 */
	public int deleteOrder(OrderBean orderBean);
	/**
	 * 付款订单改变状态
	 * @param orderBean
	 * @return
	 */
	public int payOrder(OrderBean orderBean);
	
	/**
	 * 团购人数满之后 把订单状态改成代发货
	 * @param orderBean
	 * @return
	 */
	public int updateOrderStateByGroupBuy(OrderBean orderBean);
	/**
	 * 确认收货
	 * @param orderBean
	 * @return
	 */
	public int confirmOrder(OrderBean orderBean);
	
	/**
	 * 可追加评价订单
	 * @param orderBean
	 * @param pageBean
	 * @return
	 */
	public List<OrderBean> getCanAddAssessmentOrder(OrderBean orderBean,PageBean pageBean);
	
	/**
	 * 评价订单
	 * @param assessmentBeans
	 * @return
	 */
	public int insertAssessmentOrder(AssessmentBean assessmentBean);
	
	/**
	 * 添加评价图片
	 * @return
	 */
	public int insertAssessmentImg(AssessmentImgBean assessmentImgBean);
	
	/**
	 * 评价完 改变订单状态
	 * @param orderBean
	 * @return
	 */
	public int assessmentOrder(OrderBean orderBean);
	
	/**
	 * 评价完 改变商家的星级
	 * @param merchantsBean
	 * @return
	 */
	public int updateMerchantsStar(MerchantsBean merchantsBean);
	/**
	 *用户评价列表
	 * @param assessmentBean
	 * @param pageBean
	 * @return
	 */
	public  List<AssessmentBean> getMemberAssessments(AssessmentBean assessmentBean, PageBean pageBean);
	/**
	 *用户评价列表
	 * @param assessmentBean
	 * @param pageBean
	 * @return
	 */
	public  List<AssessmentBean> getMemberAssessments(AssessmentBean assessmentBean);
	
	/**
	 *用户评价列表
	 * @param assessmentBean
	 * @param pageBean
	 * @return
	 */
	public  List<AssessmentBean> getMemberAssessmentsV2(AssessmentBean assessmentBean, PageBean pageBean);
	
	/**
	 * 评价列表
	 * @param assessmentBean
	 * @return
	 */
	public List<AssessmentBean> getOrderAssessments(AssessmentBean assessmentBean,PageBean pageBean);
	/**
	 * 评价列表
	 * @param assessmentBean
	 * @return
	 */
	public List<AssessmentBean> getOrderAssessmentsGood(AssessmentBean assessmentBean,PageBean pageBean);
	/**
	 * 评价列表
	 * @param assessmentBean
	 * @return
	 */
	public List<AssessmentBean> getOrderAssessmentsBad(AssessmentBean assessmentBean,PageBean pageBean);
	/**
	 * 评价列表
	 * @param assessmentBean
	 * @return
	 */
	public List<AssessmentBean> getOrderAssessmentsIn(AssessmentBean assessmentBean,PageBean pageBean);
	/**
	 * 获得订单晒图评价
	 * @param assessmentBean
	 * @return
	 */
	public List<AssessmentBean> getOrderAssessmentsImg(AssessmentBean assessmentBean,PageBean pageBean);
	
	
	/**
	 * 评价图片列表
	 * @param assessmentImgBean
	 * @return
	 */
	public List<AssessmentImgBean> getOrderAssessmentImgs(AssessmentImgBean assessmentImgBean);
}
