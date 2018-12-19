package club.xianmusic.music.service;

import java.util.List;

import club.xianmusic.music.domain.CollectionPu;
import club.xianmusic.music.domain.DropPu;
import club.xianmusic.music.domain.Pu;

public interface PuService {

	/***
	 * 
	 * @param type
	 * @return
	 */
	List<Pu> findPuOrderBy(String type);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Pu findPuById(int id);
	
	/***
	 * 加载所有曲谱
	 * @return
	 */
	List<Pu> findAllPu(int index);
	
	/***
	 * 点赞逻辑
	 */
	int dropPu(DropPu dp);
	
	/***
	 * 返回点赞师傅存在
	 * @param drop
	 * @return
	 */
	boolean dropExits(DropPu drop);
	
	/***
	 * 收藏逻辑
	 * @return
	 */
	boolean collectionPu(CollectionPu pu);
	
	/***
	 * 收藏是否存在
	 * @param pu
	 * @return
	 */
	boolean collectionExits(CollectionPu pu);
	
	/***
	 * 模糊查找曲谱
	 * @param name 曲谱模糊名字
	 * @return
	 */
	List<Pu> findPuByLikeName(String name);
}
