package tst.project.service.interfaces;

import tst.project.bean.address.AddressBean;
import tst.project.bean.goods.ShoppingCarBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.dao.interfaces.OrderDao;
import tst.project.utils.TimeUtils;

public class OrderUtils {
	
	
	public static int insertOrder(OrderBean orderBean,OrderMerchantsBean orderMerchantsBean,AddressBean addressBean,
			MerchantsBean merchantsBean,MerchantsServiceI merchantsServiceI,OrderDao orderDao) throws Exception{
		orderBean.setMerchantsBean(merchantsBean);
		orderBean.setAddressBean(addressBean);

		String order_no = TimeUtils.getCurrentTime("yyyyMMddHHmmss");
		orderBean.setOrder_state("wait_pay");// 订单状态
		orderBean.setOrder_no(order_no);// 订单号
		orderBean.setMember_id(orderMerchantsBean.getMember_id());// 用户id
		orderBean.setAddress_id(orderMerchantsBean.getAddress_id());// 地址id
		//orderBean.setInvoice_rise(orderMerchantsBean.getInvoice_rise());// 发票抬头
		orderBean.setOrder_type(orderMerchantsBean.getOrder_type());// 订单类型
		orderBean.setMember_group_buy_id(orderMerchantsBean.getMember_group_buy_id());// 用户团购id

		int num = orderDao.insertOrder(orderBean);// 订单入库
		if (num <= 0) {
			throw new Exception("订单入库失败");
		}
		return 1;
	}
	/**
	 * 下订单 删除购物车
	 * @param shop_car_ids
	 * @param shoppingCarService
	 * @param member_id
	 * @return
	 * @throws Exception
	 */
	public static boolean deleteShopCars(String  shop_car_ids,ShoppingCarService shoppingCarService,String member_id) throws Exception{
		if (shop_car_ids != null && shop_car_ids.length() > 0) {
			String[] car_ids = shop_car_ids.split(",");
			for (int i = 0; i < car_ids.length; i++) {
				int m = shoppingCarService.deleteShoppingCar(new ShoppingCarBean()
						.setCar_id(Integer.valueOf(car_ids[i])).setMember_id(member_id));
				if (m <= 0) {
					throw new Exception("购物车删除失败");
				}
			}
		}
		return false;
	}
}
