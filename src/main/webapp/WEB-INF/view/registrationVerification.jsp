<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- bootstrap cdn jquery library -->
<link rel="stylesheet" type="text/css" href="resources/css/loginValidationStyle.css">
			<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Registration - please verify your registration!</title>
<link href='http://fonts.googleapis.com/css?family=Berkshire+Swash' rel='stylesheet' type='text/css'>
</head>

<body>
<div id="div" class="container-fluid">
<label  class=label col-md-5 col-md-push-3" style="margin:0 auto" class="text-center">Enter the token sent to your email below to activate </label></br>

<form class="form text-center col-md-5 col-md-push-3" style="margin:0 auto" "method="post" action="registrationVerification">	
	<input  style="margin:0 auto"  class ="text-center" type="text" name="tokenFromUser"></br>
	<input type="hidden" name="username" value="${username}">
	<input type="hidden" name="password" value="${password}">
	<input type="hidden" name="firstname" value="${firstname}">
	<input type="hidden" name="lastname" value="${lastname}">
	<input type="hidden" name="year" value="${year}">
	<input type="hidden" name="semester" value="${semester}">
	<input type="hidden" name="email" value="${email}">
	<input type="hidden" name="token" value="${token}">
	<button  style="margin:0 auto" type="submit" class="btn-lg  btn-success mx-auto width:300px">Activate</button>
	<input type="hidden"
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
</form>
</div>
<p id="thing">
Thanks for Joining FLARE!
</P>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>