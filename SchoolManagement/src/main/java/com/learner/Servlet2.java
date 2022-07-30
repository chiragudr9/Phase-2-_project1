package com.learner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		try {
			PrintWriter writer = resp.getWriter();
			
			writer.print("Teacher ID");
		    writer.print("            ");
		    
		    writer.print("Teacher First Name");
		    writer.print("            ");
		    
		    writer.print("Teacher Last Name");
		    writer.print("            ");
		    
		    writer.print("Teacher Father Name");
		    writer.print("            ");
		    
		    writer.print("Teacher DOB");
		    writer.print("            ");
		    
		    writer.print("Teacher Degree");
		    writer.print("            ");
		    
		    writer.print("Teacher Annual Salary");
		    writer.print("            ");
		    
		    
		    
		    
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			
			String sql = "select * from  d_teacher1 ";
			
			
			
			Statement pstmt = con.createStatement();
			
		    ResultSet  res = pstmt.executeQuery(sql);
		    
		    while(res.next() == true) {

		    writer.print(res.getInt(1));
		    writer.print("                        ");
		    
		    writer.print(res.getString(2));
		    writer.print("                        ");
		    
		    writer.print(res.getString(3));
		    writer.print("                        ");
		    
		    writer.print(res.getString(4));
		    writer.print("                        ");
		    
		    writer.print(res.getInt(5));
		    writer.print("                     ");
		    
		    writer.print(res.getString(6));
		    writer.print("                      ");
		    
		    writer.print(res.getInt(7));
		    writer.println("            ");
		    
		    }
	    	}
		 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
