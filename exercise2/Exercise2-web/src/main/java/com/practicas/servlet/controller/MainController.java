package com.practicas.servlet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practicas.model.Car;
import com.practicas.service.CarPredicate;
import com.practicas.service.CarService;

public class MainController {

	public void mainAction(HttpServletRequest request, HttpServletResponse response) {
		List<Car> cars = CarService.getCars(0, 9);
		long counter = CarService.carTotals;

		request.setAttribute("cars", cars);
		request.setAttribute("total", counter);
	}

	public void pagination(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		int begin = 0;
		int end = 10;
		if(page != null) {
			begin = (Integer.valueOf(page)+ 1*10-10 )*10;
			end = begin + 10;
		}

		List<Car> cars = CarService.getCars(begin, end);
		long counter = CarService.carTotals;
		request.setAttribute("cars", cars);
		request.setAttribute("total", counter);
		request.setAttribute("page", page);

	}
	
	public void filters(HttpServletRequest request, HttpServletResponse response) {
		
		String year = request.getParameter("filterYear");
		String make = request.getParameter("filterMake");
		CarPredicate p = new CarPredicate();
		List<Predicate<Car>> predList = new ArrayList<Predicate<Car>>();
		if(!year.equals("null")) {
			predList.add(p.porYear(Integer.parseInt(year)));
		}
		if(!make.equals("null")) {
			predList.add(p.porMarca(make));
		}
		String page = request.getParameter("page");
		int begin = 0;
		int end = 9;
		if(page != null) {
			begin = (Integer.valueOf(page)+ 1*10-10 )*10;
			end = begin + 10;
		}
		long counter = CarService.getCarsCount(predList);
		if (counter < end) {
			end = (int) counter;
		}
		List<Car> cars = CarService.getCars(begin, end, predList);
		request.setAttribute("cars", cars);
		request.setAttribute("make", make);
		request.setAttribute("year", year);
		request.setAttribute("page", page);
		request.setAttribute("total", counter);
	}
	
	public void carDetails(HttpServletRequest request, HttpServletResponse response) {
		
		String page = request.getParameter("page");
		String filterMake = request.getParameter("filterMake");
		String filterYear = request.getParameter("filterYear");
		String id = request.getParameter("id");
		if(page != null) {
			request.setAttribute("page",page);			
		}
		if(filterMake != null || filterYear != null) {
			request.setAttribute("filterMake",filterMake);
			request.setAttribute("filterYear",filterYear);			
		}
		List<Car> cars = CarService.getCars(-1, -1);
		Car car = cars.get(Integer.valueOf(id));
		request.setAttribute("car", car);
		request.setAttribute("id", id);
		request.setAttribute("transmissions", CarService.getCarsTransmissions());
		request.setAttribute("forwardgears", CarService.getCarsNumberOfForwardGears());
		request.setAttribute("drivelines", CarService.getCarsDrivelines());
		request.setAttribute("classifications", CarService.getCarsClassifications());
		request.setAttribute("fueltypes", CarService.getCarsFuelTypes());
	}

}
