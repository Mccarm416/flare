<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inbox</title>
<style>
table {
    border-collapse: collapse;
}

table, td {
    border: 1px solid black;
}

td {
	padding: 5px;
}

/* Centers the button */
.userButton {
	horizontal-align: middle;
	display: block;
	margin:auto;

</style>
</head>
<body>
	<h1>Inbox</h1>
	<c:if test="${not empty errorMessage }">
		<h2><c:out value="${errorMessage}"/></h2>
	</c:if>
	<h2>Your Active Chats</h2>
	<table>
	<c:forEach items="${chatUsers}" var="user">
		<tr>
			<td>
				<form action="chatroom" method="POST">
					<input type="submit" class="userButton" name="selectedUser" value="<c:out value="${user.username}"/>"/>
				</form>
			</td>
		</tr>
	</c:forEach>
	</table>
	<br>
	<b>Search for user:</b>
		<form action="userSearch" method="POST">
			<input type="text" name="userFind"/>
			<input type="submit" value="Search"/>
		</form>
</body>
</html>