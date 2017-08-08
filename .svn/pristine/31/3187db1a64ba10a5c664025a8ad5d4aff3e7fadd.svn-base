package tst.project.module;

import java.util.List;

import tst.project.bean.address.CityBean;
import tst.project.bean.address.RegionBean;

public class CityMoudle {
	List<RegionBean> cityBeans;
	List<CityBean> provinceBeans;
	
	
	
	public List<CityBean> getProvinceBeans() {
		return provinceBeans;
	}

	public CityMoudle setProvinceBeans(List<CityBean> provinceBeans) {
		this.provinceBeans = provinceBeans;
		return this;
	}

	public List<RegionBean> getCityBeans() {
		return cityBeans;
	}

	public void setCityBeans(List<RegionBean> cityBeans) {
		this.cityBeans = cityBeans;
	}

	private static class Moudle {
		protected final static CityMoudle mInstance = new CityMoudle();
	}

	public static CityMoudle getInstance() {
		return Moudle.mInstance;
	}
}
