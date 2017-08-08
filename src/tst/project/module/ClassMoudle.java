package tst.project.module;

import java.util.List;

import tst.project.bean.goods.GoodsBean;

public class ClassMoudle {
	List<GoodsBean> goods1Beans;
	List<GoodsBean> goods2Beans;
	List<GoodsBean> goods3Beans;

	public List<GoodsBean> getGoods1Beans() {
		return goods1Beans;
	}

	public ClassMoudle setGoods1Beans(List<GoodsBean> goods1Beans) {
		this.goods1Beans = goods1Beans;
		return this;
	}

	public List<GoodsBean> getGoods2Beans() {
		return goods2Beans;
	}

	public ClassMoudle setGoods2Beans(List<GoodsBean> goods2Beans) {
		this.goods2Beans = goods2Beans;
		return this;
	}

	public List<GoodsBean> getGoods3Beans() {
		return goods3Beans;
	}

	public ClassMoudle setGoods3Beans(List<GoodsBean> goods3Beans) {
		this.goods3Beans = goods3Beans;
		return this;
	}

	private static class Moudle {
		protected final static ClassMoudle mInstance = new ClassMoudle();
	}

	public static ClassMoudle getInstance() {
		return Moudle.mInstance;
	}
}
