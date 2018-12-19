package club.xianmusic.music.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import club.xianmusic.music.domain.CollectionPu;
import club.xianmusic.music.domain.DropPu;
import club.xianmusic.music.domain.Pu;

public interface PuMapper {

	/****
	 * 按照点赞数的降序查找十个
	 * 
	 * @return
	 */
	List<Pu> findPuOrderBy(String type);
	
	/***
	 * 通过id 查找一个曲谱
	 * @param id
	 * @return
	 */
	Pu findPuById(int id);
	
	/***
	 * 分页加载所有的曲谱
	 * @return
	 */
	List<Pu> findAllPu();
	
	/***
	 * 保存一个点赞记录
	 */
	void saveDrop(DropPu dp);
	
	/***
	 * 返回一条点赞记录
	 * @param dp
	 * @return
	 */
	DropPu findDropBy(DropPu dp);
	
	/***
	 * 删除一条点赞记录
	 * @param id
	 */
	void deleteDropById(int id);
	
	/***
	 * 统计点赞记录
	 * @return
	 */
	int findAllDropByPuId(int puId);
	
	/***
	 * 修改点赞数
	 * @param num 0  -1
	 * 	1   +1
	 */
	void updateDropNum(@Param("num")int num ,@Param("puId") int puId);
	
	/***
	 * 保存一个收藏记录
	 * @param pu
	 */
	void saveCollectionPu(CollectionPu pu);
	
	/***
	 * 返回一条收藏记录
	 * @param pu
	 * @return
	 */
	CollectionPu findCollectionPuBy(CollectionPu pu);
	
	/***
	 * 删除一条记录
	 * @param id
	 */
	void deleteCollectionPuById(int id);
	
	/***
	 * 使用名字模糊查找
	 * @param name
	 * @return
	 */
	List<Pu> findPuByLikeName(String name);
	
	/***
	 * 查找用户收藏的曲谱
	 * @param userId
	 * @return
	 */
	List<Pu> findPuByCollectionUserId(int userId);
	
	/***
	 * 后台查询所有的曲谱信息
	 * @return
	 */
	List<Pu> findAllPuByIndex();
	
	/**
	 * 查找到指定Id
	 * @param id
	 * @return
	 */
	Pu findBackPuById(int id);
}
