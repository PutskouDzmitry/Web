<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="style/style.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Registration page</title>
</head>
<body>
	<div class="main-block-wrapper">
		<div class="main-block login-block">
			<p style="text-align: center; margin: 0; padding: 0; color:red;">${error}</p>
			<p style="text-align: center; margin: 0; padding: 0;">
				Create account
			</p>
			<hr>
			<form name="stats" action="<c:url value='/reg'/>" method="post">
				Login:<br> <input class="input" type=text name="login">
				<br>
				<br> Password:<br> <input class="input" type=text
					name="password">
				<button class="default-button confirm-button">&nbspConfirm&nbsp</button>
			</form>
		</div>
	</div>
</body>
<style>
* {
	font-family: Lucida Sans Unicode;
	font-size: 18px;
	background-color: #333333;
	color: white;
}

hr {
	background-color: white;
	height: 0.5px;
	border: 1px solid white;
	border-radius: 15px;
}

.main-block-wrapper {
	display: flex;
	align-items: center;
	justify-content: center;
	width: 100%;
	height: 100%;
}

.main-block {
	border: 2px solid white;
	border-radius: 15px;
	width: 500px;
	margin: 10px;
	padding: 15px 15px 0px 15px;
	cursor: default;
	box-shadow: 0px 0px 15px 1px rgba(255, 255, 255, 0.75);
}

.default-button {
	border: 2px solid #00e673;
	border-radius: 5px;
	color: #00e673;
	text-decoration: none;
	padding: 2px 3px;
	outline: none;
	transition: 0.2s;
}

.default-button:hover {
	color: #333333;
	border: 2px solid #00e673;
	border-radius: 5px;
	background-color: #00e673;
	box-shadow: 0px 0px 15px 5px rgba(0, 230, 115, 0.5);
}

.default-button:active {
	border: 2px solid #00e673;
	background-color: #333333;
	color: #00e673;
	box-shadow: 0px 0px 15px 5px rgba(0, 230, 115, 0.5);
}
.login-block {
	width: 400px;
}

.input {
	width: 94%;
	border-radius: 15px;
	padding: 0px 10px;
	background-color: #4d4d4d;
}

.input:focus {
	outline: none;
	color: black;
	background-color: #d9d9d9;
	border: 2px solid #00e673;
	box-shadow: 0px 0px 15px 5px rgba(0, 230, 115, 0.5);
}

.confirm-button {
	float: right;
	outline: none;
	margin: 10px 0;
}
</style>
</html>