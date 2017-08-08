package tst.project.dao.interfaces;

import java.util.List;

import tst.project.bean.collection.CollectionBean;
import tst.project.page.PageBean;

public interface CollectionDao {

	/**
	 * 添加收藏
	 * @param collectionBean
	 * @return
	 */
	public int insertCollection(CollectionBean collectionBean);
	
	/**
	 * 通过各种条件 搜索
	 * @param collectionBean
	 * @return
	 */
	public CollectionBean getCollectionBySearch(CollectionBean collectionBean);
	
	/**
	 * 改变收藏状态  删除或者恢复
	 * @return
	 */
	public int updateCollectionState(CollectionBean collectionBean);
	
	/**
	 * 用户获得收藏列表
	 * @param collectionBean
	 * @return
	 */
	public List<CollectionBean> getCollection(CollectionBean collectionBean,PageBean pageBean);
}
