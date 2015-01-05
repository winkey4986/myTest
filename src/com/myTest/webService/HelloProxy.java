package com.myTest.webService;

public class HelloProxy implements com.myTest.webService.Hello {
  private String _endpoint = null;
  private com.myTest.webService.Hello hello = null;
  
  public HelloProxy() {
    _initHelloProxy();
  }
  
  public HelloProxy(String endpoint) {
    _endpoint = endpoint;
    _initHelloProxy();
  }
  
  private void _initHelloProxy() {
    try {
      hello = (new com.myTest.webService.HelloServiceLocator()).getHelloPort();
      if (hello != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)hello)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)hello)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (hello != null)
      ((javax.xml.rpc.Stub)hello)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.myTest.webService.Hello getHello() {
    if (hello == null)
      _initHelloProxy();
    return hello;
  }
  
  public java.lang.String sayHello1(java.lang.String arg0) throws java.rmi.RemoteException{
    if (hello == null)
      _initHelloProxy();
    return hello.sayHello1(arg0);
  }
  
  public java.lang.String sayHello2(java.lang.String arg0) throws java.rmi.RemoteException{
    if (hello == null)
      _initHelloProxy();
    return hello.sayHello2(arg0);
  }
  
  
}