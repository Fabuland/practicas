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
	public JSONArray marcaModeloIntervalo(JSONArray array, int suelo, int techo) {

		int contador = suelo - 1;
		// Recorre n veces del coche número "suelo" al "techo" para recoger el modelo y
		// la marca
		// de cada uno en orden

		JSONArray arrayReturn = new JSONArray();
		for (int i = suelo - 1; i < techo; i++) {
			JSONObject objetoReturn = new JSONObject();
			JSONObject jObjeto = array.getJSONObject(contador);
			objetoReturn.put("Make", jObjeto.getJSONObject("Identification").getString("Make"));
			objetoReturn.put("ID", jObjeto.getJSONObject("Identification").getString("ID"));
			arrayReturn.put(objetoReturn);

			contador++;
			

		}
		
		return arrayReturn;
	}

	/**
	 * 
	 * @param array
	 * @param nCoches numero de coches que busca
	 * @param potencia potencia minima para recoger la marca y el modelo
	 */
	public JSONArray marcaModeloPotencia(JSONArray array, int nCoches, int potencia) {

		// int que sale del while y a su vez controla la posición en los arrays de
		// modelo y marca
		int diezPrimeros = 0;
		// int para recorrer todos los coches hasta que salga del while
		int contador = 0;
		JSONArray arrayReturn = new JSONArray();
		while (diezPrimeros < nCoches) {

			int cocheHorsepower = ((JSONObject) array.get(contador)).getJSONObject("Engine Information")
					.getJSONObject("Engine Statistics").getInt("Horsepower");

			// Si tiene más de "potencia" CV recoge el modelo y marca de esos coches para
			// guardarlos
			// en los arrays y los muestra
			if (cocheHorsepower > potencia) {
				JSONObject objetoReturn = new JSONObject();
				JSONObject jObjeto = array.getJSONObject(contador);
				objetoReturn.put("Make", jObjeto.getJSONObject("Identification").getString("Make"));
				objetoReturn.put("ID", jObjeto.getJSONObject("Identification").getString("ID"));
				arrayReturn.put(objetoReturn);
				diezPrimeros++;
			}
			contador++;

		}
		return arrayReturn;
	}
	
	/**
	 * 
	 * @param array
	 * @param transmision tipo de transmision que se puede introducir,las dos opciones son "automatico" o "manual"
	 */
	public JSONArray marcaModeloAutomáticos(JSONArray array, String transmision) {
		
		int nTotales = array.length();
		int contador = 0;
		String transmIntr = "";
		JSONArray arrayReturn = new JSONArray();
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
				JSONObject objetoReturn = new JSONObject();
				JSONObject jObjeto = array.getJSONObject(contador);
				objetoReturn.put("Make", jObjeto.getJSONObject("Identification").getString("Make"));
				objetoReturn.put("ID", jObjeto.getJSONObject("Identification").getString("ID"));
				arrayReturn.put(objetoReturn);
			}
			contador++;
		}
		return arrayReturn;
		
	}
	
	/**
	 * 
	 * @param array
	 * @param traccion    true o false para definir la traccion
	 * @return            devuelve el array
	 */
	public JSONArray marcaModeloTraccionTrasera(JSONArray array, boolean traccion) {
			
			int nTotales = array.length();
			int contador = 0;
			String traseraIntr = "Rear-wheel drive";
			JSONArray arrayReturn = new JSONArray();
			
			while(contador < nTotales) {
				
				String traccCoche = ((JSONObject) array.get(contador)).getJSONObject("Engine Information").getString("Driveline");
				//Si la traccion del coche es trasera y coincide con lo que ha introducido el usuario (true), imprime modelo y marca
				if(traccCoche.equals(traseraIntr) && traccion == true) {
					JSONObject objetoReturn = new JSONObject();
					JSONObject jObjeto = array.getJSONObject(contador);
					objetoReturn.put("Make", jObjeto.getJSONObject("Identification").getString("Make"));
					objetoReturn.put("ID", jObjeto.getJSONObject("Identification").getString("ID"));
					arrayReturn.put(objetoReturn);
				//Si la traccion del coche no es trasera y coincide con lo que ha introducido el usuario (false), imprime modelo y marca
				}else if(!traccCoche.equals(traseraIntr) && traccion == false) {
					JSONObject objetoReturn = new JSONObject();
					JSONObject jObjeto = array.getJSONObject(contador);
					objetoReturn.put("Make", jObjeto.getJSONObject("Identification").getString("Make"));
					objetoReturn.put("ID", jObjeto.getJSONObject("Identification").getString("ID"));
					arrayReturn.put(objetoReturn);
				}
				contador++;
			}
			return arrayReturn;
			
		}
	
	}
