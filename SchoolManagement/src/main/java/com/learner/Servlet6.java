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

@WebServlet("/Servlet6")
public class Servlet6 extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		try {
			PrintWriter writer = resp.getWriter();
			
			writer.print("student ID  ");
			writer.print("         ");
		    
			writer.print("student name");
			writer.print("         ");
		    
			writer.print("student class");
			writer.print("         ");
		    
			writer.print("student DOB ");
			writer.print("         ");
		    
			writer.print("english mark");
			writer.print("    ");
			writer.print("hindi mark  ");
			writer.print("     ");
			writer.print("maths mark  ");
			writer.print("    ");
			writer.print("science mark");
			writer.print("   ");
			writer.print("S.science mark");
			writer.print(" ");
			writer.print("Student percentage");
			writer.print("         ");
		    
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			
			String sql = "select * from  d_student ";
			
			Statement pstmt = con.createStatement();
			
		    ResultSet  res = pstmt.executeQuery(sql);
		    
		    while(res.next() == true) {

		    writer.print(res.getInt(1));
		    writer.print("            ");
		    
		    writer.print(res.getString(2));
		    writer.print("            ");
		    
		    writer.print(res.getString(3));
		    writer.print("            ");
		    
		    writer.print(res.getInt(4));
		    writer.print("            ");
		    
		    writer.print(res.getInt(5));
		    writer.print("            ");
		    
		    writer.print(res.getInt(6));
		    writer.print("            ");
		    
		    writer.print(res.getInt(7));
		    writer.print("            ");
		    
		    writer.print(res.getInt(8));
		    writer.print("            ");
		    
		    writer.print(res.getInt(9));
		    writer.print("            ");
		    
		    writer.print(res.getInt(10));
		    writer.println("            ");
		    
		    
		    
		    }
	    	}
		 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
