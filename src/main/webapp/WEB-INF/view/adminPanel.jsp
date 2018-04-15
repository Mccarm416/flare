<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ page import="flare.dataaccess.FlareDB" %>
  <%@ page import="java.util.List" %>
   <%@ page import="java.util.Map" %>
	
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
                background-color: firebrick;
            }
            
            .header {
                color: white;
                text-align: center;
                padding: 1.5rem;
            }
            
            .content {
                color: white;
                width: 100%;
                min-height: 400px;
              
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
                bot:0;
 
                
            }
            
            #onediv {
                           text-align: center;
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
            
            #btn {
            margin-left:45%;
                background-color: #4CAF50;
                color: white;
                width: 90px;
        		height: 40px;
        		border-radius: 12px;
            
            }
            
            #customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
   	margin-left: 40%;
   	position: fixed;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
    
}

#customers tr:nth-child(even){background-color: white;
color:black;}

#customers tr:nth-child(odd){background-color: lightblue;
color: black;}

#stuff {

margin-left:35%;
}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}

h3 {
	text-align: center;

}
            
        </style>
	</head>
	<body>
	    <div class="header">
            <h1>Hello Admin User!</h1>
            <blockquote>Please select an option below:</blockquote>	 
            </div>
            
        <div class="content">
        <table id="customers">
        <tr>
        	<th>Registered User</th>
        	<th>Account Status</th>
        </tr>
        <%
        String sql = "SELECT userid, users.username, `password`, email, firstname, lastname, accountcreation,"
  			  + " displaypicture, enabled, currentyear, semester, authority"
  			   +" FROM users"
  			  +"  JOIN authorities"
  			  + " ON users.username = authorities.username";
  		List<Map<String,Object>> list = FlareDB.getJdbc().queryForList(sql);
  		
  		for(int index = 0 ; index < list.size() ; index++){
  	        Map<String, Object> listItem = list.get(index);
  		 
  	      out.println(
  	    	"<tr>" + "<td>" + listItem.get("username")+"</td>" 
  	     	+ "<td>"+ listItem.get("enabled") + "</td>");
  	      } %>
  
          </table>   
        </div>
        
        <div class="footer">
        <div id="onediv" style="background-color: #FF9494"><h3>${msg}</h3></div>
        
         <form:form action="admin" method="post" id="stuff">
         <label>Username</label>
        <input name="username" type="text" maxsize="50">
        <input type="submit" name="ban" value="Die!">
		<input type="submit" name="ban" value="Live!">
        </form:form> 
               <form:form  action="${pageContext.request.contextPath}/logout"><input id="btn" class="button" type="submit" value="Logout"></form:form>
         </div>  
	</body>
</html>