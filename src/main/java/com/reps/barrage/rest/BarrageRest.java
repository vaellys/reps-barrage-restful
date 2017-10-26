package com.reps.barrage.rest;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reps.barrage.entity.Barrage;
import com.reps.barrage.service.IBarrageService;
import com.reps.core.restful.RestBaseController;
import com.reps.core.restful.RestResponse;
import com.reps.core.restful.RestResponseStatus;


@RestController
@RequestMapping(value = "/oapi/barrage")
public class BarrageRest extends RestBaseController {

	private final Log logger = LogFactory.getLog(BarrageRest.class);
	
	@Autowired
	private IBarrageService barrageService;
	
	@RequestMapping(value = "/publish")
	public RestResponse<Map<String, Object>> publish(Barrage barrage) {
		try {
			Map<String, Object> specialBarrageData = barrageService.getSpecialBarrageData(barrage);
			return wrap(RestResponseStatus.OK, "查询成功", specialBarrageData);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询异常", e);
			return wrap(RestResponseStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
}
