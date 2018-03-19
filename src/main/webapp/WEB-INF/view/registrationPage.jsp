<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
	<head>
		<title>Registration Page</title>
			<meta charset='utf-8'>
			<meta name='description' content='Add a description here'>
			<meta name='keywords' content='Add page keywords separated by commas'>
			<meta name='author' content='Your name and/or email here'>
			<!-- meta tag for responsive behaviour -->
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<!-- css style page for regisration -->
			<link rel="stylesheet" href="<c:url value="/resources/css/registrationStyle.css" />">
			
			<!-- bootstrap cdn jquery library -->
			<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	</head>
	<body>
      
        <div class="container-fluid">
      
        <!--                 <div class="logo"></div>-->
                <div class="row"><img class="img img-responsive center-block" src="<c:url value="/resources/images/flareLogo.png" />"></div>
                 <div class="row">
                  <h2 class="text-center">Registration</h2>
               <div class="form"> 
               <form:form method="POST" action="/validateRegistration" modelAttribute="student">
                   
                         <div class="col-md-4 col-md-4">
                        <form:label path="username" class="control-label">Desired Username</form:label>
                        <form:input path="username" class="form-control" required="required"></form:input>
                         </div>
                         
                         
                         <div class="col-md-4 col-md-4">
                        <form:label path="password" class="control-label">Desired Password</form:label>
                        <form:input path="password" class="form-control" required="required"></form:input>
                         </div>
                         
                         
                         <div class="col-md-4 col-md-4">
                        <form:label path="firstname" class="control-label">First Name </form:label>
                        <form:input path="firstname" class="form-control" required="required"></form:input>
                         </div>
                         
                         
                         <div class="col-md-4 col-md-4">
                         <form:label path="lastname" class="control-label">Desired</form:label>
                        <form:input path="lastname" class="form-control" required="required"></form:input>
                         </div>
                         
                         
                         <div class="col-md-4 col-md-4">
                        <form:label path="year" class="control-label">Current Year</form:label>
                        <form:input path="year" class="form-control" required="required"></form:input>
                         </div>
                         
                         
                         <div class="col-md-4 col-md-4">
                        <form:label path="semester" class="control-label">Current Semester</form:label>
                        <form:input path="semester" class="form-control" required="required"></form:input>
                         </div>
                         
                         
                   <div class="col-sm-12">
                      <div class="col-sm-4"></div>
                      <div class="col-sm-4 col-sm-push-1 "><button type="submit" class="btn-lg btn-success mx-auto width:300px">Register</button></div>
                      <div class="col-sm-4"></div>
                       
                   </div>
                            </form:form>  
                            
                        
                 </div> <!-- form group ends -->
           
        </div> <!-- form ends -->
        </div> <!-- row ends -->
    </div>  <!-- container ends -->
        
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	</body>
</html>