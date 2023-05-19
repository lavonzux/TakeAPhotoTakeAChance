package com.studio.bean;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity @Table(name = "StudioInfo")
	public class StudioBean2 {
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studioInfo", cascade = CascadeType.ALL)
//	@Column(name = "studioID")
	private Integer studioID;
	@Column(name = "memberID")
	private Integer memberID;
	@Column(name = "studioName")
	private String studioName;
	@Column(name = "studioAddres")
	private String studioAddress;
	@Column(name = "studioLong")
	private float studioLong;
	@Column(name = "studioLat")
	private float studioLat;
	@Column(name = "studioPhoneE")
	private String studioPhone;
	@Column(name = "studioEmail")
	private String studioEmail;
	@Column(name = "studioTime")
	private String studioTime;
	@Column(name = "studioLink")
	private String studioLink;
	@Column(name = "studioIntro")
	private String studioIntro;
	@Column(name = "studioPicID")
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