package club.xianmusic.music.domain;
/***
 * 文章实体类
 * @author 马瑞朝
 *
 */

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Text {
	
	/**id*/
	private int t_id;
	/**简介*/
	private String t_bref;
	/**主题*/
	private String t_title;
	/**作者*/
	private int t_author_id;
	/**文章内容*/
	private String t_content;
	/**点赞数*/
	private int t_drop;
	/**图片*/
	private String t_img;
	/**日期*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date t_time;
	
	/**文章作者*/
	private User user;
	
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_bref() {
		return t_bref;
	}
	public void setT_bref(String t_bref) {
		this.t_bref = t_bref;
	}
	public String getT_title() {
		return t_title;
	}
	public void setT_title(String t_title) {
		this.t_title = t_title;
	}
	public int getT_author_id() {
		return t_author_id;
	}
	public void setT_author_id(int t_author_id) {
		this.t_author_id = t_author_id;
	}
	public String getT_content() {
		return t_content;
	}
	public void setT_content(String t_content) {
		this.t_content = t_content;
	}
	public int getT_drop() {
		return t_drop;
	}
	public void setT_drop(int t_drop) {
		this.t_drop = t_drop;
	}
	public String getT_img() {
		return t_img;
	}
	public void setT_img(String t_img) {
		this.t_img = t_img;
	}
	public Date getT_time() {
		return t_time;
	}
	public void setT_time(Date t_time) {
		this.t_time = t_time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
