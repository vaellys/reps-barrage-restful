package com.reps.barrage.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reps.barrage.dao.BarrageDao;
import com.reps.barrage.entity.Barrage;
import com.reps.barrage.service.IBarrageService;
import com.reps.core.exception.RepsException;
import com.reps.core.util.StringUtil;

@Transactional
@Service
public class BarrageServiceImpl implements IBarrageService {
	
	@Autowired
	private BarrageDao dao;

	@Override
	public Map<String, Object> getSpecialBarrageData(Barrage barrage) throws RepsException {
		if(null == barrage) {
			throw new RepsException("参数异常");
		}
		String videoId = barrage.getVideoId();
		if(StringUtil.isBlank(videoId)) {
			throw new RepsException("参数异常:视频标识不能为空");
		}
		Integer nt = barrage.getNt();
		if(null == nt) {
			barrage.setNt(0);
		}
		String content = barrage.getContent();
		if(StringUtil.isNotBlank(content)) {
			this.save(barrage);
		}
		List<Barrage> barrageList = dao.find(barrage);
		Map<String, Object> retData = new HashMap<String, Object>();
		if(null != barrage && !barrageList.isEmpty()) {
			int count = barrageList.size();
			int[] nts = new int[count];
			String[] contents = new String[count];
			for (int i = 0; i < count; i++) {
				Barrage bar = barrageList.get(i);
				nts[i] = bar.getNt();
				contents[i] = bar.getContent();
			}
			Object[] datas = new Object[2];
			datas[0] = nts;
			datas[1] = contents;
			retData.put("ckplayer", datas);
		} else {
			retData.put("ckplayer", Collections.EMPTY_LIST);
		}
		return retData;
	}

	@Override
	public void save(Barrage barrage) throws RepsException {
		if(null == barrage) {
			throw new RepsException("参数异常");
		}
		if(null == barrage.getNt()) {
			throw new RepsException("发布异常:时间点不能为空");
		}
		if(StringUtil.isBlank(barrage.getContent())) {
			throw new RepsException("发布异常:发布内容不能为空");
		}
		if(StringUtil.isBlank(barrage.getVideoId())) {
			throw new RepsException("发布异常:视频标识不能为空");
		}
		barrage.setCreateTime(new Date());
		dao.save(barrage);
	}

}
