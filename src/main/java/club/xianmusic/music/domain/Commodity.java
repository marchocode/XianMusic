package club.xianmusic.music.domain;
/***
 * 商品
 * @author 马瑞朝
 *
 */
public class Commodity {

	/**id*/
	private int c_id;
	/**图片*/
	private String c_img;
	/**单价*/
	private double c_price;
	/**主题*/
	private String c_content;
	/**url*/
	private String c_url;
	
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_img() {
		return c_img;
	}
	public void setC_img(String c_img) {
		this.c_img = c_img;
	}
	public double getC_price() {
		return c_price;
	}
	public void setC_price(double c_price) {
		this.c_price = c_price;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public String getC_url() {
		return c_url;
	}
	public void setC_url(String c_url) {
		this.c_url = c_url;
	}
	
	
	
}
