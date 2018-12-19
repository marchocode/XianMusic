package club.xianmusic.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import club.xianmusic.music.domain.CollectionText;
import club.xianmusic.music.domain.TextComment;
import club.xianmusic.music.domain.TextDrop;
import club.xianmusic.music.service.TextService;

@RestController
@RequestMapping("/html")
public class TextCon {

	@Autowired
	private TextService textService;

	@RequestMapping(value="/findTextById",method=RequestMethod.GET)
	public Object findTextById(@RequestParam("textId") int textId) {
		
		return textService.findTextById(textId);

	}
	
	@RequestMapping(value="/findTextByPageIndex",method=RequestMethod.GET)
	public Object findTextByPageIndex(@RequestParam("pageIndex") int pageIndex) {
		
		return textService.findTextByPageIndex(pageIndex);
	}
	@RequestMapping(value="/saveComment",method=RequestMethod.POST)
	public String saveComment(@ModelAttribute TextComment text) {
		
		textService.saveComment(text);
		return "success";
	}
	@RequestMapping(value="/findAllCommentById",method=RequestMethod.GET)
	public List<TextComment> findAllCommentById(@RequestParam("tc_textid") int tc_textid) {
		
		return textService.findAllCommentById(tc_textid);
	}
	/***
	 * 点赞后返回总点赞数
	 * @param textDrop
	 * @return
	 */
	@RequestMapping(value="/textDrop",method=RequestMethod.GET)
	public Object textDrop(@ModelAttribute TextDrop textDrop) {
		
		return textService.textDrop(textDrop);
	}
	@RequestMapping(value="/collectionText",method=RequestMethod.GET)
	public boolean collectionText(@ModelAttribute CollectionText collectionText) {
		return textService.collectionText(collectionText);
	}
	
	/***
	 * 请求收藏内容是否以及存在
	 * @return
	 */
	@RequestMapping(value="/collectionIsExits",method=RequestMethod.GET)
	public boolean collectionIsExits(@ModelAttribute CollectionText collectionText) {
		
		return textService.collectionIsExits(collectionText);
	}

}
