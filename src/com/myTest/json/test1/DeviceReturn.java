package com.myTest.json.test1;

import java.util.ArrayList;
import java.util.List;

public class DeviceReturn {
	 private String Value;
     private String Name;
     private StatusInfo statusInfo;
     private List<StatusInfo> statusInfos = new ArrayList<StatusInfo>();  
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public StatusInfo getStatusInfo() {
		return statusInfo;
	}
	public void setStatusInfo(StatusInfo statusInfo) {
		this.statusInfo = statusInfo;
	}
	
	
	public List<StatusInfo> getStatusInfos() {
		return statusInfos;
	}
	public void setStatusInfos(List<StatusInfo> statusInfos) {
		this.statusInfos = statusInfos;
	}
	public DeviceReturn(String value, String name, StatusInfo statusInfo) {
		super();
		Value = value;
		Name = name;
		this.statusInfo = statusInfo;
	}
	public DeviceReturn() {
	}
}
