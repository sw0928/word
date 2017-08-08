package tst.project.bean.picture;

public class PictureVoteBean {
	private int vote_id;
	private int picture_id;
	private int member_id;
	private String is_delete;
	private String create_time;
	
	public int getVote_id() {
		return vote_id;
	}
	public PictureVoteBean setVote_id(int vote_id) {
		this.vote_id = vote_id;
		return this;
	}
	public int getPicture_id() {
		return picture_id;
	}
	public PictureVoteBean setPicture_id(int picture_id) {
		this.picture_id = picture_id;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public PictureVoteBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public PictureVoteBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public PictureVoteBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}

}
