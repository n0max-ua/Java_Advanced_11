<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<form action="reg" method ="post">
		<label for="firstName">First name</label> <br> <input name="firstName"><br>
		<label for="lastName">Last name</label> <br> <input name="lastName"><br>
		<label for="email">Email</label> <br> <input name="email"> <br>
		<label for="password">Password</label> <br> <input type="password" name="password"><br>
		<input type="submit" value="Submit" style="margin-top: 10px">
	</form>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>