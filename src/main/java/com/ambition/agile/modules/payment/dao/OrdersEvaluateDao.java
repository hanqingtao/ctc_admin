/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.payment.dao;

import com.ambition.agile.common.persistence.CrudDao;
import com.ambition.agile.common.persistence.annotation.MyBatisDao;
import com.ambition.agile.modules.payment.entity.OrdersEvaluate;

/**
 * 订单评价DAO接口
 * @author 订单评价
 * @version 2018-05-09
 */
@MyBatisDao
public interface OrdersEvaluateDao extends CrudDao<OrdersEvaluate> {
	
}