package club.xianmusic.music.service;

import java.util.List;

import club.xianmusic.music.domain.Pu;
import club.xianmusic.music.domain.Text;
import club.xianmusic.music.domain.User;

public interface UserService {
	
	/****
	 * 用户登陆
	 * @param u
	 * @return
	 */
	User findUser(User u);
	
	/****
	 * 用户注册
	 * @param u
	 * @return
	 */
	User registerUser(User u);
	
	/***
	 * 返回用户
	 * @param id
	 * @return
	 */
	User findUserById(int id);
	
	/***
	 * 查找出用户收藏的曲谱
	 * @param id
	 * @return
	 */
	List<Pu> findUserConnectionPu(int id);
	
	/**
	 * 查找出用户收藏的文章
	 * @param id
	 * @return
	 */
	List<Text> findUserConnectionText(int id);
}
