<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="#" method="post">
		Email <input type="email" name="f1"><br> <br> <input
			type="submit"> <a href="LoginPage.jsp"> click here to
			login</a>
	</form>
	<%
	String a = request.getParameter("f1");
	if (a != null) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from reg where email='" + a + "'");
			if (rs.next()) {
		out.println("your password is " +  rs.getString(2));
			} else {
		response.sendRedirect("forgotPage.jsp");
			}
		} catch (Exception h) {
			out.print(h);
		}
	}
	%>
</body>
</html>