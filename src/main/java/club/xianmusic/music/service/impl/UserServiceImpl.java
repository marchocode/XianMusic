package club.xianmusic.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.xianmusic.music.domain.Pu;
import club.xianmusic.music.domain.Text;
import club.xianmusic.music.domain.User;
import club.xianmusic.music.mapper.PuMapper;
import club.xianmusic.music.mapper.TextMapper;
import club.xianmusic.music.mapper.UserMapper;
import club.xianmusic.music.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PuMapper puMapper;
	
	@Autowired
	private TextMapper textMapper;
	
	@Override
	public User findUser(User u) {

		return userMapper.findUserByNameAndPass(u);
	}

	@Override
	public User registerUser(User u) {

		User user = userMapper.findUserIs(u.getU_name());//检测用户名重复？
		if (user != null) {
			return null;// 用户名重复
		}

		userMapper.saveUser(u);
		return u;
	}

	@Override
	public User findUserById(int id) {
		return userMapper.findUserById(id);
	}

	@Override
	public List<Pu> findUserConnectionPu(int id) {
		
		return puMapper.findPuByCollectionUserId(id);
	}

	@Override
	public List<Text> findUserConnectionText(int id) {
		return textMapper.findTextByCollectionUserId(id);
		
	}

}
