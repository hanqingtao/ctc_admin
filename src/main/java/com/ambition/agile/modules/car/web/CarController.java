/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.car.web;

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
import com.ambition.agile.modules.car.entity.Car;
import com.ambition.agile.modules.car.service.CarService;

/**
 * 车辆信息表Controller
 * @author harry
 * @version 2018-05-04
 */
@Controller
@RequestMapping(value = "${adminPath}/car/car")
public class CarController extends BaseController {

	@Autowired
	private CarService carService;
	
	@ModelAttribute
	public Car get(@RequestParam(required=false) String id) {
		Car entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = carService.get(id);
		}
		if (entity == null){
			entity = new Car();
		}
		return entity;
	}
	
	@RequiresPermissions("car:car:view")
	@RequestMapping(value = {"list", ""})
	public String list(Car car, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Car> page = carService.findPage(new Page<Car>(request, response), car); 
		model.addAttribute("page", page);
		return "modules/car/carList";
	}

	@RequiresPermissions("car:car:view")
	@RequestMapping(value = "form")
	public String form(Car car, Model model) {
		model.addAttribute("car", car);
		return "modules/car/carForm";
	}

	@RequiresPermissions("car:car:edit")
	@RequestMapping(value = "save")
	public String save(Car car, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, car)){
			return form(car, model);
		}
		carService.save(car);
		addMessage(redirectAttributes, "保存车辆信息表成功");
		return "redirect:"+Global.getAdminPath()+"/car/car/?repage";
	}
	
	@RequiresPermissions("car:car:edit")
	@RequestMapping(value = "delete")
	public String delete(Car car, RedirectAttributes redirectAttributes) {
		carService.delete(car);
		addMessage(redirectAttributes, "删除车辆信息表成功");
		return "redirect:"+Global.getAdminPath()+"/car/car/?repage";
	}

}