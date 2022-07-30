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

@WebServlet("/Servlet7")
public class Servlet7 extends HttpServlet {
	//// servlet to view subject master list
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		try {
			PrintWriter writer = resp.getWriter();
			
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			
			String sql = "select * from d_subject";
			
			Statement pstmt = con.createStatement();
			
		    ResultSet  res = pstmt.executeQuery(sql);
		    
		    while(res.next() == true) {

		   writer.print(res.getString(1));
		   writer.print("            ");
			    
		    writer.print(res.getString(2));
		    writer.print("            ");
		    
		    writer.print(res.getString(3));
		    writer.print("            ");
		    
		    writer.print(res.getString(4));
		    writer.print("            ");
		    
		    writer.print(res.getString(5));
		    writer.print("            ");
		    
		    writer.print(res.getString(6));
		    writer.print("            ");
		    
		    writer.print(res.getString(7));
		    writer.print("            ");
		    
		    writer.println(res.getString(8));
		    writer.println("            ");
		    
		    
		    }
	    	}
		 
		catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
