package club.xianmusic.music.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import club.xianmusic.music.domain.CollectionText;
import club.xianmusic.music.domain.Text;
import club.xianmusic.music.domain.TextComment;
import club.xianmusic.music.domain.TextDrop;

public interface TextMapper {

	/***
	 * 按照点赞数加载
	 * @return
	 */
	List<Text> findTextOrderByDrop();
	
	/***
	 * 按照id 查找一个文章
	 * @param textId
	 * @return
	 */
	Text findTextById(int textId);
	
	/***
	 * 分页查询
	 * @return
	 */
	List<Text> findAllText();
	
	/***
	 * 加载文章的所有评论
	 * @param id
	 * @return
	 */
	List<TextComment> findAllCommentByTextId(int id);
	
	/****
	 * 保存一个评论对象
	 * @param comment
	 */
	void saveComment(TextComment comment);
	
	/***
	 * 新增一个点赞记录
	 */
	void saveTextDrop(TextDrop text);
	
	/***
	 * 查询本条点赞记录是否存在
	 * @param textDrop
	 * @return
	 */
	TextDrop findTextDropByObj(TextDrop textDrop);
	
	/***
	 * 修改文章的点赞数
	 * @param num 1 +1
	 *  0  -1
	 */
	void updateTextDropNum(@Param("num")int num , @Param("textId") int textId);
	
	/***
	 * 删除一条点赞记录
	 * @param id
	 */
	void deleteTextDropById(int id);
	
	/***
	 * 返回总点赞数
	 * @param textId 文章id
	 * @return
	 */
	int findTextDropNum(int textId);
	
	/***
	 * 保存一个收藏文章对象到数据库
	 * @param collectionText
	 */
	void saveCollectionText(CollectionText collectionText);
	
	/**
	 * 查找这条记录是否存在
	 * @param collectionText
	 * @return
	 */
	CollectionText findCollectionText(CollectionText collectionText);
	
	/***
	 * 删除一条收藏记录
	 * @param id
	 */
	void deleteCollectionTextById(int id);
	
	/***
	 * 
	 * 返回收藏的文章信息
	 * @param userId
	 * @return
	 */
	List<Text> findTextByCollectionUserId(int userId);
	
	/***
	 * 后台查询所有的信息
	 * @return
	 */
	List<Text> findBackAllText();
	
	/***
	 * 查找需要审核的文章
	 * @return
	 */
	List<Text> findAllExamine();
	
	/***
	 * 返回后台文章通过id
	 * @param id
	 * @return
	 */
	Text findBackTextById(int id);
	
	/***
	 * 文章审核通过
	 */
	void saveUserTextToText(int id);
	
	/***
	 * 删除通过的文章存根
	 * @param id
	 */
	void deleteUserTextById(int id);
	
}
