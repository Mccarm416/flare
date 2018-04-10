<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Success - Welcome to falre!</title>
</head>
<body>
<h1>Congratulations! You've succesfully registered on flare ${user} </h1>

<p>Please click <a href="login">here</a> to log into the service</p>
<form>
<input type="hidden"
name="${_csrf.parameterName}"
value="${_csrf.token}"/>
</form>
</body>
</html>