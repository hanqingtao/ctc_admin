/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.station.dao;

import com.ambition.agile.common.persistence.CrudDao;
import com.ambition.agile.common.persistence.annotation.MyBatisDao;
import com.ambition.agile.modules.station.entity.Station;

/**
 * 通信站DAO接口
 * @author harry
 * @version 2018-04-25
 */
@MyBatisDao
public interface StationDao extends CrudDao<Station> {
	
}