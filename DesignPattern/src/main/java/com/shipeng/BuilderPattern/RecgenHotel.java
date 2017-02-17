package com.shipeng.BuilderPattern;

import java.util.List;

public class RecgenHotel {

	private String ei;
	private String name;
	private String brandName;
	private String logoUrl;
	private String bookUrl;
	private String stars;
	private List<String> photos;
	private List<String> amenities;
	private double rate;
	private double strikeThroughRate;
	private String currencySymbol;
	private String rgct;
	private String tpit;
	private String tpct;

	public RecgenHotel() {
	}
	
	public RecgenHotel(RecgenHotelBuilder builder) {
		this.ei                = builder.ei;
		this.name              = builder.name;
		this.brandName         = builder.brandName;
		this.logoUrl           = builder.logoUrl;
		this.bookUrl           = builder.bookUrl;
		this.stars             = builder.stars;
		this.photos            = builder.photos;
		this.amenities         = builder.amenities;
		this.rate              = builder.rate;
		this.strikeThroughRate = builder.strikeThroughRate;
		this.currencySymbol    = builder.currencySymbol;
		this.rgct              = builder.rgct;
		this.tpit              = builder.tpit;
		this.tpct              = builder.tpct;
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

	public String getLogoUrl() {
		return this.logoUrl;
	}

	public void setLogoUrl(String value) {
		this.logoUrl = value;
	}

	public String getBookUrl() {
		return this.bookUrl;
	}

	public void setBookUrl(String value) {
		this.bookUrl = value;
	}

	public String getStars() {
		return this.stars;
	}

	public void setStars(String value) {
		this.stars = value;
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

	public double getRate() {
		return this.rate;
	}

	public void setRate(double value) {
		this.rate = value;
	}

	public double getStrikeThroughRate() {
		return this.strikeThroughRate;
	}

	public void setStrikeThroughRate(double value) {
		this.strikeThroughRate = value;
	}

	public String getCurrencySymbol() {
		return this.currencySymbol;
	}

	public void setCurrencySymbol(String value) {
		this.currencySymbol = value;
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
		return "RecgenHotel:ei=" + this.ei;
	}
	
	public static class RecgenHotelBuilder {
		
		private String ei;
		private String name;
		private String brandName;
		private String logoUrl;
		private String bookUrl;
		private String stars;
		private List<String> photos;
		private List<String> amenities;
		private double rate;
		private double strikeThroughRate;
		private String currencySymbol;
		private String rgct;
		private String tpit;
		private String tpct;
		
		public RecgenHotelBuilder() {
		}

		public RecgenHotelBuilder setEi(String value) {
			this.ei = value;
			return this;
		}

		public RecgenHotelBuilder setName(String value) {
			this.name = value;
			return this;
		}

		public RecgenHotelBuilder setBrandName(String value) {
			this.brandName = value;
			return this;
		}

		public RecgenHotelBuilder setLogoUrl(String value) {
			this.logoUrl = value;
			return this;
		}

		public RecgenHotelBuilder setBookUrl(String value) {
			this.bookUrl = value;
			return this;
		}

		public RecgenHotelBuilder setStars(String value) {
			this.stars = value;
			return this;
		}

		public RecgenHotelBuilder setPhotos(List<String> value) {
			this.photos = value;
			return this;
		}

		public RecgenHotelBuilder setAmenities(List<String> value) {
			this.amenities = value;
			return this;
		}

		public RecgenHotelBuilder setRate(double value) {
			this.rate = value;
			return this;
		}

		public RecgenHotelBuilder setStrikeThroughRate(double value) {
			this.strikeThroughRate = value;
			return this;
		}

		public RecgenHotelBuilder setCurrencySymbol(String value) {
			this.currencySymbol = value;
			return this;
		}

		public RecgenHotelBuilder setRgct(String value) {
			this.rgct = value;
			return this;
		}

		public RecgenHotelBuilder setTpit(String value) {
			this.tpit = value;
			return this;
		}

		public RecgenHotelBuilder setTpct(String value) {
			this.tpct = value;
			return this;
		}
		
		public RecgenHotel build() {
			return new RecgenHotel(this);
		}
	} //end class RecgenHotelBuilder
	
	public boolean equals(RecgenHotel hotel) {
		if (hotel == null) {
			return false;
		}
		return this.ei.equals(hotel.getEi())
				&& this.name == hotel.getName()
				&& this.brandName == hotel.getBrandName()
				&& this.logoUrl == hotel.getLogoUrl()
				&& this.bookUrl == hotel.getBookUrl()
				&& this.stars == hotel.getStars()
				&& this.rate == hotel.getRate()
				&& this.strikeThroughRate == hotel.getStrikeThroughRate()
				&& this.currencySymbol == hotel.getCurrencySymbol()
				&& this.tpit == hotel.getTpit()
				&& this.tpct == hotel.getTpct();
	}
	
	
	public static void main(String[] args) {
		
		RecgenHotel hotel6 = new RecgenHotel.RecgenHotelBuilder().setEi("EX6").setName("Test Hotel Property 6")
				.setBookUrl("http://testpropertyurl6.com")
				.setRgct("/recgen/roomkey/trackclick?imp_id=99101000068&udicode=6&type=click1")
				.setTpit("http://testpropertyurl6.com/imptracker").setTpct("http://testpropertyurl6.com/clicktracker").build();
		
		RecgenHotel hotel5 = new RecgenHotel.RecgenHotelBuilder().setEi("EX6").setName("Test Hotel Property 6")
				.setBookUrl("http://testpropertyurl6.com")
				.setRgct("/recgen/roomkey/trackclick?imp_id=99101000068&udicode=6&type=click1")
				.setTpit("http://testpropertyurl6.com/imptracker").setTpct("http://testpropertyurl6.com/clicktracker").build();
		
		System.out.println("hotel6 equals hotel5: " + hotel6.equals(hotel5));
		
		RecgenHotel hotel3 = new RecgenHotel.RecgenHotelBuilder().setEi("EX3").setName("Test Hotel Property 3")
				.setBrandName("Test Brand 1").setBookUrl("http://testpropertyurl3.com")
				.setRgct("/recgen/roomkey/trackclick?imp_id=99101000068&udicode=3&type=click1")
				.setTpit("http://testpropertyurl3.com/imptracker")
				.setTpct("http://testpropertyurl3.com/clicktracker").build();
		
		System.out.println("hotel6 equals hotel3: " + hotel6.equals(hotel3));
		System.out.println("hotel5 equals hotel6: " + hotel5.equals(hotel6));
		
	}
	
}