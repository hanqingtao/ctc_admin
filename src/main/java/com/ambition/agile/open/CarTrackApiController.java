/**
 * Copyright &copy; 2012-2017  All rights reserved.
 */
package com.ambition.agile.open;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ambition.agile.common.ApiResponse;
import com.ambition.agile.common.BaseConfigHolder;
import com.ambition.agile.common.config.Global;
import com.ambition.agile.common.persistence.Page;
import com.ambition.agile.common.util.MD5Encrypt;
import com.ambition.agile.common.utils.StringUtils;
import com.ambition.agile.common.web.BaseController;
import com.ambition.agile.modules.car.entity.Car;
import com.ambition.agile.modules.car.entity.CarTrack;
import com.ambition.agile.modules.car.service.CarService;
import com.ambition.agile.modules.car.service.CarTrackService;

/**
 * 车辆轨迹信息Controller
 * @author harry
 * @version 2018-05-04
 */
@Controller
@RequestMapping(value = "${frontPath}/mobile")
public class CarTrackApiController extends BaseController {

	@Autowired
	private CarTrackService carTrackService;
	
	@Autowired
	private CarService carService;
	
	/**
	 * 用户获取 GPS 设备的轨迹 记录接口
	 * @param plate_number  （车辆 牌号 唯一标识）
	 * @param longitude （经度）
	 * @param latitude （纬度）
	 * @param timestamp （请求时间, 1970 年到此时的秒数）
	 * @param sign （签名, 所有参数名升序排列后拼接成字符串后跟密钥一起MD5）
	 * @return
	 */
	@RequestMapping(value="/gps/addpoint")
	@ResponseBody
	public ApiResponse<?> progress(String plateNumber, String longitude, String latitude, 
			String timestamp, String sign){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if( StringUtils.isEmpty(plateNumber) || StringUtils.isEmpty(longitude) || 
				StringUtils.isEmpty(latitude) || StringUtils.isEmpty(timestamp) || 
				StringUtils.isEmpty(sign) ){
			logger.error("params error...");
			return ApiResponse.fail(500, "无法 获取 gps 数据！原因：参数有误。");
		}
		// 间隔时间判断（前后 间隔 1分钟内允许获取课程学习记录）
		Date date = new Date();
		long time = date.getTime()/1000 - Long.parseLong(timestamp);
		if(time > 60 || time < -60){
			logger.error("timestamp error...");
			return ApiResponse.fail(500, "无法获取课程学习记录！原因：参数有误。");
		}
		// 判断分校标识是否正确
//		Map<String, Object> orgMap = orgWebApi.getOrgByOrgNameSn(corpid);
//		if(orgMap == null){
//			logger.error("org is null...");
//			return ApiResponse.fail(500, "无法获取课程学习记录！原因：参数有误。");
//		}
//		
		// 判断签名是否正确
		String secretKey = BaseConfigHolder.getGpsSecretKey();
		String params = "plateNumber=" + plateNumber + "longitude=" + longitude + "latitude=" + latitude + 
				"timestamp=" + timestamp + secretKey;
		if(!MD5Encrypt.encrypt(params).equals(sign)){
			logger.error("sign error, params: " + params + "sign: " + sign);
			return ApiResponse.fail(500, "获取 GPS 上传 记录！原因：签名,解密有误。");
		}
		
		//先根据车牌号查询
		Car carTemp = new Car();
		carTemp.setPlateNumber(plateNumber);
		Car car = carService.get(carTemp);
		if(null == car || !StringUtils.isNotEmpty(car.getId())){
			logger.error("plateNumber error, params: " + params + "sign: " + sign);
			return ApiResponse.fail(500, "获取 GPS 的数据，车牌号有误！原因：车牌号不存在。");
		}
		
		CarTrack carTrack = new CarTrack();
		carTrack.setLatitude(latitude);
		carTrack.setLongitude(longitude);
		carTrack.setCarId(Integer.parseInt(car.getId()));
		CarTrack carTrackTemp = carTrackService.get(carTrack);
		
		if(null == carTrackTemp || !StringUtils.isNotEmpty(carTrackTemp.getId())){
			logger.error(" save car track , params: " + carTrackTemp.toString() );
			carTrackService.save(carTrackTemp);
		}
		return ApiResponse.success("gps信息保存成功!");
	}
	
//	@ModelAttribute
//	public CarTrack get(@RequestParam(required=false) String id) {
//		CarTrack entity = null;
//		if (StringUtils.isNotBlank(id)){
//			entity = carTrackService.get(id);
//		}
//		if (entity == null){
//			entity = new CarTrack();
//		}
//		return entity;
//	}
	
}