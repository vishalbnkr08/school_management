<%@page import="java.util.List"%>
<%@page import="school_management.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	margin-top: 100px;
}
</style>
</head>
<body>
<center>
<% List<Student> students = (List) session.getAttribute("viewstudbyreg") ; %>
<table cellpadding="10px">
	<tr>
	<td><%= "ID" %></td>
	<td><%= "Name" %></td>
	<td><%= "Reg.NO" %></td>
	<td><%= "Fees" %></td>
	</tr>
	<% for(Student student : students) {%>
	 <tr>
	 <td><%= student.getId() %></td>
	 <td><%= student.getName() %></td>
	 <td><%= student.getReg_no() %></td>
	 <td><%= student.getFees() %></td>
	<% } %>
</table>
</center>
<a href="viewstudent.html"><button>Back</button></a>
</body>
</html>