package com.sem.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EmployeeHelper {

	static int intEmpId = 1000;

	// Auto assignment of ISID
	public static String isIdLogic(String firstName, String lastName) {
		String isId = "";
		if (firstName.length() >= 2 && lastName.length() >= 2) {
			isId = firstName.substring(0, 2) + lastName.substring(lastName.length() - 2, lastName.length());
		} else if (firstName.length() >= 2 && lastName.length() < 2) {
			isId = firstName.substring(0, 3) + lastName.substring(0);
		} else if (firstName.length() < 2 && lastName.length() >= 2) {
			isId = firstName.substring(0) + lastName.substring(lastName.length() - 3, lastName.length());
		} else {
			isId = firstName.substring(0) + lastName.substring(0);
		}
		return isId.toUpperCase();
	}

	// Auto Email creation
	public static String emailIdLogic(String firstName, String lastName) {
		String emailId = firstName + "." + lastName + "@softtek.com";
		return emailId.toLowerCase();
	}

	// Auto creation of Employee ID
	public static void setIntEmpId() {
		try {
			Connection con;
			ResultSet rs;
			con = DriverManager.getConnection("jdbc:mysql://localhost/springjdbc", "root", "Softtek@2022");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select emp_id from Softtek_Employee");
			while (rs.next()) {
				// gets into if condition only when the table is empty
				if (((String) rs.getString(1)).equals(null)) {
					intEmpId++;
				}
				// Auto increments intEmpId to the next value of the last employee in the table
				else {
					String EmpId = rs.getString("emp_id").substring(3);
					intEmpId = Integer.parseInt(EmpId);
					intEmpId++;
				}
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int getIntEmpId() {
		return intEmpId;
	}

	public static String empIdLogic() {
		String empId = "";
		setIntEmpId();
		empId = "ASP" + getIntEmpId();
		return empId;
	}

	// converts system date to sql date
	public static String dateToSQLDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date.toString());
	}

	// converts sql date to system date
	public static Date sqlToDate(String strDate) {
		Date dateDate = null;
		try {
			dateDate = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateDate;
	}

	// returns the current date in sql formal
	public static String currentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		return (dateFormat.format(cal.getTime()).toString());
	}

	// returns the date after 6 months in sql format
	public static String currentDatePlus6Months(String date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(dateFormat.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.add(Calendar.MONTH, 6);
		return (dateFormat.format(cal.getTime()).toString());
	}

	// to check if 6 months have completed after joining
	public static Boolean checkfor6Months(String joiningDate) {
		boolean isSixMonths = false;

		// takes currentDate(sql) converts it into currentDate(sys)
		// takes joining+6monthDate(sql) converts it into joining+6monthDate(sys)
		// checks if currentDate(sys) is after joining+6monthDate(sys) or not
		if ((EmployeeHelper.sqlToDate(EmployeeHelper.currentDate()))
				.after((EmployeeHelper.sqlToDate(EmployeeHelper.currentDatePlus6Months(joiningDate))))) {
			isSixMonths = true;
		}
		return isSixMonths;
	}
}