/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.line.entity;

import org.hibernate.validator.constraints.Length;

import com.ambition.agile.common.persistence.DataEntity;

/**
 * 通信线路Entity
 * @author harry
 * @version 2018-05-02
 */
public class Line extends DataEntity<Line> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 线路名称
	private Integer nodeCount;		// 结点数量
	private String status;		// 线路状态
	
	public Line() {
		super();
	}

	public Line(String id){
		super(id);
	}

	@Length(min=0, max=32, message="线路名称长度必须介于 0 和 32 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getNodeCount() {
		return nodeCount;
	}

	public void setNodeCount(Integer nodeCount) {
		this.nodeCount = nodeCount;
	}
	
	@Length(min=0, max=1, message="线路状态长度必须介于 0 和 1 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}