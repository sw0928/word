package tst.project.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tst.project.dao.controller.GoodsDao;

public class DaoTest {
	private String path = "applicationContext.xml";
	@Test
	public void testGoodsDao(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		GoodsDao dao = context.getBean(tst.project.dao.controller.GoodsDao.class);
	}
}
