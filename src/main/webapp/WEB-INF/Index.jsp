<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Students</title>
</head>
<body>
	<h1>All Students</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Address</th>
				<th>City</th>
				<th>State</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach var="student" items="${students}">
					<tr>
						<td>${student.firstName} ${student.lastName}</td>
						<td>${student.age}</td>
						<td>${student.contact.getAddress()}</td>
						<td>${student.contact.getCity()}</td>
						<td>${student.contact.getState()}</td>
					</tr>
				</c:forEach>
			</tr>
		</tbody>
	</table>
</body>
</html>