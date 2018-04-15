<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Submit a Ticket</title>
			<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
			<link rel="stylesheet" href="resources/css/ticketStyles.css">
</head>
<body>

		<%@ include file="/WEB-INF/view/userBanner.jsp" %>
        <%@ include file="/WEB-INF/view/navBarMenu.jsp" %>
        <h1 class="text-center" >Submit A Support Ticket</h1>
        <div class="text-center">
        	<form:form action="ticket" method="POST">
        		<label>Subject</label></br>
        		<input id="subject" name="subject" type="text" maxlength="50"></br>
        		<label>Please write your concerns</label></br>
        		<textarea name="message" id="messageBox" cols="40" rows="5" maxlength="500"></textarea></br>
        		<input type="submit" class="btn btn-primary" value="Submit Ticket">
        	</form:form>
        </div>
        <h3 style="margin-left: 25%">${msg}</h3>
        <%@ include file="/WEB-INF/view/Footer.jsp" %>

   		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>