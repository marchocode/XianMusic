package club.xianmusic.music;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/***
 * 创建外部启动类
 * @author 马瑞朝
 *
 */
public class ServletInitializer extends SpringBootServletInitializer  {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(MusicApplication.class);
	}
}
