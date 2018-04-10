<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-us">
	<head>
		<title></title>
			<meta charset='utf-8'>
			<meta name='description' content='Add a description here'>
			<meta name='keywords' content='Add page keywords separated by commas'>
			<meta name='author' content='Your name and/or email here'>
			<!-- meta tag for responsive behaviour -->
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<!-- css style page for regisration -->
			<link rel="stylesheet" href="registrationStyle.css">
			<!-- bootstrap cdn jquery library -->
			<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	</head>
	
	<style>
        
        .navbar-fixed-left {
            width: 225px;
            position: fixed;
            height: 100%;
            font-size: 1.5em;
            background-color: firebrick;
            left: 0;
        }
        
        a {
            color: white;
            text-align: center;
        }
        
        #usernamedisplay {
        	color: white;
            text-align: center;
            font-size: 1.6em;
        }
        
        li {
            border-bottom: solid 1.5px black;
        }
        
        #profilepic {
        height:250px;
        width:223px;
        }
        .logo {
        background: url(flareLogo-Small.png);
        width: 140px;
        height: 90px;
        padding-left:40px;]
        }
    </style>
	<body>
	    
	    <!-- Site Wide Navigation Bar  -->
	    <div class="container-fluid">
	    <nav class="navbar-inverse navbar-fixed-left">
        <div class="logo"> <img src="${pageContext.request.contextPath}/resources/images/flareLogo-Small.png" class="text-center"/></div>
	        <ul class="nav nav-stacked">
                <li><a href="home">Home</a></li>
	            <li><a href="agenda">Agenda</a></li>
	            <li><a href="chat">Chatrooms</a></li>
	            <li><a href="clubs">Clubs</a></li>
	            <li><a href="courses">Courses</a></li>
	            <li><a href="maps">Map</a></li>
	            <li><a href="notes">Notes</a></li>
	            <li><a href="reports">Report Card</a></li>
	            <li><a href="study">Study Area</a></li>
	            <li><a href="timetable">Timetable</a></li>
	            <li><img id="profilepic" src="${pageContext.request.contextPath}/resources/images/user_images/profilepic_placeholder.png"/></li>
	            <li id="usernamedisplay">Sean</li>
	        </ul>
	    </nav>
        </div>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous">
        </script>
        <form>
        	<input type="hidden"
			name="${_csrf.parameterName}"
			value="${_csrf.token}"/>
        </form>
	</body>
</html>
