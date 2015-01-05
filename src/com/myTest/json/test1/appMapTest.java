package com.myTest.json.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class appMapTest {
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("key1", 1);
		map2.put("key2", 2);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(map);
		list.add(map2);
		String jsonString = JSON.toJSONString(list);
		System.out.println("json×Ö·û´®:"+jsonString);
		//½âÎöjson×Ö·û´®
		List<Map<String,Object>> list2 = JSON.parseObject(jsonString,new TypeReference<List<Map<String,Object>>>(){});
	}
}
