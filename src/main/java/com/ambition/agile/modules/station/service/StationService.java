/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.station.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ambition.agile.common.persistence.Page;
import com.ambition.agile.common.service.CrudService;
import com.ambition.agile.modules.station.entity.Station;
import com.ambition.agile.modules.station.dao.StationDao;

/**
 * 通信站Service
 * @author harry
 * @version 2018-04-25
 */
@Service
@Transactional(readOnly = true)
public class StationService extends CrudService<StationDao, Station> {

	public Station get(String id) {
		return super.get(id);
	}
	
	public List<Station> findList(Station station) {
		return super.findList(station);
	}
	
	public Page<Station> findPage(Page<Station> page, Station station) {
		return super.findPage(page, station);
	}
	
	@Transactional(readOnly = false)
	public void save(Station station) {
		super.save(station);
	}
	
	@Transactional(readOnly = false)
	public void delete(Station station) {
		super.delete(station);
	}
	
}