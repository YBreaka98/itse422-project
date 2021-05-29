<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/login.css" />

<title>Booking System</title>
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->
			<h2 class="active">Sign In</h2>
			<!-- Icon -->
			<!-- <div class="fadeIn first">
				<img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon"
					alt="User Icon" />
			</div> -->

			<!-- Login Form -->
			<form action="AuthenticationServlet">
				<input type="text" id="login" class="fadeIn second" name="username"
					placeholder="login"> <input type="text" id="password"
					class="fadeIn third" name="password" placeholder="password">
				<input type="submit" class="fadeIn fourth" value="send">
			</form>

			<!-- Remind Password -->
			<div id="formFooter">
				<a class="underlineHover" href="#">Forgot Password?</a>
			</div>

		</div>
	</div>
</body>
</html>
