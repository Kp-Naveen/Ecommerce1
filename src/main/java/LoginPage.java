
import java.io.*;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String a=request.getParameter("name");
		String b=request.getParameter("pass");
		String c=request.getParameter("select");
		if(c.equals("User")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from reg where name='"+a+"' and password='"+b+"'");
				if(rs.next()) {
					HttpSession hs=request.getSession();
					hs.setAttribute("name", a);
					response.sendRedirect("UserHome.jsp");
				}
				else {
					response.sendRedirect("LoginPage.jsp");
				}
			}
			catch(Exception h) {
				pw.println(h);
			}
		}
		if(c.equals("Admin")) {
			if(a.equals("admin") & b.equals("admin@123")) {
				response.sendRedirect("AdminHome.jsp");
			}
			else {
				response.sendRedirect("LoginPage.jsp");
			}
		}
	}

}
