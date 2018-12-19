package club.xianmusic.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import club.xianmusic.music.domain.Banner;
import club.xianmusic.music.domain.Commodity;
import club.xianmusic.music.domain.Pu;
import club.xianmusic.music.domain.Text;
import club.xianmusic.music.mapper.BannerMapper;
import club.xianmusic.music.mapper.PuMapper;
import club.xianmusic.music.mapper.TextMapper;
import club.xianmusic.music.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService {

	@Autowired
	private BannerMapper bannerMapper;
	@Autowired
	private PuMapper puMapper;
	@Autowired
	private TextMapper textMapper;
	
	
	@Override
	public List<Banner> findAllBanner() {
		return bannerMapper.findBanner();

	}

	@Override
	public List<Commodity> findCommodity() {
		return bannerMapper.findCommodity();
	}

	@Override
	public void deleteBannerById(int id) {
		bannerMapper.deleteBannerById(id);
	}

	@Override
	public Banner findBannerById(int id) {
		return bannerMapper.findBannerById(id);
	}

	@Override
	public void updateBanner(Banner b) {
		
		bannerMapper.updateBanner(b);
	}

	@Override
	public void saveBanner(Banner b) {
		
		bannerMapper.saveBanner(b);
		
	}

	@Override
	public List<Pu> findPuByIndex(int index) {
		
		PageHelper.startPage(index, 5);
		return puMapper.findAllPuByIndex();
	}

	@Override
	public Pu findPuById(int id) {
		
		return puMapper.findBackPuById(id);
	}

	@Override
	public List<Text> findAllText(int index) {
		
		PageHelper.startPage(index, 5);
		return textMapper.findBackAllText();
	}

	@Override
	public List<Text> findAllExamine(int index) {
		PageHelper.startPage(index, 5);
		
		return textMapper.findAllExamine();
	}
	@Override
	public Text findBackTextById(int id) {
		return textMapper.findBackTextById(id);
	}

	@Override
	public void saveUserTextToText(int id) {
		// TODO Auto-generated method stub
		textMapper.saveUserTextToText(id);
		//删除
		textMapper.deleteUserTextById(id);
	}


}
