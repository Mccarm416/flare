<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agenda</title>
	<style>
		span {
		    border-top: 1px solid #333;
		    width: 100%;
		    height: 1px;
		    
		}
		p {
			display: inline-block;
		
		}
		s
		table {
		    font-family: arial, sans-serif;
		    background:crimson;
	
		}
		
		td, th {
		    border: 1px solid #dddddd;
		    text-align: left;
		    padding: 4px;
		}
		
		tr:nth-child(even) {
		    background-color: #dddddd;
		}
	
		#divRight{
			width:40%;
			float:right;		
		}
		#calendar{
		
  		  width:60%;
		}
		
		
	</style>
</head>
<body>
	<form action="/flare/agenda">
	<div id="calendar">
		<input type="hidden" name="selectedDay" value="${calendarBlueprint.getDay()}">    
		<input type="hidden" name="selectedMonth" value="${calendarBlueprint.getMonth()}">   
		<input type="hidden" name="selectedYear" value="${calendarBlueprint.getYear()}">   

		<input type="submit" Value="-Previous-" name="AgendaButton">
		<p>${calendarBlueprint.getMonthName()} ${calendarBlueprint.getYear()}</p>
		<input type="submit" Value="-Next-" name="AgendaButton">
		
		<table>
			<tr>
				<th>Sunday</th>
				<th>Monday</th> 
				<th>Tuesday</th>
				<th>Wednesday</th>
				<th>Thursday</th> 
				<th>Friday</th>
				<th>Saturday</th>
			</tr>
			<c:set var="i" value="1" scope="page" />
			<c:set var="d" value="1" scope="page" />
			<tr>
				<c:forEach begin="${i}" end="${calendarBlueprint.getStartDay() -1}" varStatus="loop">	    	
					<td>
				    </td> 	  
				    <c:set var="i" value="${i + 1}" scope="page"/>
				</c:forEach>
				
				<c:forEach begin="${d}" end="${calendarBlueprint.getDaysInMonth()}" varStatus="loop">
					<td>
						<p>${d}</p>
				    </td> 	  
					    <c:if test="${i % 7 == 0}">
							</tr>
							<tr>
					    </c:if>
					   
				    <c:set var="i" value="${i + 1}" scope="page"/>
				    <c:set var="d" value="${d + 1}" scope="page"/>
				</c:forEach>
				<c:if test="${i % 7 != 0}">
					<c:forEach begin="${i % 7}" end="7" varStatus="loop">
						<td>
					    </td> 
					    <c:set var="i" value="${(i % 7) + 1}" scope="page"/>
					</c:forEach>
				</c:if>
			</tr>  
			
		</table>
	</div>
	<div id="rightDiv">
		<p>Select Course</p>
		<select name="Course">
			<c:forEach items="${courseList}" var="CourseList">
					<option value="${CourseList.getCourseName()}">${CourseList.getCourseName()}</option>
			</c:forEach>
		</select>
		Enter Assignment: <input type="text">
		
		<Input type = "submit" name = "Create Assignment">
			
	</div>
	
	
	</form>
</body>
</html>