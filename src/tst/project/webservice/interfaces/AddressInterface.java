package tst.project.webservice.interfaces;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import tst.project.bean.address.AddressBean;
import tst.project.bean.address.CityBean;
import tst.project.bean.address.RegionBean;
import tst.project.bean.address.SinceBean;
import tst.project.bean.member.MemberBean;
import tst.project.module.CityMoudle;
import tst.project.service.interfaces.AddressService;
import tst.project.service.interfaces.MemberService;
import tst.project.utils.HtmlUtils;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/addressInterfaces.api")
public class AddressInterface extends BaseController {

	@Resource
	MemberService memberService;

	@Resource
	AddressService addressService;
	/**
	 * 测试
	 * 
	 * @param memberBean
	 * @param addressBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "test", method = RequestMethod.POST)
	public void test(MemberBean memberBean, SinceBean sinceBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String json=request.getParameter("json");
		Map map=new Gson().fromJson(json, Map.class);
		List<Map> maps=(List<Map>) map.get("data");
		addressService.insertCity(maps);
	}
	

	/**
	 * 城市自提点
	 * 
	 * @param memberBean
	 * @param addressBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getCitySinces", method = RequestMethod.POST)
	public void getCitySinces(MemberBean memberBean, SinceBean sinceBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<SinceBean> sinceBeans = addressService.getCitySinces(sinceBean);
		WriteObject(response, sinceBeans);
	}
	/**
	 * 获得地域数据
	 * 
	 * @param memberBean
	 * @param addressBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getCitys", method = RequestMethod.POST)
	public void getCitys(MemberBean memberBean, CityBean cityBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<CityBean> cityBeans=CityMoudle.getInstance().getProvinceBeans();
		if(cityBeans!=null){
			WriteObject(response, cityBeans);
		}else{
			cityBeans = addressService.getCitys(cityBean);
			CityMoudle.getInstance().setProvinceBeans(cityBeans);
			WriteObject(response, cityBeans);
		}	
	}

	/**
	 * 获得地域数据
	 * 
	 * @param memberBean
	 * @param addressBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getRegions", method = RequestMethod.POST)
	public void getRegions(MemberBean memberBean, RegionBean regionBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (CityMoudle.getInstance().getCityBeans() != null) {
			WriteObject(response, CityMoudle.getInstance().getCityBeans());
		} else {
			List<RegionBean> provinceBeans = addressService.getRegions(regionBean);
			CityMoudle.getInstance().setCityBeans(provinceBeans);
			WriteObject(response, provinceBeans);
		}
		// WriteObject(response,addressService.getRegions(regionBean));
	}

	/**
	 * 添加/修改地址
	 * 
	 * @param memberBean
	 * @param addressBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertAddress", method = RequestMethod.POST)
	public void insertAddress(MemberBean memberBean, AddressBean addressBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		addressBean.setDetailed_address(HtmlUtils.Html2Text(addressBean.getDetailed_address()));
		if (addressBean.getAddress_id() == 0) {
			int num = addressService.insertAddress(addressBean);
			if (num > 0) {
				WriteMsg(response, addressBean.getAddress_id() + "");
			} else {
				WriteError(response, "添加失败");
			}
		} else {
			int num = addressService.updateAddress(addressBean);
			if (num > 0) {
				WriteMsg(response, "修改成功");
			} else {
				WriteError(response, "无此地址");
			}
		}

	}

	/**
	 * 获得自己的地址列表
	 * 
	 * @param memberBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "getOwnerAddress", method = RequestMethod.POST)
	public void getOwnerAddress(MemberBean memberBean, AddressBean addressBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, addressService.getOwnerAddress(addressBean));
	}

	/**
	 * 删除地址
	 * 
	 * @param memberBean
	 * @param addressBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "deleteAddress", method = RequestMethod.POST)
	public void deleteAddress(MemberBean memberBean, AddressBean addressBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		int num = addressService.deleteAddress(addressBean);
		if (num > 0) {
			WriteObject(response, "刪除成功");
		} else {
			WriteError(response, "删除失败");
		}

	}

	/**
	 * 设置默认地址
	 * 
	 * @param memberBean
	 * @param addressBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "setDefaultAddress", method = RequestMethod.POST)
	public void setDefaultAddress(MemberBean memberBean, AddressBean addressBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		int num = addressService.setDefaultAddress(addressBean);
		if (num > 0) {
			WriteMsg(response, "设置成功");
		} else {
			WriteError(response, "设置失败");
		}
	}

	/**
	 * 获得默认地址
	 * 
	 * @param addressBean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "getDefaultAddress", method = RequestMethod.POST)
	public void getDefaultAddress(MemberBean memberBean, AddressBean addressBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, addressService.getDefaultAddress(addressBean));
	}

}
