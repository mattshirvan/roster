<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Contact Info</title>
</head>
<body>
	<h1>Contact Information</h1>
	<form:form action="/contact/create" method="POST" modelAttribute="contact">
		<div>
			<form:label path="student">Student</form:label>
			<form:errors path="student" />
			<form:select path="student">
				<c:forEach var="newStudent" items="${students}">
					<form:option value="${newStudent.id}">${newStudent.firstName} ${newStudent.lastName}</form:option>
				</c:forEach>
			</form:select>
		</div>
		<div>
			<form:label path="address">Address</form:label>
			<form:errors path="address"/>
			<form:input path="address"/>
		</div>
		<div>
			<form:label path="city">city</form:label>
			<form:errors path="city" />
			<form:input path="city"/>
		</div>
		<div>
			<form:label path="state">State</form:label>
			<form:errors path="state" />
			<form:input path="state"/>
		</div>
		<button>Add Contact Info</button>
	</form:form>
</body>
</html>