<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
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
                <div class="row"><img class="img img-responsive center-block" src=  "<c:url value="/resources/images/flareLogo.png" />"></div>
                 <div class="row">
                  <h2 class="text-center">Registration</h2>
               <div class="form"> <form type=POST>
                   
                        
                         <div class="col-md-4 col-md-4">
                        <label for="userName" class="control-label">Username:</label>
                         <input type="text" id="userName" class="form-control" required>
                         </div>
                         
                         
                         <div class="col-md-4 col-md-4">
                            <label for="passWord" class="control-label">Password:</label>
                             <input type="text" id="passWord" class="form-control" required>
                         </div>
                         
                         
                         <div class="col-md-4 col-md-4">
                            <label for="confirmPassword" class="control-label">Confirm Password:</label>
                             <input type="text" id="confirmPassword" class="form-control" required>
                         </div>
                         
                         
                         <div class="col-md-4 col-md-4">
                            <label for="firstName" class="control-label">First Name:</label>
                             <input type="text" id="firstName" class="form-control" required>
                         </div>
                         
                         
                         <div class="col-md-4 col-md-4">
                             <label for="lastName" class="control-label">Last Name:</label>
                             <input type="text" id="lastName" class="form-control" required>
                         </div>
                         
                         
                         <div class="col-md-4 col-md-4">
                            <label for="address" class="control-label">Address:</label>
                             <input type="text" id="address" class="form-control" required>
                         </div>
                         
                         
                   <div class="col-sm-12">
                      <div class="col-sm-4"></div>
                      <div class="col-sm-4"><button type="submit" class="btn">Register</button></div>
                      <div class="col-sm-4"></div>
                       
                   </div>
                             
                            
                        
                 </div> <!-- form group ends -->
            </form>
        </div> <!-- form ends -->
        </div> <!-- row ends -->
    </div>  <!-- container ends -->
        
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	</body>
</html>