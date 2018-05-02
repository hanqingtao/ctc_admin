/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.line.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ambition.agile.common.persistence.Page;
import com.ambition.agile.common.service.CrudService;
import com.ambition.agile.modules.line.entity.Line;
import com.ambition.agile.modules.line.dao.LineDao;

/**
 * 通信线路Service
 * @author harry
 * @version 2018-05-02
 */
@Service
@Transactional(readOnly = true)
public class LineService extends CrudService<LineDao, Line> {

	public Line get(String id) {
		return super.get(id);
	}
	
	public List<Line> findList(Line line) {
		return super.findList(line);
	}
	
	public Page<Line> findPage(Page<Line> page, Line line) {
		return super.findPage(page, line);
	}
	
	@Transactional(readOnly = false)
	public void save(Line line) {
		super.save(line);
	}
	
	@Transactional(readOnly = false)
	public void delete(Line line) {
		super.delete(line);
	}
	
}