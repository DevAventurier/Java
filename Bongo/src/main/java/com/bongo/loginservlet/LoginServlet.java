package com.bongo.loginservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connexion;
	//private PreparedStatement preparedStatement;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jeee", "root", "93017539");
			
		}catch(ClassNotFoundException e) {}
		
		try {
			PrintWriter out = response.getWriter();
			Connection connexion = DriverManager.getConnection("jdbc:mysql:" + "//localhost:3306/jeee", "root", "93017539");
			
			String username = request.getParameter("username");
			String motdepasse = request.getParameter("motdepasse");
			String check = request.getParameter("check");
			
			PreparedStatement ps = connexion.prepareStatement("select * from auteur where username = ? and motdepasse= ?");
			
			ps.setString(1, username);
			ps.setString(2, motdepasse);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				if(check!=null && check.equals("on")){
			          
			          Cookie userCookie = new Cookie("user", username);
			          userCookie.setMaxAge(30 * 24 * 60 * 60); 

			          response.addCookie(userCookie);
			          
			        }
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/welcome.jsp");
				dispatcher.forward(request, response);
			}else {
				out.println("<font color=red size=18>Login Failed !!! <br>");
				out.println("<a href=\"login.jsp\">Try Again !</a>");
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
				//dispatcher.forward(request, response);
			}
			
		}catch(SQLException e) {e.printStackTrace();}
	}

}
