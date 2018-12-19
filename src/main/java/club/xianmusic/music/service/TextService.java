package club.xianmusic.music.service;

import java.util.List;

import club.xianmusic.music.domain.CollectionText;
import club.xianmusic.music.domain.Text;
import club.xianmusic.music.domain.TextComment;
import club.xianmusic.music.domain.TextDrop;

public interface TextService {

	/***
	 * 首页文章信息的加载
	 * @return
	 */
	List<Text> findTextByOrder();
	
	/***
	 * 加载指定的文章
	 * @param textId
	 * @return
	 */
	Text findTextById(int textId);
	
	/***
	 * 分页加载文章信息
	 * @param index
	 * @return
	 */
	List<Text> findTextByPageIndex(int index);
	/**
	 * 保存一个评论内容
	 * @param text
	 */
	void saveComment(TextComment text);
	/***
	 * 加载评论信息
	 * @param id
	 * @return
	 */
	List<TextComment> findAllCommentById(int id);
	
	/***
	 * 文章的点赞
	 * @return
	 */
	String textDrop(TextDrop textDrop);
	
	/***
	 * 收藏一个文章到数据库
	 * @param collectionText
	 * @return
	 */
	boolean collectionText(CollectionText collectionText);
	
	/**
	 * 提前请求是否存在
	 * @param collectionText
	 * @return
	 */
	boolean collectionIsExits(CollectionText collectionText);
}
