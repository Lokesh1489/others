package com.sem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.sem.domain.Employee;

public class EmployeeDAO implements IEmployeeDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/servlet";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Softtek@2022";

	public EmployeeDAO() {

	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public List<Employee> selectAllEmployees() {
		System.out.println("Start --> selectAllEmployees");
		List<Employee> employees = new ArrayList<Employee>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_RECORDS)) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String empId = rs.getString("emp_id");
				String isID = rs.getString("is_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String address = rs.getString("address");
				Date birthDate = rs.getDate("birth_date");
				String gender = (String) rs.getString("gender");
				String email = rs.getString("email");
				Date joiningDate = rs.getDate("joining_date");
				String empType = rs.getString("emp_type");
				String empStatus = (String) rs.getString("emp_status");
				String contactNo = rs.getString("contact_no");
				int expLevel = rs.getInt("exp_level");

				employees.add(new Employee(empId, isID, firstName, lastName, address, birthDate, gender, email,
						joiningDate, empType, empStatus, contactNo, expLevel));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return employees;
	}

	private void printSQLException(SQLException ex) {

	}

	@Override
	public Employee selectEmplyee(String strEmpId) {
		System.out.println("Start --> selectAllEmployees");
		Employee employee = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_EMPLOYEE_BY_EMPID)) {
			System.out.println(preparedStatement);
			preparedStatement.setString(1, strEmpId);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String empId = rs.getString("emp_id");
				String isID = rs.getString("is_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String address = rs.getString("address");
				Date birthDate = rs.getDate("birth_date");
				String gender = (String) rs.getString("gender");
				String email = rs.getString("email");
				Date joiningDate = rs.getDate("joining_date");
				String empType = rs.getString("emp_type");
				String empStatus = (String) rs.getString("emp_status");
				String contactNo = rs.getString("contact_no");
				int expLevel = rs.getInt("exp_level");

				employee = new Employee(empId, isID, firstName, lastName, address, birthDate, gender, email,
						joiningDate, empType, empStatus, contactNo, expLevel);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		return employee;
	}

	@Override
	public void addEmplyee(Employee employee) {
		try {
			Connection connection = getConnection();
			PreparedStatement psmt = connection.prepareStatement(INSERT_EMPLOYEE_DATA);

			psmt.setString(1, employee.getEmpId());
			psmt.setString(2, employee.getIsId());
			psmt.setString(3, employee.getFirstName());
			psmt.setString(4, employee.getLastName());
			psmt.setString(5, employee.getAddress());
			psmt.setString(6, EmployeeHelper.dateToSQLDate(employee.getBirthDate()));
			psmt.setString(7, employee.getGender());
			psmt.setString(8, employee.getEmail());
			psmt.setString(9, EmployeeHelper.dateToSQLDate(employee.getJoiningDate()));
			psmt.setString(10, employee.getEmpType());
			psmt.setString(11, employee.getEmpStatus());
			psmt.setString(12, employee.getContactNo());
			psmt.setInt(13, employee.getExpLevel());

			psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmplyee(String empId) {
		try {
			Connection connection = getConnection();
			PreparedStatement psmt = connection.prepareStatement(DELETE_EMPLOYEE_BY_EMPID);
			psmt.setString(1, empId);

			psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmplyee(Employee employee) {
		try {
			Connection connection = getConnection();
			PreparedStatement psmt = connection.prepareStatement(UPDATE_EMPLOYEE_BY_EMPID);

			psmt.setString(1, employee.getFirstName());
			psmt.setString(2, employee.getLastName());
			psmt.setString(3, employee.getAddress());
			psmt.setString(4, EmployeeHelper.dateToSQLDate(employee.getBirthDate()));
			psmt.setString(5, employee.getGender());
			psmt.setString(6, employee.getEmpStatus());
			psmt.setString(7, employee.getContactNo());
			psmt.setString(8, employee.getEmpId());

			psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void pTocConfirmation(Employee employee) {
		try {
			Connection connection = getConnection();
			PreparedStatement psmt = connection.prepareStatement(UPDATE_EMPLOYEE_EMPTYPE);
			psmt.setString(1, employee.getEmpId());
			String joiningDate = EmployeeHelper.dateToSQLDate(employee.getJoiningDate());

			if (EmployeeHelper.checkfor6Months(joiningDate)) {
				psmt.executeQuery();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stats() {

	}

}