package com.myTest.json.test1;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;

public class app2 {
	public static void main(String[] args) {
		/*List<DeviceReturn> deviceReturns= app1.getPersons(jsonString, DeviceReturn.class);
		System.out.println(deviceReturns);
		String toJsonString = JSON.toJSONString(deviceReturns);
		System.out.println(toJsonString);*/
		List<DeviceReturn> deviceReturns = new ArrayList<DeviceReturn>();
		DeviceReturn deviceReturn = new DeviceReturn();
		deviceReturn.setName("张三");
		deviceReturn.setValue("aa");
		List<StatusInfo> statusInfos = new ArrayList<StatusInfo>();  
		StatusInfo statusInfo = new StatusInfo();
		statusInfo.setStatus("苹果");
		StatusInfo statusInfo2 = new StatusInfo();
		statusInfo2.setStatus("三星");
		statusInfos.add(statusInfo);
		statusInfos.add(statusInfo2);
		deviceReturn.setStatusInfos(statusInfos);
		deviceReturns.add(deviceReturn);
		String str = JSON.toJSONString(deviceReturns);
		System.out.println(str);
		List<DeviceReturn> returns = JSON.parseObject(str, new TypeReference<List<DeviceReturn>>(){});
		System.out.println(returns);
	}
}
