package com.practicas.servlet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practicas.model.Car;
import com.practicas.service.CarService;

public class MainController {

	public void mainAction(HttpServletRequest request, HttpServletResponse response) {
		List<Car> cars = CarService.getCars(0, 9);
		long counter = CarService.carTotals;

		request.setAttribute("cars", cars);
		request.setAttribute("total", counter);
	}

	public void pagination(HttpServletRequest request, HttpServletResponse response) {
		String pagination = request.getParameter("page");
		int begin = 0;
		int end = 9;
		if (pagination != null) {
			begin = (Integer.valueOf(pagination) + 1 * 10) - 1;
			end = begin + 10;
		}

		List<Car> cars = CarService.getCars(begin, end);
		long counter = CarService.carTotals;
		request.setAttribute("cars", cars);
		request.setAttribute("total", counter);
		request.setAttribute("page", pagination);

	}

}
