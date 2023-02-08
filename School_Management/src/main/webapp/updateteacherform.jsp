<%@page import="school_management.Teacher"%>
<%@page import="school_management.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Teacher Form</title>
<style type="text/css">
form{
	margin-top: 100px;
}
</style>

</head>
<body>
<center>
	<% Teacher teacher = (Teacher) session.getAttribute("update_teacher"); %>
	<form action="updateteacherform" method="post">
		 ID:<input type="number" name="id" value="<%= teacher.getId()%>"><br><br>
		 Name:<input type="text" name="name" value="<%= teacher.getName()%>"><br><br>
		 Salary<input type="text" name="salary" value="<%= teacher.getSalary() %>"><br><br>
		<input type="submit" value="Update">
	</form>
</center>
</body>
</html>