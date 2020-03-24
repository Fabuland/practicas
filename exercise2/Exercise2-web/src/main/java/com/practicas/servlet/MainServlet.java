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
		MainController controller = new MainController();
		if (action == null || action.equals("")) {
			controller.mainAction(request, response);
			// ??????
		} else if ("pagination".equals(action)) {
			controller.pagination(request, response);
		}
		request.setAttribute("years", CarService.getCarsYears());
		request.setAttribute("makes", CarService.getCarsMakes());

		request.getRequestDispatcher("./index.jsp").forward(request, response);
		;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		super.doPost(request, response);
	}

}