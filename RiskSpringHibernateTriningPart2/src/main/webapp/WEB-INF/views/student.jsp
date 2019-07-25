<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/includes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management Details</title>
</head>
<body>
	<h1>Sudent details</h1>
	<form:form action="student.do" method="POST" commandName="student">
		<table>
			<tr>

				<td>Student ID:</td>
				<td><form:input path ="studentId"/></td>

			</tr>
			
			<tr>

				<td>First Name:</td>
				<td><form:input path ="firstName"/></td>

			</tr>
			
			
			<tr>

				<td>Last Name</td>
				<td><form:input path ="lastName"/></td>

			</tr>
			
			<tr>

				<td>Year Level</td>
				<td><form:input path ="yearLevel"/></td>

			</tr>
			
			<tr>
			<td colspan="2">
			<td><input type="submit" name="action" value="Add"></td>
			<td><input type="submit" name="action" value="Edit"></td>
			<td><input type="submit" name="action" value="Delete"></td>
			<td><input type="submit" name="action" value="Search"></td>
			</tr>

		</table>
	</form:form>
	<br>
	<table>
	<tr>id<tr>
	<tr>First Name <tr>
	<tr>Last Name <tr>
	<tr>Year Level<tr>
	<c:forEach items="studentList" var="student"></c:forEach>
	<tr>
	<td>${student.studentId}</td>
	<td>${student.firstName}</td>
	<td>${student.lastName}</td>
	<td>${student.yearLevel}</td>
	</tr>
	</table>
	
</body>
</html>