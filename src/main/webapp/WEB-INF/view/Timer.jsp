<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>


<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Press+Start+2P" rel="stylesheet">

<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flare Study Timer</title>
</head>





 <body>
 
 <form:form modelAttribute="myform" action="result" method="get" >
 
 <form:select  path="nameOfInstitution">
    <form:option value="NONE"></form:option>
    <form:options items="${courseNames}"></form:options>
 </form:select>
 
 </form:form>
 
 
 <select>
 <option value="" disabled selected>Choose a course</option>
 <option> COMP 3095</option>
 <option> GSCC 1078</option>
 </select>
 
 <select>
 <option value="" disabled selected>Choose an Assignment</option>
 <option>Java Course Assignment</option>
 <option>SQL Server Assignment</option>
 </select>
 
 
 <div id="timeBox">
 
 <form method="get" >
 Hours: <input type="text" id="hrs" name="hrs" value="0" size="3" maxlength="2" /> 
 Minutes: <input type="text" id="mns" name="mns" value="0" size="3" maxlength="3" /> 
 Seconds: <input type="text" id="sec" name="sec" value="0" size="3" maxlength="3" /> 
  <input type="submit" id="btnTarg">
 </form>
    <div class="values">00:00:00</div>

        <button class="startButton">Start</button>
        <button class="pauseButton" >Pause</button>
        <button class="stopButton">Stop</button>
        <button class="resetButton">Reset</button>
        
        <button class="switch">Switch</button>
      
</div>

<select id="recordedTimes" size=4>
<option>00:01:02</option>
<option>00:09:99</option>

<c:forEach var="listValue" items="${lists}">
				<option>${listValue}</option>
			</c:forEach>
</select>
            	
  <script type="text/javascript" src="<c:url value="/resources/js/lib/easytimer.min.js" />"> </script>
  <script type="text/javascript" src="<c:url value="/resources/js/TimerControls.js" />"> </script>
  
</body>

</html>