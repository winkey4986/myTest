package com.myTest.shortestAbstract;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 例子1
 * @author winkey
 *
 */
public class ShortestAbstract {  
	  
    /** 
     * 编程之美 最短摘要的生成 
     * 扫描过程始终保持一个[pBegin,pEnd]的range,初始化确保[pBegin,pEnd]的range里包含所有关键字 
     * 然后每次迭代，尝试调整pBegin和pEnd： 
     * 1.pBegin递增，直到range无法包含所有关键字 
     * 2.pEnd递增，直到range重新包含所有关键字 
     * 计算新的range，与旧的range相比，看是否缩短了，如果是，则更新 
     * 不考虑关键字的先后顺序 
     */  
    public static void main(String[] args) {  
//      String description = "w0,w1,w2,w3,q0,w4,w5,q1,w6,w7,w8,q0,w9,q1";  
        String description = "w0,w1,w2,q1,w3,q0,w4,w5,q1,q0,w6,w7,w8,,q0,w9,q1";  
        String[] keywords = {"q1","q0"};  
        String summery = shortestAbstract(description, keywords);  
        System.out.println(summery);  
    }  
      
    public static String shortestAbstract(String description, String[] keywords) {  
        if (description == null || description.length() == 0  
                || keywords == null || keywords.length == 0) {  
            return null;  
        }  
        String[] desc = description.split(",");  
        return extract(desc, keywords);  
    }  
  
    public static String extract(String[] desc, String[] keywords) {  
        Map<String, Integer> map = new HashMap<String, Integer>();      //key=关键字 value=关键字出现的次数  
        for (String keyword : keywords) {  
            if (keyword != null && keyword.length() != 0) {     //忽略null和空字符  
                map.put(keyword, 0);  
            }  
        }  
        if (map.isEmpty()) {  
            return null;  
        }  
          
        String summery = null;  
        int descLen = desc.length;  
        int shortestLen = descLen + 1;  
        int pBegin = 0;  
        int pEnd = 0;  
        int abstractBegin = -1;  
        int abstractEnd = -1;  
          
        while (true) {  
              
            //相当于初始化，从desc[0]开始，找到第一个包含所有关键字的摘要：desc[0]~desc[pEnd]，此时pBegin=0  
            while (!isAllVisited(map) && pEnd < descLen) {  
                if (map.containsKey(desc[pEnd])) {  
                    setVisited(map, desc[pEnd], 1);     //出现次数加1  
                }  
                pEnd++;  
            }  
              
            //pBegin右移，停止条件为：已经无法包含所有关键字；  
            //然后回到上面，右移pEnd，重新初始化，使得pBegin~pEnd重新包含所有关键字  
            while (isAllVisited(map)) {  
                if (pEnd - pBegin < shortestLen) {  
                    shortestLen = pEnd - pBegin;  
                    abstractBegin = pBegin;  
                    abstractEnd = pEnd -1;  
                }  
                if (map.get(desc[pBegin]) != null) {  
                    setVisited(map, desc[pBegin], -1);      //出现次数减1  
                }  
                pBegin++;  
            }  
              
            if (pEnd >= descLen) {  
                break;  
            }  
              
        }  
          
        //返回找到的最短摘要，没找到则返回null  
        if (abstractBegin == -1 || abstractEnd == -1) {  
            System.out.println("one or more keywords not found.");  
        } else {  
            StringBuilder sb = new StringBuilder();  
            for (int i = abstractBegin; i <= abstractEnd; i++) {  
                sb.append("," + desc[i]);  
            }  
            if (sb.length() > 1) {  
                summery = sb.substring(1);  
            }  
        }  
        return summery;  
    }  
      
    //所有关键字出现次数大于0，则找到了一个摘要  
    private static boolean isAllVisited(Map<String, Integer> map) {  
        for (Entry<String, Integer> entry : map.entrySet()) {  
            int count = entry.getValue();  
            if (count == 0) {  
                return false;  
            }  
        }  
        return true;  
    }  
      
    private static void setVisited(Map<String, Integer> map, String key, int add) {  
        int count = map.get(key);  
        map.put(key, count + add);  
    }  
      
} 