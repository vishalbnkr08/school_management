<%@page import="school_management.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
form{
	margin-top: 100px;
}
</style>

</head>
<body>
<center>
	<% Student student = (Student) session.getAttribute("updatestudent"); %>
	<form action="updatestudentform" method="post">
		<input type="number" name="id" value="<%= student.getId()%>"><br><br>
		<input type="text" name="name" value="<%= student.getName() %>"><br><br>
		<input type="number" name="regno" value="<%= student.getReg_no() %>"><br><br>
		<input type="text" name="fees" value="<%= student.getFees() %>"><br><br>
		<input type="submit" value="Update">
	</form>
</center>
</body>
</html>