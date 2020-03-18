package com.practicas.model;

public class Identification {
	private String make;
	private String modelyear;
	private String id;
	private String classification;
	private int year;

	public Identification() {

	}

	public Identification(String make, String modelyear, String id, String classification, int year) {
		super();
		this.make = make;
		this.modelyear = modelyear;
		this.id = id;
		this.classification = classification;
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModelyear() {
		return modelyear;
	}

	public void setModelyear(String modelyear) {
		this.modelyear = modelyear;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "{make: " + make + ",modelyear: " + modelyear + ",id: " + id + ",classification: " + classification
				+ ",year: " + year + "}";
	}

}
