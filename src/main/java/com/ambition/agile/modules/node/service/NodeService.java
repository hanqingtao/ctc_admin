/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.node.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ambition.agile.common.persistence.Page;
import com.ambition.agile.common.service.CrudService;
import com.ambition.agile.modules.node.entity.Node;
import com.ambition.agile.modules.node.dao.NodeDao;

/**
 * 通信线路节点Service
 * @author harry
 * @version 2018-05-02
 */
@Service
@Transactional(readOnly = true)
public class NodeService extends CrudService<NodeDao, Node> {

	public Node get(String id) {
		return super.get(id);
	}
	
	public List<Node> findList(Node node) {
		return super.findList(node);
	}
	
	public Page<Node> findPage(Page<Node> page, Node node) {
		return super.findPage(page, node);
	}
	
	@Transactional(readOnly = false)
	public void save(Node node) {
		super.save(node);
	}
	
	@Transactional(readOnly = false)
	public void delete(Node node) {
		super.delete(node);
	}
	
}