
import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderPage
 */
@WebServlet("/OrderPage")
public class OrderPage extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String a=request.getParameter("n11");
		String b=request.getParameter("n12");
		int c=Integer.parseInt(request.getParameter("n13"));
		int d=Integer.parseInt(request.getParameter("n14"));
		String e=request.getParameter("n15");
		String f=request.getParameter("n16");
		int dbqu;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","");
			Statement st=con.createStatement();
			Statement st1=con.createStatement();
			ResultSet rs=st.executeQuery("select * from course where cname='"+b+"' ");	
			if(rs.next()) {
		              
				    dbqu=rs.getInt(5);
				    
				    if(d<dbqu)
				    {
				    	int ah=dbqu-d;
					st.executeUpdate("update course set cseat='"+ah+"' where cname='"+b+"'");
					st1.executeUpdate("insert into userorder values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"')");
				    response.sendRedirect("endPage.jsp");
				    }
				   
				
			}
			 else {
			    	response.sendRedirect("OrderPage.jsp");
			    }
			
		}
			
		catch(Exception h)
		{
			pw.println(h);
		}
		
	}

}
