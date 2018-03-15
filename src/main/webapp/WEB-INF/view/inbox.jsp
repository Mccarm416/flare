<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
input[type=submit] {
	horizontal-align: middle;
	display: block;
	margin:auto;

</style>
</head>
<body>
	<h1>Inbox</h1>
	
	<h2>Active Chats</h2>
	<table>
		<tr>
			<td>
				<form action="chatroom" method="GET">
				<input type="submit" value="whatSoNot"/>
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="chatroom" method="GET">
				<input type="submit" value="RL Grime"/>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>