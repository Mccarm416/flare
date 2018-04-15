<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
 <meta charset="UTF-8">
	<style>
	
        body {
            font-family: sans-serif;
            color: black !important;
            font-size: 1.2rem;
        }
        
        h1{
            margin: 0 auto;
        }
        
        .wrapper {
            width: 35%;
            background-color: #A63A31 !important;
            padding: 20px;
            border: 1px solid black;
            display:inline-block;
            float: left;
            margin-left: 20%;
        }
        
        .wrapper2 {
            width: 25%;
            background-color:#A63A31 !important;
            float: left;
            display:inline-block;
            margin-left: 10px;
            
        }
        
		#noteUpload {
			text-align: center;
		}
		
		h2 {
            text-align: center;
		}
        
		h3 {
			font-size: 21px;
		}
        
		#noteDisplay {
            margin: 10px auto;
            text-align: center;
		}
        
        .downloadBox{
            width: 350px;
            margin: auto;
            
        }
        
		.note {
			border:2px solid black;
			max-width: 30%;
			margin: 10px auto;
			position: relative;
			text-align: center;
            padding: 2.5rem;
			
		}
        
		.note b{
			text-decoration: none;
		}
		
		.note, form{
			width: 75%;
            display: inline-grid;
		
		}
		.note:hover {
			box-shadow: 0 16px 32px 0 red;
		}
        
        .button {
            font-size: 15px;
            background-color: indianred;
            border: 2px solid black;
            color: white;
        }
        
        .button:hover {
            background-color: gray;
        } 	
		
	</style>
<title>Notes</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
 <%@ include file="/WEB-INF/view/userBanner.jsp" %>
        <%@ include file="/WEB-INF/view/navBarMenu.jsp" %>
        
        <div class = "col-md-12 col-md-push-2">
	<c:if test="${not empty message }">
		<h2><c:out value="${message}"/></h2>
	</c:if>
	<div id="noteUpload">
		<h2>Upload a File</h2>
		<c:choose>
			<c:when test="${not empty courseList}">
				<form:form method="POST" action="notesUpload" enctype="multipart/form-data" id="noteSubmission">
					Select file to upload <input type="file" name="file">
					<br>
					<br>
					File Name: <input type="text" name="fileName">
					<select name="fileCourse" form="noteSubmission">
						<option selected disabled>-- Course Select --</option>
						<c:forEach items="${courseList}" var="courseList">
								<option value="${courseList.getCourseName()}">${courseList.getCourseName()}</option>
						</c:forEach>
					</select>
					<br>
					Description <textarea name="fileDescription" rows="4" cols="12" form="noteSubmission" placeholder="Optional"></textarea>
					<br>
					<input type="submit" value="Upload"> 
				</form:form>
			</c:when>
			<c:otherwise>
				<h2>You must have at least one course created to use this feature.</h2>
			</c:otherwise>
		</c:choose>
	</div>
	<div id="noteDisplay">
		<h2>Uploaded Notes</h2>
		<c:choose>
			<c:when test="${empty noteList }">
				<h2> - No Notes Uploaded - </h2>
			</c:when>
			<c:otherwise>
				<c:forEach items="${noteList}" var="note">
					<div class="note">
						<form method="POST" action="notesDownload">
							<h3><c:out value="${note.fileName}"/></h3>
							<h4><c:out value="${note.courseName}"/></h4>
							<b>Description</b>
							<br>
							<c:out value="${note.description}"/>
							<br>
							<input type="submit" value="Download"/>
							<input type="hidden" value="${note.noteId }" name="noteId"/>
						</form>
						<form method="POST" action="notesDelete">
							<input type="hidden" value="${note.noteId }" name="noteId"/>
							<input type="submit" value="Delete"/>
						</form>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
	
</div>
	<%@ include file="/WEB-INF/view/Footer.jsp" %>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"/>
   
</body>
</html>