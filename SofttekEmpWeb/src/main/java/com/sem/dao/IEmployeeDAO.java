package com.sem.dao;

import java.util.List;

import com.sem.domain.Employee;

public interface IEmployeeDAO {
	public void addEmplyee(Employee employee);

	public List<Employee> selectAllUsers();

	public Employee selectEmployee(String strEmpId);

	public void deleteEmployee(String empId);

	public void updateEmployee(Employee employee);

	public void pToConfirmation(Employee employee);

	public void stats();

	String INSERT_EMPLOYEE_DATA = "insert into softtek_employee value(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	String GET_ALL_RECORDS = "Select * from softtek_employee";
	String GET_EMPLOYEE_BY_EMPID = "select * from Softtek_Employee where emp_id=?;";
	String DELETE_EMPLOYEE_BY_EMPID = "delete from Softtek_Employee where emp_id=?;";
	String UPDATE_EMPLOYEE_BY_EMPID = "update table Softtek_Employee set first_name=?,,,,,, where emp_id=?;";
	String UPDATE_EMPLOYEE_EMPTYPE = "update table Softtek_Employee set emp_type='C' where emp_id=?;";

}
