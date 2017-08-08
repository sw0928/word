package tst.project.script;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

import tst.project.bean.goods.GoodsBean;

public class Test {

	public static void main(final String[] args) throws Exception {

		List<GoodsBean> studentList = new ArrayList();

		GoodsBean s1 = new GoodsBean();
		s1.setGoods_now_price("25");
		studentList.add(s1);
		GoodsBean s2 = new GoodsBean();
		s2.setGoods_now_price("22");
		studentList.add(s2);
		//Collections.sort(studentList); // 按照age升序 22，23，
		//Collections.reverse(studentList); // 按照age降序 23,22
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i).getGoods_now_price());
		}
	}
}
