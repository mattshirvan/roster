<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Student</title>
</head>
<body>
	<h1>New Student</h1>
	<form:form action="/students/create" method="POST" modelAttribute="student">
		<div>
			<form:label path="firstName">First Name</form:label>
			<form:errors path="firstName"/>
			<form:input path="firstName"/>
		</div>
		<div>
			<form:label path="lastName">Last Name</form:label>
			<form:errors path="lastName" />
			<form:input path="lastName"/>
		</div>
		<div>
			<form:label path="age">Age</form:label>
			<form:errors path="age" />
			<form:input path="age"/>
		</div>
		<button>Add Student</button>
	</form:form>
</body>
</html>