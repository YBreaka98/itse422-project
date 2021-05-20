<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<p>user names</p>
	<p>Signed In Successfully</p>
	<p>${user.getUserName()}</p>
	<%-- <c:forEach var="i" begin="0" end="${users.size()-1}" step="1">
		<c:out value="${users.get(i).first}" /><c:out value=" ${users.get(i).last}" />
		<br>
		<c:out value="${users.get(i).phone}" /><br>
		<c:out value="${i}" /><br>
	</c:forEach> --%>
</body>
</html>