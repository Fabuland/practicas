package com.practicas.service;

import java.util.Comparator;

import com.practicas.model.Car;

public class ComparadorConsumo implements Comparator<Car> {

	private boolean descendente = true;

	public ComparadorConsumo(boolean desc) {
		this.descendente = desc;
	}

	@Override
	public int compare(Car car1, Car car2) {
		Integer valorA = car1.getFuelinformation().getCitymph();
		Integer valorB = car2.getFuelinformation().getCitymph();

		int multip = -1;
		if (!descendente) {
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