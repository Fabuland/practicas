package com.practicas.service.main;

import java.util.List;

import com.practicas.model.Car;
import com.practicas.service.data.DatabaseJson;

public class Exercise2 {

	public static void main(String[] args) {
		
		List<Car> listCar = DatabaseJson.loadDatabase().getDataParsed();
		System.out.println(listCar);
	}

}
