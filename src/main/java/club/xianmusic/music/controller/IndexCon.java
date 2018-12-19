package club.xianmusic.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import club.xianmusic.music.domain.Banner;
import club.xianmusic.music.domain.Commodity;
import club.xianmusic.music.domain.Pu;
import club.xianmusic.music.domain.Text;
import club.xianmusic.music.service.IndexService;
import club.xianmusic.music.service.PuService;
import club.xianmusic.music.service.TextService;

/***
 * 主页面控制器
 * 
 * @author 马瑞朝
 *
 */
@RestController
public class IndexCon {

	@Autowired
	private IndexService indexService;

	@Autowired
	private PuService puService;
	
	@Autowired
	private TextService textService;

	@RequestMapping(value = "/loadBanner", method = RequestMethod.GET)
	public List<Banner> loadBanner() {
		
		return indexService.findAllBanner();
	}

	@RequestMapping(value = "/loadPuOrderBy", method = RequestMethod.GET)
	public List<Pu> loadPuOrderBy(@RequestParam("type") String type) {
		
		return puService.findPuOrderBy(type);
	}
	
	@RequestMapping(value="/loadTextByOrder",method=RequestMethod.GET)
	public List<Text> loadTextByOrder(){
		
		return textService.findTextByOrder();
	}
	
	@RequestMapping(value="/loadCommodity",method=RequestMethod.GET)
	public List<Commodity> loadCommodity(){
		
		return indexService.findCommodity();
	}

}
