/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.payment.web;

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
import com.ambition.agile.modules.payment.entity.OrdersEvaluate;
import com.ambition.agile.modules.payment.service.OrdersEvaluateService;

/**
 * 订单评价Controller
 * @author 订单评价
 * @version 2018-05-09
 */
@Controller
@RequestMapping(value = "${adminPath}/payment/ordersEvaluate")
public class OrdersEvaluateController extends BaseController {

	@Autowired
	private OrdersEvaluateService ordersEvaluateService;
	
	@ModelAttribute
	public OrdersEvaluate get(@RequestParam(required=false) String id) {
		OrdersEvaluate entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ordersEvaluateService.get(id);
		}
		if (entity == null){
			entity = new OrdersEvaluate();
		}
		return entity;
	}
	
	@RequiresPermissions("payment:ordersEvaluate:view")
	@RequestMapping(value = {"list", ""})
	public String list(OrdersEvaluate ordersEvaluate, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OrdersEvaluate> page = ordersEvaluateService.findPage(new Page<OrdersEvaluate>(request, response), ordersEvaluate); 
		model.addAttribute("page", page);
		return "modules/payment/ordersEvaluateList";
	}

	@RequiresPermissions("payment:ordersEvaluate:view")
	@RequestMapping(value = "form")
	public String form(OrdersEvaluate ordersEvaluate, Model model) {
		model.addAttribute("ordersEvaluate", ordersEvaluate);
		return "modules/payment/ordersEvaluateForm";
	}

	@RequiresPermissions("payment:ordersEvaluate:edit")
	@RequestMapping(value = "save")
	public String save(OrdersEvaluate ordersEvaluate, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, ordersEvaluate)){
			return form(ordersEvaluate, model);
		}
		ordersEvaluateService.save(ordersEvaluate);
		addMessage(redirectAttributes, "保存订单评价成功");
		return "redirect:"+Global.getAdminPath()+"/payment/ordersEvaluate/?repage";
	}
	
	@RequiresPermissions("payment:ordersEvaluate:edit")
	@RequestMapping(value = "delete")
	public String delete(OrdersEvaluate ordersEvaluate, RedirectAttributes redirectAttributes) {
		ordersEvaluateService.delete(ordersEvaluate);
		addMessage(redirectAttributes, "删除订单评价成功");
		return "redirect:"+Global.getAdminPath()+"/payment/ordersEvaluate/?repage";
	}

}