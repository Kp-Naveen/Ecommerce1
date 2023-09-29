<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>User Registration</h1>
	<h2>Fill your Details</h2>
	<form action="UserReg" method="post">
		Username <input type="text" name="n1"><br> <br>
		Password <input type="password" name="n2"><br> <br>
		Confirm Password <input type="password" name="n3"><br> <br>
		Email <input type="Email" name="n4"><br> <br> Select
		Question <select name="n5">
			<option>what is your birthday date</option>
			<option>what is your School name</option>
		</select> <br> <br> Answer <input type="text" name="n6"> <br>
		<br> <input type="submit">
	</form>

</body>
</html>