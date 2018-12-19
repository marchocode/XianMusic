package club.xianmusic.music.domain;
/***
 * 文章点赞
 * @author 马瑞朝
 *
 */
public class TextDrop {

	/**id*/
	private int td_id;
	/**用户id*/
	private int td_userid;
	/**文章id*/
	private int td_textid;
	
	
	public int getTd_id() {
		return td_id;
	}
	public void setTd_id(int td_id) {
		this.td_id = td_id;
	}
	public int getTd_userid() {
		return td_userid;
	}
	public void setTd_userid(int td_userid) {
		this.td_userid = td_userid;
	}
	public int getTd_textid() {
		return td_textid;
	}
	public void setTd_textid(int td_textid) {
		this.td_textid = td_textid;
	}
	
	
}
