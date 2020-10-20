<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="style/style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200&display=swap" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<div class="main-block-wrapper">
		<div class="main-block login-block">
			<p style="text-align: center; margin: 0; padding: 0; color:red;">${error}</p>
			<p style="text-align: center; margin: 0; padding: 0;">
				Login to your account
			</p>
			<hr>
			<form name="stats" action="<c:url value='/log'/>" method="post">
				Login:<br> <input class="input" type=text name="login">
				<br>
				<br> Password:<br> <input class="input" type=text
					name="password">
				<button class="default-button confirm-button">&nbspConfirm&nbsp</button>
			</form>
		</div>
		<div class="footer-sign">
			<span class="montserrat-font">designed by</span> <span class="indie-flower">fin.</span>
		</div>
	</div>
</body>
</html>