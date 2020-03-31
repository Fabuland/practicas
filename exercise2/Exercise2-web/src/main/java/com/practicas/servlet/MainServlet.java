package com.practicas.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practicas.service.CarService;
import com.practicas.servlet.controller.MainController;

public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String filterMake = request.getParameter("filterMake");
		String filterYear = request.getParameter("filterYear");
		String id = request.getParameter("id");
		MainController controller = new MainController();
		request.setAttribute("years", CarService.getCarsYears());
		request.setAttribute("makes", CarService.getCarsMakes());
		if (id != null) {
			controller.carDetails(request, response);
			request.getRequestDispatcher("./details.jsp").forward(request, response);
		} else if ((action == null || action.equals("")) && (filterMake == null && filterYear == null)) {
			controller.mainAction(request, response);
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		} else if ("pagination".contentEquals(action) && (filterMake == null && filterYear == null)) {
			controller.pagination(request, response);
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		} else if (filterMake != null || filterYear != null) {
			controller.filters(request, response);
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		super.doPost(request, response);
	}

}