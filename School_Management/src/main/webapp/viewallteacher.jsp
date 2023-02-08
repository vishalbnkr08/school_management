<%@page import="school_management.Teacher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Student</title>
<style type="text/css">
table{
	margin-top: 100px;
}
</style>

</head>
<body>
<center>
<% List<Teacher> teachers = (List) session.getAttribute("viewallteacher") ; %>
<table cellpadding="10px">
<tr>
	<td><%= "ID" %></td>
	<td><%= "Name" %></td>
	<td><%= "Salary" %></td>
	</tr>
	<% for(Teacher teacher : teachers) {%>
	 <tr>
	 <td><%= teacher.getId() %></td>
	 <td><%= teacher.getName() %></td>
	 <td><%= teacher.getSalary() %></td>
	<% } %>
</table>
</center>
<a href="viewteacher.html"><button>Back</button></a>
</body>
</html>