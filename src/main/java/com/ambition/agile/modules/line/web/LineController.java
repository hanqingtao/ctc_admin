/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.line.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ambition.agile.common.config.Global;
import com.ambition.agile.common.persistence.Page;
import com.ambition.agile.common.web.BaseController;
import com.ambition.agile.common.utils.StringUtils;
import com.ambition.agile.modules.line.entity.Line;
import com.ambition.agile.modules.line.service.LineService;

/**
 * 通信线路Controller
 * @author harry
 * @version 2018-05-02
 */
@Controller
@RequestMapping(value = "${adminPath}/line/line")
public class LineController extends BaseController {

	@Autowired
	private LineService lineService;
	
	@ModelAttribute
	public Line get(@RequestParam(required=false) String id) {
		Line entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = lineService.get(id);
		}
		if (entity == null){
			entity = new Line();
		}
		return entity;
	}
	
	@RequiresPermissions("line:line:view")
	@RequestMapping(value = {"list", ""})
	public String list(Line line, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Line> page = lineService.findPage(new Page<Line>(request, response), line); 
		model.addAttribute("page", page);
		return "modules/line/lineList";
	}

	@RequiresPermissions("line:line:view")
	@RequestMapping(value = "form")
	public String form(Line line, Model model) {
		model.addAttribute("line", line);
		return "modules/line/lineForm";
	}

	@RequiresPermissions("line:line:edit")
	@RequestMapping(value = "save")
	public String save(Line line, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, line)){
			return form(line, model);
		}
		lineService.save(line);
		addMessage(redirectAttributes, "保存通信线路成功");
		return "redirect:"+Global.getAdminPath()+"/line/line/?repage";
	}
	
	@RequiresPermissions("line:line:edit")
	@RequestMapping(value = "delete")
	public String delete(Line line, RedirectAttributes redirectAttributes) {
		lineService.delete(line);
		addMessage(redirectAttributes, "删除通信线路成功");
		return "redirect:"+Global.getAdminPath()+"/line/line/?repage";
	}

}