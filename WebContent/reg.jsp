<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="style/style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200&display=swap" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Registration page</title>
	<script>
	function checkInput() {
		stats.login.value = stats.login.value.trim();
		stats.password.value = stats.password.value.trim();
		if(stats.login.value === "") {
			document.getElementById("errMsg").innerHTML = "Login is empty";
			return false;
		}
		if(stats.password.value === "") {
			document.getElementById("errMsg").innerHTML = "Password is empty";
			return false;
		}
		stats.submit();
	}	
	</script>
</head>
<body>
	<div class="main-block-wrapper">
		<div class="main-block login-block">
			<p style="text-align: center; margin: 0; padding: 0; color:red;">${error}</p>
			<p style="text-align: center; margin: 0; padding: 0;">
				Create account
			</p>
			<hr>
			<form name="stats" action="<c:url value='/reg'/>" method="post" onsubmit="false">
				Login:<br> <input class="input" type="text" name="login" required>
				<br>
				<br> Password:<br> <input class="input" type="password"
					name="password" required>
				<p id="errMsg" style="color:red;"></p>
				<input type=button value="Register participant" class="default-button confirm-button" onclick="return checkInput()"/>
			</form>
		</div>
		<div class="footer-sign">
			<span class="montserrat-font">designed by</span> <span class="indie-flower">fin.</span>
		</div>
	</div>
</body>
</html>