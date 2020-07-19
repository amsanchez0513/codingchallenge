package com.codingchallenge;

public class GrapeComponent{

	private double percentage;
	private int year;
	private String variety;
	private String region;
	
	public GrapeComponent() {
		
	}
	public GrapeComponent(double percentage, int year, String variety, String region) {
		this.percentage = percentage;
		this.year = year;
		this.variety = variety;
		this.region = region;
	}
	
	public double getPercentage() {
		return percentage;
	}
	
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	public String getVariety() {
		return variety;
	}
	
	public void setVariety(String variety) {
		this.variety = variety;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	

	@Override
	public String toString() {
		return "GrapeComponent [percentage=" + percentage + ", year=" + year + ", variety=" + variety + ", region="
				+ region + "]\n";
	}
//	@Override
//	public int compareTo(Object o) {
//		if (o.getPercentage() < this.getPercentage()) return 1;
//	     else if (o.getPercentage() == this.getPercentage()) return 0;
//	     else return -1;
//	}


	
}
