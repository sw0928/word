package tst.project.service.interfaces;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.address.AddressBean;
import tst.project.bean.address.CityBean;
import tst.project.bean.address.RegionBean;
import tst.project.bean.address.SinceBean;
import tst.project.dao.interfaces.AddressDao;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor = Exception.class)
public class AddressService {
	@Resource
	AddressDao addressDao;

	/**
	 * 添加城市
	 * @param cityBean
	 * @return
	 */
	public int insertCity(List<Map> maps){
		for (int i = 0; i < maps.size(); i++) {
			Map map=maps.get(i);
			CityBean cityBean=new CityBean().setName(map.get("name").toString()).setParent_id("-1");
			int num=addressDao.insertCity(cityBean);
			
			List<Map> maps2=(List<Map>) map.get("cityList");
			for (int j = 0; j < maps2.size(); j++) {
				 Map map2=maps2.get(j);
				 CityBean cityBean2=new CityBean().setName(map2.get("name").toString()).setParent_id(cityBean.getId()+"");
				 num=addressDao.insertCity(cityBean2);
				 
				 List<String> stirngs=(List<String>) map2.get("areaList");
				 for (int k = 0; k < stirngs.size(); k++) {
					String name=stirngs.get(k);
					CityBean cityBean3=new CityBean().setName(name).setParent_id(cityBean2.getId()+"");
					num=addressDao.insertCity(cityBean3);
				}
			}
		}
		return 1;
	}
	
	/**
	 * 单个自提点详情
	 * @return
	 */
	public SinceBean getOneSince(SinceBean sinceBean){
		return addressDao.getOneSince(sinceBean);
	}
	/**
	 * 城市自提点
	 * @return
	 */
	public List<SinceBean> getCitySinces(SinceBean sinceBean){
		return addressDao.getCitySinces(sinceBean);
	}
	
	public List<CityBean> getCitys(CityBean cityBean){
		List<CityBean> cityBeans=addressDao.getCitys(cityBean.setParent_id("-1"));
		if(cityBeans!=null){
			for (int i = 0; i < cityBeans.size(); i++) {
				CityBean cityBean2=cityBeans.get(i);
				List<CityBean> cityBeans2=addressDao.getCitys(cityBean.setParent_id(cityBean2.getId()+""));
				if(cityBeans2!=null){
					for (int j = 0; j < cityBeans2.size(); j++) {
						CityBean cityBean3=cityBeans2.get(j);
						List<CityBean> cityBeans3=addressDao.getCitys(cityBean.setParent_id(cityBean3.getId()+""));
						cityBean3.setCityBeans(cityBeans3);
					}
				}
				cityBean2.setCityBeans(cityBeans2);
			}
		}
		return cityBeans;
	}
	/**
	 * 获得地域数据
	 * @param regionBean
	 * @return
	 */
	public List<RegionBean> getRegions(RegionBean regionBean){
		List<RegionBean> regionBeans=addressDao.getRegions(regionBean.setParent_id("1"));
		for (int i = 0; i < regionBeans.size(); i++) {
			RegionBean regionBean2=regionBeans.get(i);//2级
			List<RegionBean> regionBeans2=addressDao.getRegions(new RegionBean().setParent_id(regionBean2.getRegion_id()));
			for (int j = 0; j < regionBeans2.size(); j++) {
				RegionBean regionBean3=regionBeans2.get(j);
				List<RegionBean> regionBeans3=addressDao.getRegions(new RegionBean().setParent_id(regionBean3.getRegion_id()));
				for (int k = 0; k < regionBeans3.size(); k++) {
					RegionBean regionBean4=regionBeans2.get(j);
					List<RegionBean> regionBeans4=addressDao.getRegions(new RegionBean().setParent_id(regionBean4.getRegion_id()));
					regionBean4.setRegionBeans(regionBeans4);
				}
				regionBean3.setRegionBeans(regionBeans3);
			}
			regionBean2.setRegionBeans(regionBeans2);
		}
		return regionBeans;
	}
	
	/**
	 * 添加地址
	 * 
	 * @param addressBean
	 * @return
	 */
	public int insertAddress(AddressBean addressBean) {
		List<AddressBean> addressBeans = addressDao
				.getOwnerAddress(addressBean);
		if (addressBeans == null || addressBeans.size() == 0) {
			addressBean.setIs_default("1");
		} else {
			addressBean.setIs_default("0");
		}
		return addressDao.insertAddress(addressBean);
	}

	/**
	 * 修改地址
	 * 
	 * @param addressBean
	 * @return
	 */
	public int updateAddress(AddressBean addressBean) {
		return addressDao.updateAddress(addressBean);
	}

	/**
	 * 获得自己的地址列表
	 * 
	 * @param addressBean
	 * @return
	 */
	public List<AddressBean> getOwnerAddress(AddressBean addressBean) {
		return addressDao.getOwnerAddress(addressBean);
	}
	public List<AddressBean> getOwnerAddress(AddressBean addressBean,PageBean pageBean) {
		return addressDao.getOwnerAddress(addressBean,pageBean);
	}
	/**
	 * 刪除地址
	 * 
	 * @param addressBean
	 * @return
	 */
	public int deleteAddress(AddressBean addressBean) {
		int num = addressDao.deleteAddress(addressBean);
		if(num>0){
			List<AddressBean> addressBeans = addressDao
					.getOwnerAddress(addressBean);
			boolean is_hava_default = false;
			/*
			 *删除完后 还有地址 就要判断还有没有默认地址了 没有就要设置一条
			 */
			if (addressBeans != null && addressBeans.size() > 0) {
				for (int i = 0; i < addressBeans.size(); i++) {
					if (addressBeans.get(i).getIs_default().equals("1")) {
						is_hava_default=true;
						break;
					}
				}
				/*
				 *如果没有默认的了 就设置第一条为默认的 
				 */
				if(!is_hava_default){
					setDefaultAddress(addressBeans.get(0));
				}
			}	
		}
		return num;
	}

	/**
	 * 设置默认地址
	 * 
	 * @return
	 */
	public int setDefaultAddress(AddressBean addressBean) {
		return addressDao.setDefaultAddress(addressBean);
	}
	
	/**
	 * 获得默认地址
	 * @param addressBean
	 * @return
	 */
	public AddressBean getDefaultAddress(AddressBean addressBean){
		return addressDao.getDefaultAddress(addressBean);
	}
	
	/**
	 * 通过地址Id得到详细信息
	 * @param addressBean
	 * @return
	 */
	public AddressBean getAddressById(AddressBean addressBean){
		return addressDao.getAddressById(addressBean);
	}
}
