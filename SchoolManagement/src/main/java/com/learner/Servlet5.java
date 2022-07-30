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

@WebServlet("/Servlet5")
public class Servlet5 extends HttpServlet {
	private PreparedStatement pstmt;

	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String id = req.getParameter("s_id"); 
 			int sid = Integer.parseInt(id); 
			
 			String sname = req.getParameter("s_name"); 
			
			String sclass = req.getParameter("s_class");
			
			
			String dobb = req.getParameter("s_dob"); 
			int dob = Integer.parseInt(dobb); 
			
			String gr11 = req.getParameter("g_english");
			String gr22 = req.getParameter("g_hindi"); 
			String gr33 = req.getParameter("g_maths"); 
			String gr44 = req.getParameter("g_science"); 
			String gr55 = req.getParameter("g_s_science");
		//	String pr1 = req.getParameter("g_percentage");
			
			int g1 = Integer.parseInt(gr11); 
			int g2 = Integer.parseInt(gr22); 
			int g3 = Integer.parseInt(gr33); 
			int g4 = Integer.parseInt(gr44); 
			int g5 = Integer.parseInt(gr55); 
		//	int p1 = Integer.parseInt(dobb); 
			
			
			int per = (g1+ g2 +g3 +g4 +g5)/5;
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			
			String sql = "insert into d_student values(?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
		    pstmt.setInt(1, sid);
			
		    pstmt.setString(2, sname);
			pstmt.setString(3, sclass);
		    
			pstmt.setInt(4, dob);
			pstmt.setInt(5, g1);
			pstmt.setInt(6, g2);
			pstmt.setInt(7, g3);
			pstmt.setInt(8, g4);
			pstmt.setInt(9, g5);
			pstmt.setInt(10, per);
			
			
			
			
			
			
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
