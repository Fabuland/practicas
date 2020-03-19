package com.practicas.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.practicas.model.Car;
import com.practicas.model.constants.ExerciseConstants;
import com.practicas.service.data.DatabaseJson;

public class CarService {

	/**
	 * 
	 * @param listCar
	 * @param suelo   primer coche que busca
	 * @param techo   ultimo coche que busca
	 * @return
	 */
	public static List<Car> marcaModeloIntervalo(int suelo, int techo) {

		if (suelo > techo) {
			return null;
		}

		List<Car> listCar = DatabaseJson.loadDatabase().getDataParsed();
		// Recorre n veces del coche numero "suelo" al "techo" para recoger el modelo y
		// la marca
		// de cada uno en orden

		if (suelo < 0) {
			suelo = 0;
		}

		if (techo <= 0 || techo > listCar.size()) {
			techo = listCar.size();
		}

		return listCar.subList(suelo, techo);
	}

	/**
	 * 
	 * @param listCar
	 * @param nCoches  numero de coches que busca
	 * @param potencia potencia minima para recoger la marca y el modelo
	 * @return
	 */
	public static List<Car> marcaModeloPotencia(int nCoches, int potencia) {

		if (potencia < 0) {
			return null;
		}

		List<Car> listCar = marcaModeloIntervalo(-1, -1);
		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {

				return t.getEngineinformation().getEnginestatistics().getHorsepower() > potencia;
			}

		};

		List<Car> listCarReturn = listCar.parallelStream().filter(p).limit(nCoches).collect(Collectors.toList());

		return listCarReturn;

	}

	/**
	 * 
	 * @param transmision define si es automatico o no
	 * @return
	 */
	public static List<Car> marcaModeloAutomaticos(ExerciseConstants.transmission transmision) {
		List<Car> listCar = marcaModeloIntervalo(-1, -1);

		if (transmision == null) {
			return null;
		}
		String transmIntr = "";
		if (transmision.name().equals("AUTOMATIC")) {
			transmIntr = "Automatic transmission";
		} else if (transmision.name().equals("MANUAL")) {
			transmIntr = "Manual transmission";
		}

		final String fTransmision = transmIntr;

		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {

				return t.getIdentification().getClassification().equals(fTransmision);
			}

		};
		List<Car> listCarReturn = listCar.stream().filter(p).collect(Collectors.toList());
		return listCarReturn;
	}

	public static List<Car> marcaModeloTraccion(ExerciseConstants.wheel traccion) {
		if (traccion == null) {
			return null;
		}
		List<Car> listCar = marcaModeloIntervalo(-1, -1);
		String traccIntr = "";
		if (traccion.name().equals("FRONT")) {
			traccIntr = "Front-wheel drive";
		} else if (traccion.name().equals("REAR")) {
			traccIntr = "Rear-wheel drive";
		} else if (traccion.name().equals("ALL")) {
			traccIntr = "All-wheel drive";
		}

		final String fTraccion = traccIntr;

		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {

				return t.getIdentification().getClassification().equals(fTraccion);
			}

		};

		List<Car> listCarReturn = listCar.stream().filter(p).collect(Collectors.toList());

		return listCarReturn;
	}

}
