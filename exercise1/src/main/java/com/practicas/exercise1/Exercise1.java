package com.practicas.exercise1;

import org.json.JSONArray;

import com.practicas.exercise1.utils.DatabaseJson;

public class Exercise1 {

	public static void main(String[] args) {

		JSONArray array = DatabaseJson.loadDatabase().getData();
		// String cadena = ((JSONObject)array.get(0)).getJSONObject("Engine
		// Information").getString("Engine Type");
		// System.out.println("Engine Type " + cadena);
		FuncionesEjercicio1 funciones = new FuncionesEjercicio1();
		System.out.println("Marca y modelo del 24 al 32:\n");
		funciones.marcaModelo24al32(array, 91,102);
		System.out.println("\nMarca y modelo de los mayores de 150CV:\n");
		funciones.marcaModelo150CV(array, 17, 350);

	}

}
