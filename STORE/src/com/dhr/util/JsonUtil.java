package com.dhr.util;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.xml.XMLSerializer;
public class JsonUtil {
	public static String array2json(Object[] objects){
		
		JSONArray jsonArray = JSONArray.fromObject(objects);
		return jsonArray.toString();
		
	}
	
	public static String list2json(List<?> list){
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
		
	}
	
	public static String map2json(Map<?, ?> map){
		
		JSONObject jsonObject = JSONObject.fromObject(map);
		return jsonObject.toString();
		
	}
	
	public static String object2json(Object object){
		
		JSONObject jsonObject = JSONObject.fromObject(object);
		return jsonObject.toString();
		
	}
	
	public static String xml2json(String xml){
		
		JSONArray jsonArray = (JSONArray) new XMLSerializer().read(xml);
		return jsonArray.toString();
		
	}
	
	public static JsonConfig configJson(String[] excludes) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(excludes);
		jsonConfig.setIgnoreDefaultExcludes(true);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		return jsonConfig;
	}
	
}
