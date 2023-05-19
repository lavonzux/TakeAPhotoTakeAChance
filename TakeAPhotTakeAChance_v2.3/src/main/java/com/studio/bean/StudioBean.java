package com.studio.bean;

public class StudioBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer studioID;
	private Integer memberID;
	private String studioName;
	private String studioAddress;
	private float studioLong;
	private float studioLat;
	private String studioPhone;
	private String studioEmail;
	private String studioTime;
	private String studioLink;
	private String studioIntro;
	private Integer studioPicID;
	
	public Integer getStudioID() {
		return studioID;
	}
	public void setStudioID(Integer studioID) {
		this.studioID = studioID;
	}
	public Integer getMemberID() {
		return memberID;
	}
	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}
	public String getStudioName() {
		return studioName;
	}
	public void setStudioName(String studioName) {
		this.studioName = studioName;
	}
	public String getStudioAddress() {
		return studioAddress;
	}
	public void setStudioAddress(String studioAddress) {
		this.studioAddress = studioAddress;
	}
	public float getStudioLong() {
		return studioLong;
	}
	public void setStudioLong(float studioLong) {
		this.studioLong = studioLong;
	}
	public float getStudioLat() {
		return studioLat;
	}
	public void setStudioLat(float studioLat) {
		this.studioLat = studioLat;
	}
	public String getStudioPhone() {
		return studioPhone;
	}
	public void setStudioPhone(String studioPhone) {
		this.studioPhone = studioPhone;
	}
	public String getStudioEmail() {
		return studioEmail;
	}
	public void setStudioEmail(String studioEmail) {
		this.studioEmail = studioEmail;
	}
	public String getStudioTime() {
		return studioTime;
	}
	public void setStudioTime(String studioTime) {
		this.studioTime = studioTime;
	}
	public String getStudioLink() {
		return studioLink;
	}
	public void setStudioLink(String studioLink) {
		this.studioLink = studioLink;
	}
	public String getStudioIntro() {
		return studioIntro;
	}
	public void setStudioIntro(String studioIntro) {
		this.studioIntro = studioIntro;
	}
	public Integer getStudioPicID() {
		return studioPicID;
	}
	public void setStudioPicID(Integer studioPicID) {
		this.studioPicID = studioPicID;
	}


}