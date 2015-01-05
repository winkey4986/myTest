package com.myTest.designModel.Decorator;

public class FouthGradSchoolReport extends SchoolReport {

	@Override
	public void report() {
		//成绩单的格式是这个样子的
		System.out.println("尊敬的XXX家长:（这里是FouthGradSchoolReport）");
		System.out.println(" ......");
		System.out.println(" 语文 62 数学65 体育 98 自然 63（这里是FouthGradSchoolReport）");
		System.out.println(" .......");
		System.out.println(" 家长签名： （这里是FouthGradSchoolReport）");
	}

	@Override
	public void sign(String name) {
		//家长签名
		System.out.println("家长签名为："+name+"（这里是FouthGradSchoolReport）");
	}

}
