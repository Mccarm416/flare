<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inbox</title>
<style>
body {
        font-family: sans-serif;
        text-align: center;
        color: black !important;
        font-size: 1.5rem;    
    }
    
    .wrapper {
         width: 780px;
         background-color: #A63A31 !important;
         margin: auto;
         padding: 20px;
         border: 1px solid black;
    }
    
    .activeChats {
        margin-left: 350px;
    }

    
    table {
    border-collapse: collapse;
    text-align: center;
}

    table, td {
    border: 1px solid black;
}

    td {
	padding: 5px;
}
    .buttonSearch {
        font-size: 20px;
        border: 1px solid black;
        background-color: gray;
    }
    
    .buttonSearch:hover, .userButton:hover {
        background-color: indianred;
    }

/* Centers the button */
.userButton {
	display: block;
	margin:auto;
    font-size: 20px;
    border: 1px solid black;
    background-color: gray;
</style>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	<%@ include file="/WEB-INF/view/userBanner.jsp" %>
    <%@ include file="/WEB-INF/view/navBarMenu.jsp" %>
    <div class = "col-md-12 col-md-push-2">
	<h1>Inbox</h1>
	<c:if test="${not empty errorMessage }">
		<h2><c:out value="${errorMessage}"/></h2>
	</c:if>
	<h2>Your Active Chats</h2>
	<table>
	<c:forEach items="${chatUsers}" var="user">
		<tr>
			<td>
				<form action="chatroom" method="POST">
					<input type="submit" class="userButton" name="selectedUser" value="<c:out value="${user.userName}"/>"/>
				</form>
			</td>
		</tr>
	</c:forEach>
	</table>
	<br>
	<b>Search for user:</b>
		<form action="userSearch" method="POST">
			<input type="text" name="userFind"/>
			<input type="submit" value="Search"/>
		</form>
</div>	
	<%@ include file="/WEB-INF/view/Footer.jsp" %>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"/>
   
</body>
</html>