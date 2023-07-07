package com.lokesh.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class MyFirstServlet
 */
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(request.getParameter("name")==null) {
        	out.println("<h1> Welcome to the world of servlets!!!</h1>");
        }
        else {
        	 if(request.getParameter("name").equals("Lokesh")) {
             	out.println("<h1>"+ request.getParameter("name")+ "-GOOD BOYYYY"+ "</h1>");
             }
        	 if(request.getParameter("name").equals("Ashik")) {
              	out.println("<h1>"+ request.getParameter("name")+ "-GOOD BOYYYY"+ "</h1>");
              }
        	 if(request.getParameter("name").equals("Dhar")) {
              	out.println("<h1>"+ request.getParameter("name")+ "-GOOD Girllll"+ "</h1>");
              }
        }
    }
	
		
	}
	
