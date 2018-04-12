<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Courses</title>
	<style>
		
		
		table {
		    font-family: arial, sans-serif;
		    border-collapse: collapse;
		    
		}
		
		td, th {
		    border: 2px solid black;
		    text-align: left;
		    padding: 4px;
		}
		
		tr:nth-child(even) {
		    background-color: indianred;
		}
		#divLeft{
			width:45%;
			display: inline-block;
			
			
		}
		#divRight{
			width:45%;
			float:right;
			display: inline-block;
		}
		#button{
			font-size:15px;
			border:2px;
			color:white;
			background-color:grey;
		}
		.wrapper{
			width: 780px;
		}
		
	</style>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<%@ include file="/WEB-INF/view/userBanner.jsp" %>
        <%@ include file="/WEB-INF/view/navBarMenu.jsp" %>
     
<div class = "col-md-12 col-md-push-2">
	<H1>Courses</H1>
	<c:set var="count" value="0" scope="page" />
	
	<c:choose>
 	<c:when test="${courseList!= null && !courseList.isEmpty() && editPressed == true}">
		<form action="/flare/courses">
			<table>
	  			<tr>
				   <th>Course Name</th>
				   <th>Course Code</th> 
				   <th>Delete</th>
				 </tr>
				<c:forEach items="${courseList}" var="CourseList">
					<tr>
						<td><c:out value="${CourseList.getCourseName()}"/></td>
						<td><c:out value="${CourseList.getCourseCode()}"/></td>
						<td><input type ="checkbox" Value="${CourseList.getCourseID()}" Name="delete" Style="text-align:center;"></td>
						<c:set var="count" value="${count + 1}" scope="page"/>
					</tr>
				</c:forEach>
				<c:forEach begin="${count}" end="7" varStatus="loop">
	    			<tr>
					   <td><input type = "text" name ="courseNameAdd${count}" maxlength="50" style="width:100%;"></td>
					   <td><input type = "text" name ="courseCodeAdd${count}" maxlength="8" style="width:100%;"></td> 
					   <c:set var="count" value="${count + 1}" scope="page"/>
				   </tr>
				</c:forEach>
			</table>		
			<input id="button" type="submit" Value="Save" name="CourseButton">	
			<input id="button" type="submit" Value="Cancel" name="CourseButton">	
		</form>
	</c:when>
	<c:when test="${courseList!= null && !courseList.isEmpty() && editPressed == false}">
	<div id = "divLeft">
		<form action="/flare/courses">
			<table class = "table1">
	  			<tr>
				   <th>Course Name</th>
				   <th>Course Code</th> 
				 </tr>
				<c:forEach items="${courseList}" var="CourseList">
					<tr>
						<td><c:out value="${CourseList.getCourseName()}"/></td>
						<td><c:out value="${CourseList.getCourseCode()}"/></td>
					</tr>
				</c:forEach>
			</table>		
			<input id="button" type="submit" Value="Edit" name="CourseButton">	
		</form>
		</div>
		<c:if test="${assignmentList!= null && !assignmentList.isEmpty() && editPressed == false}">
		<div id = "divRight">
		<H3>Upcoming Assignments</H3>
		<table>
			<tr>
			<th>Assignment</th>
			<th>Due Date</th>
			</tr>
	  		<c:forEach items="${assignmentList}" var="AssignmentList">
					<tr>
						<td><c:out value="${AssignmentList.getAssignmentName()}"/></td>
						<td><c:out value="${AssignmentList.getDueDate()}"/></td>
					</tr>
			</c:forEach>
		</table>
		</div>
		</c:if>
	</c:when>
	<c:otherwise>
		<p>Please enter up to 8 courses!</p>
		<form action="/flare/courses">
			<table>
	  			<tr>
				   <th>Course Name</th>
				   <th>Course Code</th> 
				 </tr>
				<c:forEach begin="${count}" end="7" varStatus="loop">
	    			<tr>
					   <td><input type = "text" name ="courseNameAdd${count}" maxlength="50" style="width:100%;"></td>
					   <td><input type = "text" name ="courseCodeAdd${count}" maxlength="8" style="width:100;"></td> 
					   <c:set var="count" value="${count + 1}" scope="page"/>
				   </tr>
				</c:forEach>
			</table>		
			<input id="button" type="submit" Value="Save" name="CourseButton">	
		</form>
	</c:otherwise>
	</c:choose>
</div>
   <%@ include file="/WEB-INF/view/Footer.jsp" %>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous">
   
</body>
</html>