package com.myTest.designModel.Decorator;

public abstract class Decorator extends SchoolReport {
	
	private SchoolReport schoolReport;
	
	public Decorator(SchoolReport schoolReport) {
		this.schoolReport = schoolReport;
	}

	@Override
	public void report() {
		this.schoolReport.report();
	}

	@Override
	public void sign(String name) {
		this.schoolReport.sign(name);
	}

}
