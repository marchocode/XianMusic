package club.xianmusic.music.mapper;

import club.xianmusic.music.domain.User;

public interface UserMapper {
	
	/****
	 * 用户登陆
	 * @param u
	 * @return
	 */
	User findUserByNameAndPass(User u);
	/***
	 * 检查用户名是否存在
	 * @param u
	 * @return
	 */
	User findUserIs(String name);
	
	/****
	 * 注册一个用户，返回新注册用户id
	 * @param u
	 * @return
	 */
	int saveUser(User u);
	
	/***
	 * 传入一个用户id 返回指定对象
	 * @param id
	 * @return
	 */
	User findUserById(int id);
}
