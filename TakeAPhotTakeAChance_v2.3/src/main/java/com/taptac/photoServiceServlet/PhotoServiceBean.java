package com.taptac.photoServiceServlet;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class PhotoServiceBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private int serviceID;
	private String serviceName;
	private String serviceType;
	private String servicePrice;
	private String serviceDuration;
	private String serviceLocation;
	private String serviceCreator;
	
	
	// ==================== GETTERs ====================
	public int getServiceID() {
		return serviceID;
	}
	public String getServiceName() {
		return serviceName;
	}
	public String getServiceType() {
		return serviceType;
	}
	public String getServicePrice() {
		return servicePrice;
	}
	public String getServiceDuration() {
		return serviceDuration;
	}
	public String getServiceLocation() {
		return serviceLocation;
	}
	public String getServiceCreator() {
		return serviceCreator;
	}
	
	/**
	/* Multi-GETTER, used for getting all fields in one line <br>
	 * !!! DO NOT CHANGE THE ARRAY UNLESS NESSESARY !!!
	 * @return {@code String[]} which contains value of all fields
	 */
	public String[] getAllFields() {
		String[] fields = {Integer.toString(serviceID),serviceName,serviceType,servicePrice,serviceDuration,serviceLocation,serviceCreator};
		return fields;
	}
	
	// ==================== SETTERs ====================
	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public void setServicePrice(String servicePrice) {
		this.servicePrice = servicePrice;
	}
	public void setServiceDuration(String serviceDuration) {
		this.serviceDuration = serviceDuration;
	}
	public void setServiceLocation(String serviceLocation) {
		this.serviceLocation = serviceLocation;
	}
	public void setServiceCreator(String serviceCreator) {
		this.serviceCreator = serviceCreator;
	}
	public void setAll(int serviceID,String serviceName,String serviceType,String servicePrice,String serviceDuration,String serviceLocation,String serviceCreator) {
		this.serviceID = serviceID;
		this.serviceName = serviceName;
		this.serviceType = serviceType;
		this.servicePrice = servicePrice;
		this.serviceDuration = serviceDuration;
		this.serviceLocation = serviceLocation;
		this.serviceCreator = serviceCreator;
	}
	
	// 待實裝
	public void selectiveSetter(String targetField) {
		
	}
	
	// ==================== Utilities ====================
	public ArrayList<String> getBeanFields() {
		
		Field[] declaredFields = this.getClass().getDeclaredFields();
		ArrayList<String> allFields = new ArrayList<>();
		
		for (Field field : declaredFields) {
			allFields.add(field.getName());
		}
		
		return allFields;
	}
	
	
	
	
	
}
