<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add </title>
</head>
<body>
	<form name="reg" action="<c:url value='/action?view=${checkDay}'/>" method="post">
		<c:if test="${checkDay == 'Today'}">
			<p>
				Description: <input type=text name="description" />
			</p>
			<p>
				<input type="hidden" name="date" value="${today}">
			</p>
		</c:if>
		<c:if test="${checkDay == 'Tomorrow'}">
			<p>
				Description: <input type=text name="description" />
			</p>
			<p>
				<input type="hidden" name="date" value="${tomorrow}" />
			</p>
		</c:if>
		<c:if test="${checkDay == 'Someday'}">
			<p>
				Account: <input type=text name="account" />
			</p>
			<p>
				Description: <input type=text name="description" />
			</p>
			<p>
				Day: <input type=text name="date" />
			</p>
		</c:if>
		<button name="operation" value="Add">Submit</button>
	</form>
</body>
</html>