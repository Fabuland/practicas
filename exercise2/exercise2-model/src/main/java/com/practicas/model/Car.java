package com.practicas.model;

public class Car implements Comparable<Car>{

	private int pk;
	private EngineInformation engineinformation;
	private Dimensions dimensions;
	private Identification identification;
	private FuelInformation fuelinformation;
	
	public Car() {
		
	}

	public Car(int pk, EngineInformation engineinformation, Dimensions dimensions, Identification identification,
			FuelInformation fuelinformation) {
		super();
		this.pk = pk;
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

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}
	
	@Override
	public int compareTo(Car o) {
		
		return this.getIdentification().getId().compareTo(o.getIdentification().getId());
	}

	@Override
	public boolean equals(Object obj) {
		Car c1 = (Car)obj;
		return this.getPk() == c1.getPk();
	}

	@Override
	public String toString() {
		return "{engineinformation: "+engineinformation+",dimensions: "+dimensions.toString()+"}";
	}
		
	
}
