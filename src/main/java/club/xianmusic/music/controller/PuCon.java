package club.xianmusic.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import club.xianmusic.music.domain.CollectionPu;
import club.xianmusic.music.domain.DropPu;
import club.xianmusic.music.domain.Pu;
import club.xianmusic.music.service.PuService;

@RestController
@RequestMapping("/html")
public class PuCon {

	@Autowired
	private PuService puService;
	
	@RequestMapping("/loadPuById")
	public Pu loadPuById(@RequestParam("puId") int puId) {
		
		return puService.findPuById(puId);
	}
	
	@RequestMapping(value="/findAllPu",method=RequestMethod.GET)
	public Object findAllPu(@RequestParam("index") int index) {
		return puService.findAllPu(index);
	}
	
	@RequestMapping(value="/dropPu",method=RequestMethod.GET)
	public String dropPu(@ModelAttribute DropPu dp) {
		int temp = puService.dropPu(dp);
		return temp +"";
	}
	
	@RequestMapping(value="/dropExist",method=RequestMethod.GET)
	public boolean dropExist(@ModelAttribute DropPu dp) {
		
		return puService.dropExits(dp);
	}
	@RequestMapping(value="/collectionPu",method=RequestMethod.GET)
	public boolean collectionPu(@ModelAttribute CollectionPu pu) {
		
		return puService.collectionPu(pu);
	}
	
	@RequestMapping(value="/collectionExist",method=RequestMethod.GET)
	public boolean collectionExist(@ModelAttribute CollectionPu pu) {
		return puService.collectionExits(pu);
	}
	/***
	 * 模糊查询 查找曲谱
	 * @return
	 */
	@RequestMapping(value="/findPuByLikeName",method=RequestMethod.GET)
	public Object findPuByLikeName(@RequestParam("content")String content) {
		System.out.println(content);
		return puService.findPuByLikeName(content);
	}
	
	
}
