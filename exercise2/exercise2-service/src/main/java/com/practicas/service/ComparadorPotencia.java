package com.practicas.service;

import java.util.Comparator;

import com.practicas.model.Car;

public class ComparadorPotencia implements Comparator<Car> {

	private boolean desc = true;

	public ComparadorPotencia(boolean desc) {
		this.desc = desc;
	}

	@Override
	public int compare(Car car1, Car car2) {
		Integer valorA = car1.getEngineinformation().getEnginestatistics().getHorsepower();
		Integer valorB = car2.getEngineinformation().getEnginestatistics().getHorsepower();

		int multip = -1;
		if (!desc) {
			multip = 1;
		}

		if (valorA < valorB) {
			return multip * -1;
		} else if (valorA > valorB) {
			return multip * 1;
		} else {
			return multip * (car1.getIdentification().getMake().compareTo(car2.getIdentification().getMake()));
		}
	}

}
