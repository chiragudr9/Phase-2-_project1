package com.learner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Servlet8")
public class Servlet8 extends HttpServlet {
	
	private PreparedStatement pstmt;

	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		try {
PrintWriter writer = resp.getWriter();
			
		    writer.print("class ");
		    writer.print("              ");
		    writer.print("teaching day");
		    writer.print("              ");
		    writer.print("lecture1");
		    writer.print("              ");
		    writer.print("lecture2");
		    writer.print("              ");
		    writer.print("lecture3");
		    writer.print("              ");
		    writer.print("lecture4");
		    writer.print("              ");
		    writer.print("lecture5");
		    writer.print("              ");
		    
		    
		    
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			
			String sql = "select * from  d_class ";
			
			Statement pstmt = con.createStatement();
			
		    ResultSet  res = pstmt.executeQuery(sql);
		    
		    while(res.next() == true) {

		    
		    writer.print(res.getString(1));
		    writer.print("              ");
		    writer.print(res.getString(2));
		    writer.print("              ");
		    writer.print(res.getString(3));
		    writer.print("              ");
		    writer.print(res.getString(4));
		    writer.print("              ");
		    writer.print(res.getString(5));
		    writer.print("              ");
		    writer.print(res.getString(6));
		    writer.print("              ");
		    writer.print(res.getString(7));
		    writer.println("            ");
		    writer.println("            ");
		    
		    }
	    	}
		 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

			
			
			
			
			
			
			
			
			
			