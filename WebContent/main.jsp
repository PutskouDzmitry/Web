<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task List</title>
<link href="style/style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Indie+Flower&family=Merienda&family=Montserrat:wght@100&display=swap" rel="stylesheet">
</head>
<body>
	<%@ page import="java.sql.Date" %>
	<%@ page import="java.time.LocalDate" %>
	<div class="main-block-wrapper">
		<div class="main-block">
			<div style="margin: 0; padding: 0;">
				User: ${userName}
				<form action="<c:url value='/logout'/>" method="post">
					<button class="default-button logout-button">Logout</button>
				</form>
			</div>
			<hr>
			<div class="task-list-buttons-wrapper">
				<c:set var="today" value="<%=Date.valueOf(LocalDate.now())%>"/>
				<c:set var="tomorrow" value="<%=Date.valueOf(LocalDate.now().plusDays(1))%>"/>
				<a class="default-button task-list-button" href='<c:url value="/task?view=Today"/>'>
        			 	Today: <fmt:formatDate value="${today}" pattern="dd.MM"/>
        		</a>
        		<a class="default-button task-list-button" href='<c:url value="/task?view=Tomorrow"/>'>
        			 	Tomorrow: <fmt:formatDate value="${tomorrow}" pattern="dd.MM"/>
        		</a>
        		<a class="default-button task-list-button" href='<c:url value="/task?view=Someday"/>'>
        			 	<c:out value = "Someday"/>
        		</a>
        		<a class="default-button task-list-button" href='<c:url value="/task?view=Fixed"/>'>
        			 	<c:out value = "Fixed"/>
        		</a>
        		<a class="default-button task-list-button" href='<c:url value="/task?view=Recycle"/>'>
        			 	<c:out value = "Recycle Bin"/>
        		</a>
			</div>
			<div style="width: 100%; text-align: center;">${date}</div>
			<c:choose>
				<c:when test="${view eq 'Today'}">${view}: <fmt:formatDate value="${today}" pattern="dd.MM"/></c:when>
				<c:when test="${view eq 'Tomorrow'}">${view}: <fmt:formatDate value="${tomorrow}" pattern="dd.MM"/></c:when>
				<c:otherwise>${view}</c:otherwise>
			</c:choose>
			<table border="3">
				<tr>
					<th>Check</th>
					<th>Task</th>
					<th>Date</th>
				</tr>
				<c:forEach var="event" items="${list}">
					<tr>
						<td align="center"><input type=checkbox name=idEvent
							value="${event.idTask}" checked></td>
						<td>${event.description}</td>
						<td>${event.date}</td>
					</tr>
				</c:forEach>
			</table>

			<div class="task-list-buttons-wrapper">
				<td><a class="default-button add-button"
					href='<c:url value="/day?info=add"/>'>Add Task</a>
				<td><a class="default-button fix-button"
					href='<c:url value="/day?info=fix"/>'>Fix</a>
				<td><a class="default-button remove-button"
					href='<c:url value="/day?info=remove"/>'>Remove</a>
			</div>
		</div>
		<div class="footer-sign">
			<span class="montserrat-font">designed by</span> <span class="indie-flower">fin.</span>
		</div>
	</div>
</body>
</html>