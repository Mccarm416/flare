<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<!-- css style page for regisration -->
			<link rel="stylesheet" href="<c:url value="/resources/css/userBanner.css" />">
    		<!-- bootstrap cdn jquery library -->
			<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	<div id="userbar" >
    <a  href="#menu" id="toggle" class="pull-right"><span></span></a>
Sean
<div style="z-index: 1" id="menu" class="pull-right">
  <ul>
    <li><a href="ticket">Submit a ticket</a></li>
    <li><a href="accountManagement">Account Management</a></li>
    <li><form:form  style="z-index: 1" action="${pageContext.request.contextPath}/logout"><input type="submit" value="Logout"></form:form></li>
  </ul>
</div>   
</div>


<script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>
	<script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/userBanner.js" />"></script>
    
</body>
</html>