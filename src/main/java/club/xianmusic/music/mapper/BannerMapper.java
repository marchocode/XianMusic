package club.xianmusic.music.mapper;

import java.util.List;

import club.xianmusic.music.domain.Banner;
import club.xianmusic.music.domain.Commodity;

public interface BannerMapper {

	/***
	 * 加载banner图
	 * @return
	 */
	List<Banner> findBanner();
	
	/***
	 * 加载主页面上的商品
	 * @return
	 */
	List<Commodity> findCommodity();
	
	/***
	 * 删除Banner
	 * @param id
	 */
	void deleteBannerById(int id);
	
	/***
	 * 查询banner 详细内容
	 * @param id
	 * @return
	 */
	Banner findBannerById(int id);
	
	/***
	 * 修改Banner
	 * @param b
	 */
	void updateBanner(Banner b);
	
	/***
	 * 保存一个Banner
	 * @param b
	 */
	void saveBanner(Banner b);
	
	
}
