package com.practicas.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practicas.model.Car;
import com.practicas.service.CarService;

public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//super.doGet(request, response);
		int begin = 0;
		int end = 10;
		String page = request.getParameter("page");
		if(page != null) {
			begin = (Integer.valueOf(page)+1 * 10)-1;
			end = begin + 10;
		}
		
		List<Car> cars =CarService.getCars(begin, end);
		
		
		
		request.setAttribute("cars", cars);
		
		request.getRequestDispatcher("./index.jsp").forward(request, response);;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		super.doPost(request, response);
	}

	
}