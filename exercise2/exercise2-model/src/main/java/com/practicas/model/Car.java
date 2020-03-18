package com.practicas.model;

public class Car {

	private EngineInformation engineinformation;
	private Dimensions dimensions;
	private Identification identification;
	private FuelInformation fuelinformation;

	public Car() {

	}

	public Car(EngineInformation engineinformation, Dimensions dimensions, Identification identification,
			FuelInformation fuelinformation) {
		super();
		this.engineinformation = engineinformation;
		this.dimensions = dimensions;
		this.identification = identification;
		this.fuelinformation = fuelinformation;
	}

	public EngineInformation getEngineinformation() {
		return engineinformation;
	}

	public void setEngineinformation(EngineInformation engineinformation) {
		this.engineinformation = engineinformation;
	}

	public Dimensions getDimensions() {
		return dimensions;
	}

	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}

	public Identification getIdentification() {
		return identification;
	}

	public void setIdentification(Identification identification) {
		this.identification = identification;
	}

	public FuelInformation getFuelinformation() {
		return fuelinformation;
	}

	public void setFuelinformation(FuelInformation fuelinformation) {
		this.fuelinformation = fuelinformation;
	}

	@Override
	public String toString() {
		return "{engineinformation: " + engineinformation + ",identification: " + identification.toString()
				+ ",dimensions: " + dimensions.toString() + ",fuelinformation: " + fuelinformation.toString() + "}";
	}

}
