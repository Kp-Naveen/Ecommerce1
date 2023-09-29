<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome, Login Here</h1>
	<form action="LoginPage" method="post">
		<select name="select">
			<option>User</option>
			<option>Admin</option>
		</select> <br> <br> Username <input type="text" name="name">
		<br> <br> password <input type="password" name="pass">
		<br> <br> <a href="forgotPage.jsp">forgotPassword </a> <br>
		<br> <input type="submit">
	</form>
</body>
</html>