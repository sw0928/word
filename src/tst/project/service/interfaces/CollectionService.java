package tst.project.service.interfaces;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import tst.project.bean.collection.CollectionBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.information.InformationBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.dao.interfaces.CollectionDao;
import tst.project.page.PageBean;
import tst.project.service.controller.GoodsService;
import tst.project.service.controller.MerchantsService;


@Service
@Transactional(rollbackFor = { Exception.class })
public class CollectionService {
	@Resource
	CollectionDao collectionDao;

	@Resource
	MerchantsServiceI merchantsServiceI;

	@Resource
	GoodsServiceI goodsServiceI;
	
	@Resource
	InformationService informationService;
	/**
	 * 添加收藏
	 * 
	 * @param collectionBean
	 * @return
	 */
	public int insertCollection(CollectionBean collectionBean) {
		return collectionDao.insertCollection(collectionBean);
	}

	/**
	 * 通过各种条件 搜索 判断是否收藏过
	 * 
	 * @param collectionBean
	 * @return
	 */
	public CollectionBean getCollectionBySearch(CollectionBean collectionBean) {
		return collectionDao.getCollectionBySearch(collectionBean);
	}

	/**
	 * 改变收藏状态 删除或者恢复
	 * 
	 * @return
	 */
	public int updateCollectionState(CollectionBean collectionBean) {
		return collectionDao.updateCollectionState(collectionBean);
	}

	/**
	 * 批量取消收藏
	 * @param collect_ids
	 * @return
	 * @throws Exception
	 */
	public int cancelAllCollection(String member_id,String[] collect_ids) throws Exception{
		for (int i = 0; i < collect_ids.length; i++) {
			int num= collectionDao.updateCollectionState(new CollectionBean().
					setMember_id(member_id).
					setCollection_id(Integer.valueOf(collect_ids[i]))
					.setIs_delete("1"));
			if(num<=0){
				throw new Exception("取消失败");
			}
		}
		return 1;
	}
	/**
	 * 用户获得收藏列表
	 * 
	 * @param collectionBean
	 * @return
	 */
	public List<CollectionBean> getCollection(CollectionBean collectionBean,
			PageBean pageBean) {
		List<CollectionBean> collectionBeans = collectionDao
				.getCollection(collectionBean,pageBean);
		if(collectionBeans!=null){
			for (int i = 0; i < collectionBeans.size(); i++) {
				CollectionBean collectionBean2 = collectionBeans.get(i);
				
				if(collectionBean2.getCollection_type().equals("merchants")){
					MerchantsBean merchantsBean=merchantsServiceI.getOneMerchantsDetail(new MerchantsBean()
					.setMerchants_id(Integer.valueOf(collectionBean2.getRelation_id())));
					collectionBean2.setMerchantsBean(merchantsBean);	
					
				}else if(collectionBean2.getCollection_type().equals("goods")){
					GoodsBean goodsBean=goodsServiceI.getOneGoodsDetail(new GoodsBean().
							setGoods_id(Integer.valueOf(collectionBean2.getRelation_id())));
					collectionBean2.setGoodsBean(goodsBean);
				}else if(collectionBean2.getCollection_type().equals("information")){
					InformationBean informationBean=informationService
							.getInformationDetail(new InformationBean()
									.setInformation_id(Integer.valueOf(collectionBean2.getRelation_id())));
					collectionBean2.setInformationBean(informationBean);
				}
			}	
		}
		return collectionBeans;
	}
	
}
