<%@page import="java.net.URI"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<font color="green">${msg} </font>
	<h3>Student Registration Form</h3>
	<form:form action="save" modelAttribute="student">


		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><form:radiobutton path="gender" value="male" />Male <form:radiobutton
						path="gender" value="female" />FeMale</td>
			</tr>


			<tr>
				<td>Course :</td>
				<td><form:select path="course">

						<form:option value="">-Select-</form:option>
						<form:options items="${courses}" />

					</form:select></td>
			</tr>


			<tr>
				<td>Timings :</td>

				<td><form:checkboxes items="${timings}" path="timings" /></td>

			</tr>
			<tr>


				<td><input type="submit" value="save"></td>

			</tr>
		</table>

	</form:form>
	<a href="viewsStudent">viewStudent</a>

</body>


</html>