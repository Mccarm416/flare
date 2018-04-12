<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <%@ page import="flare.model.users.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Management</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/accountManagement.css">
</head>
<body>
		<% User user = (User)request.getSession().getAttribute("user");
		String username = user.getUserName();
		String email = user.getEmail();
		String firstname = user.getFirstName();
		String lastname = user.getLastName();
		String accountcreation = user.getAccountCreation();
		int year = user.getCurrentYear();
		int semester = user.getSemester();
		%>
		
		<%@ include file="/WEB-INF/view/userBanner.jsp" %>
        <%@ include file="/WEB-INF/view/navBarMenu.jsp" %>
        <div id="contains" class="text-center col-md-4 col-md-push-4">
        	<h1>Account: <%= username %></h1>
        	<table class="table text-center">
        		<thead class="thead-dark">
				    <tr>
				      <th class="text-center" scope="col">Value</th>
				      <th class="text-center" scope="col">Property</th>
				    </tr>
				  </thead>
        		<tr>
        			<td>User Name</td>
        			<td> <%= username %></td>
        		</tr>
        		<tr>
        			<td>Email</td>
        			<td> <%= email %></td>
        		</tr>
        		<tr>
        			<td>First Name</td>
        			<td> <%= firstname %></td>
        		</tr>
        		<tr>
        			<td>Last Name</td>
        			<td> <%= lastname %></td>
        		</tr>
        		<tr>
        			<td>Account Creation</td>
        			<td> <%= accountcreation %></td>
        		</tr>
        		<tr>
        			<td>Year</td>
        			<td> <%= year %></td>
        		</tr>
        		<tr>
        			<td>Semester</td>
        			<td> <%= semester %></td>
        		</tr>
        	</table>
        </div>
		<div class="text-center" id="managementOptions">
			  	 <button class="btn btn-success"> Update Account</button>
        
      		 	 <button class="btn btn-primary"> Upgrade Account</button>
      		 	 
      		 	 <button class="btn btn-warning"> Upload Profile Picture</button>
        
       			 <button class="btn btn-danger"> Delete Account</button>
		</div>
     
        

        <%@ include file="/WEB-INF/view/Footer.jsp" %>
</body>
</html>