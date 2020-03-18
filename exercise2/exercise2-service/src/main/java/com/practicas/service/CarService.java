package com.practicas.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

import com.practicas.model.Car;
import com.practicas.service.data.DatabaseJson;

public class CarService {

	/**
	 * 
	 * @param listCar
	 * @param suelo primer coche que busca
	 * @param techo ultimo coche que busca
	 * @return
	 */
	public static List<Car> marcaModeloIntervalo(List<Car> listCar, int suelo, int techo) {

		if (suelo > techo) {
			return null;
		}
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
	public static List<Car> marcaModeloPotencia(List<Car> listCar, int nCoches, int potencia) {

		if (potencia < 0) {
			return null;
		}

		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {

				return t.getEngineinformation().getEnginestatistics().getHorsepower() > potencia;
			}

		};

		List<Car> listCarReturn = listCar.parallelStream().filter(p).limit(nCoches).collect(Collectors.toList());

		return listCarReturn;

	}

}
