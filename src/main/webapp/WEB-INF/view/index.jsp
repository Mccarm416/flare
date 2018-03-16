<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coming Soon - Flare</title>
  
   <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    
    
    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Merriweather:300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
    <link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/coming-soon.css" />" rel="stylesheet">
    <!-- Image folder for this template -->
    <link href="<c:url value="/resources/images/light-bulb-icon.png" />">
</head>
  <body>
    <div class="overlay"></div>
    <div class="masthead">
      <div class="masthead-bg"></div>
      <div class="container h-100">
        <div class="row h-100">
          <div class="col-12 my-auto">
            <div class="masthead-content text-white py-5 py-md-0">
              <h1 class="mb-3">Welcome to Flare!</h1>
              <p class="mb-5">We're A Student Life Web Application. Get started with us to track and organize your acadamic life.
                <strong>Join Here Today</strong>! Sign up below for first time users or login with your existing account!</p>
                <form action="login">
                  <button class="btn btn-secondary" type="submit">Login!</button>
                  </form>
                  <form action="registration">
                  <button class="btn btn-secondary" type="submit" 
                  >Sign Up!</button>
                  </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>



    <!-- Plugin JavaScript
    <script src="vendor/vide/jquery.vide.min.js"></script>
    -->
    
    <!-- Custom scripts for this template
    <script src="js/coming-soon.min.js"></script>
    -->

</body>
</html>