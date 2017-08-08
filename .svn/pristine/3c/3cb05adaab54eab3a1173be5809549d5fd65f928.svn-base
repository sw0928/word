package tst.project.bean.member;

import java.sql.Time;

import tst.project.utils.TimeUtils;

public class SignStatisticsBean {
	private int sign_continuity_count_month;
	private int sign_total_count_month;
	private int sign_integral;
	private int sign_leak_count;
	
	public int getSign_leak_count() {
		return sign_leak_count;
	}
	public SignStatisticsBean setSign_leak_count(int sign_leak_count) {
		this.sign_leak_count = sign_leak_count;
		return this;
	}
	public int getSign_continuity_count_month() {
		
		return sign_continuity_count_month;
	}
	public SignStatisticsBean setSign_continuity_count_month(int sign_continuity_count_month) {
		this.sign_continuity_count_month = sign_continuity_count_month;
		return this;
	}
	public int getSign_total_count_month() {
		return sign_total_count_month;
	}
	public SignStatisticsBean setSign_total_count_month(int sign_total_count_month) {
		this.sign_total_count_month = sign_total_count_month;
		int a=TimeUtils.getDayWithMonth()-sign_total_count_month;
		this.sign_leak_count=a>0?a:0;
		return this;
	}
	public int getSign_integral() {
		return sign_integral;
	}
	public SignStatisticsBean setSign_integral(int sign_integral) {
		this.sign_integral = sign_integral;
		return this;
	}
	
}
