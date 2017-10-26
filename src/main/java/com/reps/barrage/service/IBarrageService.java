package com.reps.barrage.service;

import java.util.Map;

import com.reps.barrage.entity.Barrage;
import com.reps.core.exception.RepsException;

public interface IBarrageService {
	
	public void save(Barrage barrage) throws RepsException;
	
	public Map<String, Object> getSpecialBarrageData(Barrage barrage) throws RepsException;
}
