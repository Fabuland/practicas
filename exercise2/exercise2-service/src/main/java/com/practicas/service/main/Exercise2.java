package com.practicas.service.main;

import java.util.List;
import com.practicas.service.CarService;
import com.practicas.model.Car;
import com.practicas.service.data.DatabaseJson;

public class Exercise2 {

	public static void main(String[] args) {
		
		List<Car> listCar = DatabaseJson.loadDatabase().getDataParsed();
		//1
		System.out.println("Marca y modelo en un intervalo:\n");
		System.out.println(CarService.marcaModeloIntervalo(listCar, 19, 24));
		// 2
		System.out.println("\nMarca y modelo de los coches con potencia mayor a X:\n");
		System.out.println(CarService.marcaModeloPotencia(listCar, 10, 150));
	}

}
