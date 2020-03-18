package com.practicas.model;

public class EngineStatistics {

	private int horsepower;
	private int torque;

	public EngineStatistics() {

	}

	public EngineStatistics(int horsepower, int torque) {
		super();
		this.horsepower = horsepower;
		this.torque = torque;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}

	public int getTorque() {
		return torque;
	}

	public void setTorque(int torque) {
		this.torque = torque;
	}

	@Override
	public String toString() {
		return "{horsepower: " + horsepower + ",torque: " + torque + "}";
	}

}
