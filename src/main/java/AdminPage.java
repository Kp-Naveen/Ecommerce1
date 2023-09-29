
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminPage
 */
@WebServlet("/AdminPage")
public class AdminPage extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw =response.getWriter();
		try{
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","");
			PreparedStatement ps=con.prepareStatement("select * from reg");
			ResultSet rs=ps.executeQuery();
			pw.println("<html><body><table><tr><td>name</td><td>password</td><td>email</td><td>question</td><td>answer</td>/<tr>");
			while(rs.next()) {
				pw.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td> <td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td></tr>");
			}
			pw.println("</table></body></html>");
		}
		catch(Exception e) {
			pw.println(e);
			}
		
		try{
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","");
			PreparedStatement ps=con.prepareStatement("select * from course");
			ResultSet rs=ps.executeQuery();
			pw.println("<html><body><table><tr><td>Course ID</td><td>Course Name</td><td>Cousre Fees details</td><td>Available seats</td>/<tr>");
			while(rs.next()) {
				pw.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td> <td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td></tr>");
			}
			pw.println("</table></body></html>");
		}
		catch(Exception e) {
			pw.println(e);
			}
		try{
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","");
			PreparedStatement ps=con.prepareStatement("select * from userorder");
			ResultSet rs=ps.executeQuery();
			pw.println("<html><body><table><tr><td>Student Name</td><td>Course Selected</td><td>Cousre Fees details</td><td>seats taken</td><td> Addresss</td><td>Paytment method</td>/<tr>");
			while(rs.next()) {
				pw.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td> <td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td></tr>");
			}
			pw.println("</table></body></html>");
		}
		catch(Exception e) {
			pw.println(e);
			}
		}

}
