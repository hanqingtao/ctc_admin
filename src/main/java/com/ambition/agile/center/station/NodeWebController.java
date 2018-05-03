/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.center.station;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ambition.agile.common.web.BaseController;
import com.ambition.agile.modules.node.entity.Node;
import com.ambition.agile.modules.node.service.NodeService;
import com.ambition.agile.modules.station.entity.Station;

/**
 * 通信站Controller
 * @author harry
 * @version 2018-04-25
 */
@Controller
@RequestMapping(value = "${frontPath}/node")
public class NodeWebController extends BaseController {

	
	
	@Autowired
	private NodeService nodeService;
	
//	@ModelAttribute
//	public Station get(@RequestParam(required=false) String id) {
//		Station entity = null;
//		if (StringUtils.isNotBlank(id)){
//			entity = stationService.get(id);
//		}
//		if (entity == null){
//			entity = new Station();
//		}
//		return entity;
//	}
	
//	
//	@RequestMapping(value="/getStationList", produces={"application/json; charset=UTF-8"})
//	@ResponseBody
//	public List<Station> getStationList() {
//		
//		Node node = new Node();
//		logger.info("根据搜索名称、省份、进行查询站点 信息");
//		List<Station>   stationList =nodeService.findList(station);
//		//findAllList
//		return  stationList;
//		
//	}
	
	@RequestMapping(value="/getAllNodeList",produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public List<Node> getAllNodeList(){
		Node node = new Node();
		List<Node> nodeList = nodeService.findList(node);
		System.out.println(nodeList.toString());
		return nodeList;
	}
	
//	@RequiresPermissions("station:station:view")
//	@RequestMapping(value = {"list", ""})
//	public String list(Station station, HttpServletRequest request, HttpServletResponse response, Model model) {
//		Page<Station> page = stationService.findPage(new Page<Station>(request, response), station); 
//		model.addAttribute("page", page);
//		return "modules/station/stationList";
//	}
//
//	@RequiresPermissions("station:station:view")
//	@RequestMapping(value = "form")
//	public String form(Station station, Model model) {
//		model.addAttribute("station", station);
//		return "modules/station/stationForm";
//	}
//
//	@RequiresPermissions("station:station:edit")
//	@RequestMapping(value = "save")
//	public String save(Station station, Model model, RedirectAttributes redirectAttributes) {
//		if (!beanValidator(model, station)){
//			return form(station, model);
//		}
//		stationService.save(station);
//		addMessage(redirectAttributes, "保存通信站成功");
//		return "redirect:"+Global.getAdminPath()+"/station/station/?repage";
//	}
//	
//	@RequiresPermissions("station:station:edit")
//	@RequestMapping(value = "delete")
//	public String delete(Station station, RedirectAttributes redirectAttributes) {
//		stationService.delete(station);
//		addMessage(redirectAttributes, "删除通信站成功");
//		return "redirect:"+Global.getAdminPath()+"/station/station/?repage";
//	}

}