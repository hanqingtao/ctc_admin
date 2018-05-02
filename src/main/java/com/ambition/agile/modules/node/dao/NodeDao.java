/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.node.dao;

import com.ambition.agile.common.persistence.CrudDao;
import com.ambition.agile.common.persistence.annotation.MyBatisDao;
import com.ambition.agile.modules.node.entity.Node;

/**
 * 通信线路节点DAO接口
 * @author harry
 * @version 2018-05-02
 */
@MyBatisDao
public interface NodeDao extends CrudDao<Node> {
	
}