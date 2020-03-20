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
		// 6
		System.out.println("\nMarca y modelo de los coches con fecha especificada:\n");
		System.out.println(CarService.marcaModeloFechaOrdenado(10, 2011, true));
		// 7
		System.out.println("\nModelo de los coches con numero en la posicion indicada:\n");
		System.out.println(CarService.modeloCaracterNumero(2));
		// 8
		System.out.println("\nModelo y marca de los coches hibridos:\n");
		System.out.println(CarService.marcaModeloHibrido(true));
		// 10
		System.out.println("\nModelo de los coches con 6 velocidades:\n");
		System.out.println(CarService.cochesVelocidades(6));
		// 11
		System.out.println(
				"\nModelo y marca de los coches con un consumo menor al indicado ordenado de la manera especificada:\n");
		System.out.println(CarService.marcaModeloConsumo(18, true));
		// 12
		System.out.println("\nModelo y marca de los coches con caracteres especifico dentro de su engine type:\n");
		System.out.println(CarService.marcaModeloIncluyeCaracter("hp"));
	}

}
