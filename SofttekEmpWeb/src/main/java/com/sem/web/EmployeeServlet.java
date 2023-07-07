package com.sem.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sem.dao.EmployeeDAO;
import com.sem.domain.Employee;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			listEmployee(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Employee> listEmployee = null;
		try {
			EmployeeDAO empDAO = new EmployeeDAO();
			listEmployee = empDAO.selectAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("listEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/list-employee.jsp");
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unused")
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String empId = request.getParameter("empId");
		EmployeeDAO empDAO = new EmployeeDAO();
		empDAO.deleteEmployee(empId);
		response.sendRedirect("list");
	}

}