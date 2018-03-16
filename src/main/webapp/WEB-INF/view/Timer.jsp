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
 
 <select>
 <option>COMP 3095</option>
 <option>GSSCI 1135</option>
 </select>
 
 <div id="timeBox">
 
 <form method="get" >
 <input type="text" required>
  <input type="submit" value="Submit">
 </form>
    <div class="values">00:00:00</div>

        <button class="startButton">Start</button>
        <button class="pauseButton" >Pause</button>
        <button class="stopButton">Stop</button>
        <button class="resetButton">Reset</button>
        
        <button class="switch">Switch</button>
    </div>
</div>

<select size=4>
<option>00:01:02</option>
<option>00:09:99</option>
</select>
            	
  <script type="text/javascript" src="<c:url value="/resources/js/lib/easytimer.min.js" />"> </script>
  <script type="text/javascript" src="<c:url value="/resources/js/TimerControls.js" />"> </script>
  
</body>

</html>