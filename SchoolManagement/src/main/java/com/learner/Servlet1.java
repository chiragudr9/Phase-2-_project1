package com.learner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private PreparedStatement pstmt;

	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String id = req.getParameter("t_id"); //1
 			int idd = Integer.parseInt(id); 
			
 			String fname = req.getParameter("t_fname"); //2
			
			String lname = req.getParameter("t_lname"); //3
			
			String faname = req.getParameter("t_fathername"); //4
			
			String dobb = req.getParameter("t_dob"); //5
			int dob = Integer.parseInt(dobb); 
			
			String degree = req.getParameter("t_degree"); //6
			
			String salar = req.getParameter("t_salary"); //7
			int salary = Integer.parseInt(salar); 
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			
			String sql = "insert into d_teacher1 values(?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
		    pstmt.setInt(1, idd);
			pstmt.setString(2, fname);
			pstmt.setString(3, lname);
		    pstmt.setString(4, faname);
			pstmt.setInt(5, dob);
			pstmt.setString(6, degree);
			pstmt.setInt(7, salary);	
	    	int x = pstmt.executeUpdate();
			
			PrintWriter writer = resp.getWriter();
			
			if(x > 0) 
			{
			writer.print("data inserted");
			}
			else {
				writer.print("data not inserted");
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
