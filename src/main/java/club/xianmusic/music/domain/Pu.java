package club.xianmusic.music.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/***
 * 吉他谱对象
 * 
 * @author 马瑞朝
 *
 */
public class Pu {

	/** id */
	private int pu_id;
	/** 曲谱名字 */
	private String pu_name;
	/** 歌手id */
	private int pu_sing_id;
	/** 作者 */
	private String pu_author;
	/** 视频id */
	private String pu_video;
	/** 页数 */
	private int pu_num;
	/** 点赞数 */
	private int pu_drop;
	/** 日期 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date pu_date;
	/**对应歌手*/
	private Singer singer;
	/**对应的图片*/
	private List<Picture> pictures;
	
	/**上传的用户*/
	private User user;
	
	public int getPu_id() {
		return pu_id;
	}

	public void setPu_id(int pu_id) {
		this.pu_id = pu_id;
	}

	public String getPu_name() {
		return pu_name;
	}

	public void setPu_name(String pu_name) {
		this.pu_name = pu_name;
	}

	public int getPu_sing_id() {
		return pu_sing_id;
	}

	public void setPu_sing_id(int pu_sing_id) {
		this.pu_sing_id = pu_sing_id;
	}

	public String getPu_author() {
		return pu_author;
	}

	public void setPu_author(String pu_author) {
		this.pu_author = pu_author;
	}

	public String getPu_video() {
		return pu_video;
	}

	public void setPu_video(String pu_video) {
		this.pu_video = pu_video;
	}

	public int getPu_num() {
		return pu_num;
	}

	public void setPu_num(int pu_num) {
		this.pu_num = pu_num;
	}

	public int getPu_drop() {
		return pu_drop;
	}

	public void setPu_drop(int pu_drop) {
		this.pu_drop = pu_drop;
	}

	public Date getPu_date() {
		return pu_date;
	}

	public void setPu_date(Date pu_date) {
		this.pu_date = pu_date;
	}

	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
