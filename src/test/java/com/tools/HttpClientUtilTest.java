package com.tools;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.http.ParseException; 

import com.ambition.agile.common.util.HttpClientUtil;
import com.google.common.collect.Lists;

import junit.framework.TestCase;

public class HttpClientUtilTest extends TestCase{
	
	public void  testMethod1() {
		
		/*
		String url = "http://yingyan.baidu.com/api/v3/track/addpoint";
		Map<String,String>  maps= new HashMap<String,String>();
		maps.put("ak", "lBBPrgP1Qaa0V3zQBc6gYuKi8TXcpklY");
		maps.put("service_id", "200466");
		maps.put("entity_name", "nm888");
		maps.put("latitude","40.111");
		maps.put("longitude", "116.3444");
		maps.put("loc_time", "1526961135");
		maps.put("coord_type_input", "wgs84");
		HttpClientUtil httpClientUtil = HttpClientUtil.getInstance();
		String post  =  httpClientUtil.sendHttpPost(url, maps);
		
		System.out.println(post);
		*/
		
		String httpUrl = "http://yingyan.baidu.com/api/v3/entity/list";

		 //封装请求参数  
        List<NameValuePair> params = Lists.newArrayList();  
        params.add(new BasicNameValuePair("ak", "lBBPrgP1Qaa0V3zQBc6gYuKi8TXcpklY"));  
        params.add(new BasicNameValuePair("service_id", "200466"));  
        
        HttpClientUtil httpClientUtil = HttpClientUtil.getInstance();
        try{
//        	String str = "";  
//        //转换为键值对  
//        str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));  
//        System.out.println(str);  
//       
//		
//		//String post  =  httpClientUtil.sendHttpPost(url, maps);
//		String post  =  httpClientUtil.sendHttpGet(url+"?"+str);
		String get = httpClientUtil.sendHttpGet(httpUrl, params);
		System.out.println(get);
		//创建Get请求
        }catch(ParseException e){
        	e.printStackTrace(); 
		  
		
        }//catch(IOException e){
//        	e.printStackTrace();
//        }

		
	}
	
	
}
