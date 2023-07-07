<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>



<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>



<body>



	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">
					Employee Management App </a>
			</div>



			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employees</a></li>
			</ul>
		</nav>
	</header>
	<br>



	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->



		<div class="container">
			<h3 class="text-center">List of Employees</h3>
			<hr>
			<div class="container text-left">



				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Employee</a> <a href="<%=request.getContextPath()%>/new"
					class="btn btn-success"> Prob 2 Conf</a> <a
					href="<%=request.getContextPath()%>/new" class="btn btn-success">
					Statistics</a> <a href="<%=request.getContextPath()%>/new"
					class="btn btn-success"> Search Employee</a>
			</div>




			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Employee Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="employee" items="${listEmployee}">



						<tr>
							<td><c:out value="${employee.empId}" /></td>
							<td><c:out value="${employee.firstName}" /></td>
							<td><c:out value="${employee.lastName}" /></td>
							<td><c:out value="${employee.email}" /></td>
							<td><a
								href="/UserMgmt/edit?id=<c:out value='${employee.empId}' />">Edit</a>
								&nbsp; <a href="/delete?id=<c:out value='${employee.empId}' />">Delete</a>
								&nbsp; <a href="view?id=<c:out value='${employee.empId}' />">View</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>



			</table>
		</div>
	</div>
</body>



</html>