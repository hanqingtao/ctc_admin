/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.modules.station.web;

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
import com.ambition.agile.modules.station.entity.Station;
import com.ambition.agile.modules.station.service.StationService;

/**
 * 通信站Controller
 * @author harry
 * @version 2018-04-25
 */
@Controller
@RequestMapping(value = "${adminPath}/station/station")
public class StationController extends BaseController {

	@Autowired
	private StationService stationService;
	
	@ModelAttribute
	public Station get(@RequestParam(required=false) String id) {
		Station entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = stationService.get(id);
		}
		if (entity == null){
			entity = new Station();
		}
		return entity;
	}
	
	@RequiresPermissions("station:station:view")
	@RequestMapping(value = {"list", ""})
	public String list(Station station, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Station> page = stationService.findPage(new Page<Station>(request, response), station); 
		model.addAttribute("page", page);
		return "modules/station/stationList";
	}

	@RequiresPermissions("station:station:view")
	@RequestMapping(value = "form")
	public String form(Station station, Model model) {
		model.addAttribute("station", station);
		return "modules/station/stationForm";
	}

	@RequiresPermissions("station:station:edit")
	@RequestMapping(value = "save")
	public String save(Station station, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, station)){
			return form(station, model);
		}
		stationService.save(station);
		addMessage(redirectAttributes, "保存通信站成功");
		return "redirect:"+Global.getAdminPath()+"/station/station/?repage";
	}
	
	@RequiresPermissions("station:station:edit")
	@RequestMapping(value = "delete")
	public String delete(Station station, RedirectAttributes redirectAttributes) {
		stationService.delete(station);
		addMessage(redirectAttributes, "删除通信站成功");
		return "redirect:"+Global.getAdminPath()+"/station/station/?repage";
	}

}