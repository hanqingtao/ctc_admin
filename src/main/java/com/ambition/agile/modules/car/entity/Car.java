/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.car.entity;

import org.hibernate.validator.constraints.Length;

import com.ambition.agile.common.persistence.DataEntity;

/**
 * 车辆信息表Entity
 * @author harry
 * @version 2018-05-04
 */
public class Car extends DataEntity<Car> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 车辆名称
	private Integer lineId;		// 归属线路
	private String contact;		// 联系人
	private String logoPath;		// 车的标识
	private String plateNumber;		// 车牌号
	private String content;		// 内容
	
	public Car() {
		super();
	}

	public Car(String id){
		super(id);
	}

	@Length(min=0, max=32, message="车辆名称长度必须介于 0 和 32 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getLineId() {
		return lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}
	
	@Length(min=0, max=32, message="联系人长度必须介于 0 和 32 之间")
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	@Length(min=0, max=64, message="车的标识长度必须介于 0 和 64 之间")
	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	
	@Length(min=0, max=16, message="车牌号长度必须介于 0 和 16 之间")
	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	@Length(min=0, max=64, message="内容长度必须介于 0 和 64 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}