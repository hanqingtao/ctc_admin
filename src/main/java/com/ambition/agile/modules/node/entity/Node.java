/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.node.entity;

import org.hibernate.validator.constraints.Length;

import com.ambition.agile.common.persistence.DataEntity;

/**
 * 通信线路节点Entity
 * @author harry
 * @version 2018-05-02
 */
public class Node extends DataEntity<Node> {
	
	private static final long serialVersionUID = 1L;
	private Integer lineId;		// 线路
	private String name;		// 结点名称
	private String before;		// 前面距离
	private String after;		// 后面距离
	private Integer sort;		// 顺序号
	private String longitude;		// 经度
	private String status;		// 状态
	private String latitude;		// 纬度
	
	public Node() {
		super();
	}

	public Node(String id){
		super(id);
	}

	public Integer getLineId() {
		return lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}
	
	@Length(min=0, max=32, message="结点名称长度必须介于 0 和 32 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=64, message="前面距离长度必须介于 0 和 64 之间")
	public String getBefore() {
		return before;
	}

	public void setBefore(String before) {
		this.before = before;
	}
	
	@Length(min=0, max=64, message="后面距离长度必须介于 0 和 64 之间")
	public String getAfter() {
		return after;
	}

	public void setAfter(String after) {
		this.after = after;
	}
	
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	@Length(min=0, max=16, message="经度长度必须介于 0 和 16 之间")
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@Length(min=0, max=1, message="状态长度必须介于 0 和 1 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=0, max=16, message="纬度长度必须介于 0 和 16 之间")
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
}