package com.reps.barrage.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reps.barrage.entity.Barrage;
import com.reps.core.orm.IGenericDao;
import com.reps.core.util.StringUtil;

/**
 * 弹幕插件dao
 * @author qianguobing
 * @date 2017年10月25日 下午2:05:57
 */
@Repository
public class BarrageDao {
	
	@Autowired
	IGenericDao<Barrage> dao;
	
	public void save(Barrage barrage) {
		dao.save(barrage);
	}
	
	public Barrage get(String id) {
		return dao.get(Barrage.class, id);
	}

	public List<Barrage> find(Barrage barrage) {
		 DetachedCriteria dc = DetachedCriteria.forClass(Barrage.class);
		 if(null != barrage) {
			 String videoId = barrage.getVideoId();
			 if(StringUtil.isNotBlank(videoId)) {
				 dc.add(Restrictions.eq("videoId", videoId));
			 }
		 }
	     return dao.findByCriteria(dc);
	}
	
}
