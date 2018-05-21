/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.car.dao;

import com.ambition.agile.common.persistence.CrudDao;
import com.ambition.agile.common.persistence.annotation.MyBatisDao;
import com.ambition.agile.modules.car.entity.Car;

/**
 * 车辆信息表DAO接口
 * @author harry
 * @version 2018-05-04
 */
@MyBatisDao
public interface CarDao extends CrudDao<Car> {
	
	public Car getCarByPlateNumber(String plateNumber);
	
}