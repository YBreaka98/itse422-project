<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>welcome to JSP</h1>
	<form action="AuthenticationServlet">
	<label>first name:</label>
		<input type="text" name="username"/><br>
		<label>last name:</label>
		<input type="text" name="password" /><br>
		<label>phone:</label> 
		<input type="submit" value="send" />
	</form>
</body>
</html>