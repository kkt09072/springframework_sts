package com.spring1.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.annotation.Before;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.spring1.util.JsonUtils;

public class JsonUtilsTest {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		HashMap<String, Object> map = null;	
		ArrayList<Map<String, Object>> list = null;
		
		String jsonStr = "{\"key01\":\"value01\",\"key02\":\"value02\",\"key03\":\"value03\",\"key04\":\"value04\",\"key05\":\"value05\"}";
		
		JSONObject jsonObject = null;	
		JSONArray jsonArray = null;
		
		//맵
		map = new HashMap<String, Object>();
		map.put("key01", "value01");
		map.put("key02", "value02");
		map.put("key03", "value03");
		map.put("key04", "value04");
		map.put("key05", "value05");
		
		//리스트
		list = new ArrayList<Map<String, Object>>(); 
		list.add(map);		
		list.add(map);		
		list.add(map);

		//JSON
		jsonObject = new JSONObject();
		jsonObject.put("key01", "value01");
		jsonObject.put("key02", "value02");
		jsonObject.put("key03", "value03");
		jsonObject.put("key04", "value04");
		jsonObject.put("key05", "value05");
		
		//JSON
		jsonArray = new JSONArray();
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject);
		
		testGetJsonStringFromMap(map);
		testGetJsonStringFromList(list);
		testGetJsonObjectFromString(jsonStr);
		testGetMapFromJsonObject(jsonObject);
		testGetListMapFromJsonArray(jsonArray);
	}
	
	public static void testGetJsonStringFromMap(HashMap<String, Object> map1) {
		String jsonStr = JsonUtils.getJsonStringFromMap(map1);			
		System.out.println("JsonStringFromMap(Map을 Json으로 변환) : " + jsonStr);
	}
	
	public static void testGetJsonStringFromList(ArrayList<Map<String, Object>> list1) {
		String jsonStr = JsonUtils.getJsonStringFromList(list1);		
		System.out.println("JsonStringFromList(List를 Json으로 변환) : " + jsonStr);
	}

	public static void testGetJsonObjectFromString(String jsonStr1) {
		JSONObject jsonObject = JsonUtils.getJsonObjectFromString(jsonStr1);		
		System.out.println("JsonObjectFromString(String을 JsonObject로 변환) : " + jsonObject);
	}

	public static void testGetMapFromJsonObject(JSONObject jsonObject1) {
		Map<String, Object> map = JsonUtils.getMapFromJsonObject(jsonObject1);
		System.out.println("MapFromJsonObject(JsonObject를 Map으로 변환) : " + map);
	}
	
	public static void testGetListMapFromJsonArray(JSONArray jsonArray1) {
		List<Map<String, Object>> list = JsonUtils.getListMapFromJsonArray(jsonArray1);		
		System.out.println("ListMapFromJsonArray(JsonArray를 List로 변환) : " + list);
	}
	
	

}
