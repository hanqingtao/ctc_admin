/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.station.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.ambition.agile.common.persistence.DataEntity;

/**
 * 通信站Entity
 * @author harry
 * @version 2018-04-25
 */
public class Station extends DataEntity<Station> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String address;		// 地址
	private String photoPath;		// 图片
	private String content;		// 简介
	private String phone;		// 联系电话
	private String contact;		// 联系人
	private Integer proviceId;		// 省
	private Integer cityId;		// 市
	private Integer area;		// 县
	private Integer townId;		// 镇 id
	private String areaFullName;		// (省市县集合名称)#分割
	private String longitude;		// 经度
	private String latitude;		// 纬度
	private String recommend;		// 推荐指数
	private Integer sort;		// 排序
	
	public Station() {
		super();
	}

	public Station(String id){
		super(id);
	}

	@Length(min=0, max=32, message="名称长度必须介于 0 和 32 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=256, message="地址长度必须介于 0 和 256 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=64, message="图片长度必须介于 0 和 64 之间")
	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	
	@Length(min=0, max=256, message="简介长度必须介于 0 和 256 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=32, message="联系电话长度必须介于 0 和 32 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=32, message="联系人长度必须介于 0 和 32 之间")
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public Integer getProviceId() {
		return proviceId;
	}

	public void setProviceId(Integer proviceId) {
		this.proviceId = proviceId;
	}
	
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}
	
	public Integer getTownId() {
		return townId;
	}

	public void setTownId(Integer townId) {
		this.townId = townId;
	}
	
	@Length(min=0, max=128, message="(省市县集合名称)#分割长度必须介于 0 和 128 之间")
	public String getAreaFullName() {
		return areaFullName;
	}

	public void setAreaFullName(String areaFullName) {
		this.areaFullName = areaFullName;
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
	
	@Length(min=0, max=4, message="推荐指数长度必须介于 0 和 4 之间")
	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	
	@NotNull(message="排序不能为空")
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}