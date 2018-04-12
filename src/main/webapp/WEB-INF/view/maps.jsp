<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html LANG="en-us">
	<head>
		<!-- Optional theme -->
		<link rel="stylesheet" href="<c:url value="/resources/css/maps.css" />">
		<!-- bootstrap cdn jquery library -->
			<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	</head>
	<body>
		
        <%@ include file="/WEB-INF/view/userBanner.jsp" %>
		<%@ include file="/WEB-INF/view/navBarMenu.jsp" %>
		<div style="z-index: 1" id="inputs" class="text-center col-lg-12 col-lg-push-6">
			<label style="z-index: 1"> Enter the classroom; e.g. C416 </label>
			</br>
			<input style="z-index: 1" type="text" id="classData">
			</br>
			<button style="z-index: 1" onClick="classFinder()" >Find My Class</button>
			</br>
			
		</div>
		<div  style="z-index: 0">
			<img id="imageContainer" style="z-index: 0" class="col-md-3 col-md-push-2" />
		</div>
		 <%@ include file="/WEB-INF/view/Footer.jsp" %>
		<script src="<c:url value="/resources/js/maps.js" />"></script>

	</body>
</html>