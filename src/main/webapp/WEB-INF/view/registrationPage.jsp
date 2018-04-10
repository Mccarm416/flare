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
               
               <form method="POST" action="registrationValidation">
                   
                         <div class="col-md-4 col-md-4">
                        <label name="username" class="control-label">Desired Username</label>
                        <input name="username" class="form-control" required="required"></input>
                         </div>
                         
                         
                         <div class="col-md-4 col-md-4">
                        <label name="password" class="control-label">Desired Password</label>
                        <input type="password" name="password" class="form-control" required="required"></input>
                         </div>
                         
                         
                         <div class="col-md-4 col-md-4">
                        <label name="firstname" class="control-label">First Name </label>
                        <input name="firstname" class="form-control" required="required"></input>
                         </div>
                         
                         
                         <div class="col-md-4 col-md-4">
                         <label name="lastname" class="control-label">Last Name</label>
                        <input name="lastname" class="form-control" required="required"></input>
                         </div>
                         
                         
                         <div class="col-md-4 col-md-4">
                        <label name="year" class="control-label">Current Year</label>
                        <input name="year" class="form-control" required="required"></input>
                         </div>
                         
                         
                         <div class="col-md-4 col-md-4">
                        <label name="semester" class="control-label ">Current Semester</label>
                        <input name="semester" class="form-control" required="required"></input>
                         </div>
                         
                         <div class="col-md-4 col-md-push-4">
                         <label name="email" class="control-label col-md-push-4">Email</label>
                        <input name="email" class="form-control" required="required"></input>
                         </div>
                         
                   <div class="col-sm-12">
                      <div class="col-sm-4"></div>
                      <div class="col-sm-4 col-sm-push-1 "><button type="submit" class="btn-lg  btn-success mx-auto width:300px">Register</button></div>
                      <div class="col-sm-4"></div>
                       
                   </div>
                   <input type="hidden"
					name="${_csrf.parameterName}"
					value="${_csrf.token}"/>
                            </form>  
                            
                        
                 </div> <!-- form group ends -->
           
        </div> <!-- form ends -->
        </div> <!-- row ends -->
    </div>  <!-- container ends -->
        
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	</body>
</html>