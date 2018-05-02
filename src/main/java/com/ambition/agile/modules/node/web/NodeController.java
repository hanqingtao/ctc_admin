/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.node.web;

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
import com.ambition.agile.modules.node.entity.Node;
import com.ambition.agile.modules.node.service.NodeService;

/**
 * 通信线路节点Controller
 * @author harry
 * @version 2018-05-02
 */
@Controller
@RequestMapping(value = "${adminPath}/node/node")
public class NodeController extends BaseController {

	@Autowired
	private NodeService nodeService;
	
	@ModelAttribute
	public Node get(@RequestParam(required=false) String id) {
		Node entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = nodeService.get(id);
		}
		if (entity == null){
			entity = new Node();
		}
		return entity;
	}
	
	@RequiresPermissions("node:node:view")
	@RequestMapping(value = {"list", ""})
	public String list(Node node, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Node> page = nodeService.findPage(new Page<Node>(request, response), node); 
		model.addAttribute("page", page);
		return "modules/node/nodeList";
	}

	@RequiresPermissions("node:node:view")
	@RequestMapping(value = "form")
	public String form(Node node, Model model) {
		model.addAttribute("node", node);
		return "modules/node/nodeForm";
	}

	@RequiresPermissions("node:node:edit")
	@RequestMapping(value = "save")
	public String save(Node node, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, node)){
			return form(node, model);
		}
		nodeService.save(node);
		addMessage(redirectAttributes, "保存通信线路节点成功");
		return "redirect:"+Global.getAdminPath()+"/node/node/?repage";
	}
	
	@RequiresPermissions("node:node:edit")
	@RequestMapping(value = "delete")
	public String delete(Node node, RedirectAttributes redirectAttributes) {
		nodeService.delete(node);
		addMessage(redirectAttributes, "删除通信线路节点成功");
		return "redirect:"+Global.getAdminPath()+"/node/node/?repage";
	}

}