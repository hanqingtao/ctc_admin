/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.car.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ambition.agile.common.persistence.Page;
import com.ambition.agile.common.service.CrudService;
import com.ambition.agile.modules.car.entity.CarTrack;
import com.ambition.agile.modules.car.dao.CarTrackDao;

/**
 * 车辆轨迹信息Service
 * @author harry
 * @version 2018-05-04
 */
@Service
@Transactional(readOnly = true)
public class CarTrackService extends CrudService<CarTrackDao, CarTrack> {

	public CarTrack get(String id) {
		return super.get(id);
	}
	
	public List<CarTrack> findList(CarTrack carTrack) {
		return super.findList(carTrack);
	}
	
	public Page<CarTrack> findPage(Page<CarTrack> page, CarTrack carTrack) {
		return super.findPage(page, carTrack);
	}
	
	@Transactional(readOnly = false)
	public void save(CarTrack carTrack) {
		super.save(carTrack);
	}
	
	@Transactional(readOnly = false)
	public void delete(CarTrack carTrack) {
		super.delete(carTrack);
	}
	
}