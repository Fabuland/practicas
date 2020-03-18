package com.practicas.model;

public class FuelInformation {
	private int highwaympg;
	private int citymph;
	private String fueltype;

	public FuelInformation() {

	}

	public FuelInformation(int highwaympg, int citymph, String fueltype) {
		super();
		this.highwaympg = highwaympg;
		this.citymph = citymph;
		this.fueltype = fueltype;
	}

	public int getHighwaympg() {
		return highwaympg;
	}

	public void setHighwaympg(int highwaympg) {
		this.highwaympg = highwaympg;
	}

	public int getCitymph() {
		return citymph;
	}

	public void setCitymph(int citymph) {
		this.citymph = citymph;
	}

	public String getFueltype() {
		return fueltype;
	}

	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}

	@Override
	public String toString() {
		return "{highwaympg: " + highwaympg + ",citymph: " + citymph + ",fueltype: " + fueltype + "}";
	}
}
