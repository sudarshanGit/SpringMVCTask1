<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register page</title>

<style type="text/css">
.error {
	color: red;
}
</style>

</head>
<body>

	<h3 align="center">${headerMessage}</h3>
	<form:form action="/SpringMVCTask2/registerSuccess" method="post" modelAttribute="user">
		
		<table>
			<tr>
				<td>User Name</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Country</td>
				<td><form:select path="country">
						<form:option value="India">India</form:option>
						<form:option value="US">US</form:option>
						<form:option value="UK">UK</form:option>
					</form:select></td>
				<td><form:errors path="country" cssClass="error" /></td>

			</tr>

			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>


			<tr>
				<td>Age</td>
				<td><form:input path="age" /></td>
				<td><form:errors path="age" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Phone Number</td>
				<td><form:input path="phone" /></td>
				<td><form:errors path="phone" cssClass="error" /></td>
			</tr>


			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>

		</table>

	</form:form>

</body>
</html>