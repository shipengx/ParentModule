package com.shipeng.data.object;

public class RecgenAirRoute {

	private String oName;
	private String oCode;
	private String oCity;
	private String oState;
	private String dName;
	private String dCode;
	private String dCity;
	private String dState;
	private String companyName;
	private String companyLogoUrl;
	private String url;
	private double rate;
	private double strikeThroughRate;
	private String currencySymbol;
	private String rgct;

	public RecgenAirRoute() {
	}
	
	public RecgenAirRoute(RecgenAirRouteBuilder builder) {
		this.oName = builder.oName;
		this.oCode = builder.oCode;
		this.oCity = builder.oCity;
		this.oState = builder.oState;
		this.dName = builder.dName;
		this.dCode = builder.dCode;
		this.dCity = builder.dCity;
		this.dState = builder.dState;
		this.companyName = builder.companyName;
		this.companyLogoUrl = builder.companyLogoUrl;
		this.url = builder.url;
		this.rate = builder.rate;
		this.strikeThroughRate = builder.strikeThroughRate;
		this.currencySymbol = builder.currencySymbol;
		this.rgct = builder.rgct;
	}

	public String getoName() {
		return this.oName;
	}

	public void setoName(String value) {
		this.oName = value;
	}

	public String getoCode() {
		return this.oCode;
	}

	public void setoCode(String value) {
		this.oCode = value;
	}

	public String getoCity() {
		return this.oCity;
	}

	public void setoCity(String value) {
		this.oCity = value;
	}

	public String getoState() {
		return this.oState;
	}

	public void setoState(String value) {
		this.oState = value;
	}

	public String getdName() {
		return this.dName;
	}

	public void setdName(String value) {
		this.dName = value;
	}

	public String getdCode() {
		return this.dCode;
	}

	public void setdCode(String value) {
		this.dCode = value;
	}

	public String getdCity() {
		return this.dCity;
	}

	public void setdCity(String value) {
		this.dCity = value;
	}

	public String getdState() {
		return this.dState;
	}

	public void setdState(String value) {
		this.dState = value;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String value) {
		this.companyName = value;
	}

	public String getCompanyLogoUrl() {
		return this.companyLogoUrl;
	}

	public void setCompanyLogoUrl(String value) {
		this.companyLogoUrl = value;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String value) {
		this.url = value;
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
	
	public String toString() {
		return "[RecgenAirRoute]:oCode="+this.oCode+"-"+"dCode="+this.dCode;
	}
	
	public static class RecgenAirRouteBuilder {
		
		private String oName;
		private String oCode;
		private String oCity;
		private String oState;
		private String dName;
		private String dCode;
		private String dCity;
		private String dState;
		private String companyName;
		private String companyLogoUrl;
		private String url;
		private double rate;
		private double strikeThroughRate;
		private String currencySymbol;
		private String rgct;
		
		public RecgenAirRouteBuilder() {
		}
		
		public RecgenAirRouteBuilder setOName(String value) {
			this.oName = value;
			return this;
		}
		
		public RecgenAirRouteBuilder setOCode(String value) {
			this.oCode = value;
			return this;
		}
		
		public RecgenAirRouteBuilder setOCity(String value) {
			this.oCity = value;
			return this;
		}
		
		public RecgenAirRouteBuilder setOState(String value) {
			this.oState = value;
			return this;
		}
		
		public RecgenAirRouteBuilder setDName(String value) {
			this.dName = value;
			return this;
		}
		
		public RecgenAirRouteBuilder setDCode(String value) {
			this.dCode = value;
			return this;
		}
		
		public RecgenAirRouteBuilder setDCity(String value) {
			this.dCity = value;
			return this;
		}
		
		public RecgenAirRouteBuilder setDState(String value) {
			this.dState = value;
			return this;
		}
		
		public RecgenAirRouteBuilder setCompanyName(String value) {
			this.companyName = value;
			return this;
		}
		
		public RecgenAirRouteBuilder setCompanyLogoUrl(String value) {
			this.companyLogoUrl = value;
			return this;
		}
		
		public RecgenAirRouteBuilder setUrl(String value) {
			this.url = value;
			return this;
		}
		
		public RecgenAirRouteBuilder setRate(double value) {
			this.rate = value;
			return this;
		}
		
		public RecgenAirRouteBuilder setStrikeThroughRate(double value) {
			this.strikeThroughRate = value;
			return this;
		}
		
		public RecgenAirRouteBuilder setCurrencySymbol(String value) {
			this.currencySymbol = value;
			return this;
		}
		
		public RecgenAirRouteBuilder setRgct(String value) {
			this.rgct = value;
			return this;
		}
		
		public RecgenAirRoute build() {
			return new RecgenAirRoute(this);
		}
		
	} //end inner builder class
	
}