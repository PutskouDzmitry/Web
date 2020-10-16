<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task List</title>
<link href="style/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	User: ${userName}
	<%@ page import="java.sql.Date" %>
	<%@ page import="java.time.LocalDate" %>
	<div class="main-block-wrapper">
		<div class="main-block">
			<div style="margin: 0; padding: 0;">
				<form action="<c:url value='/logout'/>" method="post">
					<button class="default-button float-right" style="margin-top: -30px;">logout</button>
				</form>
			</div>
			<hr>
			<div class="task-list-buttons-wrapper">
				<c:set var="today" value="<%= Date.valueOf(LocalDate.now()) %>"/>
				<c:set var="tomorrow" value ="<%= Date.valueOf(LocalDate.now().plusDays(1)) %>"/>
				<a class="default-button task-list-button" href='<c:url value="/action?info=TODAY&date=${today}"/>'>
        			 	Today: <fmt:formatDate value="${today}" pattern="dd.MM"/>
        		</a>
        		<a class="default-button task-list-button" href='<c:url value="/action?info=TOMORROW&date=${tomorrow}"/>'>
        			 	Tomorrow: <fmt:formatDate value="${tomorrow}" pattern="dd.MM"/>
        		</a>
        		<a class="default-button task-list-button" href='<c:url value="/action?info=SOMEDAY&date=${tomorrow}"/>'>
        			 	<c:out value = "Someday"/>
        		</a>
        		<a class="default-button task-list-button" href='<c:url value="/action?info=FIXED"/>'>
        			 	<c:out value = "Fixed"/>
        		</a>
        		<a class="default-button task-list-button" href='<c:url value="/action?info=RECYCLE"/>'>
        			 	<c:out value = "Recycle Bin"/>
        		</a>
			</div>
			<div style="width: 100%; text-align: center;">${date}</div>
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
	</div>
</body>
</html>