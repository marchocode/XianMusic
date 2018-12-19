package club.xianmusic.music.domain;

public class User {

	private int u_id;
	/** 用户名 */
	private String u_name;
	/** 密码 **/
	private String u_password;
	/** 昵称 */
	private String u_nick = "吉他爱好者";
	private String u_email;
	/** 积分 */
	private int u_integrate = 20;
	/** 头像 */
	private String u_img = "default.jpg";
	/** 签名 */
	private String u_autograph = "这个人很懒，没有留下什么";
	
	
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_nick() {
		return u_nick;
	}
	public void setU_nick(String u_nick) {
		this.u_nick = u_nick;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public int getU_integrate() {
		return u_integrate;
	}
	public void setU_integrate(int u_integrate) {
		this.u_integrate = u_integrate;
	}
	public String getU_img() {
		return u_img;
	}
	public void setU_img(String u_img) {
		this.u_img = u_img;
	}
	public String getU_autograph() {
		return u_autograph;
	}
	public void setU_autograph(String u_autograph) {
		this.u_autograph = u_autograph;
	}
	
	
	
}
