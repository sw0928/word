package tst.project.dao.controller;

import java.util.List;
import java.util.Map;

import tst.project.bean.finance.ProfitBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.order.BusinessProfitBean;
import tst.project.bean.order.LogisticsBean;
import tst.project.bean.order.OrderActivityBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.order.OrderGoodsBean;
import tst.project.bean.order.OrderParameterBean;
import tst.project.bean.order.OrderServiceBean;
import tst.project.bean.order.RefundBean;
import tst.project.bean.order.RefundImgBean;
import tst.project.bean.order.RefundReasonBean;
import tst.project.page.PageBean;

public interface OrderDaoC {
	
	/**
	 * 
	 * @param orderActivityBean
	 * @return
	 */
	public OrderActivityBean getOrderActivity(OrderActivityBean orderActivityBean);
	
	/**
	 * 
	 * @param orderBean
	 * @return
	 */
	public Map getOrderStatistics(OrderBean orderBean);
	
	/**
	 * 修改退款详情
	 * @return
	 */
	public int updateRefundDetail(RefundBean refundBean);
	
	/**
	 * 获得物流公司 不分页
	 * @param logisticsBean
	 * @return
	 */
	public List<LogisticsBean> getOrderLogisticsNoPage(LogisticsBean logisticsBean);
	
	/**
	 * 获得物流公司
	 * @param logisticsBean
	 * @return
	 */
	public List<LogisticsBean> getOrderLogistics(LogisticsBean logisticsBean,PageBean pageBean);
	
	/**
	 * 添加物流公司
	 * @param logisticsBean
	 * @return
	 */
	public int insertOrderLogistics(LogisticsBean logisticsBean);
	
	/**
	 * 修改物流公司
	 * @param logisticsBean
	 * @return
	 */
	public int updateOrderLogistics(LogisticsBean logisticsBean);

	/**
	 * 删除物流公司
	 * @param logisticsBean
	 * @return
	 */
	public int deleteOrderLogistics(LogisticsBean logisticsBean);
	/**
	 * 订单收益统计
	 * @param profitBean
	 * @return
	 */
	public Map getOrderProfits(OrderBean orderBean);
	
	/**
	 * 获得收益详情
	 * @param businessProfitBean
	 * @param pageBean
	 * @return
	 */
	public ProfitBean getBusinessProfitsTypeCount(BusinessProfitBean businessProfitBean);
	
	/**
	 * 获得收益详情
	 * @param businessProfitBean
	 * @param pageBean
	 * @return
	 */
	public List<BusinessProfitBean> getBusinessProfitsType(BusinessProfitBean businessProfitBean,PageBean pageBean);

	
	/**
	 * 更新订单数据
	 * @return
	 */
	public int updateOrderGoodsDetail(OrderGoodsBean orderGoodsBean);
	
	/**
	 * 更新订单数据
	 * @return
	 */
	public int updateOrderDetail(OrderBean orderBean);
	
	/**
	 * 添加退款原因
	 * @param refundReasonBean
	 * @return
	 */
	public int insertRefundReason(RefundReasonBean refundReasonBean);
	/**
	 * 修改退款原因
	 * @param refundReasonBean
	 * @return
	 */
	public int updateRefundReason(RefundReasonBean refundReasonBean);
	/**
	 * 删除退款原因
	 * @param refundReasonBean
	 * @return
	 */
	public int deleteRefundReason(RefundReasonBean refundReasonBean);
	/**
	 * 商品退款可能的原因
	 * @return
	 */
	public List<RefundReasonBean> getRefundReasons(RefundReasonBean refundReasonBean,PageBean pageBean);
	
	/**
	 * 审核退款申请
	 */
	public int updateRefundState(RefundBean refundBean);
	
	/**
	 * 退款申请详情
	 * @param refundBean
	 * @return
	 */
	public RefundBean getOrderRefundDetail(RefundBean refundBean);
	
	/**
	 * 获得所有退单申请
	 * @return
	 */
	public List<RefundBean> getOrderRefunds(RefundBean refundBean,PageBean pageBean);
	
	/**
	 * 获得店铺退款订单列表
	 * @param refundBean
	 * @return
	 */
	public List<RefundBean> getBussinessRefundOrders(RefundBean refundBean,PageBean pageBean);
	
	/**
	 * 获得店铺退款单个订单详情
	 * @param refundBean
	 * @return
	 */
	public RefundBean getOneBussinessRefundOrder(RefundBean refundBean);
	
	/**
	 * 单个退款图片详情
	 * @param refundBean
	 * @return
	 */
	public List<RefundImgBean> getRefundImgs(RefundImgBean refundImgBean);
	
	/**
	 * 获得历史收益
	 * @param orderGoodsBean
	 * @return
	 */
	public String getHistoryBusinessProfitsPrice(OrderGoodsBean orderGoodsBean);
	
	/**
	 * 商户的收益
	 * @param orderGoodsBean
	 * @param pageBean
	 * @return
	 */
	public List<OrderGoodsBean> getBusinessProfits(OrderGoodsBean orderGoodsBean,PageBean pageBean);
	
	/**
	 * 获得店铺的订单列表（家纺）
	 * @param orderBean
	 * @param pageBean
	 * @return
	 */
	public List<OrderBean> getBusinessOrderList(OrderBean orderBean,PageBean pageBean);
	
	
	/**
	 * 获得店铺的订单商品列表（家纺） 
	 * @param orderGoodsBean
	 * @return
	 */
	public List<OrderGoodsBean> getBusinessOrderGodoss(OrderGoodsBean orderGoodsBean);
	
	/**
	 * 获得店铺的订单详情（家纺）
	 * @param orderBean
	 * @param pageBean
	 * @return
	 */
	public OrderBean getOneBusinessOrderDetail(OrderBean orderBean);
	
	/**
	 * 获得用户的订单列表
	 * @return
	 */
	public List<OrderBean> getMemberOrderList(OrderBean orderBean,PageBean pageBean);
	
	/**
	 * 确认发货
	 * @param orderBean
	 * @return
	 */
	public int confirmSendOrder(OrderBean orderBean);
	/**
	 * 获得订单的商品详情
	 * @param orderGoodsBean
	 * @return
	 */
	public OrderGoodsBean getOrderGoodsDetail(OrderGoodsBean orderGoodsBean);
	/**
	 * 获得订单的商品的参数列表
	 * @param orderGoodsBean
	 * @return
	 */
	public List<OrderParameterBean> getOrderGoodsParameters(OrderParameterBean orderParameterBean);
	/**
	 * 获得订单的商品的服务列表
	 * @param orderGoodsBean
	 * @return
	 */
	public List<OrderServiceBean> getOrderGoodsServices(OrderServiceBean orderServiceBean);
	/**
	 * 获得订单的商品
	 * @param orderGoodsBean
	 * @return
	 */
	public List<OrderGoodsBean> getOrderGoodss(OrderGoodsBean orderGoodsBean);
	
	public OrderGoodsBean getOrderGoodssByGoods(OrderGoodsBean orderGoodsBean);
	/**
	 * 获得商家的订单详情
	 * @return
	 */
	public OrderBean getOrderDetail(OrderBean orderBean);
	
	/**
	 * 获得商家的订单列表
	 * @return
	 */
	public List<OrderBean> getOrderList(OrderBean orderBean,PageBean pageBean);
	
	public Map getOrderGoodsListCount(OrderBean orderBean);
	
	public List<OrderGoodsBean> getOrderGoodsList(OrderBean orderBean, PageBean pageBean);
	
	/**
	 * 导出订单列表
	 * @param orderBean
	 * @return
	 */
	public List<Object> exportOrderExcel(OrderBean orderBean);
	
	/*
	 * 新增
	 */
	public List<OrderGoodsBean> getOrderGoodsList2(OrderGoodsBean orderGoodsBean, PageBean pageBean);
	
	public Map getOrderGoodsListCount2(OrderGoodsBean orderGoodsBean);
}
