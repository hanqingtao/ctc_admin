/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.car.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ambition.agile.common.persistence.Page;
import com.ambition.agile.common.service.CrudService;
import com.ambition.agile.modules.car.entity.Car;
import com.ambition.agile.modules.car.dao.CarDao;

/**
 * 车辆信息表Service
 * @author harry
 * @version 2018-05-04
 */
@Service
@Transactional(readOnly = true)
public class CarService extends CrudService<CarDao, Car> {

	public Car get(String id) {
		return super.get(id);
	}
	
	@Transactional(readOnly = true)
	public Car getCarByPlateNumber(String plateNumber) {
		return this.dao.getCarByPlateNumber(plateNumber);
	}

//	public void deleteByRoomId(RoomPrice roomPrice) {
//		((RoomPriceDao)this.dao).deleteByRoomId(roomPrice);
//	}
	
	public List<Car> findList(Car car) {
		return super.findList(car);
	}
	
	public Page<Car> findPage(Page<Car> page, Car car) {
		return super.findPage(page, car);
	}
	
	@Transactional(readOnly = false)
	public void save(Car car) {
		super.save(car);
	}
	
	@Transactional(readOnly = false)
	public void delete(Car car) {
		super.delete(car);
	}
	
}