<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html>
<head>
<style>
	#noteUpload {
		border:2px solid red;
		text-align: centre;
		
	}
	#noteDisplay {
		display: block;
		text-align: centre;
		border:2px solid red;
	}
	.note {
		border:1px solid black;
		max-width: 30%;
		margin-bottom: 10px;
		margin-left:auto;
		margin-right:auto;
		
	}
	.note:hover {
		box-shadow: 0 8px 16px 0 red;
	}
</style>
<title>Notes</title>
</head>
<body>
	<c:if test="${not empty message }">
		<h2><c:out value="${message}"/></h2>
	</c:if>
	<div id="noteUpload">
		<h2>Upload a File</h2>
		<c:choose>
			<c:when test="${not empty courseList}">
				<form method="POST" action="notesUpload" enctype="multipart/form-data" id="noteSubmission">
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
				</form>
			</c:when>
			<c:otherwise>
				<h2>You must have at least one course created to use this feature.</h1>
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
						<h3><c:out value="${note.fileName}"/></h3>
						<h4><c:out value="${note.courseName}"/></h4>
						<c:set var = "noteDescription" value = "${note.description}"/>
						<b>Description:</b><c:out value="${note.description}"/>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>