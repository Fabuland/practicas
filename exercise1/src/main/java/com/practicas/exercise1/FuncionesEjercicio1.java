package com.practicas.exercise1;

import org.json.JSONArray;
import org.json.JSONObject;

public class FuncionesEjercicio1 {

	public void marcaModelo24al32(JSONArray array, int suelo, int techo) {

		int nCoches = suelo-1;
		// Recorre n veces del coche número "suelo" al "techo" para recoger el modelo y la marca
		// de cada uno en orden
		
		
		for (int i = suelo-1; i < techo; i++) {
			String modelo = ((JSONObject) array.get(nCoches)).getJSONObject("Identification").getString("ID");
			String marca = ((JSONObject) array.get(nCoches)).getJSONObject("Identification").getString("Make");

			nCoches++;
			System.out.println("Coche " + (nCoches) + ": [Modelo: " + modelo + "], [Marca: " + marca + "]");

		}
	}

	public void marcaModelo150CV(JSONArray array, int nCoches, int potencia) {

		// int que sale del while y a su vez controla la posición en los arrays de
		// modelo y marca
		int diezPrimeros = 0;
		// int para recorrer todos los coches hasta que salga del while
		int todosCoches = 0;
		while (diezPrimeros < nCoches) {

			int cocheHorsepower = ((JSONObject) array.get(todosCoches)).getJSONObject("Engine Information")
					.getJSONObject("Engine Statistics").getInt("Horsepower");

			// Si tiene más de "potencia" CV recoge el modelo y marca de esos coches para guardarlos
			// en los arrays y los muestra
			if (cocheHorsepower > potencia) {
				String modelo = ((JSONObject) array.get(todosCoches)).getJSONObject("Identification")
						.getString("ID");
				String marca = ((JSONObject) array.get(todosCoches)).getJSONObject("Identification")
						.getString("Make");

				System.out.println("Coche " + (diezPrimeros + 1) + ": [Modelo: " + modelo + "], [Marca: "
						+ marca + "]");
				diezPrimeros++;
			}
			todosCoches++;

		}
	}

}
