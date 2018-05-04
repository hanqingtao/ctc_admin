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
import com.ambition.agile.modules.car.entity.CarTrack;
import com.ambition.agile.modules.car.service.CarTrackService;

/**
 * 车辆轨迹信息Controller
 * @author harry
 * @version 2018-05-04
 */
@Controller
@RequestMapping(value = "${adminPath}/car/carTrack")
public class CarTrackController extends BaseController {

	@Autowired
	private CarTrackService carTrackService;
	
	@ModelAttribute
	public CarTrack get(@RequestParam(required=false) String id) {
		CarTrack entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = carTrackService.get(id);
		}
		if (entity == null){
			entity = new CarTrack();
		}
		return entity;
	}
	
	@RequiresPermissions("car:carTrack:view")
	@RequestMapping(value = {"list", ""})
	public String list(CarTrack carTrack, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CarTrack> page = carTrackService.findPage(new Page<CarTrack>(request, response), carTrack); 
		model.addAttribute("page", page);
		return "modules/car/carTrackList";
	}

	@RequiresPermissions("car:carTrack:view")
	@RequestMapping(value = "form")
	public String form(CarTrack carTrack, Model model) {
		model.addAttribute("carTrack", carTrack);
		return "modules/car/carTrackForm";
	}

	@RequiresPermissions("car:carTrack:edit")
	@RequestMapping(value = "save")
	public String save(CarTrack carTrack, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, carTrack)){
			return form(carTrack, model);
		}
		carTrackService.save(carTrack);
		addMessage(redirectAttributes, "保存车辆轨迹信息成功");
		return "redirect:"+Global.getAdminPath()+"/car/carTrack/?repage";
	}
	
	@RequiresPermissions("car:carTrack:edit")
	@RequestMapping(value = "delete")
	public String delete(CarTrack carTrack, RedirectAttributes redirectAttributes) {
		carTrackService.delete(carTrack);
		addMessage(redirectAttributes, "删除车辆轨迹信息成功");
		return "redirect:"+Global.getAdminPath()+"/car/carTrack/?repage";
	}

}