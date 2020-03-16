package com.practicas.exercise1;

import org.json.JSONArray;

import com.practicas.exercise1.utils.DatabaseJson;

public class Exercise1 {

	public static void main(String[] args) {

		JSONArray array = DatabaseJson.loadDatabase().getData();
		
		FuncionesEjercicio1 funciones = new FuncionesEjercicio1();
		
		System.out.println("Marca y modelo en un intervalo:\n");
		funciones.marcaModeloIntervalo(array, 24,32);
		System.out.println("\nMarca y modelo de los coches con potencia mayor a X:\n");
		funciones.marcaModeloPotencia(array, 10, 150);
		System.out.println("\nMarca y modelo de los coches automáticos o manuales:\n");
		funciones.marcaModeloAutomáticos(array, "automatico");

	}

}
