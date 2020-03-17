package com.practicas.exercise1;

import org.json.JSONArray;

import com.practicas.exercise1.utils.DatabaseJson;

public class Exercise1 {

	public static void main(String[] args) {

		JSONArray array = DatabaseJson.loadDatabase().getData();
		
		FuncionesEjercicio1 funciones = new FuncionesEjercicio1();
		
		/*System.out.println("Marca y modelo en un intervalo:\n");
		System.out.println(funciones.marcaModeloIntervalo(array, 24,32));
		System.out.println("\nMarca y modelo de los coches con potencia mayor a X:\n");
		System.out.println(funciones.marcaModeloPotencia(array, 10, 150));
		System.out.println("\nMarca y modelo de los coches automáticos o manuales:\n");
		System.out.println(funciones.marcaModeloAutomáticos(array, "automatico"));
		System.out.println("\nMarca y modelo de los coches con traccion trasera o sin ella:\n");
		System.out.println(funciones.marcaModeloTraccionTrasera(array, true));
		System.out.println("\nMarca y modelo de los coches con combustible diesel o de otro tipo:\n");
		System.out.println(funciones.marcaModeloCombustible(array, true));*/
		System.out.println("\nMarca y modelo de los coches con fecha especificada:\n");
		System.out.println(funciones.marcaModeloFechaOrdenado(array, 30, 2011));
	}

}
