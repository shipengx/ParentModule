package com.shipeng.data.object;

import java.util.List;

public class RecgenHotel {

	String ei;
	String name;
	String brandName;
	String bookUrl;
	List<String> photos;
	List<String> amenities;
	String rgct;
	String tpit;
	String tpct;

	
	public RecgenHotel() {
	}

	public String getEi() {
		return this.ei;
	}

	public void setEi(String value) {
		this.ei = value;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String value) {
		this.brandName = value;
	}

	public String getBookUrl() {
		return this.bookUrl;
	}

	public void setBookUrl(String value) {
		this.bookUrl = value;
	}

	public List<String> getPhotos() {
		return this.photos;
	}

	public void setPhotos(List<String> value) {
		this.photos = value;
	}

	public List<String> getAmenities() {
		return this.amenities;
	}

	public void setAmenities(List<String> value) {
		this.amenities = value;
	}

	public String getRgct() {
		return this.rgct;
	}

	public void setRgct(String value) {
		this.rgct = value;
	}

	public String getTpit() {
		return this.tpit;
	}

	public void setTpit(String value) {
		this.tpit = value;
	}

	public String getTpct() {
		return this.tpct;
	}

	public void setTpct(String value) {
		this.tpct = value;
	}
	
	public String toString() {
		return "RecgenHotel:ei="+this.ei;
	}
	
}
