package com.myTest.json.test1;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class app1 {

	public static void main(String[] args) {
		String jsonString = "[{'Value':'0','Name':'≤‚ ‘0','statusInfo':{'Status':'0'}},{'Value':'1','Name':'≤‚ ‘1','statusInfo':{'Status':'10'}},{'Value':'2','Name':'≤‚ ‘2','statusInfo':{'Status':'20'}},{'Value':'3','Name':'≤‚ ‘3','statusInfo':{'Status':'30'}},{'Value':'4','Name':'≤‚ ‘4','statusInfo':{'Status':'40'}},{'Value':'5','Name':'≤‚ ‘5','statusInfo':{'Status':'50'}},{'Value':'6','Name':'≤‚ ‘6','statusInfo':{'Status':'60'}},{'Value':'7','Name':'≤‚ ‘7','statusInfo':{'Status':'70'}},{'Value':'8','Name':'≤‚ ‘8','statusInfo':{'Status':'80'}},{'Value':'9','Name':'≤‚ ‘9','statusInfo':{'Status':'90'}}]";
		//String jsonString = "{'Value':'0','Name':'≤‚ ‘0','statusInfo':{'Status':'12'}}";
		List<DeviceReturn> deviceReturns= app1.getPersons(jsonString, DeviceReturn.class);
		System.out.println(deviceReturns);
		String toJsonString = JSON.toJSONString(deviceReturns);
		System.out.println(toJsonString);
		
	}

	public static <T> T getPerson(String jsonString, Class cls) {
        T t = null;
        try {
            t = (T) JSON.parseObject(jsonString, cls);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return t;
    }
	
	public static <T> List<T> getPersons(String jsonString, Class cls) {
        List<T> list = new ArrayList<T>();
        try {
            list = JSON.parseArray(jsonString, cls);
        } catch (Exception e) {
        }
        return list;
    }
}
