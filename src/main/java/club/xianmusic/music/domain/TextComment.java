package club.xianmusic.music.domain;
/***
 * 文章评论对象
 * @author 马瑞朝
 *
 */
public class TextComment {

	/**id*/
	private int tc_id;
	/**用户id*/
	private int tc_userid;
	/**文章id*/
	private int tc_textid;
	/**评论内容*/
	private String tc_content;
	/**点赞数量*/
	private int tc_drop;
	/**评论的用户*/
	private User user;
	public int getTc_id() {
		return tc_id;
	}
	public void setTc_id(int tc_id) {
		this.tc_id = tc_id;
	}
	public int getTc_userid() {
		return tc_userid;
	}
	public void setTc_userid(int tc_userid) {
		this.tc_userid = tc_userid;
	}
	public int getTc_textid() {
		return tc_textid;
	}
	public void setTc_textid(int tc_textid) {
		this.tc_textid = tc_textid;
	}
	public String getTc_content() {
		return tc_content;
	}
	public void setTc_content(String tc_content) {
		this.tc_content = tc_content;
	}
	public int getTc_drop() {
		return tc_drop;
	}
	public void setTc_drop(int tc_drop) {
		this.tc_drop = tc_drop;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
	
}
