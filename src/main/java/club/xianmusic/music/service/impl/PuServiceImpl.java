package club.xianmusic.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import club.xianmusic.music.domain.CollectionPu;
import club.xianmusic.music.domain.DropPu;
import club.xianmusic.music.domain.Pu;
import club.xianmusic.music.mapper.PuMapper;
import club.xianmusic.music.service.PuService;

@Service
public class PuServiceImpl implements PuService {

	@Autowired
	private PuMapper puMapper;

	@Override
	public List<Pu> findPuOrderBy(String type) {
		// TODO Auto-generated method stub

		return puMapper.findPuOrderBy(type);
	}

	@Override
	public Pu findPuById(int id) {
		return puMapper.findPuById(id);
	}

	@Override
	public List<Pu> findAllPu(int index) {
		PageHelper.startPage(index, 8);
		return puMapper.findAllPu();
	}

	@Override
	public int dropPu(DropPu dp) {

		DropPu temp = puMapper.findDropBy(dp);
		if (temp != null) {
			// 存在记录，点赞数-1 删除这条记录
			puMapper.deleteDropById(temp.getDp_id());
			puMapper.updateDropNum(0, temp.getDp_puid());
		} else {
			// 不存在记录 ，新建一个点赞记录 点赞数+1;
			puMapper.saveDrop(dp);
			puMapper.updateDropNum(1, dp.getDp_puid());
		}
		return puMapper.findAllDropByPuId(dp.getDp_puid());
	}

	@Override
	public boolean dropExits(DropPu drop) {

		DropPu temp = puMapper.findDropBy(drop);
		if (temp != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean collectionPu(CollectionPu pu) {

		CollectionPu temp = puMapper.findCollectionPuBy(pu);

		if (temp != null) {
			// 存在记录，删除记录，取消收藏
			puMapper.deleteCollectionPuById(temp.getCp_id());
			return false;
		}
		// 不存在记录 ，增加记录，新增收藏
		puMapper.saveCollectionPu(pu);

		return true;
	}

	@Override
	public boolean collectionExits(CollectionPu pu) {
		
		CollectionPu temp = puMapper.findCollectionPuBy(pu);
		if (temp != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Pu> findPuByLikeName(String name) {
		
		name = "%"+name+"%";
		return puMapper.findPuByLikeName(name);
	}

}
