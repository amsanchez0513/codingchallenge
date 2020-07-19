package com.codingchallenge;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



public class Wine implements Serializable{

	private static final long serialVersionUID = -6892434771833441384L;
	
	private Set<GrapeComponent> components = new HashSet<GrapeComponent>();
	private String lotCode;
	private double volume;
	private String description;
	private String tankCode;
	private String productState;
	private String ownerName;
	
	public Wine() {
	}

	
	public Wine(String lotCode, double volume, String description, String tankCode,
			String productState, String ownerName, Set<GrapeComponent> components){
		this.lotCode = lotCode;
		this.volume = volume;
		this.description = description;
		this.tankCode = tankCode;
		this.productState = productState;
		this.ownerName = ownerName;
		this.components = components;
		
    }
	
	public Wine(String lotCode, double volume) {
		this.lotCode = lotCode;
		this.volume = volume;
	}
	
	
	public Set<GrapeComponent> getComponents() {
		return components;
	}

	public String getLotCode() {
		return lotCode;
	}

	public void setLotCode(String lotCode) {
		this.lotCode = lotCode;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTankCode() {
		return tankCode;
	}

	public void setTankCode(String tankCode) {
		this.tankCode = tankCode;
	}

	public String getProductState() {
		return productState;
	}

	public void setProductState(String productState) {
		this.productState = productState;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public void setComponents(Set<GrapeComponent> components) {
		this.components = components;
	}
	
	public void getWine() {
		System.out.println("Wineee");
	}
	
	public String sortByVariety() {
        return "sortByVariety";
    }

	@Override
	public String toString() {
		return "Wine [components=" + components + ", lotCode=" + lotCode + ", volume=" + volume + ", description="
				+ description + ", tankCode=" + tankCode + ", productState=" + productState + ", ownerName=" + ownerName
				+ "]";
	}
	
	
	
	
}
