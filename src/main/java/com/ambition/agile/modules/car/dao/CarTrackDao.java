/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.car.dao;

import com.ambition.agile.common.persistence.CrudDao;
import com.ambition.agile.common.persistence.annotation.MyBatisDao;
import com.ambition.agile.modules.car.entity.CarTrack;

/**
 * 车辆轨迹信息DAO接口
 * @author harry
 * @version 2018-05-04
 */
@MyBatisDao
public interface CarTrackDao extends CrudDao<CarTrack> {
	
}