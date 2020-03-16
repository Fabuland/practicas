package com.practicas.exercise1;

import org.json.JSONArray;
import org.json.JSONObject;

public class FuncionesEjercicio1 {
	/**
	 * 
	 * @param array
	 * @param suelo primer coche que busca
	 * @param techo ultimo coche que busca
	 */
	public void marcaModeloIntervalo(JSONArray array, int suelo, int techo) {

		int nCoches = suelo - 1;
		// Recorre n veces del coche número "suelo" al "techo" para recoger el modelo y
		// la marca
		// de cada uno en orden

		for (int i = suelo - 1; i < techo; i++) {
			String modelo = ((JSONObject) array.get(nCoches)).getJSONObject("Identification").getString("ID");
			String marca = ((JSONObject) array.get(nCoches)).getJSONObject("Identification").getString("Make");

			nCoches++;
			System.out.println("Coche " + (nCoches) + ": [Modelo: " + modelo + "], [Marca: " + marca + "]");

		}
	}

	/**
	 * 
	 * @param array
	 * @param nCoches numero de coches que busca
	 * @param potencia potencia minima para recoger la marca y el modelo
	 */
	public void marcaModeloPotencia(JSONArray array, int nCoches, int potencia) {

		// int que sale del while y a su vez controla la posición en los arrays de
		// modelo y marca
		int diezPrimeros = 0;
		// int para recorrer todos los coches hasta que salga del while
		int todosCoches = 0;
		while (diezPrimeros < nCoches) {

			int cocheHorsepower = ((JSONObject) array.get(todosCoches)).getJSONObject("Engine Information")
					.getJSONObject("Engine Statistics").getInt("Horsepower");

			// Si tiene más de "potencia" CV recoge el modelo y marca de esos coches para
			// guardarlos
			// en los arrays y los muestra
			if (cocheHorsepower > potencia) {
				String modelo = ((JSONObject) array.get(todosCoches)).getJSONObject("Identification").getString("ID");
				String marca = ((JSONObject) array.get(todosCoches)).getJSONObject("Identification").getString("Make");

				System.out
						.println("Coche " + (diezPrimeros + 1) + ": [Modelo: " + modelo + "], [Marca: " + marca + "]");
				diezPrimeros++;
			}
			todosCoches++;

		}
	}
	
	/**
	 * 
	 * @param array
	 * @param transmision tipo de transmision que se puede introducir,las dos opciones son "automatico" o "manual"
	 */
	public void marcaModeloAutomáticos(JSONArray array, String transmision) {
		
		int nTotales = array.length();
		int contador = 0;
		String transmIntr = "";
		//Depende de lo que introduzcas asigna un valor u otro a la variable transmIntr
		if(transmision.equals("automatico")) {
			transmIntr = "Automatic transmission";
		}else if(transmision.equals("manual")) {
			transmIntr = "Manual transmission";
		}else {
			System.out.println("Escribe automatico o manual para recibir el resultado");
		}
		
		while(contador < nTotales) {
			
			String transmCoche = ((JSONObject) array.get(contador)).getJSONObject("Identification").getString("Classification");
			//Si la transmision del coche es igual a la introducida por el usuario, imprime el modelo y la marca del coche
			if(transmCoche.equals(transmIntr)) {
				String modelo = ((JSONObject) array.get(contador)).getJSONObject("Identification").getString("ID");
				String marca = ((JSONObject) array.get(contador)).getJSONObject("Identification").getString("Make");
				System.out
						.println("Coche " + (contador + 1) + ": [Modelo: " + modelo + "], [Marca: " + marca + "]");
			}
			contador++;
		}
		
	}

}
