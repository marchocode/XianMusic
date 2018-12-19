package club.xianmusic.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import club.xianmusic.music.domain.CollectionText;
import club.xianmusic.music.domain.Text;
import club.xianmusic.music.domain.TextComment;
import club.xianmusic.music.domain.TextDrop;
import club.xianmusic.music.mapper.TextMapper;
import club.xianmusic.music.service.TextService;
@Service
public class TextServiceImpl implements TextService {
	
	@Autowired
	private TextMapper textMapper;
	
	@Override
	public List<Text> findTextByOrder() {
		// TODO Auto-generated method stub
		return textMapper.findTextOrderByDrop();
	}

	@Override
	public Text findTextById(int textId) {
	
		return textMapper.findTextById(textId);
	}

	@Override
	public List<Text> findTextByPageIndex(int index) {
		
		PageHelper.startPage(index, 5);
		return textMapper.findAllText();
	}

	@Override
	public void saveComment(TextComment text) {
		textMapper.saveComment(text);
	}

	@Override
	public List<TextComment> findAllCommentById(int id) {
		
		return textMapper.findAllCommentByTextId(id);
	}

	@Override
	public String textDrop(TextDrop textDrop) {
		
		TextDrop temp = textMapper.findTextDropByObj(textDrop);
		
		if (temp !=null) {
			//点赞记录存在 删除点赞记录 点赞数-1 
			textMapper.deleteTextDropById(temp.getTd_id());
			textMapper.updateTextDropNum(0, temp.getTd_textid());
		} else {
			//不存在记录 新增记录 点赞数+1 
			textMapper.saveTextDrop(textDrop);
			textMapper.updateTextDropNum(1, textDrop.getTd_textid());
		}
		return textMapper.findTextDropNum(textDrop.getTd_textid())+"";
	}

	@Override
	public boolean collectionText(CollectionText collectionText) {
		
		CollectionText temp = textMapper.findCollectionText(collectionText);
		if (temp!=null) {
			//存在收藏记录，删除记录
			textMapper.deleteCollectionTextById(temp.getCt_id());
			return false;//不存在了
		}
		//不存在记录，收藏记录
		textMapper.saveCollectionText(collectionText);
		return true;
	}

	@Override
	public boolean collectionIsExits(CollectionText collectionText) {
		CollectionText temp = textMapper.findCollectionText(collectionText);
		
		if (temp !=null) {
			//存在
			return true;
		}
		return false;
	}

}
