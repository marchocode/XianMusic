package club.xianmusic.music.service;

import java.util.List;

import club.xianmusic.music.domain.Banner;
/***
 * 主页面相关的服务处
 * @author 马瑞朝
 *
 */
import club.xianmusic.music.domain.Commodity;
import club.xianmusic.music.domain.Pu;
import club.xianmusic.music.domain.Text;
public interface IndexService {
	
	List<Banner> findAllBanner();
	
	/***
	 * 加载商品
	 * @return
	 */
	List<Commodity> findCommodity();
	
	/***
	 * 删除Banner图
	 * @param id
	 */
	void deleteBannerById(int id);
	
	/***
	 * 查询具体的banner 
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
	 * 
	 * @param b
	 */
	void saveBanner(Banner b);
	
	/***
	 * 后台分页查找所有的曲谱
	 * @param index
	 * @return
	 */
	List<Pu> findPuByIndex(int index);
	
	/***
	 * 查找到指定id
	 * @param id
	 * @return
	 */
	Pu findPuById(int id);
	
	/**
	 * 后台分页所有数据
	 * @param index
	 * @return
	 */
	List<Text> findAllText(int index);
	
	/***
	 * 后台分页查找需要审核的曲谱
	 * @param index
	 * @return
	 */
	List<Text> findAllExamine(int index);
	
	/**
	 * 文章详情
	 * @param id
	 * @return
	 */
	Text findBackTextById(int id);
	
	/***
	 * 通过审核
	 * @param id
	 */
	void saveUserTextToText(int id);
}
