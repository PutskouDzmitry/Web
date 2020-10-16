<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="style/style.css" rel="stylesheet" type="text/css">
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
	</div>
</body>
</html>