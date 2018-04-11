<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-us">
	<head>
		<title>Admin User Panel</title>
			<meta charset='utf-8'>
			<meta name='description' content='Add a description here'>
			<meta name='keywords' content='Add page keywords separated by commas'>
			<meta name='author' content='Your name and/or email here'>
		<style>
            
            body {
                font-family: sans-serif;
                background-color: lightslategrey;
            }
            
            .header {
                color: white;
                text-align: center;
                padding: 1.5rem;
            }
            
            .content {
                color: white;
            }
            
            ul li {
                padding: 1rem;
                list-style-type: none;
            }
            
            a {
                color: white;
                text-decoration: none;
            }
            
            .footer {
                background-color: white;
                padding: 5rem;
            }
            
            button {
                background-color: dodgerblue;
                color: white;
                font-size: 15px;
                float: right;
                padding: 12px;
                border-top-width: 0px;
                border-bottom-width: 0px;
                border-left-width: 0px;
                border-right-width: 0px;
                margin-top: 8px;
                margin-bottom: 8px;
                margin-left: 8px;
                margin-right: 8px;

                
            }
        </style>
	</head>
	<body>
	    <div class="header">
            <h1>Hello Admin User!</h1>
            <blockquote>Please select an option below:</blockquote>	 
            </div>
            
        <div class="content">
             <ul>
                 <li><a href="#">create club</a></li>
                 <li><a href="#">manage club</a></li>
                 <li><a href="#">edit club</a></li>
                 <li><a href="#">create user</a></li>
                 <li><a href="#">edit user</a></li>
                 <li><a href="#">add club</a></li>
            </ul>
        </div>
        
        <div class="footer">
               <form:form action="${pageContext.request.contextPath}/logout"><input type="submit" value="Logout"></form:form>
        </div>  
        <form>
        <input type="hidden"
			name="${_csrf.parameterName}"
			value="${_csrf.token}"/>
        </form>  
	</body>
</html>