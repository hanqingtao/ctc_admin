/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.ambition.agile.test.dao;

import com.ambition.agile.common.persistence.CrudDao;
import com.ambition.agile.common.persistence.annotation.MyBatisDao;
import com.ambition.agile.test.entity.TestDataMain;

/**
 * 主子表生成DAO接口
 * @author harry
 * @version 2015-04-06
 */
@MyBatisDao
public interface TestDataMainDao extends CrudDao<TestDataMain> {
	
}