package tst.project.bean.picture;

import java.util.List;

public class PictureBean {
	private int picture_id;
	private String picture_title;
	private String picture_desc;
	private String is_delete;
	private String create_time;
	private String picture_state;
	private String member_id;
	private int vote_count;
	private String nick_name;
	
	private String start_time;
	private String end_time;
	private List<PictureImgBean> pictureImgBeans;


	public String getStart_time() {
		return start_time;
	}
	public PictureBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public PictureBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getNick_name() {
		return nick_name;
	}
	public PictureBean setNick_name(String nick_name) {
		this.nick_name = nick_name;
		return this;
	}
	public List<PictureImgBean> getPictureImgBeans() {
		return pictureImgBeans;
	}
	public PictureBean setPictureImgBeans(List<PictureImgBean> pictureImgBeans) {
		this.pictureImgBeans = pictureImgBeans;
		return this;
	}
	public int getPicture_id() {
		return picture_id;
	}
	public PictureBean setPicture_id(int picture_id) {
		this.picture_id = picture_id;
		return this;
	}
	public String getPicture_title() {
		return picture_title;
	}
	public PictureBean setPicture_title(String picture_title) {
		this.picture_title = picture_title;
		return this;
	}
	public String getPicture_desc() {
		return picture_desc;
	}
	public PictureBean setPicture_desc(String picture_desc) {
		this.picture_desc = picture_desc;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public PictureBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public PictureBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getPicture_state() {
		return picture_state;
	}
	public PictureBean setPicture_state(String picture_state) {
		this.picture_state = picture_state;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public PictureBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public int getVote_count() {
		return vote_count;
	}
	public PictureBean setVote_count(int vote_count) {
		this.vote_count = vote_count;
		return this;
	}

}
