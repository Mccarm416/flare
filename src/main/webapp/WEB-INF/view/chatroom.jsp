<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
</head>
<body>
	<h1>Chatting with: <c:out value="${selectedUser}"/></h1>

	 <jsp:include page="chatbox.jsp"></jsp:include>
	 
</body>
</html>