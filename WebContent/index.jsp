<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Start Page</title>
<link href="style/style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200&display=swap" rel="stylesheet">
</head>
<body>
	<div class="main-block-wrapper">
		<div class="main-block">
			<p style="text-align: center; margin: 0; padding: 0; color:red;">${error}</p>
			User: <b>guest</b> &ensp;&ensp;
			<td><a class="default-button" href='<c:url value="/login.jsp"/>'>
					Login&ensp;</a> &ensp;&ensp;<a class="default-button"
				href='<c:url value="/reg.jsp"/>'> Registrate&ensp;</a></td>
			<hr>
			<p> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
				do eiusmod tempor incididunt ut labore et do
				lore magna aliqua. Ut
				enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
				ut aliquip ex ea commodo consequat. Duis aute irure dolor in
				reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
				p
				ariatur. Excepteur sint occaecat cupidatat non proident, sunt in
				culpa qui officia deserunt mollit anim id est laborum.
			</p>
			<hr>
			<p> Developed by Damaskanau Daniil ddamaskanau@gmail.com </p>
		</div>
		<div class="footer-sign">
			<span class="montserrat-font">designed by</span> <span class="indie-flower">fin.</span>
		</div>
	</div>
</body>
</html>