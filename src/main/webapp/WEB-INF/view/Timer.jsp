<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>


<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Press+Start+2P" rel="stylesheet">

<link href="<c:url value="/resources/css/timer.css" />" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flare Study Timer</title>
</head>





 <body>
 
 
 
 <div id="timeBox">
 

 
  
  

 
 
<form method="POST" action="course" enctype="multipart/form-data" id="courseSelect" name="courseSelect">
	<select id="courseList" name="courseList" onchange="document.getElementById('courseSelect').submit()">
						<option selected disabled>Select Course</option>
						<c:forEach items="${courseList}" var="courseList">
								<option value="${courseList.getCourseID()}">${courseList.getCourseName()}</option>
						</c:forEach>
	</select>
  </form>  
   
    
  


 
<form method="POST" action="time" id="assignmentSelect">
	<select name="assignmentList" form="assignmentSelect">
						<option selected disabled>Select Assignment</option>
						<c:forEach items="${assignmentList}" var="assignmentList">
								<option value="${assignmentList.getAssignmentID()}">${assignmentList.getAssignmentName()}</option>
						</c:forEach>
	</select>
  </form>  
 
 <br> <br> <br>
 
 <form method="get" action="" >
 Hours: <input type="text" id="hrs" name="hrs" value="0" size="3" maxlength="2" /> 
 Minutes: <input type="text" id="mns" name="mns" value="0" size="3" maxlength="3" /> 
 Seconds: <input type="text" id="sec" name="sec" value="0" size="3" maxlength="3" /> 
  <input type="submit" id="btnTarg">
 </form>
 <br>
    <div class="values">00:00:00</div>
<br>
        <button class="startButton">Start</button>
        <button class="pauseButton" >Pause</button>
        <button class="stopButton">Stop</button>
        <button class="resetButton">Reset</button>

        
   <br>
<select id="recordedTimes" size=4>
<c:forEach var="listValue" items="${lists}">
				<option>${listValue}</option>
			</c:forEach> 
</select>
            
</div>
	
  <script type="text/javascript" src="<c:url value="/resources/js/lib/easytimer.min.js" />"> </script>
  <script type="text/javascript" src="<c:url value="/resources/js/TimerControls.js" />"> </script>
  
</body>

</html>