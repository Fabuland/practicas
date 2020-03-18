package com.practicas.model;

public class Dimensions {

	private int width;
	private int length;
	private int height;

	public Dimensions() {

	}

	public Dimensions(int width, int length, int height) {
		this.width = width;
		this.height = height;
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "{width: " + width + ",length: " + length + ",heigth: " + height + "}";
	}

}
