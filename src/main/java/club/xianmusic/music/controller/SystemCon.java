package club.xianmusic.music.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import club.xianmusic.music.domain.Banner;
import club.xianmusic.music.domain.Pu;
import club.xianmusic.music.service.IndexService;

/***
 * 后台管理请求
 * 
 * @author 马瑞朝
 *
 */
@Controller
@RequestMapping("/admin")
public class SystemCon {

	@Autowired
	private IndexService indexService;
	
	@RequestMapping(value = "/loadBanner", method = RequestMethod.GET)
	@ResponseBody
	public List<Banner> loadBanner() {

		return indexService.findAllBanner();
	}

	@RequestMapping("/deleteBanner/{id}")
	public String deleteBanner(@PathVariable("id") int id) {

		indexService.deleteBannerById(id);
		return "redirect:/admin/banner_Admin.html";
	}

	@RequestMapping(value = "/findBannerById", method = RequestMethod.GET)
	@ResponseBody
	public Object findBannerById(@RequestParam("id") int id) {

		return indexService.findBannerById(id);

	}

	@RequestMapping("/updateBanner")
	public String updateBanner(@ModelAttribute() Banner b) {
		System.out.println(b.getB_title());
		System.out.println(b.getB_id());
		indexService.updateBanner(b);

		return "redirect:/admin/banner_Admin.html";
	}

	@RequestMapping("/uploadBanner")
	public String uploadBanner(@RequestParam("file") MultipartFile file ,@ModelAttribute Banner b) {

		String fileName = null;
		
		if (file.isEmpty()) {

			return "redirect:/admin/banner_Admin.html";
		}

		try {
			File path1 = new File(ResourceUtils.getURL("classpath:").getPath());
			if(!path1.exists()) path1 = new File("");
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get( path1 +"/static/img/banner/"+ file.getOriginalFilename());
			fileName = file.getOriginalFilename();
			Files.write(path, bytes);

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (fileName !=null) {
			b.setB_imgaddress(fileName);
			indexService.saveBanner(b);
		}
		
		return "redirect:/admin/banner_Admin.html";
	}
	
	@RequestMapping("/findAllPuByIndex")
	@ResponseBody
	public List<Pu> findAllPuByIndex(@RequestParam("index") int index){
		
		return indexService.findPuByIndex(index);
	}
	
	@RequestMapping("/findPuById")
	@ResponseBody
	public Pu findPuById(@RequestParam("puId") int puId){
		
		return indexService.findPuById(puId);
	}
	
	@RequestMapping("/findAllTextByIndex")
	@ResponseBody
	public Object findAllTextByIndex(@RequestParam("index") int index) {
		
		return indexService.findAllText(index);
	}
	
	@RequestMapping("/findAllExamine")
	@ResponseBody
	public Object findAllExamine(@RequestParam("index") int index) {
		
		return indexService.findAllExamine(index);
	}
	
	
	@RequestMapping("/findBackTextById")
	@ResponseBody
	public Object findBackTextById(@RequestParam("textId") int textId) {
		
		return indexService.findBackTextById(textId);
		
	}
	
	@RequestMapping("/saveUserTextToText")
	public String saveUserTextToText(@RequestParam("t_id") int t_id) {
		
		indexService.saveUserTextToText(t_id);
		return "redirect:/admin/ExamineText.html";
	}

}
