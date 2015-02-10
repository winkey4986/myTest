package com.myTest.webServiceTest;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.ser.JAFDataHandlerDeserializerFactory;
import org.apache.axis.encoding.ser.JAFDataHandlerSerializerFactory;

import javax.activation.DataHandler;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;

/**
 * Created by winkey on 15-2-10.
 */
public class uploadTest {
    /**
     * @param args
     */
    public static void main(String[] args) {   // TODO Auto-generated method stub
        String url = "http://192.168.129.245:8080/btm-szny/services/FileController";
        Service service = new Service();
        Call call;
        DataHandler handler;
        InputStream input = null;
        FileOutputStream fos = null;
        String filepath = "f:/test/";
        String filename = filepath + "tests.jpg";
        File file = new File(filename);
        try {
            call = (Call) service.createCall();
            QName qn = new QName("ns1:DataHandler", "DataHandler");
            call.setTargetEndpointAddress(url);
            call.setOperationName(new QName("FileController", "downloadFile"));
            call.registerTypeMapping(DataHandler.class, qn, JAFDataHandlerSerializerFactory.class, JAFDataHandlerDeserializerFactory.class); //
            //call.addParameter("source", XMLType.XSD_STRING ,ParameterMode.IN); //设置服务调用方法的传入参数类型
            call.setReturnType(qn, DataHandler.class);//需要返回的QName以及返回的类型是DataHandler.class
            handler = (DataHandler) call.invoke(new Object[]{});
            input = handler.getInputStream();
            fos = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            while (input.read(buffer) != -1) {
                fos.write(buffer);
            }
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception e2) {      // TODO: handle exception
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e2) {      // TODO: handle exception
                }
            }
        }
    }
}