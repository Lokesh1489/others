package com.loki;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class TableFetch extends HttpServlet {
	Connection conn;
	java.sql.Statement stmt;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "Softtek@2022");
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				PrintWriter out = response.getWriter();
				ResultSet rs = stmt.executeQuery("select * from employee");
				ResultSetMetaData rsm = rs.getMetaData();
				int columnCount = rsm.getColumnCount();
				
				for (int i = 1; i <= columnCount; i++) {
					response.getWriter().print(rsm.getColumnName(i) + " : ");
				}
				
				while (rs.next()) {
					out.println();
					out.println();
					out.println(rs.getString(1) + " : " + "" + rs.getString(2) + " : " + rs.getInt(3) + " : "
							+ rs.getString(4) + " : " + rs.getString(5) + " : " + "" + rs.getString(6));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}