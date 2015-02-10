package com.myTest.string;

public class app1 {

	public static void main(String[] args) {
		//String a = "1,2,3,4,4,5,6,7,8";
		//System.out.println(a.substring(a.length()-1,a.length()));

        String scanResult = "配品配件编号:PCservice002\\n PN:8408-E8B\\n SN:06-5F534";
        String serial_number = scanResult.substring(scanResult.indexOf(":")+1,scanResult.indexOf("\\n"));
        System.out.println(serial_number);
    }

}
