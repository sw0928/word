package tst.project.service.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pingplusplus.model.Card;

import tst.project.bean.distribution.DistributionBean;
import tst.project.bean.distribution.TotalDistributionBean;
import tst.project.bean.goods.CardBean;
import tst.project.bean.member.MemberBean;
import tst.project.dao.controller.DistributionDao;
import tst.project.page.PageBean;
import tst.project.utils.CreateRandom;

@Service
@Transactional(rollbackFor = Exception.class)
public class DistributionService {
	@Resource
	DistributionDao distributionDao;
	
	/**
	 * 平台统计
	 * @param memberBean
	 * @return
	 */
	public List<Object> exportAllDistributon(DistributionBean distributionBean){
		List<Object> objects=new ArrayList<Object>();
		DistributionBean distributionBean2=distributionDao.exportAllDistributon1(distributionBean);
		System.out.println("---------------------------------------");

		if(distributionBean2!=null){
			System.out.println("====================================");
			objects.add(distributionBean2.setMobile_phone("总计:"));		
		}
		
		List<Object>  objects2=distributionDao.exportAllDistributon(distributionBean);
		if(objects2!=null){
			objects.addAll(objects2);
		}
		return objects;
	}
	
	/**
	 * vip用户导出
	 * @param memberBean
	 * @return
	 */
	public List<Object> exportDistributionsExcel(MemberBean memberBean){
		return distributionDao.exportDistributionsExcel(memberBean);
	}
	/**
	 * 不是未vip用户导出
	 * @param memberBean
	 * @return
	 */
	public List<Object> exportUnDistributionsExcel(MemberBean memberBean){
		return distributionDao.exportUnDistributionsExcel(memberBean);
	}
	
	public TotalDistributionBean getTotalDistributionsCount(TotalDistributionBean totalDistributionBean){
		return distributionDao.getTotalDistributionsCount(totalDistributionBean);
	}
	/**
	 * 平台未获得佣金
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public TotalDistributionBean getTotalUnDistributionsCount(TotalDistributionBean totalDistributionBean){	
		return distributionDao.getTotalUnDistributionsCount(totalDistributionBean);
	}
	/**
	 * 未获得佣金
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public List<Object> exportUnDistributions(MemberBean memberBean,String type){
		List<Object> objects=new ArrayList<Object>();
		List<Object> objects1=distributionDao.exportUnDistributions1(memberBean);
		if(objects1!=null){
			TotalDistributionBean totalDistributionBean=distributionDao.getUnDistributionsCount1(memberBean); 
			if(totalDistributionBean!=null){
				System.out.println("121321312312321");
				objects.add(new DistributionBean()
						.setDistribution_type("人数总计:")
						.setUser_id(objects1.size()+"")
						.setUser_name("金额总计")
						.setMobile_phone(totalDistributionBean.getTotal_price()+""));	
			}
			objects.addAll(objects1);
		}
		
		List<Object> objects2=distributionDao.exportUnDistributions2(memberBean);
		if(objects2!=null){
			TotalDistributionBean totalDistributionBean=distributionDao.getUnDistributionsCount2(memberBean); 
			if(totalDistributionBean!=null){
				System.out.println("cddcqwd");

				objects.add(new DistributionBean()
						.setDistribution_type("人数总计:")
						.setUser_id(objects2.size()+"")
						.setUser_name("金额总计")
						.setMobile_phone(totalDistributionBean.getTotal_price()+""));	
			}
			objects.addAll(objects2);
		}
		
		List<Object> objects3=distributionDao.exportDistributions1(memberBean);
		if(objects3!=null){
			float price=distributionDao
					.getDistributionsCount(new DistributionBean().setMember_id(memberBean.getMember_id()+"")
											.setDistribution_relation("vip1")); 
			if(price!=0){
				objects.add(new DistributionBean()
						.setDistribution_type("人数总计:")
						.setUser_id(objects3.size()+"")
						.setUser_name("金额总计")
						.setMobile_phone(price+""));				
			}			
			objects.addAll(objects3);
		}
		
		List<Object> objects4=distributionDao.exportDistributions2(memberBean);
		if(objects4!=null){
			float price=distributionDao
					.getDistributionsCount(new DistributionBean().setMember_id(memberBean.getMember_id()+"")
											.setDistribution_relation("vip2")); 
			if(price!=0){
				objects.add(new DistributionBean()
						.setDistribution_type("人数总计:")
						.setUser_id(objects4.size()+"")
						.setUser_name("金额总计")
						.setMobile_phone(price+""));				
			}
			objects.addAll(objects4);	
		}
		return objects;
	}
	
	/**
	 * 未获得佣金
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public TotalDistributionBean getUnDistributionsCount(MemberBean memberBean,String type,PageBean pageBean){
		TotalDistributionBean totalDistributionBean=new TotalDistributionBean();
		//float price=0;
		if("1".equals(type)){
			totalDistributionBean=distributionDao.getUnDistributionsCount1(memberBean);
		}else{
			totalDistributionBean=distributionDao.getUnDistributionsCount2(memberBean);
		}
		//totalDistributionBean.setTotal_price(price);
		totalDistributionBean.setDistributionBeans(getUnDistributions(memberBean,type,pageBean));			
		return totalDistributionBean;
	}
	
	/**
	 * 未获得佣金
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public List<DistributionBean> getUnDistributions(MemberBean memberBean,String type,PageBean pageBean){
		if("1".equals(type)){
			return distributionDao.getUnDistributions1(memberBean, pageBean);			
		}else{
			return distributionDao.getUnDistributions2(memberBean, pageBean);
		}
	}
	
	public TotalDistributionBean getDistributionsCount(DistributionBean distributionBean,PageBean pageBean){
		TotalDistributionBean totalDistributionBean=new TotalDistributionBean();
		totalDistributionBean.setTotal_price(distributionDao.getDistributionsCount(distributionBean));
		totalDistributionBean.setDistributionBeans(getDistributions(distributionBean,pageBean));
		
		return totalDistributionBean;
	}
	
	/**
	 * 用户的分销余额详情
	 * @param distributionBean
	 * @return
	 */
	public List<DistributionBean> getDistributions(DistributionBean distributionBean,PageBean pageBean){
		return distributionDao.getDistributions(distributionBean,pageBean);
	}
	
	
	
	/**
	 * 收益列表
	 * @param distributionBean
	 * @return
	 */
	public List<DistributionBean> getProfits(DistributionBean distributionBean,PageBean pageBean){
		return distributionDao.getProfits(distributionBean,pageBean);
	}
	
	/**
	 * 获得分销卡列表
	 * @return
	 */
	public List<CardBean> getCardGoodss(CardBean cardBean,PageBean pageBean){
		return distributionDao.getCardGoodss(cardBean, pageBean);
	}
	
	/**
	 * 删除分销卡（特殊商品）
	 * @param cardBean
	 * @return
	 */
	public int deleteCardGoods(CardBean cardBean){
		return distributionDao.deleteCardGoods(cardBean);
	}
	/**
	 * 添加分销卡（特殊商品）
	 * @param cardBean
	 * @return
	 */
	public int insertCardGoods(List<CardBean> cardBeans){
		int num=0;
		for (int i = 0; i < cardBeans.size(); i++) {
			try{
				num=distributionDao.insertCardGoods(cardBeans.get(i));
			}catch(Exception e){
				
			}
		}
		return 1;
	}
	/**
	 * 添加分销卡（特殊商品）
	 * @param cardBean
	 * @return
	 */
	public int insertCardGoods(CardBean cardBean,int count){
		int num=0;
		for (int i = 0; i < count; i++) {
			String code=CreateRandom.createRandom(false,8);
			try{
				num=distributionDao.insertCardGoods(cardBean.setCard_code(code));
			}catch(Exception e){
				i--;
			}
		}
		return num;
	}
}
