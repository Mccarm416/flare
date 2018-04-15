<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
    
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

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>





 <body>
 <%@ include file="/WEB-INF/view/userBanner.jsp" %>
        <%@ include file="/WEB-INF/view/navBarMenu.jsp" %>
        
        <div class = "col-md-12 col-md-push-2">
 
 
 
 <div id="timeBox">
 

 
  
  
  


 
<form method="POST" action="getCourseList" id="courseSelect" name="courseSelect">
	<select id="courseList" name="courseList" onchange="document.getElementById('courseSelect').submit()">
						<option selected disabled>Select Course</option>
						<c:forEach items="${courseList}" var="courseList">
								<option value="${courseList.getCourseID()}">${courseList.getCourseName()}</option>
						</c:forEach>
	</select>
   
  </form>  
 
 <form method="POST" action="postTime" id="assignmentSelect" name="assignmentSelect">
	<select name="assignmentList" form="assignmentSelect" action="assignmentSelect">
						<option selected disabled>Select Assignment</option>
						<c:forEach items="${assignmentList}" var="assignmentList">
								<option value="${assignmentList.getAssignmentID()}">${assignmentList.getAssignmentName()}</option>
						</c:forEach>
	</select>
	
	
	
	
  </form>  
 
 
 

<br> <br> <br>
	 Hours: <input type="text" class="hrs" id="hrs" name="hrs" value="0" size="3" maxlength="2" /> 
 Minutes: <input type="text" class="mns" id="mns" name="mns" value="0" size="3" maxlength="3" /> 
 Seconds: <input type="text" class="sec" id="sec" name="sec" value="0" size="3" maxlength="3" /> 
 
 <br>
    <div class="values">00:00:00</div>
<br>
        <button class="startButton">Start</button>
        <button class="pauseButton" >Pause</button>
        <button class="stopButton">Stop</button>
        <button class="resetButton">Reset</button>

        
   <br>

            
</div>
	
  <script type="text/javascript" src="<c:url value="/resources/lib/easytimer.min.js" />"> </script>
  <script type="text/javascript" src="<c:url value="/resources/js/TimerControls.js" />"> </script>
  
  
  <%@ include file="/WEB-INF/view/Footer.jsp" %>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous">
   
</body>

</html>