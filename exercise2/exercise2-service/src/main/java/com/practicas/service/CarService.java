package com.practicas.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.practicas.model.Car;
import com.practicas.service.data.DatabaseJson;

public class CarService {
	
	public List<Car> marcaModeloIntervalo(JSONArray array, int suelo, int techo) {

		int contador = suelo - 1;
		// Recorre n veces del coche número "suelo" al "techo" para recoger el modelo y
		// la marca
		// de cada uno en orden

		JSONArray arrayReturn = new JSONArray();
		List<Car> listCar = DatabaseJson.loadDatabase().getDataParsed();
		for (int i = suelo - 1; i < techo; i++) {
			JSONObject objetoReturn = new JSONObject();
			JSONObject jObjeto = array.getJSONObject(contador);
			objetoReturn.put("make", jObjeto.getJSONObject("Identification").getString("Make"));
			objetoReturn.put("id", jObjeto.getJSONObject("Identification").getString("ID"));
			arrayReturn.put(objetoReturn);

			contador++;

		}

		return listCar.subList(suelo, techo);
	}
	
	public List<Car> marcaModeloPotencia(JSONArray array, int nCoches, int potencia) {

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
				objetoReturn.put("make", jObjeto.getJSONObject("Identification").getString("Make"));
				objetoReturn.put("id", jObjeto.getJSONObject("Identification").getString("ID"));
				arrayReturn.put(objetoReturn);
				diezPrimeros++;
			}
			contador++;

		}
		return arrayReturn;
	}
	
}
