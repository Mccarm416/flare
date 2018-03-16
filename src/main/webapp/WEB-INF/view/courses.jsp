<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Courses</title>
	<style>
		span {
		    border-top: 1px solid #333;
		    width: 100%;
		    height: 1px;  
		}
		
		table {
		    font-family: arial, sans-serif;
		    border-collapse: collapse;
		}
		
		td, th {
		    border: 1px solid #dddddd;
		    text-align: left;
		    padding: 4px;
		}
		
		tr:nth-child(even) {
		    background-color: #dddddd;
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
		
	</style>
</head>
<body>
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
			<input type="submit" Value="Save" name="CourseButton">	
			<input type="submit" Value="Cancel" name="CourseButton">	
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
			<input type="submit" Value="Edit" name="CourseButton">	
		</form>
		</div>
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
			<input type="submit" Value="Save" name="CourseButton">	
		</form>
	</c:otherwise>
	</c:choose>

</body>
</html>