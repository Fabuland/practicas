package com.practicas.model;

public class EngineInformation {

	private String transmission;
	private String enginetype;
	private EngineStatistics enginestatistics;
	private boolean hybrid;
	private int numberofforwardgears;
	private String driveline;

	public EngineInformation() {

	}

	public EngineInformation(String transmission, String enginetype, EngineStatistics enginestatistics, boolean hybrid,
			int numberofforwardgears, String driveline) {
		super();
		this.transmission = transmission;
		this.enginetype = enginetype;
		this.enginestatistics = enginestatistics;
		this.hybrid = hybrid;
		this.numberofforwardgears = numberofforwardgears;
		this.driveline = driveline;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getEnginetype() {
		return enginetype;
	}

	public void setEnginetype(String enginetype) {
		this.enginetype = enginetype;
	}

	public EngineStatistics getEnginestatistics() {
		return enginestatistics;
	}

	public void setEnginestatistics(EngineStatistics enginestatistics) {
		this.enginestatistics = enginestatistics;
	}

	public boolean isHybrid() {
		return hybrid;
	}

	public void setHybrid(boolean hybrid) {
		this.hybrid = hybrid;
	}

	public int getNumberofforwardgears() {
		return numberofforwardgears;
	}

	public void setNumberofforwardgears(int numberofforwardgears) {
		this.numberofforwardgears = numberofforwardgears;
	}

	public String getDriveline() {
		return driveline;
	}

	public void setDriveline(String driveline) {
		this.driveline = driveline;
	}

	@Override
	public String toString() {
		return "{transmission: " + transmission + ",enginetype: " + enginetype + ",enginestatistics: "
				+ enginestatistics.toString() + "}";
	}

}
