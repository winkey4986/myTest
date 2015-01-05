package com.myTest.designModel.Decorator;

public class Father {

	public static void main(String[] args) {
		//成绩单拿过来
		SchoolReport sr;
		sr = new FouthGradSchoolReport();
		
		sr = new HighScoreDecorator(sr);
		
		sr = new SortDecorator(sr);
		
		sr.report();
		
		sr.sign("老三");
	}

}
