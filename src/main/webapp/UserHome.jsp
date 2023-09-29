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
	<h1>
		Welcome
		<%
String a=session.getAttribute("name").toString();
out.println(a+"<br>");
%>
	</h1>
	<h2>
		<%
try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from course");	
	while(rs.next()) 
	{%>
		<form action="OrderPage.jsp" method="post">
			Course id : <input type="text" value=<%=rs.getString(1) %> name="n1">
			Course name :<input type="text" value=<%=rs.getString(2) %> name="n2">
			Couurse photo : <img src="<%=rs.getString(3) %>" name="n3">
			Course Fees :<input type="text" value=<%=rs.getString(4) %> name="n4">
			<input type="hidden" value=<%=rs.getString(5) %> name="n5"><br>
			<br> <input type="submit">
		</form>
		<%}
	
}
catch(Exception e){
	out.print(e);
}
%>
	</h2>





</body>
</html>