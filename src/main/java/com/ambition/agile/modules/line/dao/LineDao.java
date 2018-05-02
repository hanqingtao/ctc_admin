/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.line.dao;

import com.ambition.agile.common.persistence.CrudDao;
import com.ambition.agile.common.persistence.annotation.MyBatisDao;
import com.ambition.agile.modules.line.entity.Line;

/**
 * 通信线路DAO接口
 * @author harry
 * @version 2018-05-02
 */
@MyBatisDao
public interface LineDao extends CrudDao<Line> {
	
}