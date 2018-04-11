<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-us">
	<head>
		<title>Dashboard</title>
			<meta charset='utf-8'>
			<meta name='description' content='Add a description here'>
			<meta name='keywords' content='Add page keywords separated by commas'>
			<meta name='author' content='Your name and/or email here'>
			<!-- meta tag for responsive behaviour -->
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<!-- bootstrap cdn jquery library -->
			<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<style>
        
        .navbar-fixed-left {
            width: 225px;
            position: fixed;
            border-radius: 8px;
            height: 100%;
            font-size: 1.5em;
            background-color: firebrick;
            padding-left: 5px;  
        }
        
        a {
            color: white;
            text-align: center;
        }
        
        li {
            border-bottom: solid 1.5px black;
        }
        
    .logo {
        background: url(flareLogo-Small.png);
        width: 140px;
        height: 80px;
        display: block;
        }

        
     .header {
            text-align: center;
            font-size: 25px;
            padding: 5px;
            padding-top: 15px;
        }
            
    .top-right-link{
            float: right;
            padding: 15px;
        }            
        </style>
	</head>
	<body>
        
        <div class="header">Welcome, User!</div>
        <div class="container-fluid">
        
	    <div class="top-right-link">
	        <button class="btn">Logout</button>
	    </div>
	    <div class="main">
	        
	    </div>
	    <div class="nav-bar">
	         <!-- Site Wide Navigation Bar  -->
	    <nav class="navbar-inverse navbar-fixed-left">
        <div class="logo"></div>
	        <ul class="nav nav-stacked">
                <li><a href "#">Home</a></li>
	            <li><a href "#">Agenda</a></li>
	            <li><a href "#">Chatrooms</a></li>
	            <li><a href "#">Clubs</a></li>
	            <li><a href "#">Courses</a></li>
	            <li><a href "#">Map</a></li>
	            <li><a href "#">Notes</a></li>
	            <li><a href "#">Report Card</a></li>
	            <li><a href "#">Study Area</a></li>
	            <li><a href "#">Timetable</a></li>
	        </ul>
	    </nav>
        </div>
	    </div>
	</body>
</html>