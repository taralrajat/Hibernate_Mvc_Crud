<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.cjc.employeeapp.app.model.Employee" %>   
<%@page import="java.util.List" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Data</title>
</head>
<body>

<table border="1">
<tr>
	<th>Name</th>
	<th>Username</th>
	<th>Password</th>
</tr>
<%List<Employee> empList = (List<Employee>)request.getAttribute("allData");%>
<%for(Employee e : empList) { %>
<tr>
	<td><%=e.getName() %></td>
	<td><%=e.getUsername() %></td>
	<td><%=e.getPassword() %></td>
	
	
	<td> <a href="delete?empid=<%=e.getId()%>">Delete</a> </td>
	<td> <a href="edit?empid=<%=e.getId()%>">Edit</a></td>
	
	
</tr>
<% } %>


</table>

</body>
</html>