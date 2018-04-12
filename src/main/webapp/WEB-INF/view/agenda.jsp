<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
	function ClickedOnCalendar(x)
	{
	 	document.location.href = "http://localhost:8080/flare/agenda?date=" + x;
	}
</script>

<title>Agenda</title>
	<style>
	
		#divRight{
			width:25%;
			float:left;
			display: inline-block;
			background-color: none;
			 background-color:  #A63A31;
		}
		
		#day {
		  	text-align: right;
		  	color:Gold;
		  	font-size:120%;
		  	
		}
		#assignment{
			font-size:80%;
		}
		
		span {
		    border-top: 1px solid #333;
		    width: 100%;
		    height: 1px;
		    
		}
	
		s
		table {
		    font-family: arial, sans-serif;
		    background-color:crimson;
		   table-layout:fixed;
		  
	
		}
		th{
			table-layout:fixed;
		}
		td, th {
		 
		    
			width:120px;
		   
		  
		    padding: 2px; 
		 	 border: 1px solid #dddddd;
		}
		
		#blank{
		 	background-color:grey;
		}
		
		th{
			
			text-align: center;
		}
		
		td{
			
			height:90px;
			 text-align: left;
			 vertical-align: top;
		}
		
		tr:nth-child(even) {
		    background-color: none;
		}
	
		#calendar{
		float:left;
			display: inline-block;
  		    width:67%;
  		     background-color:  #A63A31;
		}
		#link
		{
		    cursor: pointer;
		}
		#calendarTitle{
			padding-left:24%;
			font-size:200%;		
		}
		body{
			 color:white;
			 font-family:sans-serif;
		}
		
		#button{
			font-size:15px;
			border:2px;
			color:white;
			background-color:grey;
		}
		
		
	
	</style>
</head>
<body>
<%@ include file="/WEB-INF/view/userBanner.jsp" %>
        <%@ include file="/WEB-INF/view/navBarMenu.jsp" %>
     
<div class = "col-md-12 col-md-push-2" style="padding-top:12px">
     

	<form action="/flare/agenda">
	<div id="calendar">
		<input type="hidden" name="selectedDay" value="${calendarBlueprint.getDay()}">    
		<input type="hidden" name="selectedMonth" value="${calendarBlueprint.getMonth()}">   
		<input type="hidden" name="selectedYear" value="${calendarBlueprint.getYear()}">   

	
		<div id="calendarTitle">	
		<input id="button" type="submit" Value="-Previous-" name="AgendaButton">
		${calendarBlueprint.getMonthName()} ${calendarBlueprint.getYear()}
		<input id="button" type="submit" Value="-Next-" name="AgendaButton">
		</div>
		
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
					<td id="blank">
				    </td> 	  
				    <c:set var="i" value="${i + 1}" scope="page"/>
				</c:forEach>
				
				<c:forEach begin="${d}" end="${calendarBlueprint.getDaysInMonth()}" varStatus="loop">
					
					<c:if test="${d < 10}">
						<c:set var="x" value="${dateString}0${d}" scope="page" />
					</c:if>
					<c:if test="${d >= 10}">
							<c:set var="x" value="${dateString}${d}" scope="page" />
					</c:if>	
					<c:if test="${x == dateStringYMD}">
						<td id="link" OnClick="ClickedOnCalendar('${x}')" style="border-color: gold;">
					</c:if>
					<c:if test="${x != dateStringYMD}">
						<td id="link" OnClick="ClickedOnCalendar('${x}')">
					</c:if>
						<div id="day">${d}</div>
						<div id="assignment">
						<c:forEach items="${assignmentList}" var="AssignmentList">
								<c:if test="${AssignmentList.getDueDate() == x }">
									-${AssignmentList.getAssignmentName()}
									<c:forEach items="${courseList}" var="CourseList">
										<c:if test="${AssignmentList.getCourseID() == CourseList.getCourseID()}">
											(${CourseList.getCourseCode()})<br><br>
										</c:if>
									</c:forEach>
									
								</c:if>
						</c:forEach>
						</div>
					    </td> 	 
					 <c:if test="${i % 7 == 0}">
						</tr>
						<tr>
					 </c:if>
					
					 <c:set var="i" value="${i + 1}" scope="page"/>
					 <c:set var="d" value="${d + 1}" scope="page"/>
				</c:forEach>
				
				<c:if test="${i % 7 != 1}">
					<c:if test="${i % 7 != 0}">
						<c:forEach begin="${i % 7}" end="7" varStatus="loop">
							<td id="blank">
						    </td> 
						    <c:set var="i" value="${(i % 7) + 1}" scope="page"/>
						</c:forEach>
					</c:if>
					<c:if test="${i % 7 == 0}">
							<td id="blank">
						    </td> 
					</c:if>
				</c:if>
			</tr>  
			
		</table>
	</div>
	
	<c:if test="${insertBox == true}">
		<div id="divRight">
			<input type="hidden" name="dateYMD" value="${dateStringYMD}">
			<p>Select Course</p>
			<select name="courseID">
				<c:forEach items="${courseList}" var="CourseList">
						<option value="${CourseList.getCourseID()}">${CourseList.getCourseName()}</option>
				</c:forEach>
			</select>
			<p>Enter Assignment</p> <input type="text" name="assignmentName">
			<Input type = "submit" name = "AgendaButton" value="Submit">
		
			<c:forEach items="${assignmentList}" var="AssignmentList">
								
								<c:if test="${AssignmentList.getDueDate() == dateStringYMD }">
								</br></br>
									<input type="hidden" name="Delete" value="${AssignmentList.getAssignmentID()}">
									${AssignmentList.getAssignmentName()} <input id="button" type="submit" name="AgendaButton" value="X">
								</c:if>
			
			</c:forEach>
			
				
				
		</div>
	</c:if>
	
	</form>
	</div>
	 <%@ include file="/WEB-INF/view/Footer.jsp" %>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous">
   
   
</body>
</html>