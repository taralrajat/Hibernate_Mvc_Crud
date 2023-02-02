<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.cjc.employeeapp.app.model.Employee" %>
    <%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>

<form action="editform">

<%Employee e = (Employee)request.getAttribute("singleData"); %>


<pre>    
           <input type="hidden" name="empid" value="<%=e.getId()%>">

Name     : <input type="text" name="name" value="<%=e.getName()%>">

Username : <input type="text" name="username" value="<%=e.getUsername()%>">

Password : <input type="text" name="password" value="<%=e.getPassword()%>">

			<input type="submit" value="Update Information">

</pre>

</form>

</body>
</html>