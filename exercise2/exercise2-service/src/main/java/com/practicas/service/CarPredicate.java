package com.practicas.service;

import java.util.function.Predicate;

import com.practicas.model.Car;

public class CarPredicate {
	public Predicate<Car> esHibrido(boolean hibrido) {
		return car -> car.getEngineinformation().isHybrid() == hibrido;
	}

	public Predicate<Car> porVelocidad(int velocidad) {
		return car -> car.getEngineinformation().getNumberofforwardgears() == velocidad;
	}
	
	public Predicate<Car> porMarca(String marca) {
		return car -> car.getIdentification().getMake().equals(marca);
	}

	public Predicate<Car> porPotenciaMayor(int potencia) {
		return car -> car.getEngineinformation().getEnginestatistics().getHorsepower() > potencia;
	}

	public Predicate<Car> porPotenciaMenor(int potencia) {
		return car -> car.getEngineinformation().getEnginestatistics().getHorsepower() < potencia;
	}

	public Predicate<Car> porCombustibleMayor(int combustible) {
		return car -> car.getFuelinformation().getCitymph() > combustible;
	}

	public Predicate<Car> porCombustibleMenor(int combustible) {
		return car -> car.getFuelinformation().getCitymph() < combustible;
	}

	public Predicate<Car> porCaracterMotor(String caracter) {
		return car -> car.getEngineinformation().getEnginetype().toLowerCase().contains(caracter.toLowerCase());
	}

	public Predicate<Car> caracterNumericoEnId(int pos) {
		return car -> (int) car.getIdentification().getId().charAt(pos) > 46
				&& (int) car.getIdentification().getId().charAt(pos) < 58;
	}

	public Predicate<Car> porYear(int year) {
		return car -> car.getIdentification().getYear() == year;
	}

	public Predicate<Car> tipoCombustible(String combustible) {
		return car -> car.getFuelinformation().getFueltype().equals(combustible);
	}

	public Predicate<Car> tipoTraccion(String traccion) {
		return car -> car.getEngineinformation().getDriveline().equals(traccion);
	}

	public Predicate<Car> tipoClasificacion(String clasificacion) {
		return car -> car.getIdentification().getClassification().equals(clasificacion);
	}

}