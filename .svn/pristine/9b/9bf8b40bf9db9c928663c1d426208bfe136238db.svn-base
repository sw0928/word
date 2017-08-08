package tst.project.service.interfaces;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.others.AdviceBean;
import tst.project.bean.others.AdviceImgBean;
import tst.project.dao.interfaces.AdviceDao;

@Service
@Transactional(rollbackFor = Exception.class)
public class AdviceService {
	@Resource
	AdviceDao adviceDao;
	
	/**
	 * 提交建议或者投诉
	 * @param adviceBean
	 * @return
	 * @throws Exception 
	 */
	public int insertAdvice(AdviceBean adviceBean,List<String> files) throws Exception{
		int num=adviceDao.insertAdvice(adviceBean);
		if(num>0){
			if(files!=null){
				for (int i = 0; i < files.size(); i++) {
					int h=adviceDao.insertAdviceImg(new AdviceImgBean()
							.setAdvice_id(adviceBean.getAdvice_id()+"")
							.setAdvice_img(files.get(i)));
					if(h<=0){
						throw new Exception("建议图片入库失败");
					}
				}		
			}
		}
		return num;
	}
	
	/**
	 * 提交建议或者投诉
	 * @param adviceBean
	 * @return
	 * @throws Exception 
	 */
	public int insertAdvice(AdviceBean adviceBean,String imgs) throws Exception{
		String[] files=imgs!=null?(imgs.length()>0?imgs.split(","):null):null;
		int num=adviceDao.insertAdvice(adviceBean);
		if(num>0){
			if(files!=null){
				for (int i = 0; i < files.length; i++) {
					int h=adviceDao.insertAdviceImg(new AdviceImgBean()
							.setAdvice_id(adviceBean.getAdvice_id()+"")
							.setAdvice_img(files[i]));
					if(h<=0){
						throw new Exception("建议图片入库失败");
					}
				}		
			}
		}
		return num;
	}
	
	
	/**
	 * 提交建议或者投诉的图片
	 * @param adviceBean
	 * @return
	 */
	public int insertAdviceImg(AdviceImgBean adviceImgBean){
		 return adviceDao.insertAdviceImg(adviceImgBean);
	}
}
