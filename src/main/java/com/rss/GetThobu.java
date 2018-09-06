package com.rss;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetThobu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetThobu() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		
		//passing JSP parameters to request object
		String fname = request.getParameter("s_fname").toString();
		String lname = request.getParameter("s_lname").toString();
		String aadhar = request.getParameter("s_aadhar").toString();
		String phone = request.getParameter("s_phone").toString();
		String email = request.getParameter("s_email").toString();
		String address = request.getParameter("s_address").toString();
		String city = request.getParameter("s_city").toString();
		String state = request.getParameter("s_state").toString();
		
		//establishing JDBC MySQL connection 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection pilla = DriverManager.getConnection("jdbc:mysql://localhost:3306/siblings?useTimezone=true&serverTimezone=UTC", "root", "R@ghu1989");
			String q1 = "insert into mysiblings values ('"+fname+"', '"+lname+"', '"+aadhar+"', '"+phone+"', '"+email+"', '"+address+"', '"+city+"', '"+state+"')";
			Statement ra = pilla.createStatement();
			int i = ra.executeUpdate(q1);
			if (i > 0) {
				p.println("table data inserted");
				
			} else {
				p.println("No data inserted");
			}
			
		} catch (Exception e) {
			p.println(e);
		}
		
		
		
	}

}
