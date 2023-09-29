
import java.io.*;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserReg
 */
@WebServlet("/UserReg")
public class UserReg extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String a=request.getParameter("n1");
		String b=request.getParameter("n2");
		String c=request.getParameter("n3");
		String d=request.getParameter("n4");
		String e=request.getParameter("n5");
		String f=request.getParameter("n6");
		
		try {
			if(b.equals(c)) {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","");
				PreparedStatement ps=con.prepareStatement("insert reg values(?,?,?,?,?)");
				ps.setString(1,a);
				ps.setString(2,b);
				ps.setString(3,d);
				ps.setString(4,e);
				ps.setString(5,f);
				ps.executeUpdate();
				response.sendRedirect("LoginPage.jsp");
				
			}
			else {
				response.sendRedirect("userreg.jsp");
			}
		}
		catch(Exception h) {
			pw.println(h);
		}
	}

}
