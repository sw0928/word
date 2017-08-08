package tts.moudle.api.cityapi;

import java.io.Serializable;
import java.util.List;

public class CityBean implements Serializable{
	private String id;
	private String name;
	private String pyf;//全拼
	private String pys;//首拼

	private List<CityBean> cityList;
	private List<String> areaList;

	public List<CityBean> getCityList() {
		return cityList;
	}

	public void setCityList(List<CityBean> cityList) {
		this.cityList = cityList;
	}

	public List<String> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<String> areaList) {
		this.areaList = areaList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPyf() {
		return pyf;
	}

	public void setPyf(String pyf) {
		this.pyf = pyf;
	}

	public String getPys() {
		return pys;
	}

	public void setPys(String pys) {
		this.pys = pys;
	}

	public String getSortKey() {

		return pys.substring(0, 1);
	}

}
