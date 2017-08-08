package tst.project.bean;

import java.util.List;

public class TestBean {
	private String name;
	private List<String> list;
	public String getName() {
		return name;
	}
	public TestBean setName(String name) {
		this.name = name;
		return this;
	}
	public List<String> getList() {
		return list;
	}
	public TestBean setList(List<String> list) {
		this.list = list;
		return this;
	}
	
	
}
