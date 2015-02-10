package com.myTest.webServiceServer;

import javax.jws.WebMethod; 
import javax.jws.WebService; 
import javax.xml.ws.Endpoint; 
  
@WebService 
public class Hello { 
     
    @WebMethod(operationName="sayHello1") 
    public String sayHello(String userName) 
    { 
        return "Hello,"+userName+"!"; 
    } 
     
    @WebMethod(operationName="sayHello2") 
    public String sayHello(){ 
        return "Hello World!"; 
    } 
    public static void main(String[] args){
        //
        //��WebService������ָ����ַ  
        Endpoint.publish("http://127.0.0.1:8888/WebServiceTest/Hello", new Hello());     
        System.out.println("�����ɹ���");
    } 
}