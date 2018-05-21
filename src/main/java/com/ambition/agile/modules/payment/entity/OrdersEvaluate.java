/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.payment.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;

import com.ambition.agile.common.persistence.DataEntity;

/**
 * 订单评价Entity
 * @author 订单评价
 * @version 2018-05-09
 */
public class OrdersEvaluate extends DataEntity<OrdersEvaluate> {
	
	private static final long serialVersionUID = 1L;
	private String content;		// 评价内容
	private String starNum;		// 评价星数
	private String evaluate;		// 评价类型
	private Integer ordersId;		// 订单号
	private Integer centerId;		// 中心区域
	private Integer userId;		// 用户
	private Date beginCreateDate;		// 开始 创建时间
	private Date endCreateDate;		// 结束 创建时间
	
	public OrdersEvaluate() {
		super();
	}

	public OrdersEvaluate(String id){
		super(id);
	}

	@Length(min=0, max=64, message="评价内容长度必须介于 0 和 64 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=4, message="评价星数长度必须介于 0 和 4 之间")
	public String getStarNum() {
		return starNum;
	}

	public void setStarNum(String starNum) {
		this.starNum = starNum;
	}
	
	@Length(min=0, max=1, message="评价类型长度必须介于 0 和 1 之间")
	public String getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	
	public Integer getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}
	
	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Date getBeginCreateDate() {
		return beginCreateDate;
	}

	public void setBeginCreateDate(Date beginCreateDate) {
		this.beginCreateDate = beginCreateDate;
	}
	
	public Date getEndCreateDate() {
		return endCreateDate;
	}

	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}
		
}