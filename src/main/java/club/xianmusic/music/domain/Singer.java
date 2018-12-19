package club.xianmusic.music.domain;

/***
 * 歌手
 * 
 * @author 马瑞朝
 *
 */
public class Singer {
	/** id */
	private int s_id;
	/** 歌手名字 */
	private String s_name;
	/** 简介 */
	private String s_title;
	/** 头像 */
	private String s_img;

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_title() {
		return s_title;
	}

	public void setS_title(String s_title) {
		this.s_title = s_title;
	}

	public String getS_img() {
		return s_img;
	}

	public void setS_img(String s_img) {
		this.s_img = s_img;
	}

}
