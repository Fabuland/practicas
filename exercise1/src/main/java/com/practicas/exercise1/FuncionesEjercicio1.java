package com.practicas.exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

		if (suelo <= 0 || suelo > techo || techo > array.length() - 1) {
			return null;
		}

		int contador = suelo - 1;
		// Recorre n veces del coche número "suelo" al "techo" para recoger el modelo y
		// la marca
		// de cada uno en orden

		JSONArray arrayReturn = new JSONArray();
		for (int i = suelo - 1; i < techo; i++) {
			JSONObject objetoReturn = new JSONObject();
			JSONObject jObjeto = array.getJSONObject(contador);
			objetoReturn.put("make", jObjeto.getJSONObject("Identification").getString("Make"));
			objetoReturn.put("id", jObjeto.getJSONObject("Identification").getString("ID"));
			arrayReturn.put(objetoReturn);

			contador++;

		}

		return arrayReturn;
	}

	/**
	 * 
	 * @param array
	 * @param nCoches  numero de coches que busca
	 * @param potencia potencia minima para recoger la marca y el modelo
	 */
	public JSONArray marcaModeloPotencia(JSONArray array, int nCoches, int potencia) {

		if (nCoches <= 0 || nCoches > array.length() - 1 || potencia <= 0) {
			return null;
		}

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

	/**
	 * 
	 * @param array
	 * @param transmision tipo de transmision que se puede introducir,las dos
	 *                    opciones son "automatico" o "manual"
	 */
	public JSONArray marcaModeloAutomáticos(JSONArray array, String transmision) {

		int nTotales = array.length();
		int contador = 0;
		String transmIntr = "";
		JSONArray arrayReturn = new JSONArray();
		// Depende de lo que introduzcas asigna un valor u otro a la variable transmIntr
		if (transmision.equals("automatico")) {
			transmIntr = "Automatic transmission";
		} else if (transmision.equals("manual")) {
			transmIntr = "Manual transmission";
		} else {
			System.out.println("Escribe automatico o manual para recibir el resultado");
		}

		while (contador < nTotales) {

			String transmCoche = ((JSONObject) array.get(contador)).getJSONObject("Identification")
					.getString("Classification");
			// Si la transmision del coche es igual a la introducida por el usuario, imprime
			// el modelo y la marca del coche
			if (transmCoche.equals(transmIntr)) {
				JSONObject objetoReturn = new JSONObject();
				JSONObject jObjeto = array.getJSONObject(contador);
				objetoReturn.put("make", jObjeto.getJSONObject("Identification").getString("Make"));
				objetoReturn.put("id", jObjeto.getJSONObject("Identification").getString("ID"));
				arrayReturn.put(objetoReturn);
			}
			contador++;
		}
		return arrayReturn;

	}

	/**
	 * 
	 * @param array
	 * @param traccion true o false para definir la traccion
	 * @return devuelve el array
	 */
	public JSONArray marcaModeloTraccionTrasera(JSONArray array, boolean traccion) {

		int nTotales = array.length();
		int contador = 0;
		String traseraIntr = "Rear-wheel drive";
		JSONArray arrayReturn = new JSONArray();

		while (contador < nTotales) {

			String traccCoche = ((JSONObject) array.get(contador)).getJSONObject("Engine Information")
					.getString("Driveline");
			// Si la traccion del coche es trasera y coincide con lo que ha introducido el
			// usuario (true), imprime modelo y marca
			if (traccCoche.equals(traseraIntr) && traccion) {
				JSONObject objetoReturn = new JSONObject();
				JSONObject jObjeto = array.getJSONObject(contador);
				objetoReturn.put("make", jObjeto.getJSONObject("Identification").getString("Make"));
				objetoReturn.put("id", jObjeto.getJSONObject("Identification").getString("ID"));
				arrayReturn.put(objetoReturn);
				// Si la traccion del coche no es trasera y coincide con lo que ha introducido
				// el usuario (false), imprime modelo y marca
			} else if (!traccCoche.equals(traseraIntr) && !traccion) {
				JSONObject objetoReturn = new JSONObject();
				JSONObject jObjeto = array.getJSONObject(contador);
				objetoReturn.put("make", jObjeto.getJSONObject("Identification").getString("Make"));
				objetoReturn.put("id", jObjeto.getJSONObject("Identification").getString("ID"));
				arrayReturn.put(objetoReturn);
			}
			contador++;
		}
		return arrayReturn;

	}

	/**
	 * 
	 * @param array
	 * @param combustible true o false para definir el tipo de combustible
	 * @return devuelve el array
	 */
	public JSONArray marcaModeloCombustible(JSONArray array, boolean combustible) {

		int nTotales = array.length();
		int contador = 0;
		String dieselIntr = "Diesel fuel";
		JSONArray arrayReturn = new JSONArray();

		while (contador < nTotales) {

			String combCoche = ((JSONObject) array.get(contador)).getJSONObject("Fuel Information")
					.getString("Fuel Type");
			// Si el combustible del coche es diesel y coincide con lo que ha introducido el
			// usuario (true), imprime modelo y marca
			if (combCoche.equals(dieselIntr) && combustible) {
				JSONObject objetoReturn = new JSONObject();
				JSONObject jObjeto = array.getJSONObject(contador);
				objetoReturn.put("make", jObjeto.getJSONObject("Identification").getString("Make"));
				objetoReturn.put("id", jObjeto.getJSONObject("Identification").getString("ID"));
				arrayReturn.put(objetoReturn);
				// Si el combustible del coche no es diesel y coincide con lo que ha introducido
				// el usuario (false), imprime modelo y marca
			} else if (!combCoche.equals(dieselIntr) && !combustible) {
				JSONObject objetoReturn = new JSONObject();
				JSONObject jObjeto = array.getJSONObject(contador);
				objetoReturn.put("make", jObjeto.getJSONObject("Identification").getString("Make"));
				objetoReturn.put("id", jObjeto.getJSONObject("Identification").getString("ID"));
				arrayReturn.put(objetoReturn);
			}
			contador++;
		}
		return arrayReturn;

	}

	/**
	 * 
	 * @param array
	 * @param nCoches primeros n coches que busca
	 * @param fecha   fecha del coche
	 * @return devuelve el array
	 */
	public JSONArray marcaModeloFechaOrdenado(JSONArray array, int nCoches, int fecha) {

		if (fecha < 0) {
			return null;
		}

		JSONArray arrayReturn = new JSONArray();
		int contador = 0;

		// Busca todos los coches con la fecha introducida
		for (int i = 0; contador < nCoches; i++) {
			JSONObject jObj = (JSONObject) array.get(i);

			if (jObj.getJSONObject("Identification").getInt("Year") == fecha) {
				JSONObject objReturn = new JSONObject();
				objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
				objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
				objReturn.put("horsepower", jObj.getJSONObject("Engine Information").getJSONObject("Engine Statistics")
						.getInt("Horsepower"));
				arrayReturn.put(objReturn);
				contador++;
			}
		}
		// Pasamos del JSONArray arrayReturn al nuevo List creado para poder comparar
		int returnTamano = arrayReturn.length();
		List<JSONObject> listJson = new ArrayList<>();
		for (int i = 0; i < returnTamano; i++) {
			listJson.add(arrayReturn.getJSONObject(i));
		}

		// Comparamos los valores de la potencia de cada coche
		Collections.sort(listJson, new Comparator<JSONObject>() {

			private static final String potencia = "horsepower";

			@Override
			public int compare(JSONObject a, JSONObject b) {

				Integer valorA = a.getInt(potencia);
				Integer valorB = b.getInt(potencia);

				return valorB.compareTo(valorA);
			}
		});
		// Creamos un nuevo JSONArray ya ordenado con los valores del List
		JSONArray arrayOrden = new JSONArray();
		for (int i = 0; i < listJson.size(); i++) {
			arrayOrden.put(listJson.get(i));
		}

		return arrayOrden;

	}

	/**
	 * 
	 * @param array
	 * @param pos   posicion en el string para buscar el numero
	 * @return
	 */
	public JSONArray modeloCaracterNumero(JSONArray array, int pos) {

		if (pos < 0) {
			return null;
		}

		JSONArray arrayReturn = new JSONArray();
		int tamanoArray = array.length();

		// Busca todos los coches que tengan un digito en la posicion indicada
		for (int i = 0; i < tamanoArray; i++) {
			char ch = ((JSONObject) array.get(i)).getJSONObject("Identification").getString("ID").charAt(pos);
			// isDigit es un metodo que comprueba si el caracter es un digito
			boolean esDigito = Character.isDigit(ch);
			if (esDigito) {
				JSONObject objReturn = new JSONObject();
				JSONObject jObj = array.getJSONObject(i);
				objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
				arrayReturn.put(objReturn);
			}
		}
		return arrayReturn;

	}

	/**
	 * 
	 * @param array
	 * @param hibrido si es hibrido o no
	 * @return
	 */
	public JSONArray modeloMarcaHibrido(JSONArray array, boolean hibrido) {

		JSONArray arrayReturn = new JSONArray();

		int tamanoArray = array.length();

		// Busca si el coche es hibrido o no y compara el boolean con el introducido por
		// el usuario
		for (int i = 0; i < tamanoArray; i++) {
			boolean hibridoJson = ((JSONObject) array.get(i)).getJSONObject("Engine Information").getBoolean("Hybrid");
			if (hibrido == hibridoJson) {
				JSONObject objReturn = new JSONObject();
				JSONObject jObj = array.getJSONObject(i);
				objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
				objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
				arrayReturn.put(objReturn);
			} else if (!hibrido == !hibridoJson) {
				JSONObject objReturn = new JSONObject();
				JSONObject jObj = array.getJSONObject(i);
				objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
				objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
				arrayReturn.put(objReturn);
			}
		}

		return arrayReturn;

	}

	/**
	 * 
	 * @param array
	 * @param velocidades numero de velocidades del coche
	 * @return
	 */
	public JSONArray cochesVelocidades(JSONArray array, int velocidades) {

		if (velocidades <= 0 || velocidades > 8) {
			return null;
		}

		int nTotales = array.length();
		JSONArray arrayReturn = new JSONArray();

		// Si la velocidad del coche coincide con lo que ha introducido el
		// usuario, imprime modelo y marca
		for (int i = 0; i < nTotales; i++) {
			int speedCoche = ((JSONObject) array.get(i)).getJSONObject("Engine Information")
					.getInt("Number of Forward Gears");

			if (speedCoche == velocidades) {
				JSONObject objetoReturn = new JSONObject();
				JSONObject jObjeto = array.getJSONObject(i);
				objetoReturn.put("engine information", jObjeto.getJSONObject("Engine Information"));
				objetoReturn.put("identification", jObjeto.getJSONObject("Identification"));
				objetoReturn.put("dimensions", jObjeto.getJSONObject("Dimensions"));
				objetoReturn.put("fuel information", jObjeto.getJSONObject("Fuel Information"));
				arrayReturn.put(objetoReturn);

			}
		}
		return arrayReturn;

	}

	/**
	 * 
	 * @param array
	 * @param consumo   consumo mínimo del coche
	 * @param siConsumo tener en cuenta el consumo
	 * @param orden     ascendente o descendente mayor/menor consumo
	 * @return
	 */
	public JSONArray modeloMarcaConsumo(JSONArray array, int consumo, boolean siConsumo, boolean orden) {

		if (consumo <= 0) {
			return null;
		}
		int nTotales = array.length();
		JSONArray arrayReturn = new JSONArray();

		//Busca los coches con un consumo menor al introducido por el usuario, siempre que siConsumo sea true
		for (int i = 0; i < nTotales; i++) {
			int consumoCoche = ((JSONObject) array.get(i)).getJSONObject("Fuel Information").getInt("City mph");
			if (siConsumo) {
				if (consumoCoche < consumo) {
					JSONObject objReturn = new JSONObject();
					JSONObject jObj = array.getJSONObject(i);
					objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
					objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
					objReturn.put("mph", jObj.getJSONObject("Fuel Information").getInt("City mph"));
					arrayReturn.put(objReturn);
				}
			} else {
				if (consumoCoche > consumo) {
					JSONObject objReturn = new JSONObject();
					JSONObject jObj = array.getJSONObject(i);
					objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
					objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
					objReturn.put("mph", jObj.getJSONObject("Fuel Information").getInt("City mph"));
					// se añade el jsonobject al jsonarray de retorno
					arrayReturn.put(objReturn);
				}
			}
		}

		//Pasamos de JSONArray a List
		List<JSONObject> listJson = new ArrayList<JSONObject>();
		for (int i = 0; i < arrayReturn.length(); i++) {
			listJson.add(arrayReturn.getJSONObject(i));
		}

		//Ordenamos dependiendo del orden que haya introducido el usuario
		Collections.sort(listJson, new Comparator<JSONObject>() {

			private static final String MPH = "mph";

			@Override
			public int compare(JSONObject a, JSONObject b) {
				Integer valA = 0;
				Integer valB = 0;

				valA = (int) a.get(MPH);
				valB = (int) b.get(MPH);

				int multiplicar = -1;
				if (!orden) {
					multiplicar = 1;
				}

				if (valA < valB) {
					return multiplicar * -1;
				} else if (valA > valB) {
					return multiplicar * 1;
				} else {
					return multiplicar * (a.getString("model").compareTo(b.getString("model")));
				}

			}
		});
		//Volvemos a pasar a JSONArray
		JSONArray arrayOrden = new JSONArray();
		for (int i = 0; i < listJson.size(); i++) {
			arrayOrden.put(listJson.get(i));
		}

		return arrayOrden;

	}

	/**
	 * 
	 * @param array
	 * @param caracteres el string que debe estar incluido en el tipo de motor del coche
	 * @return
	 */
	public JSONArray modeloMarcaIncluyeCaracter(JSONArray array, String caracteres) {

		if (caracteres.length() == 0) {
			return null;
		}
		JSONArray arrayReturn = new JSONArray();
		int nTotales = array.length();
		
		//Pasamos de JSONArray a List
		List<JSONObject> listJson = new ArrayList<JSONObject>();
		for (int i = 0; i < nTotales; i++) {
			listJson.add(array.getJSONObject(i));
		}

		//Comprueba si el string existe dentro de cada uno de los coches
		for (int i = 0; i < array.length(); i++) {
			String motorCoche = listJson.get(i).getJSONObject("Engine Information").getString("Engine Type");
			if (motorCoche.contains(caracteres)) {
				JSONObject objReturn = new JSONObject();
				JSONObject jObj = array.getJSONObject(i);
				objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
				objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
				arrayReturn.put(objReturn);
			}
		}

		return arrayReturn;

	}

}