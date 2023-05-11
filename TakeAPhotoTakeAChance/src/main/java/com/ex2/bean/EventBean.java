package com.ex2.bean;

import java.sql.Date;

public class EventBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int eventID;
	private int memberID;
	private String eventType;
	private String eventTopic;
	private String eventInfo;
	private Date eventDate;
	
	
	public int getEventID() {
		return eventID;
	}
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
		
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	public String getEventTopic() {
		return eventTopic;
	}
	public void setEventTopic(String eventTopic) {
		this.eventTopic = eventTopic;
	}
	
	public String getEventInfo() {
		return eventInfo;
	}
	public void setEventInfo(String eventInfo) {
		this.eventInfo = eventInfo;
	}
	
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
}
	
	