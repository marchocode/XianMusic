package club.xianmusic.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import club.xianmusic.music.domain.User;
import club.xianmusic.music.service.MailService;
import club.xianmusic.music.service.UserService;
import club.xianmusic.music.util.MD5Util;

/***
 * 用户类控制器
 * 
 * @author 马瑞朝
 *
 */
@RestController
@RequestMapping("/html")
public class UserCon {

	@Autowired
	private UserService userService;

	@Autowired
	private MailService mailService;

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute User u) {

		String pass = MD5Util.encode(u.getU_password());
		u.setU_password(pass);
		User user = userService.findUser(u);
		if (user != null) {
			return user.getU_id() + "";
		}
		return "none";
	}
	
	@RequestMapping(value = "/userRegister", method = RequestMethod.POST)
	public User userRegister(@ModelAttribute User u) {
		u.setU_password(MD5Util.encode(u.getU_password()));
		User user = userService.registerUser(u);
		if (user != null) {
			return user;
		}
		return null;

	}

	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public String sendEmail(@RequestParam("email") String email) {

		String code = mailService.generateMade(4);
		mailService.sendSimpleMail(email, "弦乐吉他网注册验证码", code);

		return code;
	}
	@RequestMapping(value = "/findUserById", method = RequestMethod.GET)
	public User findUserById(@RequestParam("userId") int userId) {
		
		return userService.findUserById(userId);
	}
	
	@RequestMapping(value = "/findUserConnectionPu", method = RequestMethod.GET)
	public Object findUserConnectionPu(@RequestParam("userId") int userId) {
		
		return userService.findUserConnectionPu(userId);
	}
	@RequestMapping(value = "/findUserCollectionText", method = RequestMethod.GET)
	public Object findUserCollectionText(@RequestParam("userId") int userId) {
		
		return userService.findUserConnectionText(userId);
	}
}
