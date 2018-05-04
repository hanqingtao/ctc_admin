/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.car.entity;

import org.hibernate.validator.constraints.Length;

import com.ambition.agile.common.persistence.DataEntity;

/**
 * 车辆轨迹信息Entity
 * @author harry
 * @version 2018-05-04
 */
public class CarTrack extends DataEntity<CarTrack> {
	
	private static final long serialVersionUID = 1L;
	private Integer carId;		// 车辆
	private String longitude;		// 经度
	private String latitude;		// 纬度
	
	public CarTrack() {
		super();
	}

	public CarTrack(String id){
		super(id);
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	
	@Length(min=0, max=16, message="经度长度必须介于 0 和 16 之间")
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@Length(min=0, max=16, message="纬度长度必须介于 0 和 16 之间")
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
}