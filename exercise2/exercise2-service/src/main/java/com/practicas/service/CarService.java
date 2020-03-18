package com.practicas.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.practicas.model.Car;
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
	public static List<Car> marcaModeloAutomaticos(String transmision) {
		List<Car> listCar = marcaModeloIntervalo(-1, -1);

		if (transmision == null || transmision.equals("")) {
			return null;
		}

		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {
				String transmIntr = "";

				if (transmision.toLowerCase().equals("automatico")) {
					transmIntr = "Automatic transmission";
				} else if (transmision.toLowerCase().equals("manual")) {
					transmIntr = "Manual transmission";
				} else {
					System.out.println("Escribe automatico o manual para recibir el resultado");
				}

				return t.getIdentification().getClassification().equals(transmIntr);
			}

		};
		List<Car> listCarReturn = listCar.stream().filter(p).collect(Collectors.toList());
		return listCarReturn;
	}

}
