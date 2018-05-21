/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.payment.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ambition.agile.common.persistence.Page;
import com.ambition.agile.common.service.CrudService;
import com.ambition.agile.modules.payment.entity.OrdersEvaluate;
import com.ambition.agile.modules.payment.dao.OrdersEvaluateDao;

/**
 * 订单评价Service
 * @author 订单评价
 * @version 2018-05-09
 */
@Service
@Transactional(readOnly = true)
public class OrdersEvaluateService extends CrudService<OrdersEvaluateDao, OrdersEvaluate> {

	public OrdersEvaluate get(String id) {
		return super.get(id);
	}
	
	public List<OrdersEvaluate> findList(OrdersEvaluate ordersEvaluate) {
		return super.findList(ordersEvaluate);
	}
	
	public Page<OrdersEvaluate> findPage(Page<OrdersEvaluate> page, OrdersEvaluate ordersEvaluate) {
		return super.findPage(page, ordersEvaluate);
	}
	
	@Transactional(readOnly = false)
	public void save(OrdersEvaluate ordersEvaluate) {
		super.save(ordersEvaluate);
	}
	
	@Transactional(readOnly = false)
	public void delete(OrdersEvaluate ordersEvaluate) {
		super.delete(ordersEvaluate);
	}
	
}