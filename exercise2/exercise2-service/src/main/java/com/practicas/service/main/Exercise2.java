package com.practicas.service.main;

import com.practicas.model.constants.ExerciseConstants;
import com.practicas.service.CarService;

public class Exercise2 {

	public static void main(String[] args) {

		// 1
		System.out.println("Marca y modelo en un intervalo:\n");
		System.out.println(CarService.marcaModeloIntervalo(19, 24));
		// 2
		System.out.println("\nMarca y modelo de los coches con potencia mayor a X:\n");
		System.out.println(CarService.marcaModeloPotencia(10, 150));
		// 3
		System.out.println("\nMarca y modelo de los coches automaticos o manuales:\n");
		System.out.println(CarService.marcaModeloAutomaticos(ExerciseConstants.transmission.AUTOMATIC));
		// 4
		System.out.println("\nMarca y modelo de los coches dependiendo de la traccion:\n");
		System.out.println(CarService.marcaModeloTraccion(ExerciseConstants.wheel.REAR));
		// 5
		System.out.println("\nMarca y modelo de los coches dependiendo del combustible:\n");
		System.out.println(CarService.marcaModeloCombustible(ExerciseConstants.fuel.DIESEL));
	}

}
