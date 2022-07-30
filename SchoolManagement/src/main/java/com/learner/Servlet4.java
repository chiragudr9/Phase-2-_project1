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

@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet {
	private PreparedStatement pstmt;

	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String day = req.getParameter("t_day");
			
			String name = req.getParameter("t_name");
			
			String lec1 = req.getParameter("lec_1");
			String sub1 = req.getParameter("T_subject1");
			
			String lec2 = req.getParameter("lec_2");
			String sub2 = req.getParameter("T_subject2");
			
			String lec3 = req.getParameter("lec_3");
			String sub3 = req.getParameter("T_subject4");
			
			String lec4 = req.getParameter("lec_4");
			String sub4 = req.getParameter("T_subject4");
			
			String lec5 = req.getParameter("lec_5");
			String sub5 = req.getParameter("T_subject5");
			
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			
			String sql = "insert into d_teachertimetable values(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
		    pstmt.setString(1, day);
			pstmt.setString(2, name);
			
			
		    pstmt.setString(3, lec1);
		    pstmt.setString(4, sub1);
		    
		    pstmt.setString(5, lec2);
		    pstmt.setString(6, sub2);
		    
		    pstmt.setString(7, lec3);
		    pstmt.setString(8, sub3);
		    
		    pstmt.setString(9, lec4);
		    pstmt.setString(10, sub4);
		    
		    pstmt.setString(11, lec5);
		    pstmt.setString(12, sub5);
		    
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
