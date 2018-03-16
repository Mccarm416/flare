<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
	<head>
		<title>Title goes here</title>
			<meta charset='utf-8'>
			<meta name='description' content='Add a description here'>
			<meta name='keywords' content='Add page keywords separated by commas'>
			<meta name='author' content='Your name and/or email here'>
			<!-- meta tag for responsive behaviour -->
			<meta name="viewport" content="width=device-width, initial-scale=1">
			
			<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/loginStyle.css" />">
			
	</head>
	<body>
        <div class="logo"></div>
        
	    <div class="wrap">
	        <h2>Login To Flare</h2>
	        <h5>A student life assistance web app</h5>
	        
	        <input type="text" name="username" placeholder="Your Username...">
	        <input type="password" name="password" placeholder="Your Password...">
	        
	        <button class="btn-login">Login</button>
	        <div class="newuser">New User?<a href="#" target=_blank>Click Here</a></div>
        </div>     
	</body>
</html>