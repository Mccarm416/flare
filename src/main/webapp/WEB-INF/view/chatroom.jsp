<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
    margin: 0 auto;
    max-width: 800px;
    padding: 0 20px;
}

.message {
    border: 2px solid #dedede;
    background-color: #550600;
    color: white;
    border-radius: 5px;
    padding: 10px;
    margin: 10px 0;
    text-align: right;
}

.receiver {
    border-color: #ccc;
    background-color: #A63A31;
    text-align: left;
}

.message::after {
    content: "";
    clear: both;
    display: table;
}

.message img {
    float: left;
    max-width: 60px;
    width: 100%;
    margin-right: 20px;
    border-radius: 50%;
}

.message img.right {
    float: right;
    margin-left: 20px;
    margin-right:0;
}

.time-right {
    float: right;
    color: #aaa;
}

.time-left {
    float: left;
    color: #999;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chatroom</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	 <%@ include file="/WEB-INF/view/userBanner.jsp" %>
     <%@ include file="/WEB-INF/view/navBarMenu.jsp" %>
     <div class = "col-md-12 col-md-push-2">
     
	<h1>Chatting with: <c:out value="${selectedUser}"/></h1>
	 <jsp:include page="chatbox.jsp"></jsp:include>
	 </div>
	 	<%@ include file="/WEB-INF/view/Footer.jsp" %>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"/>
   
	 
</body>
</html>