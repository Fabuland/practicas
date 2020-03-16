package com.practicas.exercise1;

import org.json.JSONArray;
import org.json.JSONObject;

public class FuncionesEjercicio1 {
	
	public void marcaModelo24al32(JSONArray array) {

    	String[] modelo = new String[9];
    	String[] marca = new String[9];
    	int nModelo = 23;
    	for(int i = 0; i < 9; i++) {
    		modelo[i] = ((JSONObject)array.get(nModelo)).getJSONObject("Identification").getString("Model Year");
    		marca[i] = ((JSONObject)array.get(nModelo)).getJSONObject("Identification").getString("Make");
    		
    		
    		System.out.println("Coche " + (nModelo+1) + ": [Modelo: " + modelo[i] + "], [Marca: " + marca[i] + "]");
    		nModelo++;
    	}
    }

}
