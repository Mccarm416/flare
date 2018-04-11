<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
	<head>
		<title>Login</title>
			<meta charset='utf-8'>
			<meta name='description' content='Add a description here'>
			<meta name='keywords' content='Add page keywords separated by commas'>
			<meta name='author' content='Your name and/or email here'>
			<!-- meta tag for responsive behaviour -->
			<meta name="viewport" content="width=device-width, initial-scale=1">
			
			<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/loginStyle.css" />">
			<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	</head>
	<body id="havoc" style="background-color:firebrick">
        <div class="logo"><img id="profilepic" src="${pageContext.request.contextPath}/resources/images/flareLogo.png"></div>
        
	    <div class="wrap" style="padding:40px; width:460px;">
	        <h2>Login To Flare</h2>
	        <h5>A student life assistance web app</h5>
	        <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
	         <div class="form-group">
					        <div class="col-xs-15">
					           <c:if test="${param.error != null}">
					            <div> 
					            
									<div class="alert alert-danger col-xs-offset-1 col-xs-10">
										Invalid username and password.
									</div>
								</c:if>	
								  <c:if test="${param.logout != null}">		            
									<div class="alert alert-success col-xs-offset-1 col-xs-10">
										You have been logged out!
									</div>
								</c:if>
					            </div>
					        </div>
	        
		        <input type="text" name="username" placeholder="Your Username...">

		        <input type="password" name="password" placeholder="Your Password...">

				<button type = "submit"class="btn-login">Login</button>
		    </form:form>
	        
	        
	        <div class="newuser">New User?<a href="registration" target=_blank>Click Here</a></div>
        </div>     
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        
	</body>
</html>