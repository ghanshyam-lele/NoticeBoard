package com.example.esl;

public class Notice 
{
	String nid;
	String title;
	String desc;
	public Notice(String nid, String title, String desc) {
		
		this.nid = nid;
		this.title = title;
		this.desc = desc;
		
	}
	public String getNid() {
		return nid;
	}
	public String getTitle() {
		return title;
	}
	public String getDesc() {
		return desc;
	}
	
}
