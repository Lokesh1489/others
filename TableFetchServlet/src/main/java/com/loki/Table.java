package com.sanjay;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	Connection conn;
	java.sql.Statement stmt;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Softtek@2022");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ResultSet rs = stmt.executeQuery("select * from book");
				ResultSetMetaData rsm = rs.getMetaData();
				int columnCount = rsm.getColumnCount();
				for (int i = 1; i < columnCount; i++) {
					response.getWriter().print(rsm.getColumnName(i) + " : ");
				}
				while (rs.next()) {
					response.getWriter().println();
					response.getWriter().println();

					response.getWriter().println(rs.getInt(1) + " : " + "" + rs.getString(2) + " : " + rs.getString(3)
							+ " : " + rs.getInt(4));
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