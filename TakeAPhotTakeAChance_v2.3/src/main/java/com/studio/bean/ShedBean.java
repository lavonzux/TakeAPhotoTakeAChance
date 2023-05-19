package com.studio.bean;

public class ShedBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public Integer getStudioID() {
		return studioID;
	}
	public void setStudioID(Integer studioID) {
		this.studioID = studioID;
	}
	public Integer getShedID() {
		return shedID;
	}
	public void setShedID(Integer shedID) {
		this.shedID = shedID;
	}
	public String getShedName() {
		return shedName;
	}
	public void setShedName(String shedName) {
		this.shedName = shedName;
	}
	public Integer getShedSize() {
		return shedSize;
	}
	public void setShedSize(Integer shedSize) {
		this.shedSize = shedSize;
	}
	public Integer getShedFee() {
		return shedFee;
	}
	public void setShedFee(Integer shedFee) {
		this.shedFee = shedFee;
	}
	public String getShedFeature() {
		return shedFeature;
	}
	public void setShedFeature(String shedFeature) {
		this.shedFeature = shedFeature;
	}
	public String getShedEquip() {
		return shedEquip;
	}
	public void setShedEquip(String shedEquip) {
		this.shedEquip = shedEquip;
	}
	public String getShedType() {
		return shedType;
	}
	public void setShedType(String shedType) {
		this.shedType = shedType;
	}
	public String getShedIntro() {
		return shedIntro;
	}
	public void setShedIntro(String shedIntro) {
		this.shedIntro = shedIntro;
	}
	public Integer getStudioPicID() {
		return studioPicID;
	}
	public void setStudioPicID(Integer studioPicID) {
		this.studioPicID = studioPicID;
	}
	private Integer studioID;
	private Integer shedID;
	private String shedName;
	private Integer shedSize;
	private Integer shedFee;
	private String shedFeature;
	private String shedEquip;
	private String shedType;
	private String shedIntro;
	private Integer studioPicID;
}
