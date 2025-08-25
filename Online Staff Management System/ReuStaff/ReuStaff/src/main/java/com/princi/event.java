package com.princi;

public class event {
	
	//private attributes
	String eventid;
	String eventName;
	String eventInCharge;
	String EventDate;
	
	@Override
	public String toString() {
		return "event [eventid=" + eventid + ", eventName=" + eventName + ", eventInCharge=" + eventInCharge + ", EventDate=" + EventDate + "]";
	}
	
	//overloaded constructor
	public event(String eventid,String eventName,String eventInCharge,String EventDate) {
		super();
		this.eventid=eventid;
		this.eventName=eventName;
		this.eventInCharge=eventInCharge;
		this.EventDate=EventDate;
		
		
	}
	//getters and setters
	
	public String getEventid() {
		return eventid;
	}
	public void setEventid(String eventid) {
		this.eventid = eventid;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventInCharge() {
		return eventInCharge;
	}
	public void setEventInCharge(String eventInCharge) {
		this.eventInCharge = eventInCharge;
	}
	public String getEventDate() {
		return EventDate;
	}
	public void setEventDate(String eventDate) {
		EventDate = eventDate;
	}

	
	
	

}
