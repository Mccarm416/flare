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

<script type="text/javascript">
	function ClickedOnTime(t, d)
	{
	 	document.location.href = "http://localhost:8080/flare/timetable?time=" + t +"&day=" + d;
	}
</script>

<title>Timetable</title>
	<style>
	
		#divRight{
			width:15%;
			float:left;
			display: inline-block;
			background-color: #A63A31;
			border-style:solid;
			padding:25px;
			
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
			
			height:10px;
			 text-align: left;
			 vertical-align: top;
		}
		
		tr:nth-child(even) {
		    background-color: none;
		}
	
		#timetable{
			display: inline-block;
  		    width:55%;
  		    float:left;
  		     background-color:  #A63A31;
			
		}
		#link
		{
		   
		    cursor: pointer;
		    font-size:80%;
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
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
</head>
<%@ include file="/WEB-INF/view/userBanner.jsp" %>
        <%@ include file="/WEB-INF/view/navBarMenu.jsp" %>
     
<div class = "col-md-12 col-md-push-2" style="padding-top:12px">
	<form action="/flare/timetable">
	<div id="timetable">			
		<table>
			<tr>
				<th id="blank"></th>
				<th>Monday</th> 
				<th>Tuesday</th>
				<th>Wednesday</th>
				<th>Thursday</th> 
				<th>Friday</th>
			</tr>
			<c:set var="i" value="1" scope="page" />
			<c:set var="d" value="1" scope="page"/>
			<c:set var="t" value="6" scope="page"/>
				<c:forEach begin="${i}" end="102" varStatus="loop">
					<c:if test="${i % 6 == 1}">
						<tr>
						<td>
						${t}:00
						</td>
					 </c:if> 
					 <c:if test="${i % 6 != 1 && i % 6 != 0}">
						
							 <c:if test="${t == time && d == day}">
							  		 <td id="link" OnClick="ClickedOnTime(${t}, ${d})" style="border-color: gold;">
							  		 		 		<c:forEach items="${timetableList}" var="TimetableList">
								  		 		<c:if test="${t == TimetableList.getTimeStart() && d == TimetableList.getTimeDay()}">
								  		 			<c:forEach items="${courseList}" var="CourseList">
								  		 				<c:if test ="${CourseList.getCourseID() == TimetableList.getCourseID()}">
								  		 					${CourseList.getCourseName()}<br>
								  		 					
								  		 					<c:if test ="${TimetableList.getLabLecture() == 0}">
								  		 					Lecture
								  		 					</c:if>
								  		 					<c:if test ="${TimetableList.getLabLecture() != 0}">
								  		 					Lab
								  		 					</c:if>
								  		 					<br>
								  		 					Rm: ${TimetableList.getRoom()}
								  		 					
								  		 					
								  		 				</c:if>
								  		 			</c:forEach>
								  		 		</c:if>
								  		 		
								  		 		<c:if test="${d == TimetableList.getTimeDay() && t <= TimetableList.getTimeEnd()-1 && t > TimetableList.getTimeStart()   }">
								  		 		Continued...
								  		 		</c:if>
							  		 		</c:forEach>
							  		 
							  		 </td>
							  		  <c:set var="insertBox" value="${true}" scope="page"/>
							  </c:if>
							   <c:if test="${t != time || d != day}">
							  		<td id="link" OnClick="ClickedOnTime(${t}, ${d})">
							  		 		<c:forEach items="${timetableList}" var="TimetableList">
								  		 		<c:if test="${t == TimetableList.getTimeStart() && d == TimetableList.getTimeDay()}">
								  		 			<c:forEach items="${courseList}" var="CourseList">
								  		 				<c:if test ="${CourseList.getCourseID() == TimetableList.getCourseID()}">
								  		 					${CourseList.getCourseName()}<br>
								  		 					
								  		 					<c:if test ="${TimetableList.getLabLecture() == 0}">
								  		 					Lecture
								  		 					</c:if>
								  		 					<c:if test ="${TimetableList.getLabLecture() != 0}">
								  		 					Lab
								  		 					</c:if>
								  		 					<br>
								  		 					Rm: ${TimetableList.getRoom()}
								  		 				</c:if>
								  		 			</c:forEach>
								  		 			
								  		 		</c:if>
								  		 		<c:if test="${d == TimetableList.getTimeDay() && t <= TimetableList.getTimeEnd()-1 && t > TimetableList.getTimeStart()   }">
								  		 		Continued...
								  		 		</c:if>
							  		 		</c:forEach>
							  		 	
							  		
							  		 </td>
							  </c:if>
						<c:set var="d" value="${d + 1}" scope="page"/>
					 </c:if>
					 
					 
					 
					  <c:if test="${i % 6 == 0}">
						    <c:if test="${t == time && d == day}">
							  		 <td id="link" OnClick="ClickedOnTime(${t}, ${d})" style="border-color: gold;">
							  		 		 <c:forEach items="${timetableList}" var="TimetableList">
								  		 		<c:if test="${t == TimetableList.getTimeStart() && d == TimetableList.getTimeDay()}">
								  		 			<c:forEach items="${courseList}" var="CourseList">
								  		 				<c:if test ="${CourseList.getCourseID() == TimetableList.getCourseID()}">
								  		 					${CourseList.getCourseName()}<br>
								  		 					
								  		 					<c:if test ="${TimetableList.getLabLecture() == 0}">
								  		 					Lecture
								  		 					</c:if>
								  		 					<c:if test ="${TimetableList.getLabLecture() != 0}">
								  		 					Lab
								  		 					</c:if>
								  		 					<br>
								  		 					Rm: ${TimetableList.getRoom()}
								  		 					
								  		 				</c:if>
								  		 			</c:forEach>
								  		 		
								  		 		</c:if>
								  		 		<c:if test="${d == TimetableList.getTimeDay() && t <= TimetableList.getTimeEnd()-1 && t > TimetableList.getTimeStart()   }">
								  		 		Continued...
								  		 		</c:if>
							  		 		</c:forEach>
							  		 
							  		 </td>
							  		 <c:set var="insertBox" value="${true}" scope="page"/>
							 </c:if>
							  <c:if test="${t != time || d != day}">
							  
							  		
							  			 <td id="link" OnClick="ClickedOnTime(${t}, ${d})">
							  			 
							  			 
										
							  		 		 <c:forEach items="${timetableList}" var="TimetableList">
								  		 		<c:if test="${t == TimetableList.getTimeStart() && d == TimetableList.getTimeDay()}">
								  		 			<c:forEach items="${courseList}" var="CourseList">
								  		 				<c:if test ="${CourseList.getCourseID() == TimetableList.getCourseID()}">
								  		 					${CourseList.getCourseName()}<br>
								  		 					
								  		 					<c:if test ="${TimetableList.getLabLecture() == 0}">
								  		 					Lecture
								  		 					</c:if>
								  		 					<c:if test ="${TimetableList.getLabLecture() != 0}">
								  		 					Lab
								  		 					</c:if>
								  		 					<br>
								  		 					Rm: ${TimetableList.getRoom()}
								  		 					
								  		 				</c:if>
								  		 			</c:forEach>
								  		 		</c:if>
								  		 		
								  		 		<c:if test="${d == TimetableList.getTimeDay() && t <= TimetableList.getTimeEnd()-1 && t > TimetableList.getTimeStart()   }">
								  		 		Continued...
								  		 		
								  		 		
								  		 		</c:if>
							  		 		</c:forEach>
							  		 </td>
							</c:if>
							</tr>
							<c:set var="t" value="${t + 1}" scope="page"/>
							<c:set var="d" value="${d = 1}" scope="page"/>
					</c:if>
					
	
					 
					 <c:set var="i" value="${i + 1}" scope="page"/>
					 
					 
					 
					 
				</c:forEach>
		</table>
	</div>
	
	<c:if test="${insertBox == true}">
		<input type="hidden" name="dayOfWeek" value="${day}">
		<input type="hidden" name="timeStart" value="${time}">
		<div id="divRight">
			<p>Select Course</p>
			<select name="courseID">
				<c:forEach items="${courseList}" var="CourseList">
						<option value="${CourseList.getCourseID()}">${CourseList.getCourseName()}</option>
				</c:forEach>
			</select>
			<br><br>
			End Time:
			<select name="timeEnd">
				<c:set var="timeSlot" value="${time + 1}" scope="page"/>
				<c:forEach begin="${timeSlot + 1}" end="24" varStatus="loop">
					<option value="${timeSlot}">${timeSlot}:00</option>
					<c:set var="timeSlot" value="${timeSlot + 1}" scope="page"/>
				</c:forEach>
			</select>
			<br><br>
			Room: <Input type = "text" name ="room">
			<br><br>
			
			
			Lab or Lecture?
			<select name="labLecture">
				<option value="0">Lecture<option>
				<option value="1">Lab<option>
			</select>
			<Input id="button" type = "submit" name = "TimetableButton" value="Submit">
			
			
			<c:forEach items="${timetableList}" var="TimetableList">
								
								<c:if test="${TimetableList.getTimeStart() == time && TimetableList.getTimeDay() == day}">
								</br></br></br></br>
									<input type="hidden" name="Delete" value="${TimetableList.getTimetableID()}">
									Clear: <input id="button" type="submit" name="TimetableButton" value="X">
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